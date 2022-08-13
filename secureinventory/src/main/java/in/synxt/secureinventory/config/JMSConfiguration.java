package in.synxt.secureinventory.config;

import javax.jms.ConnectionFactory;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JMSConfiguration {
	
	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	@Bean("jmsConnectionFactory")
	JmsListenerContainerFactory jmsConnectionFactory(ConnectionFactory connectionFactory,DefaultJmsListenerContainerFactoryConfigurer configurer) {
		
		DefaultJmsListenerContainerFactory factory=new DefaultJmsListenerContainerFactory();
		configurer.configure(factory, connectionFactory);
		return factory;
	}
	
	@Bean("aMQFactory")
	ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory=new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL(brokerUrl);
		activeMQConnectionFactory.setTrustAllPackages(true);
		return activeMQConnectionFactory;
	}
	
	@Bean
	JmsTemplate jmsTemplate() {
		JmsTemplate jmsTemplate=new JmsTemplate();
		jmsTemplate.setConnectionFactory(connectionFactory());
		return jmsTemplate;
	}
}
