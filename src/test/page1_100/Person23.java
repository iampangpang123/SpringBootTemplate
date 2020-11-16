package src.test.page1_100;

public class Person23  implements Cloneable  {

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Override
	public boolean equals(Object obj) {

		if(obj instanceof Person23){
			Person23 person=(Person23)obj;
			 if (person.getName() == null ||this.name == null) {
	                return false;
	            }else{
	                return this.name.equalsIgnoreCase(person.getName());
	            }
		}
		// TODO Auto-generated method stub
		return false;
	}
	private String name;
	private int age;

	public Person23() {
		super();
	}

	public Person23(String name, int age) {
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

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
