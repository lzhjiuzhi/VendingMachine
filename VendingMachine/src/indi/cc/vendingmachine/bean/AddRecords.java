package indi.cc.vendingmachine.bean;


//������Ǯ��¼
public class AddRecords {
	private int id;	//ID�Ǥ�
	private String administrator;	//��������Ա
	private int  beforeAdd;	//����ǰ�Ľ��
	private int addAmount;	//������Ǯ���
	private int afterAdd;	//�����Ľ��
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
	private String date;	//����ʱ��
	
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
