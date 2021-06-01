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
	private  Vector<String> columnNames = null;	//列名
	private Vector<Vector<String>> rowData = null;	//行数据
	
	
	 public PurchaseRecordsModel(JDialog jd) {
			helper = new AdminManageHelper();
			Vector<PurchaseRecords> records = helper.getAllPurchaseRecords();	//得到所有的取现补充记录
			
			columnNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			columnNames.add("ID");
			columnNames.add("商品名");
			columnNames.add("価額");
			columnNames.add("支払い金額");
			columnNames.add("お釣り");
			columnNames.add("日付");
			
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
				JOptionPane.showMessageDialog(jd, getRowCount()+"個の履歴があります");
				return ;
			}else{
				JOptionPane.showMessageDialog(jd, "履歴はありません");
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
