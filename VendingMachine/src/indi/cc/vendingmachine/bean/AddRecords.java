package indi.cc.vendingmachine.bean;


//硬貨補充の履歴
public class AddRecords {
	private int id;	//番号
	private String administrator;	//管理員
	private int  beforeAdd;	//補充前のお金の合計金額
	private int addAmount;	//補充した硬貨の合計金額
	private int afterAdd;	//補充後のお金の合計金額
	public int getBeforeAdd() {
		return beforeAdd;
	}
	public void setBeforeAdd(int beforeAdd) {
		this.beforeAdd = beforeAdd;
	}
	public int getAfterAdd() {
		return afterAdd;
	}
	public void setAfterAdd(int afterAdd) {
		this.afterAdd = afterAdd;
	}
	private String date;	//補充時間
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAdministrator() {
		return administrator;
	}
	public void setAdministrator(String administrator) {
		this.administrator = administrator;
	}
	
	public int getAddAmount() {
		return addAmount;
	}
	public void setAddAmount(int addAmount) {
		this.addAmount = addAmount;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}
