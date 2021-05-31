package indi.cc.vendingmachine.bean;



//お金引き出しの記録
public class CashRecords {
	private int id;	//番号
	private String administrator;	//操作の管理員
	private int beforeCash;	//引き出し前の合計金額
	private int cash;	//引き出した分の金額
	private int afterCash;	//お金を引き出した後、今のお金の在庫合計金額
	public int getBeforeCash() {
		return beforeCash;
	}
	public void setBeforeCash(int beforeCash) {
		this.beforeCash = beforeCash;
	}
	public int getAfterCash() {
		return afterCash;
	}
	public void setAfterCash(int afterCash) {
		this.afterCash = afterCash;
	}
	private String date;	//お金を引き出した時間
	
	
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

	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
	
}
