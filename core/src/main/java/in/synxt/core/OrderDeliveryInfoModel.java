package in.synxt.core;

import java.io.Serializable;

public class OrderDeliveryInfoModel implements Serializable{
	
	private String orderId;
	private String deliveryTrackerNo;
	private String currentStatus;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getDeliveryTrackerNo() {
		return deliveryTrackerNo;
	}
	public void setDeliveryTrackerNo(String deliveryTrackerNo) {
		this.deliveryTrackerNo = deliveryTrackerNo;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public OrderDeliveryInfoModel(String orderId, String deliveryTrackerNo, String currentStatus) {
		super();
		this.orderId = orderId;
		this.deliveryTrackerNo = deliveryTrackerNo;
		this.currentStatus = currentStatus;
	}
	public OrderDeliveryInfoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "OrderDeliveryInfoModel [orderId=" + orderId + ", deliveryTrackerNo=" + deliveryTrackerNo
				+ ", currentStatus=" + currentStatus + "]";
	}
	
	
	
}
