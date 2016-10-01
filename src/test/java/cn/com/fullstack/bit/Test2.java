package cn.com.fullstack.bit;

public class Test2 {
	public static void main(String[] args) {
		byte[] b = new byte[4];
		b[0] = 113;
		b[1] = 123;
		b[2] = 33;
		b[3] = 43;
		System.out.println(getInt1(b, 0)+"==="+Integer.toBinaryString(getInt1(b, 0)));
		System.out.println(getInt2(b, 0)+"==="+Integer.toBinaryString(getInt2(b, 0)));
	}
	
	public static int getInt1(byte[] b,int off){
		return ((b[off+3] & 0xFF))+
			((b[off+2] & 0xFF)<<8)+
		   ((b[off+1] & 0xFF)<<16)+
		   ((b[off] & 0xFF)<<24);
	}
	
	public static int getInt2(byte[] b,int off){
		return ((b[off+3] & 0xFF))|
				((b[off+2] & 0xFF)<<8)|
			   ((b[off+1] & 0xFF)<<16)|
			   ((b[off] & 0xFF)<<24);
	}
}
