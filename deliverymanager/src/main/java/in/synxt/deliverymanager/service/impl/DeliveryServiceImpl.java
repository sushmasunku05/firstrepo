package in.synxt.deliverymanager.service.impl;

import java.sql.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.synxt.core.OrderDeliveryInfoModel;
import in.synxt.core.ProductOrderModel;
import in.synxt.deliverymanager.dao.DeliveryRequestDao;
import in.synxt.deliverymanager.entity.DeliveryRequest;
import in.synxt.deliverymanager.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	@Autowired
	private DeliveryRequestDao dao;

	@Override
	public OrderDeliveryInfoModel deliverProduct(ProductOrderModel model) {
		
		DeliveryRequest dr=new DeliveryRequest();
		dr.setOrderId(model.getOrderId());
		dr.setDeliveryTrackerNo(UUID.randomUUID().toString());
		dr.setOrderDate(new Date(System.currentTimeMillis()));
		dr.setStatus("RECIEVED");
		dao.save(dr);
		OrderDeliveryInfoModel deliveryInfo=new OrderDeliveryInfoModel(dr.getOrderId(),dr.getDeliveryTrackerNo(),dr.getStatus());
		return deliveryInfo;
	}

}
