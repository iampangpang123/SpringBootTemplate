package src.test.designpattern.factory.abstact;

public class SendMailFactory implements Provider {

	@Override
	public Sender produce() {
	    return new MailSender();
	}

}
