package cn.com.fullstack.study1;

import java.io.PrintStream;

public class Question1 {
	/**
	 * byte short 位运算会转成int进行计算。所以ba左移2位的时需强转为byte
	 */
	public static void main(String[] args) {
		byte ba = 127;
		byte bb = (byte) (ba<<2);
		System.out.println(bb);
		System.out.println(Integer.toBinaryString(ba));
		System.out.println(Integer.toBinaryString(bb));
	}
}
