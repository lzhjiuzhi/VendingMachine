package indi.cc.vendingmachine.dao;

import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.bean.PurchaseRecords;

//顧客操作データベースのhelperクラス
public class CustomerManageHelper {
	private SqlHelper helper;
	/**
	 * 顧客の購入履歴を追加
	 * @param record 購入履歴
	 */
	public void addPurchaseRecords(PurchaseRecords record){
		helper = new SqlHelper();
		helper.addPurchaseRecords(record);
		helper.close();
	}
	
	/**
	 * 商品を購入
	 * @param drink 商品のインスタンス
	 */
	public void buyDrink(Drink drink){
		helper = new SqlHelper();
		helper.buyDrink(drink);
		helper.close();
		
	}
	
}
