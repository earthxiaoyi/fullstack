package cn.com.fullstack.io;

import java.io.*;

/**
 * Created by jiaming on 2018/4/23.
 */
public class BufferedOutputStreamDemo {
    public static void main(String[] args) throws Exception {
        FileOutputStream fout = new FileOutputStream(new File("src/main/resources/FileInputStreamDemo.txt"));
        OutputStream out = new BufferedOutputStream(fout);
        for (int i = 0; i < 100; i++) {
            String str = "成龙"+i;
            out.write(str.getBytes("utf-8"));
            out.write("\n".getBytes());
        }
        out.flush();
        fout.close();
        out.close();
    }
}
