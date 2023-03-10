package egovframework.example.sample.VO;

import java.util.Date;

public class OrdersVO {

	private int orderNumber;
	
	private Date orderDate;
	
	private Date requiredDate;
	
	private String status;
	
	private String comments;
	
	private int customerNumber;
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public Date getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public Date getRequiredDate() {
		return requiredDate;
	}
	
	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
}
