package src.test.designpattern.factory.abstact;

public class SendSsmFactory  implements Provider{

	@Override
	public Sender produce() {

		return new SmsSender();
	}

}
