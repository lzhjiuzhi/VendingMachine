package indi.cc.vendingmachine.dao;

import java.util.Vector;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.bean.AddRecords;
import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.CashRecords;
import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.bean.PurchaseRecords;
import indi.cc.vendingmachine.bean.VendingMachine;

//����Ա�������ݿ������
public class AdminManageHelper {
	private SqlHelper helper;

	public AdminManageHelper(){

	}

	/**
	 * �õ�����Ա���� 
	 * @param admin ����Ա
	 * @return ���ع���Ա����
	 */
	public Administrator getAdmin(Administrator admin){
		helper = new SqlHelper();
		Administrator administrator = helper.getAdmin(admin);
		helper.close();
		return administrator;
	}




	/**
	 * ����Ա��½
	 * @param admin ����Ա
	 * @return �����Ƿ��½�ɹ�
	 */
	public boolean Login(Administrator admin){
		Administrator administrator = getAdmin(admin);
		if(admin.getPassword().equals(administrator.getPassword())){
			return true;
		}
		return false;
	}

	/**
	 * ��ӹ���Ա
	 * @param admin	����Ա
	 * @return �����Ƿ���ӳɹ�
	 */
	public boolean addAdmin(Administrator admin){
		helper = new SqlHelper();
		boolean b = helper.addAdmin(admin);
		helper.close();
		return b;
	}

	/**
	 * �޸Ĺ���Ա����
	 * @param oldAdmin �ɹ���Ա
	 * @param newAdmin �¹���Ա
	 * @return �����Ƿ��޸ĳɹ�
	 */
	public boolean updatePassword(Administrator oldAdmin,Administrator newAdmin){
		helper = new SqlHelper();
		boolean b = helper.updateAdmin(oldAdmin, newAdmin);
		helper.close();
		return b;
	}


	/**
	 * �������е�����
	 * @return ���е����ϼ���
	 */
	public Vector<Drink> getAllDrink(){
		helper = new SqlHelper();
		Vector<Drink> drinks = helper.getAllDrink();
		helper.close();
		return drinks;
	}

	/**
	 * �������
	 * @param drink ���϶���
	 * @return	�Ƿ���ӳɹ�
	 */
	public boolean addDrink(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.addDrink(drink);
		helper.close();
		return b;
	}

	/**
	 * �޸�������Ϣ
	 * @param oldDrink �����϶���
	 * @param drink ���϶���
	 * @return �����Ƿ��޸ĳɹ�
	 */
	public boolean updateDrink(Drink oldDrink,Drink drink){
		helper = new SqlHelper();
		boolean b = helper.updateDrink(oldDrink, drink);
		helper.close();
		return b;
	}

	/**
	 * ɾ������
	 * @param drink ���϶���
	 * @return �����Ƿ��޸ĳɹ�
	 */
	public boolean deleteDrink(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.deleteDrink(drink);
		helper.close();
		return b;
	}

	/**
	 * �޸���������
	 * @param drink ���϶���
	 * @return
	 */
	public boolean updateDrinkNum(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.updateDrinkNum(drink);
		helper.close();
		return b;
	}


	/**
	 * ��ʼ�����ϻ�����
	 *
	 */
	public void getVendingMachine(){
		helper = new SqlHelper();
		helper.getVendingMachine();
		helper.close();
	}


	/**
	 * �޸����ϻ�����
	 * @param machine ���ϻ�����
	 * @return �����Ƿ��޸ĳɹ�
	 */
	public boolean updateVendingMachine(VendingMachine machine){
		helper = new SqlHelper();
		boolean b = helper.updateVendingMachine(machine);
		helper.close();
		return b;
	}

	/**
	 * ������е���Ǯ�����¼
	 * @return ������Ǯ�����¼����
	 */
	public Vector<AddRecords> getAllAddRecords(){
		helper = new SqlHelper();
		Vector<AddRecords> records  = helper.getAllAddRecords();
		helper.close();
		return records;
	}


	/**
	 * ��Ӳ�����Ǯ��¼
	 * @param record ������Ǯ��¼
	 */
	public void addAddRecords(AddRecords record){
		helper = new SqlHelper();
		helper.addAddRecords(record);
		helper.close();
	}



	/**
	 * ������е�ȡ�ּ�¼
	 * @return ����ȡ�ּ�¼����
	 */
	public Vector<CashRecords> getAllCashRecords(){
		helper = new SqlHelper();
		Vector<CashRecords> records  = helper.getAllCashRecords();
		helper.close();
		return records;
	}


	/**
	 * ���ȡ�ּ�¼
	 * @param record
	 */
	public void addCashRecords(CashRecords record){
		helper = new SqlHelper();
		helper.addCashRecords(record);
		helper.close();

	}

	/**
	 * ������еĹ˿͹����¼
	 * @return ���ع˿͹����¼����
	 */
	public Vector<PurchaseRecords> getAllPurchaseRecords(){
		helper = new SqlHelper();
		Vector<PurchaseRecords> records  = helper.getAllPurchaseRecords();
		helper.close();
		return records;
	}


	/**
	 * �õ�����������ϵļ�¼
	 * @return ��������������ϼ�¼
	 */
	public Vector<AddDrinkRecords> getAllAddDrinkRecords(){
		helper = new SqlHelper();
		Vector<AddDrinkRecords> records = helper.getAllAddDrinkRecords();
		helper.close();
		return records;
	}


	/**
	 * ������ϲ����¼
	 * @param record ���ϲ����¼
	 */
	public void addAddDrinkRecords(AddDrinkRecords record){
		helper = new SqlHelper();
		helper.addAddDrinkRecords(record);
		helper.close();

	}

	public int getAllSum(){
		helper = new SqlHelper();
		int money = helper.getSumOfMoney();
		helper.close();
		return money;
	}
}
