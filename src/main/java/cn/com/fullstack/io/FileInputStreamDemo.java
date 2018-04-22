package cn.com.fullstack.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by jiaming on 2018/4/22.
 */
public class FileInputStreamDemo {

    public static void main(String[] args) throws Exception {
        File file = new File("src/main/resources/FileInputStreamDemo.txt");
        FileInputStream in = new FileInputStream(file);
        byte[] b = new byte[4];
        int i = 0;
        while((i = in.read(b))!=-1){
            System.out.println(new String(b,0,i,"UTF-8"));
        }
        in.close();
    }

}
