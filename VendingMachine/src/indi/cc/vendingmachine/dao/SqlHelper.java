package indi.cc.vendingmachine.dao;


import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.bean.AddRecords;
import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.CashRecords;
import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.bean.PurchaseRecords;
import indi.cc.vendingmachine.bean.VendingMachine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SqlHelper implements JdbcConfig{
	//データベースに接続するのに必要なインスタンスを定義する
		private PreparedStatement ps = null;
		private ResultSet rs = null;
		private Connection ct = null;
		

		//データベースとのconnectionを取得
		private  void init(){
			try {
				Class.forName(DRIVER);
				ct = DriverManager.getConnection(URL, USERNAME, PASSWORD);// データベースとのconnectionを取得
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public SqlHelper(){
			this.init();
		}
		
		//データベースのリソースをシャットダウン
		public void close()	{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
					
///////////////////////////////
//管理員操作////////////////////
///////////////////////////////		
		
		/**
		 * 管理員のインスタンスを取得
		 * @param admin 管理員
		 * @return	管理員のインスタンスを戻り
		 */
		public Administrator getAdmin(Administrator admin){
			Administrator administrator = new Administrator();
			try {
				ps = ct.prepareStatement("select * from Administrator where username=binary(?)");
				ps.setString(1, admin.getUsername());
				rs = ps.executeQuery();
				if(rs.next()){
					administrator.setUsername(rs.getString(1));
					administrator.setPassword(rs.getString(2));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return administrator;
		}
		
		/**
		 * 管理員を追加
		 * @param admin 管理員
		 * @return	追加できたかどうかを戻り
		 */
		public boolean addAdmin(Administrator admin){
			boolean b = true;
			try {
				ps = ct.prepareStatement("insert into Administrator(username,passwords) values(?,?)");
				ps.setString(1, admin.getUsername());
				ps.setString(2, admin.getPassword());
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		/**
		 * 管理員のパスワードを変更
		 * @param oldAdmin 元の管理員
		 * @param newAdmin 新しい管理員
		 * @return 変更できたかどうかを戻り
		 */
		public boolean updateAdmin(Administrator oldAdmin,Administrator newAdmin){
			boolean b = true;
			try {
				ps = ct.prepareStatement("update Administrator set passwords=? where username=?");
				ps.setString(1, newAdmin.getPassword());
				ps.setString(2, oldAdmin.getUsername());
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		
		/**
		 * id番号に基づいて、指定された商品を戻り
		 * @param drink 商品のインスタンス
		 * @return 返回饮料对象商品のインスタンを戻り
		 */
		public Drink getDrink(Drink drink){
			try {
				ps = ct.prepareStatement("select * from Drink where drinkId = ?");
				ps.setString(1, drink.getId());
				rs = ps.executeQuery();
				if(rs.next()){
					drink.setId(rs.getString(1));
					drink.setDrinkName(rs.getString(2));
					drink.setDrinkImg(rs.getString(3));
					drink.setPrice(rs.getInt(4));
					drink.setQuantity(rs.getInt(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return drink;
		}
		
		
		
		
		/**
		 * すべての商品のコレクションを取得
		 * @return
		 */
		public Vector<Drink> getAllDrink(){
			Vector<Drink> drinks = new Vector<Drink>();
			try {
				ps = ct.prepareStatement("select * from Drink");
				rs = ps.executeQuery();
				while(rs.next()){
					Drink drink = new Drink();
					drink.setId(rs.getString(1));
					drink.setDrinkName(rs.getString(2));
					drink.setDrinkImg(rs.getString(3));
					drink.setPrice(rs.getInt(4));
					drink.setQuantity(rs.getInt(5));
					drinks.add(drink);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return drinks;
		}
		
		
		/**
		 * 商品を追加
		 * @param drink
		 * @return
		 */
		public boolean addDrink(Drink drink){
			boolean b = true;
			try {
				ps = ct.prepareStatement("insert into Drink(drinkId,drinkName,drinkImg,price) values (?,?,?,?)");
				ps.setString(1, drink.getId());
				ps.setString(2, drink.getDrinkName());
				ps.setString(3, drink.getDrinkImg());
				ps.setInt(4, drink.getPrice());
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		
		/**
		 * 商品の情報を変更
		 * @param oldDrink 古い商品
		 * @param drink 商品
		 * @return
		 */
		public boolean updateDrink(Drink oldDrink,Drink drink){
			boolean b = true;
			try {
				ps = ct.prepareStatement("update Drink set drinkId=? ,drinkName=?, drinkImg=? ,price=? where drinkId=?");
				ps.setString(1, drink.getId());
				ps.setString(2, drink.getDrinkName());
				ps.setString(3, drink.getDrinkImg());
				ps.setInt(4, drink.getPrice());
				ps.setString(5, oldDrink.getId());
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		/**
		 * 商品を削除
		 * @param drink 商品のインスタンス
		 * @return 削除できたかどうかを戻り
		 */
		public boolean deleteDrink(Drink drink){
			boolean b = true;
			try {
				ps = ct.prepareStatement("delete from Drink where drinkId=?");
				ps.setString(1, drink.getId());
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		
		/**
		 * 商品数量を変更
		 * @param drink 商品のインスタンス
		 * @return
		 */
		public boolean updateDrinkNum(Drink drink){
			boolean b = true;
			try {
				ps = ct.prepareStatement("update Drink set quantity=? where drinkId=?");
				ps.setInt(1, drink.getQuantity());
				ps.setString(2, drink.getId());
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		
		/**
		 * マシンのインスタンスを取得
		 * @return マシンのインスタンスを戻り
		 */
		public VendingMachine getVendingMachine(){
			VendingMachine machine = VendingMachine.getInstance();
			try {
				ps = ct.prepareStatement("select * from VendingMachine where id=1");
				rs = ps.executeQuery();
				if(rs.next()){
					machine.setTotalAmount(rs.getInt(2));
					machine.setCoin(rs.getInt(3));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return machine;
		}
		
		
		/**
		 * マシンのインスタンスを変更
		 * @param machine マシンのインスタンス
		 * @return 変更できたかどうかを戻り
		 */
		public boolean updateVendingMachine(VendingMachine machine){
			boolean b = true;
			try {
				ps = ct.prepareStatement("update VendingMachine set totalAmount=?, coin=? where id=1");
				ps.setInt(1, machine.getTotalAmount());
				ps.setInt(2, machine.getCoin());
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		
		/**
		 * 顧客の購入履歴を取得
		 * @return 購入履歴を戻り
		 */
		public Vector<PurchaseRecords> getAllPurchaseRecords(){
			Vector<PurchaseRecords> records = new Vector<PurchaseRecords>();
			try {
				ps = ct.prepareStatement("select * from PurchaseRecords order by customerId asc");
				rs = ps.executeQuery();
				while(rs.next()){
					PurchaseRecords record = new PurchaseRecords();
					record.setCustomerId(rs.getInt(1));
					record.setDrinkName(rs.getString(2));
					record.setPrice(rs.getInt(3));
					record.setPayment(rs.getInt(4));
					record.setRepayment(rs.getInt(5));
					record.setDate(rs.getString(6));
					records.add(record);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return records;
		}
			
		
		
		/**
		 * 細かいお金の補充履歴を取得
		 * @return 細かいお金の補充履歴のコレクションを戻り
		 */
		public Vector<AddRecords> getAllAddRecords(){
			Vector<AddRecords> records = new Vector<AddRecords>();
			try {
				ps = ct.prepareStatement("select * from AddRecords order by id asc");
				rs = ps.executeQuery();
				while(rs.next()){
					AddRecords record = new AddRecords();
					record.setId(rs.getInt(1));
					record.setAdministrator(rs.getString(2));
					record.setBeforeAdd(rs.getInt(3));
					record.setAddAmount(rs.getInt(4));
					record.setAfterAdd(rs.getInt(5));
					record.setDate(rs.getString(6));
					records.add(record);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return records;
			
		}
		
		
		
		/**
		 * 細かいお金の補充履歴を追加
		 * @param record 細かいお金の補充履歴
		 */
		public void addAddRecords(AddRecords record){
			try {
				ps = ct.prepareStatement("insert into AddRecords (administrator,beforeAdd,addAmount,afterAdd,add_Time) values(?,?,?,?,now())");
				ps.setString(1, record.getAdministrator());
				ps.setInt(2, record.getBeforeAdd());
				ps.setInt(3, record.getAddAmount());
				ps.setInt(4, record.getAfterAdd());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/**
		 * すべてのお金の引き出し記録を取得
		 * @return 引き出し履歴のコレクションを戻り
		 */
		public Vector<CashRecords> getAllCashRecords(){
			Vector<CashRecords> records = new Vector<CashRecords>();
			try {
				ps = ct.prepareStatement("select * from CashRecords order by id asc");
				rs = ps.executeQuery();
				while(rs.next()){
					CashRecords record = new CashRecords();
					record.setId(rs.getInt(1));
					record.setAdministrator(rs.getString(2));
					record.setBeforeCash(rs.getInt(3));
					record.setCash(rs.getInt(4));
					record.setAfterCash(rs.getInt(5));
					record.setDate(rs.getString(6));
					records.add(record);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return records;
		}
		
		
		/**
		 * お金の引き出し履歴を追加
		 * @param record
		 */
		public void addCashRecords(CashRecords record){
			try {
				ps = ct.prepareStatement("insert into CashRecords (administrator,beforeCash,cash,afterCash,CashTime) values(?,?,?,?,now())");
				ps.setString(1, record.getAdministrator());
				ps.setInt(2, record.getBeforeCash());
				ps.setInt(3, record.getCash());
				ps.setInt(4, record.getAfterCash());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/**
		 * 商品の補充履歴を取得
		 * @return すべての商品の補充履歴を戻り
		 */
		public Vector<AddDrinkRecords> getAllAddDrinkRecords(){
			Vector<AddDrinkRecords> records = new Vector<AddDrinkRecords>();
			try {
				ps = ct.prepareStatement("select * from addDrinkRecords");
				rs = ps.executeQuery();
				while(rs.next()){
					AddDrinkRecords record = new AddDrinkRecords();
					record.setId(rs.getInt(1));
					record.setAdministrator(rs.getString(2));
					record.setDrinkName(rs.getString(3));
					record.setDate(rs.getString(4));
					record.setBefroeNum(rs.getInt(5));
					record.setAddNum(rs.getInt(6));
					record.setNowNum(rs.getInt(7));
					records.add(record);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return records;
		}
		
		
		/**
		 * 商品の補充履歴を追加
		 * @param record 商品の補充履歴
		 */
		public void addAddDrinkRecords(AddDrinkRecords record){
			try {
				ps = ct.prepareStatement("insert into addDrinkRecords (administrator,drinkName,before_num,add_num,now_num,add_Time) values(?,?,?,?,?,now())");
				ps.setString(1, record.getAdministrator());
				ps.setString(2, record.getDrinkName());
				ps.setInt(3, record.getBefroeNum());
				ps.setInt(4, record.getAddNum());
				ps.setInt(5, record.getNowNum());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
///////////////////////////
//顧客操作/////////////////
//////////////////////////		
		
		/**
		 * 顧客購入履歴を追加
		 * @param record 購入履歴
		 */
		public void addPurchaseRecords(PurchaseRecords record){
			try {
				ps = ct.prepareStatement("insert into PurchaseRecords(drinkName,price,payment,repayment,buyTime) values(?,?,?,?,now())");
				ps.setString(1, record.getDrinkName());
				ps.setInt(2, record.getPrice());
				ps.setInt(3, record.getPayment());
				ps.setInt(4, record.getRepayment());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/**
		 * 商品購入
		 * @param drink 商品のインスタンス
		 */
		public void buyDrink(Drink drink){
			try {
				ps = ct.prepareStatement("update Drink set quantity=? where drinkId=?");
				ps.setInt(1, drink.getQuantity()-1);
				ps.setString(2, drink.getId());
				ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
}
