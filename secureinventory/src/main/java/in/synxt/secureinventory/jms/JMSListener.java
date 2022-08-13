package in.synxt.secureinventory.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import in.synxt.core.OrderDeliveryInfoModel;
import in.synxt.secureinventory.dao.OrderDao;
import in.synxt.secureinventory.entities.Order;

@Component
public class JMSListener {
	
	@Autowired
	private OrderDao dao;
	
	@JmsListener(destination="deliverystatusack",containerFactory="jmsConnectionFactory")
	public void recieveMessage(ObjectMessage message) throws JMSException {
		OrderDeliveryInfoModel deliveryInfo=(OrderDeliveryInfoModel) message.getObject();
		Order order=dao.findByOrderPid(deliveryInfo.getOrderId());
		order.setDeliveryTrackerNo(deliveryInfo.getDeliveryTrackerNo());
		dao.save(order);
	}
}
