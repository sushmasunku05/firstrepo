package in.synxt.secureinventory.service;

import in.synxt.core.ProductOrderModel;

public interface OrderService {
	public ProductOrderModel orderProduct(ProductOrderModel orderModel);
	public ProductOrderModel getOrderDetails(String orderId);
}
