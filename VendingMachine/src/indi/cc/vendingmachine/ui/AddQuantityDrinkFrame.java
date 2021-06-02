package indi.cc.vendingmachine.ui;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;


public class AddQuantityDrinkFrame extends javax.swing.JDialog {

	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JTextField jTextField1;
	private JDialog jd;
	private Drink drink;
	private Administrator admin;
	/**
	 *
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public AddQuantityDrinkFrame(JDialog owner, String title, boolean modal,Drink drink,Administrator admin){
		super(owner, title, modal);
		this.admin = admin;
		this.drink = drink;
		initComponents();
		WindowUtil.setFrameCenter(this);
		this.setResizable(false);
		this.setVisible(true);
	}


	private void initComponents() {
		this.jd = this;
		jLabel1 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jTextField1.addKeyListener(new KeyAdapter(){
			//����ֻ����������
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){

				}else{
					e.consume(); //�ؼ������ε��Ƿ�����
				}
			}
		});

		jLabel1.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
		jLabel1.setText("��Ʒ���a�䤷�Ƥ�������:");

		jButton1.setText("�a�䡡");
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String s = jTextField1.getText().trim();	//�õ������ֵ
				if(s.equals("")||Integer.parseInt(s)==0){
					JOptionPane.showMessageDialog(jd, "��Ʒ���a�䤷�Ƥ�������:");
				}else{
					AdminManageHelper helper = new AdminManageHelper();
					//������ϲ����¼
					AddDrinkRecords record = new AddDrinkRecords();
					record.setAdministrator(admin.getUsername());
					record.setDrinkName(drink.getDrinkName());
					record.setBefroeNum(drink.getQuantity());//���ò���ǰ������
					drink.setQuantity(Integer.parseInt(s)+drink.getQuantity());//��������
					record.setAddNum(Integer.parseInt(s));//���ò��������
					record.setNowNum(drink.getQuantity());//���ò���������
					helper.updateDrinkNum(drink);	//������������
					helper.addAddDrinkRecords(record);	//��Ӳ������ϵļ�¼
					JOptionPane.showMessageDialog(jd, Integer.parseInt(s)+"����׷�Ӥ��ޤ���");

					jd.dispose();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(40, 40, 40)
								.addComponent(jLabel1)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(18, 18, 18)
								.addComponent(jButton1)
								.addContainerGap(42, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(47, 47, 47)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel1)
										.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jButton1))
								.addContainerGap(47, Short.MAX_VALUE))
		);

		pack();
	}

}
