package in.synxt.secureinventory.service.impl;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import in.synxt.core.ProductOrderModel;
import in.synxt.secureinventory.dao.OrderDao;
import in.synxt.secureinventory.entities.Order;
import in.synxt.secureinventory.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Override
	public ProductOrderModel orderProduct(ProductOrderModel orderModel) {
		Order order=new Order();
		BeanUtils.copyProperties(orderModel, order);
		order.setOrderPid(UUID.randomUUID().toString());
		orderModel.setOrderId(order.getOrderPid());
		order.setOrderDate(new Date(System.currentTimeMillis()));
		orderDao.save(order);
		//orderModel.setOrderId(Integer.toString(order.getOrderId()));
		jmsTemplate.convertAndSend("deliveryrequests",orderModel);
		return orderModel;
	}

	@Override
	public ProductOrderModel getOrderDetails(String orderId) {
		Order order=orderDao.findByOrderPid(orderId);
		//Optional<Order> order=dao.findById(Integer.parseInt(orderId));
		ProductOrderModel orderModel=new ProductOrderModel();
		BeanUtils.copyProperties(orderModel,order);
		
		return orderModel;
	}

}

