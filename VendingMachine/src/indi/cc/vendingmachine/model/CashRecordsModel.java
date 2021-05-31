package indi.cc.vendingmachine.model;


import indi.cc.vendingmachine.bean.CashRecords;
import indi.cc.vendingmachine.dao.AdminManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

//お金の引き出し履歴モデル
public class CashRecordsModel extends AbstractTableModel{
	AdminManageHelper helper = null;
	private  Vector<String> columnNames = null;	//列の名前
	private Vector<Vector<String>> rowData = null;	//行のデータ
	
	
	 public CashRecordsModel(JDialog jd) {
			helper = new AdminManageHelper();
			Vector<CashRecords> records = helper.getAllCashRecords();	//お金の引き出しや補充履歴を取得
			
			columnNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			columnNames.add("番号");
			columnNames.add("操作管理員");
			columnNames.add("お金の引き出し前の金額");
			columnNames.add("引き出したお金");
			columnNames.add("引き出し後の金額");
			columnNames.add("引き出し時間");
			
			if(records!=null){
				for(CashRecords record : records){
					Vector<String> hang = new Vector<String>();
					hang.add(String.valueOf(record.getId()));
					hang.add(record.getAdministrator());
					hang.add(record.getBeforeCash()+"円");
					hang.add(record.getCash()+"円");
					hang.add(record.getAfterCash()+"円");
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
			
			//メソッドオーバライド getColumnName
			@Override  
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return (String)this.columnNames.get(column);
			}


}
