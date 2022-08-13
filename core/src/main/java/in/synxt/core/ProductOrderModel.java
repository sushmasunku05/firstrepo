package in.synxt.core;

import java.io.Serializable;

public class ProductOrderModel implements Serializable{
	
	private String orderId;
	private int productId;
	private int userId;
	private String orderStatus;
	private int quantity;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductOrderModel [orderId=" + orderId + ", productId=" + productId + ", userId=" + userId
				+ ", orderStatus=" + orderStatus + ", quantity=" + quantity + "]";
	}
	
}
