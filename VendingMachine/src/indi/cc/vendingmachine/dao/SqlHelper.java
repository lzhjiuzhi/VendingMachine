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
	//�����������ݿ�����Ҫ�Ķ���
		private PreparedStatement ps = null;
		private ResultSet rs = null;
		private Connection ct = null;
		

		//������ݿ������
		private  void init(){
			try {
				Class.forName(DRIVER);
				ct = DriverManager.getConnection(URL, USERNAME, PASSWORD);// ������ݿ�����
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
		
		//�ر����ݿ���Դ
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
//����Ա����////////////////////
///////////////////////////////		
		
		/**
		 * �õ�����Ա����
		 * @param admin ����Ա
		 * @return	���ع���Ա����
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
		 * ��ӹ���Ա
		 * @param admin ����Ա
		 * @return	�����Ƿ���ӳɹ�
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
		 * �޸Ĺ���Ա����
		 * @param oldAdmin �ɹ���Ա
		 * @param newAdmin �¹���Ա
		 * @return �Ƿ��޸ĳɹ�
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
		 * ����id�ŷ���ָ��������
		 * @param drink ���϶���
		 * @return �������϶���
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
		 * ����������ϼ���
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
	 *  Get Sum of money
	 */
	public int getSumOfMoney(){
		int money = 0;
		try{
			ps = ct.prepareStatement("select sum(price) from Drink");
			rs= ps.executeQuery();
			while(rs.next()){
				money = rs.getInt(1);
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		return money;
	}
	/**
		 * �������
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
		 * �޸�������Ϣ
		 * @param oldDrink ������
		 * @param drink ����
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
		 * ɾ������
		 * @param drink ���϶���
		 * @return �����Ƿ�ɾ���ɹ�
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
		 * �޸���������
		 * @param drink ���϶���
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
		 * ������ϻ�����
		 * @return �������ϻ�����
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
		 * �޸����ϻ�����
		 * @param machine ���ϻ�����
		 * @return �����Ƿ��޸ĳɹ�
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
		 * ��ù˿͹����¼
		 * @return ���ع����¼
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
		 * ������еĲ�����Ǯ��¼
		 * @return ���ز�����Ǯ��¼����
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
		 * ��Ӳ�����Ǯ��¼
		 * @param record ������Ǯ��¼
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
		 * �õ����е�ȡ�ּ�¼
		 * @return ����ȡ�ּ�¼����
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
		 * ���ȡ�ּ�¼
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
		 * �õ�����������ϵļ�¼
		 * @return ��������������ϼ�¼
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
		 * ������ϲ����¼
		 * @param record ���ϲ����¼
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
//�˿Ͳ���/////////////////
//////////////////////////		
		
		/**
		 * ��ӹ˿͹����¼
		 * @param record �����¼
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
		 * ��������
		 * @param drink ���϶���
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
