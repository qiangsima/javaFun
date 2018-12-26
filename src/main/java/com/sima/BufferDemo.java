package main.java.com.sima;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/**
 * Created by sima on 2017/4/23.
 */
public class BufferDemo {
    public void useByteBuffer(){
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put((byte) 1);
        buffer.put(new byte[3]);
        buffer.putChar('A');
        buffer.putFloat(0.2F);
        System.out.println(buffer.getChar(4));//A
    }
    //字节顺序，ByteBuffer默认使用大端表示
    public void byteOrder(){
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(1);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        System.out.println(buffer.getInt(0));//2^24
    }
    //字节缓冲区视图
    public void viewBuffer(){
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.putInt(1);//读取位置为4
        /*
        * 视图和buffer对象共享同样的存储空间
        * 准确讲，是读写位置和读写限制之间的可用空间
        * */
        IntBuffer intBuffer = buffer.asIntBuffer();//
        intBuffer.put(2);
        System.out.println(buffer.getInt());//2
    }
    public static void main(String[] args){
        BufferDemo demo = new BufferDemo();
        demo.useByteBuffer();
        demo.byteOrder();
        demo.viewBuffer();
    }
}
