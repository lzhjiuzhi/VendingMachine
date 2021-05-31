package indi.cc.vendingmachine.model;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.dao.AdminManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class AddDrinkRecordsModel extends AbstractTableModel{
	AdminManageHelper helper = null;
	private  Vector<String> columnNames = null;	//列の名前
	private Vector<Vector<String>> rowData = null;	//行のデータ
	
	
	 public AddDrinkRecordsModel(JDialog jd) {
			helper = new AdminManageHelper();
			Vector<AddDrinkRecords> records = helper.getAllAddDrinkRecords();	//すべての補充履歴を取得する
			
			columnNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			columnNames.add("番号");
			columnNames.add("操作管理員");
			columnNames.add("商品の名前");
			columnNames.add("補充前の数量");
			columnNames.add("補充した数量");
			columnNames.add("補充後の数量");
			columnNames.add("補充時間");
			
			if(records!=null){
				for(AddDrinkRecords record : records){
					Vector<String> hang = new Vector<String>();
					hang.add(String.valueOf(record.getId()));
					hang.add(record.getAdministrator());
					hang.add(record.getDrinkName());
					hang.add(record.getBefroeNum()+"個");
					hang.add(record.getAddNum()+"個");
					hang.add(record.getNowNum()+"個");
					hang.add(record.getDate());
					rowData.add(hang);
					
				}
			}
			
			
			
			if(getRowCount()!=0){
				JOptionPane.showMessageDialog(jd, "合計"+getRowCount()+"件履歴！");
				return ;
			}else{
				JOptionPane.showMessageDialog(jd, "履歴がありません。");
				return ;
			}
		}
	
	
	
	//取得した行数の数
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