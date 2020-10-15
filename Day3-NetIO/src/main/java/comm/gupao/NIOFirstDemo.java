package comm.gupao;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFirstDemo {

    public static void main(String[] args) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File("E:/test.txt"));

            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:/test_cp.txt"));
            //NIO channel - buffer
            FileChannel fileChannel = fileInputStream.getChannel();
            FileChannel fileOutChannel = fileOutputStream.getChannel();
            //初始化缓存区
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            fileChannel.read(byteBuffer); //读到缓冲区
            byteBuffer.flip();//读到写
            fileOutChannel.write(byteBuffer);
            byteBuffer.clear();//重置缓冲区
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
