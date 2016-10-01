package cn.com.fullstack.study2;

public class Question1 {

	/**
	 * 1 得到 String s="中国"
	 * 这个字符串的utf-8编码，gbk编码，iso-8859-1编码的字符串，
	 * 看看各自有多少字节，同时解释为什么以utf-8编码得到的byte[]
	 * 无法用gbk的方式“还原”为原来的字符串
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		String s = "中国上放水电费水电费水电费是的废弃物让人";
		byte[] utf = s.getBytes("UTF-8");
		byte[] gbk = s.getBytes("gbk");
		byte[] iso = s.getBytes("iso-8859-1");
		System.out.println("utf-8:"+utf.length);
		System.out.println("gbk:"+gbk.length);
		System.out.println("iso:"+iso.length);
		System.out.println(new String(utf,"utf-8"));
		System.out.println(new String(gbk,"gbk"));
		System.out.println(new String(iso,"iso-8859-1"));
		System.out.println(new String(iso,"gbk"));
		System.out.println(new String(iso,"utf-8"));
		System.out.println(new String(utf,"gbk"));
		
		String s1 = new String(s.getBytes("utf-8"),"utf-8");
		String s2 = new String(s1.getBytes("gbk"),"gbk");
		System.out.println("s1:"+s1);
		System.out.println("s2:"+s2);
	}

}
