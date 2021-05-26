package indi.cc.vendingmachine.ui;

import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.bean.PurchaseRecords;
import indi.cc.vendingmachine.bean.VendingMachine;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.dao.CustomerManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class MainFrame extends javax.swing.JFrame {
                        
    private JButton jButton1;
    private JButton jButton2;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTextField jTextField1;
    private JFrame thisJframe;
    private int price = 0;	//Ӧ�����
    private int need = 0;	//������
    private Drink chooseDrink;	//ѡ�е�����
    private int pay = 0;	//��֧���Ľ��
    public MainFrame() {
    	//�����ϻ�������г�ʼ��
    	AdminManageHelper helper = new AdminManageHelper();
    	helper.getVendingMachine();//��ʼ�����ϻ�
        initComponents();
        upateJpanel();
        WindowUtil.setFrameCenter(this);
        this.setResizable(false);
        this.setVisible(true);
    }

                             
    private void initComponents() {
    	this.thisJframe = this;
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane(jPanel1);
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jLabel5 = new JLabel();
        jPanel1.setLayout(new GridLayout(0,2));//�������񲼾�
      
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("�Ԅ�؜�әC");
        setBackground(new java.awt.Color(245, 140, 100));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        //����ֻ����������  (ģ�����)
        jTextField1.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
                      
                }else{  
                    e.consume(); //�ؼ������ε��Ƿ�����  
                }  
            }  
        }); 
        jButton1.setFont(new java.awt.Font("��Բ", 1, 12)); // NOI18N
        jButton1.setText("����Ա���");
        //ע���¼�
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thisJframe.dispose();
				LoginFrame loginFrame = new LoginFrame();

				
			}
		});
        jLabel1.setText("Ͷ�ҿڣ�");

        jButton2.setFont(new java.awt.Font("��Բ", 1, 15)); // NOI18N
        jButton2.setText("ȷ��Ͷ��");
        //ע���¼�
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				computing();//����Ͷ�Һͳ�����
				
			}
		});
       

        jLabel2.setText("��ӦͶ�룺");

        jLabel3.setText("0Ԫ");

        jLabel4.setText("ѡ�е����ϣ�");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jSeparator1))
                        .addGap(5, 5, 5))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }
              
    
    private void upateJpanel(){
    	AdminManageHelper manageHelper = new AdminManageHelper();
    	Vector<Drink> drinks = manageHelper.getAllDrink();	//������е�����
    	 for(int i=0;i<drinks.size();i++){
         	Drink drink = drinks.get(i);   	
         	String s;
         	JButton jb;//��ť
         	//������Ϊ0�����Ͻ����жϲ��Ҵ���
         	if(drinks.get(i).getQuantity()==0){
         		s = drink.getDrinkName()+"|���ۿ�";
         		jb = new JButton(s,new ImageIcon(drink.getDrinkImg()));
         		jb.setEnabled(false);//���ò�����
         	}else{
         		s = drink.getDrinkName()+"|�۸�:"+drink.getPrice()+"Ԫ|����:"+drink.getQuantity();
         		jb = new JButton(s,new ImageIcon(drink.getDrinkImg()));
         	}
         	//�����ϻ�����ǮС��10��ʱ��(�޷������ʱ��)�����жϺʹ���
         	if(VendingMachine.getInstance().getCoin()<10){
         		jb.setEnabled(false);	//���ò����á�
         	}
         	
         	jb.addActionListener(new ActionListener() {
 				
 				@Override
 				public void actionPerformed(ActionEvent e) {
 					// TODO Auto-generated method stub
 					if(pay!=0){
 						JOptionPane.showMessageDialog(thisJframe, "�����֧��!!");
 					}else{
	 					chooseDrink = drink;
	 					jLabel5.setIcon((new ImageIcon(drink.getDrinkImg())));
	 					jLabel3.setText(drink.getPrice()+"Ԫ");
	 					price = drink.getPrice();
	 					need = price;	//���û���Ľ��
	 					jLabel5.updateUI();
 					}
 				}
 			});
         	jPanel1.add(jb);
         }
    }
    
    
    //���㴦��Ͷ�ҵķ���
    private void computing(){
    	int repayment = 0;	//�һؽ��
		int oncePay = 0;	//һ��֧�����
		String s = jTextField1.getText().trim();
		if(!s.equals("")){
			 oncePay = Integer.parseInt(s);//�õ�Ͷ�ҵĽ��
		} 
		
		if(price==0){
			
			if(oncePay!=0){
				JOptionPane.showMessageDialog(thisJframe, "��ѡ��һ��������Ͷ��!!");
				JOptionPane.showMessageDialog(thisJframe, "����ȡ�����Ǯ!!");
				jTextField1.setText("");
			}else{
				JOptionPane.showMessageDialog(thisJframe, "��ѡ��һ������!!");
				jTextField1.setText("");
			}
		}else if(price!=0 && oncePay==0){
			JOptionPane.showMessageDialog(thisJframe, "��Ͷ��!!");
			jTextField1.setText("");
		}else{
			
			switch (oncePay) {
			case 1:
					need = need - 1;
					if(need!=0){
						JOptionPane.showMessageDialog(thisJframe, "����Ͷ�룺"+need+"Ԫ");
					}
					pay += oncePay;	//�õ�һ��֧���Ľ��
					break;
			case 5:
					if(need<5){	//֧����5ԪǮ���ڻ���Ľ��,���һ�Ǯ
						repayment = 5 - need;
						need = 0;	//����
					}else{//֧����5ԪǮС���ڻ���Ľ��,���������Ǯ
						need = need - 5;	
						if(need!=0){
							JOptionPane.showMessageDialog(thisJframe, "����Ͷ�룺"+need+"Ԫ");
						}
					}
					pay += oncePay;	//�õ�һ��֧���Ľ��
					break;
			case 10:
				    need -= 10;
					if(need!=0){

						JOptionPane.showMessageDialog(thisJframe, "����Ͷ�룺"+need+"Ԫ");
					}
					pay += oncePay;	//�õ�һ��֧���Ľ��
					break;
					
			default:
					JOptionPane.showMessageDialog(thisJframe, "��Ͷ��1ԪӲ�һ�5Ԫֽ��,10Ԫֽ��!!");
					JOptionPane.showMessageDialog(thisJframe, "����ȡ�����Ǯ!!");
					jTextField1.setText("");
					break;
			}
			
			
			if(repayment!=0){
				JOptionPane.showMessageDialog(thisJframe, "һ���һ�����"+repayment+"Ԫ");
			}
			if(price!=0 && need==0){//����ɹ�
				JOptionPane.showMessageDialog(thisJframe, "���Ѿ��ɹ����������,��ȴ�����!!");
				//��Ӧ������������Ҫ����!!
				//�˿Ͳ����İ�����ʵ�����������ļ���
				CustomerManageHelper helper = new CustomerManageHelper();
				helper.buyDrink(chooseDrink);//��������
				//��ӹ˿͹���ļ�¼
				PurchaseRecords record = new PurchaseRecords();
				record.setDrinkName(chooseDrink.getDrinkName());
				record.setPrice(chooseDrink.getPrice());
				record.setPayment(pay);	//�ܹ�֧���Ľ��
				record.setRepayment(repayment);
				helper.addPurchaseRecords(record);
				//�һ���Ǯ֮����Ҫ�����ϻ�����Ǯ������
				AdminManageHelper adminManageHelper = new AdminManageHelper();
				VendingMachine.getInstance().setCoin(VendingMachine.getInstance().getCoin()-repayment);//��ȥ�һص���Ǯ
				//���ϻ����ܽ��Ҫ����
				VendingMachine.getInstance().setTotalAmount(VendingMachine.getInstance().getTotalAmount()+oncePay);//����֧����Ǯ
				adminManageHelper.updateVendingMachine(VendingMachine.getInstance());
				
				//���½���
				jPanel1.removeAll();//�Ƴ�����ϵĿؼ�
				jPanel1.updateUI();
				upateJpanel();	//��������ϵİ�ť
				jPanel1.updateUI();
				need = 0;	//���û�ԭ����ֵ
				price = 0;	//���û�ԭ����ֵ
				pay = 0;	//���û�ԭ����ֵ
				jLabel5.setIcon(null);
				jLabel5.updateUI();
			}
			jTextField1.setText("");
			jLabel3.setText(need+"Ԫ");
		}
		
    }
}
