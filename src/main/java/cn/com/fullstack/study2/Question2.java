package cn.com.fullstack.study2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Question2 {
	
	public static void main(String[] args) throws Exception {
		int a = 10240;
		File file = new File("src/main/resources/binaryFile.txt");
		FileOutputStream output = new FileOutputStream(file);
		FileInputStream input = new FileInputStream(file);
		//output.write(bigEndian(a));
		output.write(littleEndian(a));
		byte[] b = new byte[4];
		input.read(b);
		//int bigEndianF = bigEndianF(b, 0);
		//System.out.println(bigEndianF);
		int littleEndianF = littleEndianF(b, 0);
		System.out.println(littleEndianF);
	}
	/**
	 * 小头
	 * @param a
	 * @return
	 */
	public static byte[] littleEndian(int a){
		byte[] b = new byte[4];
		b[0] = (byte)(a & 0xff);
		b[1] = (byte)((a >> 8) & 0xff);
		b[2] = (byte)((a >> 16) & 0xff);
		b[3] = (byte)((a >> 24) & 0xff);
		return b;
	}
	
	/*public static int littleEndianF(byte[] b,int offset){
		return (((b[offset] & 0xff) >> 24) |
				((b[offset+1] & 0xff) >> 16) |
				((b[offset+2] & 0xff) >> 8) |
				(b[offset+3] & 0xff)
				);
	}*/
	
	public static int littleEndianF(byte[] b,int offset){
		return (((b[offset] & 0xff) ) |
				((b[offset+1] & 0xff) << 8) |
				((b[offset+2] & 0xff) << 16) |
				((b[offset+3] & 0xff) << 24)
				);
	}
	
	/**
	 * 大头
	 * @param a
	 * @return
	 */
	public static byte[] bigEndian(int a){
		byte[] b = new byte[4];
		b[0] =(byte) ((a>>24) & 0xff);
		b[1] =(byte) ((a>>16) & 0xff);
		b[2] =(byte) ((a>>8) & 0xff);
		b[3] =(byte) (a & 0xff);
		return b;
	}
	
	/**
	 * 大头转换
	 * @param b
	 * @return int
	 */
	public static int bigEndianF(byte[] b,int offset){
		return (((b[offset]  & 0xff)<< 24) |
				((b[offset+1] & 0xff) << 16) |
				((b[offset+2] & 0xff ) << 8) |
				(b[offset+3] & 0xff));
	}	
	
	
}
