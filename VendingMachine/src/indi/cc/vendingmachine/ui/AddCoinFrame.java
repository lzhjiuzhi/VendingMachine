package indi.cc.vendingmachine.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import indi.cc.vendingmachine.bean.AddRecords;
import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.bean.VendingMachine;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
//細かいお金の補充のwindow

public class AddCoinFrame extends javax.swing.JDialog {
    
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JTextField jTextField1;
	private JDialog jd;
	private Administrator admin;
	/**
	 * 
	 * @param owner 親レベルのwindow
	 * @param title windowの名前
	 * @param modal 指定されたmodalとmodelessのwindow
	 */
	public AddCoinFrame(JDialog owner, String title, boolean modal,Administrator admin){
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
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField1.requestFocus();//フォーカスを取得
       

        jLabel1.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jLabel1.setText("細かいお金を追加してください：");
        jTextField1.addKeyListener(new KeyAdapter(){  
        	//入力は数字のみと制限する
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
                      
                }else{  
                    e.consume(); //大切、条件を満たさない入力を遮断
                }  
            }  
        }); 
       

        jButton1.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton1.setText("追加");
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String inputValue = jTextField1.getText().trim();
				if(inputValue.equals("")||Integer.parseInt(inputValue)==0){
					JOptionPane.showMessageDialog(jd, "細かいお金をいれてください！");
					jTextField1.setText("");
				}else{
					AdminManageHelper helper = new AdminManageHelper();
					//細かいお金の補充履歴を記録
					AddRecords record = new AddRecords();
					record.setAdministrator(admin.getUsername());//操作管理員
					record.setBeforeAdd(VendingMachine.getInstance().getCoin());//補充前のお金の在庫金額
					VendingMachine.getInstance().setCoin(Integer.parseInt(inputValue)+VendingMachine.getInstance().getCoin());
					helper.updateVendingMachine(VendingMachine.getInstance());
					JOptionPane.showMessageDialog(jd, "補充した金額"+inputValue+"円！！");	
					record.setAddAmount(Integer.parseInt(inputValue));//補充金額を設定
					record.setAfterAdd(VendingMachine.getInstance().getCoin());
					helper.addAddRecords(record);	///補充履歴
					
					jd.dispose();
				}
			}
		});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }                                   


                     
}
