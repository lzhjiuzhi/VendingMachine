package indi.cc.vendingmachine.bean;



//購買履歴のクラス
public class PurchaseRecords {
	private int customerId;	//顧客の番号
	private String date;	//購買の時間
	private String drinkName;	//購入した商品の名前
	private int price;	//価額
	private int payment;	//お支払い金額
	private int repayment;	//お返しの金額
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
