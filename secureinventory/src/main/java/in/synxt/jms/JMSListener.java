package in.synxt.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JMSListener {
	
	@JmsListener(destination="myfirst",containerFactory="connectionFactory")
	public void recieveMessage(String message) {
		System.out.println(message);
	}
}
