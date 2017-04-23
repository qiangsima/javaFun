package com.sima;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
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
    public static void main(String[] args){
        FileChannelDemo demo = new FileChannelDemo();
        try {
            demo.openAndWrite();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
