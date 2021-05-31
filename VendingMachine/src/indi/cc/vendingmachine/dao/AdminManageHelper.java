package indi.cc.vendingmachine.dao;

import java.util.Vector;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.bean.AddRecords;
import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.CashRecords;
import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.bean.PurchaseRecords;
import indi.cc.vendingmachine.bean.VendingMachine;

//管理員操作データベースのhelperクラス
public class AdminManageHelper {
	private SqlHelper helper;
	
	public AdminManageHelper(){
		
	}
	
	/**
	 * 管理員インスタンスを取得
	 * @param admin 管理員
	 * @return 管理員インスタンスを戻り
	 */
	public Administrator getAdmin(Administrator admin){
		helper = new SqlHelper();
		Administrator administrator = helper.getAdmin(admin);
		helper.close();
		return administrator;
	}
	
	
	
	
	/**
	 * 管理員登録
	 * @param admin 管理員
	 * @return 登録成功かどうかを戻り
	 */
	public boolean Login(Administrator admin){
		Administrator administrator = getAdmin(admin);
		if(admin.getPassword().equals(administrator.getPassword())){
			return true;
		}
		return false;
	}
	
	/**
	 * 管理員を追加
	 * @param admin	管理員
	 * @return 管理員が追加されたかどうかを戻り
	 */
	public boolean addAdmin(Administrator admin){
		helper = new SqlHelper();
		boolean b = helper.addAdmin(admin);
		helper.close();
		return b;
	}
	
	/**
	 * 管理者のパスワードを変更
	 * @param oldAdmin 元の管理者
	 * @param newAdmin 新しい管理者
	 * @return 変更されたかどうかを戻り
	 */
	public boolean updatePassword(Administrator oldAdmin,Administrator newAdmin){
		helper = new SqlHelper();
		boolean b = helper.updateAdmin(oldAdmin, newAdmin);
		helper.close();
		return b;
	}
	
	
	/**
	 * すべての商品を戻り
	 * @return すべての商品のコレクションを戻り
	 */
	public Vector<Drink> getAllDrink(){
		helper = new SqlHelper();
		Vector<Drink> drinks = helper.getAllDrink();
		helper.close();
		return drinks;
	}
	
	/**
	 * 商品を追加
	 * @param drink 商品のインスタンス
	 * @return	追加できたかどうかを戻り
	 */
	public boolean addDrink(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.addDrink(drink);
		helper.close();
		return b;
	}
	
	/**
	 * 商品の情報を変更
	 * @param oldDrink 古い商品のインスタンス
	 * @param drink 商品のインスタンス
	 * @return 変更できたかどうかを戻り
	 */
	public boolean updateDrink(Drink oldDrink,Drink drink){
		helper = new SqlHelper();
		boolean b = helper.updateDrink(oldDrink, drink);
		helper.close();
		return b;
	}
	
	/**
	 * 商品を削除
	 * @param drink 商品のインスタンス
	 * @return 削除できたかどうかを戻り
	 */
	public boolean deleteDrink(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.deleteDrink(drink);
		helper.close();
		return b;
	}
	
	/**
	 * 商品の数量を変更
	 * @param drink 商品のインスタンス
	 * @return
	 */
	public boolean updateDrinkNum(Drink drink){
		helper = new SqlHelper();
		boolean b = helper.updateDrinkNum(drink);
		helper.close();
		return b;
	}
	
	
	/**
	 * 初始化饮料机对象　商品のインスタンスを初期化
	 * 
	 */
	public void getVendingMachine(){
		helper = new SqlHelper();
		helper.getVendingMachine();
		helper.close();
	}
	
	
	/**
	 * マシンのインスタンスを変更
	 * @param machine マシンのインスタンス
	 * @return 変更できたかどうかを戻り
	 */
	public boolean updateVendingMachine(VendingMachine machine){
		helper = new SqlHelper();
		boolean b = helper.updateVendingMachine(machine);
		helper.close();
		return b;
	}
	
	/**
	 * 細かいお金の補充履歴　
	 * @return 細かいお金の補充履歴のコレクションを戻り
	 */
	public Vector<AddRecords> getAllAddRecords(){
		helper = new SqlHelper();
		Vector<AddRecords> records  = helper.getAllAddRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * 細かいお金の補充履歴を追加
	 * @param record 細かいお金の補充履歴
	 */
	public void addAddRecords(AddRecords record){
		helper = new SqlHelper();
		helper.addAddRecords(record);
		helper.close();
	}
	
	
	
	/**
	 * すべてのお金の引き出し履歴を取得
	 * @return お金の引き出し履歴のコレクションを戻り
	 */
	public Vector<CashRecords> getAllCashRecords(){
		helper = new SqlHelper();
		Vector<CashRecords> records  = helper.getAllCashRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * お金の引き出し履歴を追加
	 * @param record
	 */
	public void addCashRecords(CashRecords record){
		helper = new SqlHelper();
		helper.addCashRecords(record);
		helper.close();
		
	}
	
	/**
	 * すべての顧客の購入履歴を取得
	 * @return 顧客の購入履歴のコレクションを戻り
	 */
	public Vector<PurchaseRecords> getAllPurchaseRecords(){
		helper = new SqlHelper();
		Vector<PurchaseRecords> records  = helper.getAllPurchaseRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * すべての商品の補充履歴を取得
	 * @return すべての商品の補充履歴を戻り
	 */
	public Vector<AddDrinkRecords> getAllAddDrinkRecords(){
		helper = new SqlHelper();
		Vector<AddDrinkRecords> records = helper.getAllAddDrinkRecords();
		helper.close();
		return records;
	}
	
	
	/**
	 * 商品の補充履歴を追加
	 * @param record 商品の補充履歴
	 */
	public void addAddDrinkRecords(AddDrinkRecords record){
		helper = new SqlHelper();
		helper.addAddDrinkRecords(record);
		helper.close();
		
	}
}
