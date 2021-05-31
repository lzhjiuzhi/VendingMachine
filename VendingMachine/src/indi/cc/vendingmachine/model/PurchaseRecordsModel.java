package indi.cc.vendingmachine.model;

import indi.cc.vendingmachine.bean.CashRecords;
import indi.cc.vendingmachine.bean.PurchaseRecords;
import indi.cc.vendingmachine.dao.AdminManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class PurchaseRecordsModel extends AbstractTableModel{
	AdminManageHelper helper = null;
	private  Vector<String> columnNames = null;	//列の名前
	private Vector<Vector<String>> rowData = null;	//行のデータ
	
	
	 public PurchaseRecordsModel(JDialog jd) {
			helper = new AdminManageHelper();
			Vector<PurchaseRecords> records = helper.getAllPurchaseRecords();	//購買履歴を取得する
			
			columnNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			columnNames.add("顧客番号");
			columnNames.add("商品の名前");
			columnNames.add("価額");
			columnNames.add("お支払い金額");
			columnNames.add("お返し金額");
			columnNames.add("購入時間");
			
			if(records!=null){
				for(PurchaseRecords record : records){
					Vector<String> hang = new Vector<String>();
					hang.add(String.valueOf(record.getCustomerId()));
					hang.add(record.getDrinkName());
					hang.add(record.getPrice()+"円");
					hang.add(record.getPayment()+"円");
					hang.add(record.getRepayment()+"円");
					hang.add(record.getDate());
					rowData.add(hang);
					
				}
			}
			
			
			
			if(getRowCount()!=0){
				JOptionPane.showMessageDialog(jd, "合計"+getRowCount()+"件履歴");
				return ;
			}else{
				JOptionPane.showMessageDialog(jd, "履歴がありません");
				return ;
			}
		}
	
	
	
	//取得した行の数
			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return this.rowData.size();
			}
			//取得した列の数
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return this.columnNames.size();
			}
			//ある行ある列のデータを取得
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
			}
			
			//オーバライド getColumnName
			@Override  
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return (String)this.columnNames.get(column);
			}


}
