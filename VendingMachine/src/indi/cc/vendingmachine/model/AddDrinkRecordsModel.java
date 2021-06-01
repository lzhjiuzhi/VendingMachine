package indi.cc.vendingmachine.model;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.dao.AdminManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class AddDrinkRecordsModel extends AbstractTableModel{
	AdminManageHelper helper = null;
	private  Vector<String> columnNames = null;	//列名
	private Vector<Vector<String>> rowData = null;	//行数据
	
	
	 public AddDrinkRecordsModel(JDialog jd) {
			helper = new AdminManageHelper();
			Vector<AddDrinkRecords> records = helper.getAllAddDrinkRecords();	//得到所有的取现补充记录
			
			columnNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			columnNames.add("ID");
			columnNames.add("管理者");
			columnNames.add("商品名");
			columnNames.add("補充前数量");
			columnNames.add("補充数量");
			columnNames.add("補充後数量");
			columnNames.add("日付");
			
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
				JOptionPane.showMessageDialog(jd, getRowCount()+"個の履歴があります");
				return ;
			}else{
				JOptionPane.showMessageDialog(jd, "履歴はないです");
				return ;
			}
		}
	
	
	
	//得到共有多少行
			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return this.rowData.size();
			}
			//得到共有多少列
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return this.columnNames.size();
			}
			//得到某行某列的数据
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
			}
			
			//重写方法 getColumnName
			@Override  
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return (String)this.columnNames.get(column);
			}


}