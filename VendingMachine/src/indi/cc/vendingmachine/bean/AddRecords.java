package indi.cc.vendingmachine.bean;


//Ӳ؛�a����Ěs
public class AddRecords {
	private int id;	//����
	private String administrator;	//����T
	private int  beforeAdd;	//�a��ǰ�Τ���κ�Ӌ���~
	private int addAmount;	//�a�䤷��Ӳ؛�κ�Ӌ���~
	private int afterAdd;	//�a����Τ���κ�Ӌ���~
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
	private String date;	//�a��r�g
	
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
