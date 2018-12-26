package main.java.com.sima;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by sima on 2017/4/23.
 */
public class FileChannelDemo {
    //打开文件通道
    public void openAndWrite() throws IOException {
        FileChannel channel = FileChannel.open(Paths.get("my.txt"),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(64);
        /*
        * 当需要读取缓冲区时，调用flip方法
        * 将读写限制改为当前读写位置，将读写位置改为0
        * */
        buffer.putChar('A').flip();
        channel.write(buffer);
    }
    //使用文件通道保存网页内容
    public void loadWebPage(String url) throws IOException {
        try(FileChannel destChannel = FileChannel.open(Paths.get("web.text"),
                StandardOpenOption.CREATE, StandardOpenOption.WRITE)){
            InputStream inputStream = new URL(url).openStream();
            ReadableByteChannel srcChannel = Channels.newChannel(inputStream);
            destChannel.transferFrom(srcChannel,0,Integer.MAX_VALUE);
        }
    }
    //使用字节缓冲区进行文件复制
    public void copyUseByteBuffer(String srcFileName, String destFileName) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024*32);
        try(FileChannel src = FileChannel.open(Paths.get(srcFileName),
                StandardOpenOption.READ);
        FileChannel dest = FileChannel.open(Paths.get(destFileName),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)){
            while (src.read(buffer) > 0 || buffer.position() != 0){
                buffer.flip();
                dest.write(buffer);
                buffer.compact();
            }
        }
    }
    //使用文件通道进行文件复制
    public void copyUseChannelTransfer(String srcFileName, String destFileName) throws IOException {
        try(FileChannel src = FileChannel.open(Paths.get(srcFileName),
                StandardOpenOption.READ);
        FileChannel dest = FileChannel.open(Paths.get(destFileName),
                StandardOpenOption.APPEND, StandardOpenOption.CREATE)){
            dest.transferFrom(src,0,Integer.MAX_VALUE);
        }
    }
    public static void main(String[] args){
        FileChannelDemo demo = new FileChannelDemo();
        try {
            //demo.openAndWrite();
            //demo.loadWebPage("http://www.baidu.com");
            //demo.copyUseByteBuffer("my.txt", "web.text");
            demo.copyUseChannelTransfer("web.text", "my.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
