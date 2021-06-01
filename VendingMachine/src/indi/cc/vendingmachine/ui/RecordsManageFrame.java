package indi.cc.vendingmachine.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import indi.cc.vendingmachine.util.WindowUtil;

import javax.swing.JDialog;
import javax.swing.JFrame;


public class RecordsManageFrame extends javax.swing.JDialog {
    
	private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
                 
    private JDialog jd;
	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public RecordsManageFrame(JFrame owner, String title, boolean modal){
    	super(owner, title, modal);
		  initComponents();
		  WindowUtil.setFrameCenter(this);
	        this.setResizable(false);
	        this.setVisible(true);
	}
                  
    private void initComponents() {
    	this.jd = jd;
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

      

        jButton1.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
        jButton1.setText("ȡ�ּ�¼");
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CashRecordsFrame frame = new CashRecordsFrame(jd, "ȡ�ּ�¼", true);
			}
		});

        jButton2.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
        jButton2.setText("��Ǯ�����¼");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecordFrame frame = new AddRecordFrame(jd, "��Ǯ�����¼", true);
            }
        });

        jButton3.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
        jButton3.setText("��Ʒ�a���Ěs");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               AddDrinkRecordFrame frame = new AddDrinkRecordFrame(jd, "��Ʒ�a���Ěs", true);
            }
        });

        jButton4.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
        jButton4.setText("ُ���Ěs");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseRecordsFrame frame = new PurchaseRecordsFrame(jd, "ُ���Ěs", true);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
//                .addGap(48, 48, 48)
//                .addComponent(jButton1)
//                .addGap(40, 40, 40)
//                .addComponent(jButton2)
                .addGap(40, 40, 40)
                .addComponent(jButton3)
                .addGap(38, 38, 38)
                .addComponent(jButton4)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }                

}
