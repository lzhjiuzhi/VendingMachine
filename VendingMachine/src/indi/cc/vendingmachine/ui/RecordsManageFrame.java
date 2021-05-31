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
	 * @param owner 它的父窗口
	 * @param title 窗口名
	 * @param modal 指定的模式窗口，还有非模式窗口
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

      

        jButton1.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton1.setText("お金の引き出し履歴");
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				CashRecordsFrame frame = new CashRecordsFrame(jd, "お金の引き出し履歴", true);
			}
		});

        jButton2.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton2.setText("細かいお金の補充履歴");
        jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddRecordFrame frame = new AddRecordFrame(jd, "細かいお金の補充履歴", true);
            }
        });

        jButton3.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton3.setText("商品の補充履歴");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
               AddDrinkRecordFrame frame = new AddDrinkRecordFrame(jd, "商品の補充履歴", true);
            }
        });

        jButton4.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton4.setText("顧客の購入履歴");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PurchaseRecordsFrame frame = new PurchaseRecordsFrame(jd, "顧客の購入履歴", true);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jButton1)
                .addGap(40, 40, 40)
                .addComponent(jButton2)
                .addGap(40, 40, 40)
                .addComponent(jButton3)
                .addGap(38, 38, 38)
                .addComponent(jButton4)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }                

}
