package cn.com.fullstack.bit;

import org.junit.Test;

public class BitOperationTest {
	
	/**
	 * 左移运算
	 */
	@Test
	public void leftMoveOpTest1(){
		byte j = 26;
		byte c = (byte) (j<<1);
		System.out.println(c);
		System.out.println(Integer.toBinaryString(c));
	}
	
	/**
	 * 右移运算
	 */
	@Test
	public void rightMoveOpTest1(){
		byte i = 77;
		byte a = 1;
		byte c = (byte) (i>>1);
		System.out.println(0xf0);
		System.out.println(Integer.toBinaryString(0xf0));
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(c));
		System.out.println(Integer.toBinaryString(0xf0));
	}
	
	@Test
	public void test2(){
		byte a = (byte)0xf0;
		int b = a&0xff;
		System.out.println(a);
		System.out.println(b);
	}
	
	@Test
	public void test3(){
		int flag = 0B01101000;
		byte b = (byte)((flag&0B00110000)>>4);
		System.out.println(b);
		System.out.println(Integer.toBinaryString(2));
		System.out.println("0B00110000==00"+Integer.toBinaryString(0B00110000));
		System.out.println("0B01101000==0"+Integer.toBinaryString(0B01101000));
	}
}
