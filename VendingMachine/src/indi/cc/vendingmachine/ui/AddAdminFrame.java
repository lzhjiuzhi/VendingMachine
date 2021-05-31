package indi.cc.vendingmachine.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

public class AddAdminFrame extends javax.swing.JDialog {
		
		private javax.swing.JButton jButton1;
	    private javax.swing.JButton jButton2;
	    private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JLabel jLabel3;
	    private javax.swing.JPasswordField jPasswordField1;
	    private javax.swing.JPasswordField jPasswordField2;
	    private javax.swing.JTextField jTextField1;
	    private JDialog jd;
	    /**
		 * 
		 * @param owner �H��٥��window
		 * @param title window����ǰ
		 * @param modal ָ�����줿modal��modeless��window
		 */
		public AddAdminFrame(JFrame owner, String title, boolean modal){
	    	super(owner, title, modal);
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
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();


        jLabel1.setText("��`���`��:");

        jLabel2.setText("�ѥ���`��:");

        jLabel3.setText("�ѥ���`�ɴ_�J:");

       

        jButton1.setText("����");
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String username = jTextField1.getText().trim();
				String password = String.valueOf(jPasswordField1.getPassword());
				String rePassword = String.valueOf(jPasswordField2.getPassword());
				if(username.equals("")){
					JOptionPane.showMessageDialog(jd, "��`���`�����O�����Ƥ���������");
					return ;
				}else if(password.equals("")){
					JOptionPane.showMessageDialog(jd, "�ѥ���`�ɤ��O�����Ƥ���������");
					return ;
				}else if(rePassword.equals("")){
					JOptionPane.showMessageDialog(jd, "�ѥ���`�ɴ_�J���������Ƥ�������");
					return ;
				}else if(!password.equals(rePassword)){
					JOptionPane.showMessageDialog(jd, "�ѥ���`�ɤ�ѥ���`�ɴ_�J��һ�¤��ʤ�");
					return ;
				}else {
					Administrator admin = new Administrator(username, password);
					AdminManageHelper manageHelper = new AdminManageHelper();
					if(manageHelper.addAdmin(admin)){
						JOptionPane.showMessageDialog(jd, "�������ˣ�");
						jd.dispose();
						return ;
					}else{
						JOptionPane.showMessageDialog(jd, "���ɤǤ��ޤ���Ǥ�����");
						jd.dispose();
						return ;
					}
				}
			}
		});

        jButton2.setText("����󥻥�");
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
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                    .addComponent(jPasswordField1))))
                        .addContainerGap(67, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }                      

                                        

                   
   
                    
}
