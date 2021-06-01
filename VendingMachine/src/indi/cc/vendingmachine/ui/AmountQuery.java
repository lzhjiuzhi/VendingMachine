package indi.cc.vendingmachine.ui;

import indi.cc.vendingmachine.bean.VendingMachine;
import indi.cc.vendingmachine.util.WindowUtil;

import javax.swing.JDialog;
//����ѯ����

public class AmountQuery extends javax.swing.JDialog {
	  
	private javax.swing.JLabel jLabel1;
	    private javax.swing.JLabel jLabel2;
	    private javax.swing.JTextField jTextField1;
	    private javax.swing.JTextField jTextField2;
	                  
		/**
		 * 
		 * @param owner ���ĸ�����
		 * @param title ������
		 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
		 */
		public AmountQuery(JDialog owner, String title, boolean modal){
			super(owner, title, modal);
		  initComponents();
		  WindowUtil.setFrameCenter(this);
	        this.setResizable(false);
	        this.setVisible(true);
	}


   
                       
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField( VendingMachine.getInstance().getTotalAmount()+"��");
        jTextField1.setEditable(false);
        jTextField2 = new javax.swing.JTextField(VendingMachine.getInstance().getCoin()+"��");
        jTextField2.setEditable(false);
        
       
        
        jLabel1.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
        jLabel1.setText("�t���~:");

        jLabel2.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
        jLabel2.setText("��ឤ�:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }                   
 
}
