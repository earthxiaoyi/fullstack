package cn.com.fullstack.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * 这种读的方式可能会存在乱码问题，根源：byte数组太小接收不完3个字节的中文
 * Created by jiaming on 2018/4/22.
 */
public class BufferInputStreamDemo {

    public static void main(String[] args) throws Exception {
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(new File("src/main/resources/FileInputStreamDemo.txt")));
        byte[] b =new byte[1024];
        int i = 0;
        while((i = bfIn.read(b))!=-1){
            System.out.println(new String(b,0,i,"utf-8"));
        }
        bfIn.close();
    }
}
