package egovframework.example.sample.VO;

import java.util.Date;

public class PaymentsVO {

	private int customerNumber;
	
	private int checkNumber;
	
	private Date paymentDate;
	
	private String amount;
	
	public int getCustomerNumber() {
		return customerNumber;
	}
	
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	
	public int getCheckNumber() {
		return checkNumber;
	}
	
	public void setCheckNumber(int checkNumber) {
		this.checkNumber = checkNumber;
	}
	
	public Date getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	public String getAmount() {
		return amount;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
}
