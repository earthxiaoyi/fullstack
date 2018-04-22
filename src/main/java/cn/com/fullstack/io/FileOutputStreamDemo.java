package cn.com.fullstack.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by jiaming on 2018/4/22.
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) throws Exception {
        File file = new File("src/main/resources/FileInputStreamDemo.txt");
        FileOutputStream out = new FileOutputStream(file);
        for (int i = 0; i < 10; i++) {
            String str = "成龙"+i;
            out.write(str.getBytes("utf-8"));
            out.write("\n".getBytes());
        }
        out.close();
    }
}
