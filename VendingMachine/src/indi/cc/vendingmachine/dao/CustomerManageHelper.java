package indi.cc.vendingmachine.dao;

import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.bean.PurchaseRecords;

//Ͳ����ǩ`���٩`����helper���饹
public class CustomerManageHelper {
	private SqlHelper helper;
	/**
	 * ͤ�ُ���Ěs��׷��
	 * @param record ُ���Ěs
	 */
	public void addPurchaseRecords(PurchaseRecords record){
		helper = new SqlHelper();
		helper.addPurchaseRecords(record);
		helper.close();
	}
	
	/**
	 * ��Ʒ��ُ��
	 * @param drink ��Ʒ�Υ��󥹥���
	 */
	public void buyDrink(Drink drink){
		helper = new SqlHelper();
		helper.buyDrink(drink);
		helper.close();
		
	}
	
}
