package cn.tang.web1.p273_329;

public class test {
	public static void main(String[] args) {
	String dd="hello";
	String aa="hello";
	String cc=aa;
	String bb=new String("hello");
	System.out.println(aa==bb);//false
	System.out.println(aa==cc);//true
	System.out.println(aa==dd);//true

	}

}
