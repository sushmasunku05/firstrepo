package in.synxt.deliverymanager.jms.listeners;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import in.synxt.core.OrderDeliveryInfoModel;
import in.synxt.core.ProductOrderModel;
import in.synxt.deliverymanager.service.DeliveryService;

@Component
public class OrderDeliveryRequestListener {
	
	@Autowired
	private DeliveryService deliveryService;
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@JmsListener(destination="deliveryrequests",containerFactory="jmsConnectionFactory")
	public void recieveMessage(ObjectMessage msg) throws JMSException {
		ProductOrderModel order=(ProductOrderModel) msg.getObject();
		OrderDeliveryInfoModel deliveryInfo=deliveryService.deliverProduct(order);
		jmsTemplate.convertAndSend("deliverystatusack",deliveryInfo);
	}
}
