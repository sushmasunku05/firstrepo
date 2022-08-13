package in.synxt.deliverymanager.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="deliveryrequests")
@SequenceGenerator(name="seqdr",sequenceName="seq_dr",initialValue=1,allocationSize=1)
public class DeliveryRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqdr")
	private int id;
	
	@Column(name="deliverytrackerno")
	private String deliveryTrackerNo;
	
	@Column(name="orderid")
	private String orderId;
	
	private String status;
	
	private Date orderDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeliveryTrackerNo() {
		return deliveryTrackerNo;
	}

	public void setDeliveryTrackerNo(String deliveryTrackerNo) {
		this.deliveryTrackerNo = deliveryTrackerNo;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
}
