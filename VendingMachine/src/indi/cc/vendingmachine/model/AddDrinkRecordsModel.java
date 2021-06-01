package indi.cc.vendingmachine.model;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.dao.AdminManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class AddDrinkRecordsModel extends AbstractTableModel{
	AdminManageHelper helper = null;
	private  Vector<String> columnNames = null;	//����
	private Vector<Vector<String>> rowData = null;	//������
	
	
	 public AddDrinkRecordsModel(JDialog jd) {
			helper = new AdminManageHelper();
			Vector<AddDrinkRecords> records = helper.getAllAddDrinkRecords();	//�õ����е�ȡ�ֲ����¼
			
			columnNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			columnNames.add("ID");
			columnNames.add("������");
			columnNames.add("��Ʒ��");
			columnNames.add("�a��ǰ����");
			columnNames.add("�a������");
			columnNames.add("�a��������");
			columnNames.add("�ո�");
			
			if(records!=null){
				for(AddDrinkRecords record : records){
					Vector<String> hang = new Vector<String>();
					hang.add(String.valueOf(record.getId()));
					hang.add(record.getAdministrator());
					hang.add(record.getDrinkName());
					hang.add(record.getBefroeNum()+"��");
					hang.add(record.getAddNum()+"��");
					hang.add(record.getNowNum()+"��");
					hang.add(record.getDate());
					rowData.add(hang);
					
				}
			}
			
			
			
			if(getRowCount()!=0){
				JOptionPane.showMessageDialog(jd, getRowCount()+"�����Ěs������ޤ�");
				return ;
			}else{
				JOptionPane.showMessageDialog(jd, "�Ěs�Ϥʤ��Ǥ�");
				return ;
			}
		}
	
	
	
	//�õ����ж�����
			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return this.rowData.size();
			}
			//�õ����ж�����
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return this.columnNames.size();
			}
			//�õ�ĳ��ĳ�е�����
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
			}
			
			//��д���� getColumnName
			@Override  
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return (String)this.columnNames.get(column);
			}


}