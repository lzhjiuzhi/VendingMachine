package indi.cc.vendingmachine.bean;
//�������������ļ�¼��
public class AddDrinkRecords {
	private int id;	//ID�Ǥ�
	private String administrator;	//��������Ա
	private String drinkName;	//��������
	private String date;	//���ʱ��
	private int befroeNum;	//���ǰ������
	private int addNum;	//��ӵ�����
	private int nowNum;	//���ڵ�����
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
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getBefroeNum() {
		return befroeNum;
	}
	public void setBefroeNum(int befroeNum) {
		this.befroeNum = befroeNum;
	}
	public int getAddNum() {
		return addNum;
	}
	public void setAddNum(int addNum) {
		this.addNum = addNum;
	}
	public int getNowNum() {
		return nowNum;
	}
	public void setNowNum(int nowNum) {
		this.nowNum = nowNum;
	}
	
	
}
