package indi.cc.vendingmachine.bean;



//ُ�I�Ěs�Υ��饹
public class PurchaseRecords {
	private int customerId;	//ͤη���
	private String date;	//ُ�I�Εr�g
	private String drinkName;	//ُ�뤷����Ʒ����ǰ
	private int price;	//���~
	private int payment;	//��֧�B�����~
	private int repayment;	//�������ν��~
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getRepayment() {
		return repayment;
	}
	public void setRepayment(int repayment) {
		this.repayment = repayment;
	}
	
	
}
