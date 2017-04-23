package com.sima;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * Created by sima on 2017/4/23.
 */
public class LoadWebPageUseSelector {
    public void load(Set<URL> urls) throws IOException {
        Map<SocketAddress, String> map = urlToSoketAddress(urls);
        Selector selector = Selector.open();
        for (SocketAddress address : map.keySet()){
            register(selector, address);
        }
        int finished = 0, total = map.size();
        ByteBuffer buffer = ByteBuffer.allocate(32 * 1024);
        int len = -1;
        while (finished < total){
            selector.select();//阻塞操作，直到所监听的Socket通道至少有一个感兴趣的事件发生
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                iterator.remove();
                if (key.isValid() && key.isReadable()){
                    SocketChannel channel = (SocketChannel) key.channel();
                    InetSocketAddress address = (InetSocketAddress) channel.getRemoteAddress();
                    String fileName = address.getHostName();
                    FileChannel destChannel = FileChannel.open(Paths.get(fileName),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    buffer.clear();
                     while ((len = channel.read(buffer)) > 0 || buffer.position() != 0){
                        buffer.flip();
                        destChannel.write(buffer);
                        buffer.compact();
                    }
                    if (len == -1){//通道内所有数据读取完毕
                        finished++;
                        key.cancel();//取消选择器对此通道的管理
                    }
                }else if (key.isValid() && key.isConnectable()){
                    SocketChannel channel = (SocketChannel) key.channel();
                    boolean success = channel.finishConnect();
                    if (!success){//链接建立失败
                        finished++;
                        key.cancel();
                    }else{
                        InetSocketAddress address = (InetSocketAddress) channel.getRemoteAddress();
                        String path = map.get(address);
                        String request = "GET " + path + " HTTP/1.0 \r\n\r\nHOST: " +
                                address.getHostString() + "\r\n\r\n";
                        ByteBuffer header = ByteBuffer.wrap(request.getBytes("UTF-8"));
                        channel.write(header);//向通道中写入请求头信息
                    }
                }
            }
        }
    }

    private void register(Selector selector, SocketAddress address) throws IOException {
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        channel.connect(address);
        channel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ);
    }

    private Map<SocketAddress, String> urlToSoketAddress(Set<URL> urls) {
        Map<SocketAddress, String> map = new HashMap<>();
        for (URL url : urls){
            int port = url.getPort() != -1 ? url.getPort() : url.getDefaultPort();
            SocketAddress address = new InetSocketAddress(url.getHost(), port);
            String path = url.getPath();
            if (url.getQuery() != null){
                path = path + "?" +url.getQuery();
            }
            map.put(address, path);
        }
        return map;
    }
    public static void main(String[] args) throws IOException {
        LoadWebPageUseSelector demo = new LoadWebPageUseSelector();
        Set<URL> set = new HashSet<>();
        set.add(new URL("http://www.baidu.com"));
        set.add(new URL("http://www.sina.com"));
        set.add(new URL("http://www.seu.edu.cn"));
        demo.load(set);
    }
}
