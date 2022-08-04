package in.synxt.jms.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

public class JMSConfiguration {
	@Value("${spring.sctivemq.broker-url}")
	private String brokerUrl;
	
	@Bean
	ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(brokerUrl);
		return activeMQConnectionFactory;
	}
	
	JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate=new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		return jmsTemplate;
		
	}
}
