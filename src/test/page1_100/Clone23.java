package src.test.page1_100;

public class Clone23 {
	public static void main(String[] args) throws CloneNotSupportedException {
		Person23 p1=new Person23("zhangsan",20);
		Person23 p2=p1;
		System.out.println(p1);//page1_100.Person@6d06d69c
		System.out.println(p2);//page1_100.Person@6d06d69c
		//上面地址相同，因为这相当于复制引用，地址相同，说明他们指向的是同一个对象。
	  System.out.println("***************************");
		p2.setAge(21);
		System.out.println(p1);
		System.out.println(p2);
		/*
		 * 上面可以看出，引用复制其实指向的是同一个对象，其中一个引用改变属性值，另一个也会改变,但是String等封装类不会，因为他们是final得，
		 */
		System.out.println("***************************");
		Person23 p3=(Person23) p1.clone();
		 Boolean boolean1=p1.getName()==p3.getName();
		System.out.println(p1);
		System.out.println(p3);

		   System.out.println(boolean1);//true.所以是浅拷贝
		   System.out.println("***************************");
		/*这才是真正的值复制，值复制，相当于内存中有两个p1对象，p1，p3分别指向这两个对象。
		但是克隆是浅拷贝。
		先深拷贝必须实现Cloneable接口。实现重写里面的clone方法
		*/
		p1.setName("lisi");
		System.out.println(p1);
        System.out.println(p3);

       Person23 p5=new Person23("zhansgan",2);
       Person23 p6=new Person23("zhansgan",2);
       System.out.println(p5.equals(p6));
       System.out.println(p5=p6);

       String aa="aa";
		String bb="aa";
		System.out.println(aa==bb);
		System.out.println(aa.getBytes());
	}


}


