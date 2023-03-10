package egovframework.example.sample.VO;

public class OrderDetailsVO {

	private int orderNumber;
	
	private String productCode;
	
	private int quantityOrdered;
	
	private int priceEach;
	
	private int orderLineNumber;
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getProductCode() {
		return productCode;
	}
	
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	
	public int getQuantityOrdered() {
		return quantityOrdered;
	}
	
	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}
	
	public int getPriceEach() {
		return priceEach;
	}
	
	public void setPriceEach(int priceEach) {
		this.priceEach = priceEach;
	}
	
	public int getOrderLineNumber() {
		return orderLineNumber;
	}
	
	public void setOrderLineNumber(int orderLineNumber) {
		this.orderLineNumber = orderLineNumber;
	}
}
