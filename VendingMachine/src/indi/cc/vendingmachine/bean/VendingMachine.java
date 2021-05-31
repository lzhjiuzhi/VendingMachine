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
    //staticメソッドでインスタンスを戻り
    public static VendingMachine getInstance(){  
        //インスタンスを作る前に、インスタンスもう既に存在しているかどうかをチェック
        if(instance == null){  
            //存在しないなら、新しいインスタンスを生成  
            instance = new VendingMachine();  
        }  
        //お戻り値：クラスのインスタンス   
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
