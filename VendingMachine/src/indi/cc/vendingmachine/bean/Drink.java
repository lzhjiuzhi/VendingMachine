package indi.cc.vendingmachine.bean;
//��Ʒ�Υ��饹
public class Drink {
	private String id;	//��Ʒ�η���
	private String drinkName;	//��Ʒ����ǰ
	private String drinkImg;	//��Ʒ�λ���
	private int price;	//��Ʒ�΂���
	private int quantity;	//��Ʒ������
	
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
