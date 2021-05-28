package indi.cc.vendingmachine.bean;

import indi.cc.vendingmachine.dao.AdminManageHelper;

//自動販売機のクラス
public class VendingMachine {
	private int totalAmount;	//お会計の合計金額
	private int coin;	//硬貨

	
	 //staticを使い、インスタンスを保存する
    private static VendingMachine instance;  
    // privateを使い、複数の自動販売機のインスタンスが生成されることを防ぐ
    private VendingMachine(){  
      
    }  
    //staticメソッドでインスタンスを戻し
    public static VendingMachine getInstance(){  
        //实例化类实例前，先检查该实例是否存在  
        if(instance == null){  
            //如果不存在，则新建一个实例  
            instance = new VendingMachine();  
        }  
        //返回该类的成员变量：该类的实例   
        return instance;      
    }  
	
	

	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}

	
}
