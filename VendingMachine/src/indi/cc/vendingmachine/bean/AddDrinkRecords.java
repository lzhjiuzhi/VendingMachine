package indi.cc.vendingmachine.bean;
//商品補充の数量に関するクラス
public class AddDrinkRecords {
	private int id;	//番号
	private String administrator;	//管理員
	private String drinkName;	//商品の名前
	private String date;	//補充の時間
	private int befroeNum;	//補充する前の数量
	private int addNum;	//補充した分の商品数量
	private int nowNum;	//現在の商品数量
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
