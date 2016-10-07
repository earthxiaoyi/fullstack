package cn.com.fullstack.study1;

import cn.com.fullstack.Salary;

import java.util.*;

public class Question4 {

	public static void main(String[] args) {
		List<Salary> salaryList = genaretorSalaryList();
		//排序
		Collections.sort(salaryList, new Comparator<Salary>() {
			@Override
			public int compare(Salary o1, Salary o2) {
				int income1 = o1.getBaseSalary()*13+o1.getBonus();
				int income2 = o2.getBaseSalary()*13+o2.getBonus();
				if(income1>income2){
					return 1;
				}
				return 0;
			}
		});
	}
	
	public static List<Salary> genaretorSalaryList(){
		List<Salary> salaryList = new ArrayList<>(10000);
		Random random = new Random();
		for(int i=0;i<10000;i++){
			Salary salary = new Salary("张三"+i,genSalary(),random.nextInt(10));
			salaryList.add(salary);
		}
		return salaryList;
	}
	
	public static int genSalary(){
		Random random = new Random();
		while(true){
			int value = random.nextInt(100);
			if(value>=5 && value<=100){
				return value;
			}
		}
	}
}

