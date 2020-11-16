package src.test.designpattern.single;

public class TestDesign {

	private TestDesign() {
		// TODO Auto-generated constructor stub
	}
	public static TestDesign design=new TestDesign();

	public static TestDesign  getDesign() {

		return design;
	}


}
