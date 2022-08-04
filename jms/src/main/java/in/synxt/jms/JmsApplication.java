package in.synxt.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JmsApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(JmsApplication.class, args);
		JMSTest test=context.getBean("JMSTest",JMSTest.class);
		//System.out.println(test.toString());
		test.sendMsg("myfirst","Sample JMS Message");
	}

}
