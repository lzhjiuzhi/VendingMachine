package indi.cc.vendingmachine.dao;

import java.util.Vector;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.bean.AddRecords;
import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.CashRecords;
import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.bean.PurchaseRecords;
import indi.cc.vendingmachine.bean.VendingMachine;

//����T�����ǩ`���٩`����helper���饹
public class AdminManageHelper {
	private SqlHelper helper;
	
	public AdminManageHelper(){
		
	}
	
	/**
	 * ����T���󥹥��󥹤�ȡ��
	 * @param admin ����T
	 * @return ����T���󥹥��󥹤����
	 */
	public Administrator getAdmin(Administrator admin){
		helper = new SqlHelper();
		Administrator administrator = helper.getAdmin(admin);
		helper.close();
		return administrator;
	}
	
	
	
	
	/**
	 * ����T���h
	 * @param admin ����T
	 * @return ���h�ɹ����ɤ��������
	 */
	public boolean Login(Administrator admin){
		Administrator administrator = getAdmin(admin);
		if(admin.getPassword().equals(administrator.getPassword())){
			return true;
		}
		return false;
	}
	
	/**
	 * ����T��׷��
	 * @param admin	����T
	 * @return ����T��׷�Ӥ��줿���ɤ��������
	 */
	public boolean addAdmin(Administrator admin){
		helper = new SqlHelper();
		boolean b = helper.addAdmin(admin);
		helper.close();
		return b;
	}
	
	/**
	 * �����ߤΥѥ���`�ɤ���
	 * @param oldAdmin Ԫ�ι�����
	 * @param newAdmin �¤���������
	 * @return ������줿���ɤ��������
	 */
	public boolean updatePassword(Administrator oldAdmin,Administrator newAdmin){
		helper = new SqlHelper();
		boolean b = helper.updateAdmin(oldAdmin, newAdmin);
		helper.close();
		return b;
	}
	
	
	/**
	 * ���٤Ƥ���Ʒ�����
	 * @return ���٤Ƥ���Ʒ�Υ��쥯���������
	 */
	public Vector<Drink> getAllDrink(){
		helper = new SqlHelper();
		Vector<Drink> drinks = helper.getAllDrink();
		helper.close();
		return drinks;
	}
	
	/**
	 * ��Ʒ��׷��
	 * @param drink ��Ʒ�Υ��󥹥���
	 * @return	׷�ӤǤ������ɤ��������
	 */
	public boolean addDrink(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.addDrink(drink);
		helper.close();
		return b;
	}
	
	/**
	 * ��Ʒ��������
	 * @param oldDrink �Ť���Ʒ�Υ��󥹥���
	 * @param drink ��Ʒ�Υ��󥹥���
	 * @return ����Ǥ������ɤ��������
	 */
	public boolean updateDrink(Drink oldDrink,Drink drink){
		helper = new SqlHelper();
		boolean b = helper.updateDrink(oldDrink, drink);
		helper.close();
		return b;
	}
	
	/**
	 * ��Ʒ������
	 * @param drink ��Ʒ�Υ��󥹥���
	 * @return �����Ǥ������ɤ��������
	 */
	public boolean deleteDrink(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.deleteDrink(drink);
		helper.close();
		return b;
	}
	
	/**
	 * ��Ʒ����������
	 * @param drink ��Ʒ�Υ��󥹥���
	 * @return
	 */
	public boolean updateDrinkNum(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.updateDrinkNum(drink);
		helper.close();
		return b;
	}
	
	
	/**
	 * ��ʼ�����ϻ�������Ʒ�Υ��󥹥��󥹤���ڻ�
	 * 
	 */
	public void getVendingMachine(){
		helper = new SqlHelper();
		helper.getVendingMachine();
		helper.close();
	}
	
	
	/**
	 * �ޥ���Υ��󥹥��󥹤���
	 * @param machine �ޥ���Υ��󥹥���
	 * @return ����Ǥ������ɤ��������
	 */
	public boolean updateVendingMachine(VendingMachine machine){
		helper = new SqlHelper();
		boolean b = helper.updateVendingMachine(machine);
		helper.close();
		return b;
	}
	
	/**
	 * ������������a���Ěs��
	 * @return ������������a���Ěs�Υ��쥯���������
	 */
	public Vector<AddRecords> getAllAddRecords(){
		helper = new SqlHelper();
		Vector<AddRecords> records  = helper.getAllAddRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * ������������a���Ěs��׷��
	 * @param record ������������a���Ěs
	 */
	public void addAddRecords(AddRecords record){
		helper = new SqlHelper();
		helper.addAddRecords(record);
		helper.close();
	}
	
	
	
	/**
	 * ���٤ƤΤ�������������Ěs��ȡ��
	 * @return ��������������Ěs�Υ��쥯���������
	 */
	public Vector<CashRecords> getAllCashRecords(){
		helper = new SqlHelper();
		Vector<CashRecords> records  = helper.getAllCashRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * ��������������Ěs��׷��
	 * @param record
	 */
	public void addCashRecords(CashRecords record){
		helper = new SqlHelper();
		helper.addCashRecords(record);
		helper.close();
		
	}
	
	/**
	 * ���٤Ƥ�ͤ�ُ���Ěs��ȡ��
	 * @return ͤ�ُ���Ěs�Υ��쥯���������
	 */
	public Vector<PurchaseRecords> getAllPurchaseRecords(){
		helper = new SqlHelper();
		Vector<PurchaseRecords> records  = helper.getAllPurchaseRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * ���٤Ƥ���Ʒ���a���Ěs��ȡ��
	 * @return ���٤Ƥ���Ʒ���a���Ěs�����
	 */
	public Vector<AddDrinkRecords> getAllAddDrinkRecords(){
		helper = new SqlHelper();
		Vector<AddDrinkRecords> records = helper.getAllAddDrinkRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * ��Ʒ���a���Ěs��׷��
	 * @param record ��Ʒ���a���Ěs
	 */
	public void addAddDrinkRecords(AddDrinkRecords record){
		helper = new SqlHelper();
		helper.addAddDrinkRecords(record);
		helper.close();
		
	}
}
