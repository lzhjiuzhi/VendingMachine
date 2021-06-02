package indi.cc.vendingmachine.ui;

import indi.cc.vendingmachine.bean.AddDrinkRecords;
import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.Tools;
import indi.cc.vendingmachine.util.WindowUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AddDrinkFrame extends javax.swing.JDialog {
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField4;
	private JDialog jd;
	private Administrator admin;
	private String filepath = null;	//�ļ�·��
	private String fileName = null;	//�ļ���
	/**
	 *
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public AddDrinkFrame(JDialog owner, String title, boolean modal,Administrator admin){
		super(owner, title, modal);
		this.admin = admin;
		initComponents();
		WindowUtil.setFrameCenter(this);
		this.setResizable(false);
		this.setVisible(true);
	}


	private void initComponents() {
		this.jd = this;
		jButton1 = new javax.swing.JButton("����");
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();

		//ͼƬ���
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser chooser = new JFileChooser();
				// ���´��뵯��һ������û���Ŀ¼���ļ�ѡ����������ֻ��ʾ .jpg �� .gif ͼ��
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif","png");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(jd);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					jButton1.setText("");
					filepath = chooser.getSelectedFile().getPath();
					fileName = chooser.getSelectedFile().getName();
					jButton1.setIcon(new ImageIcon(filepath));
					jButton1.updateUI();

				}

			}
		});


		jLabel1.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
		jLabel1.setText("ID��");

		jLabel2.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
		jLabel2.setText("��Ʒ��:");

		jLabel4.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
		jLabel4.setText("���~:");

		jButton2.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
		jButton2.setText("׷��");
		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String id = jTextField1.getText().trim();
				String name = jTextField2.getText().trim();
				String price = jTextField4.getText().trim();
				if(id.equals("")){
					JOptionPane.showMessageDialog(jd, "ID���������Ƥ�������");
					return ;
				}else if(name.equals("")){
					JOptionPane.showMessageDialog(jd, "��Ʒ�����������Ƥ�������");
					return ;
				}else if(price.equals("")){
					JOptionPane.showMessageDialog(jd, "���Τ��������Ƥ�������");
					return ;
				}else if(filepath==null){
					JOptionPane.showMessageDialog(jd, "������������Ƥ�������");
					return ;
				}else{
					String filename = "img/"+fileName;
					if(Tools.copy(filepath, filename)){
						AdminManageHelper manageHelper = new AdminManageHelper();
						Drink drink = new Drink();
						drink.setId(id);
						drink.setDrinkName(name);
						drink.setPrice(Integer.parseInt(price));
						drink.setDrinkImg(filename);
						if(manageHelper.addDrink(drink)){
							JOptionPane.showMessageDialog(jd, "�ɹ�!!");
							jd.dispose();
							return ;
						}else {
							JOptionPane.showMessageDialog(jd, "ʧ��!!");
							jd.dispose();
							return ;
						}
					}else{
						JOptionPane.showMessageDialog(jd, "ʧ��!!");
						jd.dispose();
						return ;
					}

				}
			}
		});

		jButton3.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
		jButton3.setText("����");
		jButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				jd.dispose();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGap(51, 51, 51)
												.addComponent(jButton2)
												.addGap(96, 96, 96)
												.addComponent(jButton3))
										.addGroup(layout.createSequentialGroup()
												.addGap(20, 20, 20)
												.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel1)
																.addGap(18, 18, 18)
																.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel2)
																.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addGroup(layout.createSequentialGroup()
																.addComponent(jLabel4)
																.addGap(18, 18, 18)
																.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))))
								.addContainerGap(25, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addGap(25, 25, 25)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel1)
														.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(36, 36, 36)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel2)
														.addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGap(36, 36, 36)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(jLabel4)
														.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(25, 25, 25)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jButton2)
										.addComponent(jButton3))
								.addContainerGap(26, Short.MAX_VALUE))
		);

		pack();
	}






}
