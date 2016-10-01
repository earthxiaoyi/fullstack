package cn.com.fullstack.study1;

public class Question3 {
	
	public static void main(String[] args) {
		byte[][] b = new byte[10240][10240];
		long rowPriorST = System.currentTimeMillis();
		rowPrior(b);
		System.out.println("行优先耗时："+(System.currentTimeMillis()-rowPriorST));
		long columnPriorST = System.currentTimeMillis();
		columnPrior(b);
		System.out.println("列优先耗时："+(System.currentTimeMillis()-columnPriorST));
	}
	
	/**
	 * 行优先
	 * @param b
	 */
	public static void rowPrior(byte[][] b){
		int c=0;
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b.length;j++){
				c+=b[i][j];
			}
		}
		System.out.println(c);
	}
	
	/**
	 * 列有限
	 * @param b
	 */
	public static void columnPrior(byte[][] b){
		int c=0;
		for(int i=0;i<b.length;i++){
			for(int j=0;j<b.length;j++){
				c+=b[j][i];
			}
		}
		System.out.println(c);
	}
}
