package indi.cc.vendingmachine.bean;
//商品のクラス
public class Drink {
	private String id;	//商品の番号
	private String drinkName;	//商品の名前
	private String drinkImg;	//商品の画像
	private int price;	//商品の値段
	private int quantity;	//商品の数量
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDrinkName() {
		return drinkName;
	}
	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}
	public String getDrinkImg() {
		return drinkImg;
	}
	public void setDrinkImg(String drinkImg) {
		this.drinkImg = drinkImg;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
