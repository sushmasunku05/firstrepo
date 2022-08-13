package in.synxt.secureinventory.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="orders")
@SequenceGenerator(name="seqid",sequenceName="seq_order",initialValue=1,allocationSize=1)
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqid")
	@Column(name="orderid")
	private int orderId;
	
	@Column(name="productid")
	private int productId;
	
	@Column(name="userid")
	private int userId;
	
	@Column(name="orderdate")
	private Date orderDate;
	
	@Column(name="orderstatus")
	private String orderStatus;
	private int quantity;
	
	@Column(name="deliverytrackerno")
	private String deliveryTrackerNo;
	
	@Column(name="orderpid")
	private String orderPid;
	
	public String getDeliveryTrackerNo() {
		return deliveryTrackerNo;
	}
	public void setDeliveryTrackerNo(String deliveryTrackerNo) {
		this.deliveryTrackerNo = deliveryTrackerNo;
	}
	public String getOrderPid() {
		return orderPid;
	}
	public void setOrderPid(String orderPid) {
		this.orderPid = orderPid;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
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
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
		return "Order [orderId=" + orderId + ", productId=" + productId + ", userId=" + userId + ", orderDate="
				+ orderDate + ", orderStatus=" + orderStatus + "]";
	}
	
}
