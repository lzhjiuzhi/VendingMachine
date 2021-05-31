package indi.cc.vendingmachine.model;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.dao.AdminManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class AddDrinkRecordsModel extends AbstractTableModel{
	AdminManageHelper helper = null;
	private  Vector<String> columnNames = null;	//�Ф���ǰ
	private Vector<Vector<String>> rowData = null;	//�ФΥǩ`��
	
	
	 public AddDrinkRecordsModel(JDialog jd) {
			helper = new AdminManageHelper();
			Vector<AddDrinkRecords> records = helper.getAllAddDrinkRecords();	//���٤Ƥ��a���Ěs��ȡ�ä���
			
			columnNames = new Vector<String>();
			rowData = new Vector<Vector<String>>();
			columnNames.add("����");
			columnNames.add("��������T");
			columnNames.add("��Ʒ����ǰ");
			columnNames.add("�a��ǰ������");
			columnNames.add("�a�䤷������");
			columnNames.add("�a���������");
			columnNames.add("�a��r�g");
			
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
				JOptionPane.showMessageDialog(jd, "��Ӌ"+getRowCount()+"���Ěs��");
				return ;
			}else{
				JOptionPane.showMessageDialog(jd, "�Ěs������ޤ���");
				return ;
			}
		}
	
	
	
	//ȡ�ä�����������
			@Override
			public int getRowCount() {
				// TODO Auto-generated method stub
				return this.rowData.size();
			}
			//ȡ�ä����Ф���
			@Override
			public int getColumnCount() {
				// TODO Auto-generated method stub
				return this.columnNames.size();
			}
			//�����Ф����ФΥǩ`����ȡ��
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
			}
			
			//�᥽�åɥ��`�Х饤�� getColumnName
			@Override  
			public String getColumnName(int column) {
				// TODO Auto-generated method stub
				return (String)this.columnNames.get(column);
			}


}