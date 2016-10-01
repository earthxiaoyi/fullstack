package cn.com.fullstack.study1;

/**
 * 	2题
 	int a=-1024;
	给出 a>>1与a>>>1的的结果，并且用位移方式图示解释

 * @author jiaming.jiang
 *
 */
public class Question2 {
	
	public static void main(String[] args) {
		int a = -1024;
		System.out.println(a>>1);
		System.out.println(a>>>1);
		System.out.println("-1024=="+Integer.toBinaryString(a));
		System.out.println("a>>1=="+Integer.toBinaryString(a>>1));
		System.out.println("a>>>1=="+Integer.toBinaryString(a>>>1));
	}
}
