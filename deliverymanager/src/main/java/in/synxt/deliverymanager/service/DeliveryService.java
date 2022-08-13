package in.synxt.deliverymanager.service;

import in.synxt.core.OrderDeliveryInfoModel;
import in.synxt.core.ProductOrderModel;

public interface DeliveryService {
	
	OrderDeliveryInfoModel deliverProduct(ProductOrderModel model);
}
