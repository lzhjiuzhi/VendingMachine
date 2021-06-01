package indi.cc.vendingmachine.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author c
 */
public class UpdatePasswordFrame extends javax.swing.JDialog {
	 	
		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JPasswordField jPasswordField1;
	    private javax.swing.JPasswordField jPasswordField2;
	    private javax.swing.JPasswordField jPasswordField0;
	    private JDialog jd;
	    private Administrator admin;
	 /**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public UpdatePasswordFrame(JFrame owner, String title, boolean modal,Administrator admin){
    	super(owner, title, modal);
    	this.admin = admin;
		  initComponents();
		  WindowUtil.setFrameCenter(this);
	        this.setResizable(false);
	        this.setVisible(true);
    
    
	}

                     
    private void initComponents() {
    	this.jd = this;
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField0 = new javax.swing.JPasswordField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

       

        jLabel1.setText("�ɥѥ���`���:");

        jLabel2.setText("�¥ѥ���`���:");

        jLabel3.setText("�¥ѥ���`��ɴ_�J:");

        jButton1.setText("����");
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String oldPass = String.valueOf(jPasswordField0.getPassword());
				String newPass = String.valueOf(jPasswordField1.getPassword());
				String rePass = String.valueOf(jPasswordField2.getPassword());
				if(oldPass.equals("")){
					JOptionPane.showMessageDialog(jd, "�ɥѥ���`��ɤ��������Ƥ�������");
					return ;
				}else if(newPass.equals("")){
					JOptionPane.showMessageDialog(jd, "�¥ѥ���`��ɤ��������Ƥ�������");
					return ;
				}else if(rePass.equals("")){
					JOptionPane.showMessageDialog(jd, "�¥ѥ���`��ɤ��������Ƥ�������");
					return ;
				}else if(!newPass.equals(rePass)){
					JOptionPane.showMessageDialog(jd, "�ѥ���`��ɤ�һ�¤��Ƥ��ޤ���");
					return ;
				}else{
					Administrator newAdmin = new Administrator(admin.getUsername(), newPass);
					AdminManageHelper manageHelper = new AdminManageHelper();
					if(manageHelper.getAdmin(admin).getPassword().equals(oldPass)&&manageHelper.updatePassword(admin, newAdmin)){
						JOptionPane.showMessageDialog(jd, "�ɹ�");
						jd.dispose();
						return ;
					}else{
						JOptionPane.showMessageDialog(jd, "ʧ��");
						jd.dispose();
						return ;
					}
				}
			}
		});

        jButton2.setText("����");
        jButton2.addActionListener(new ActionListener() {
			
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
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordField1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jPasswordField0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(65, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jPasswordField0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }
    
                    
   
                 
}
