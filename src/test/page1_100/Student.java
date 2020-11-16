package src.test.page1_100;


public class Student {
	public static void main(String[] args) {

		Student s1=new Student("张三", 20);
		Student s2=new Student("李四", 20);
		Student s3=new Student("张三", 20);
		System.out.println(s1.equals(s3));
		System.out.println(s1.equals2(s3));
		}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			Student newStudent = (Student) obj;
			if (newStudent.getName().equals(this.getName())) {
				return true;
			} else {
				return false;
			}

		}
		return false;
	}
	private String name;
	private int age;

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public boolean equals2(Object obj) {

		if(obj instanceof Student) {
			if(((Student) obj).getName().equals(this.getName())) {
				return true;
			}else {
				return false;

			}


		}
		return false;
	}



}
