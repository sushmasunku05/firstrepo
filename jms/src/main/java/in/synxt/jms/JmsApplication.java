package in.synxt.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.synxt.core.Employee;

@SpringBootApplication
public class JmsApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(JmsApplication.class, args);
		JMSTest test=context.getBean("JMSTest",JMSTest.class);
		//System.out.println(test.toString());
		Employee emp=new Employee(1,"Sushma",900000);
		test.sendMsg("myfirst",emp);
	}

}
