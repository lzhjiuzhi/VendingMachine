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
    private int price = 0;	//应付金额
    private int need = 0;	//还需金额
    private Drink chooseDrink;	//选中的饮料
    private int pay = 0;	//总支付的金额
    public MainFrame() {
    	//对饮料机对象进行初始化
    	AdminManageHelper helper = new AdminManageHelper();
    	helper.getVendingMachine();//初始化饮料机
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
        jPanel1.setLayout(new GridLayout(0,2));//设置网格布局
      
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("自動販売機");
        setBackground(new java.awt.Color(245, 140, 100));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        //限制只能输入数字  (模板代码)
        jTextField1.addKeyListener(new KeyAdapter(){  
            public void keyTyped(KeyEvent e) {  
                int keyChar = e.getKeyChar();                 
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){  
                      
                }else{  
                    e.consume(); //关键，屏蔽掉非法输入  
                }  
            }  
        }); 
        jButton1.setFont(new java.awt.Font("幼圆", 1, 12)); // NOI18N
        jButton1.setText("管理者コンソール");
        //注册事件
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thisJframe.dispose();
				LoginFrame loginFrame = new LoginFrame();

				
			}
		});
        jLabel1.setText("お金の投入口：");

        jButton2.setFont(new java.awt.Font("幼圆", 1, 15)); // NOI18N
        jButton2.setText("確認");
        //注册事件
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				computing();//处理投币和出饮料
				
			}
		});
       

        jLabel2.setText("足りないお金?：");

        jLabel3.setText("0円");

        jLabel4.setText("選択した商品：");

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
    	Vector<Drink> drinks = manageHelper.getAllDrink();	//获得所有的饮料
    	 for(int i=0;i<drinks.size();i++){
         	Drink drink = drinks.get(i);   	
         	String s;
         	JButton jb;//按钮
         	//对数量为0的饮料进行判断并且处理
         	if(drinks.get(i).getQuantity()==0){
         		s = drink.getDrinkName()+"|売り切れ";
         		jb = new JButton(s,new ImageIcon(drink.getDrinkImg()));
         		jb.setEnabled(false);//设置不可用
         	}else{
         		s = drink.getDrinkName()+"|円："+drink.getPrice()+"円|在庫数："+drink.getQuantity();
         		jb = new JButton(s,new ImageIcon(drink.getDrinkImg()));
         	}
         	//对饮料机的零钱小于10的时候(无法找零的时候)进行判断和处理
         	if(VendingMachine.getInstance().getCoin()<10){
         		jb.setEnabled(false);	//设置不可用。
         	}
         	
         	jb.addActionListener(new ActionListener() {
 				
 				@Override
 				public void actionPerformed(ActionEvent e) {
 					// TODO Auto-generated method stub
 					if(pay!=0){
 						JOptionPane.showMessageDialog(thisJframe, "お支払いを完了してください！！");
 					}else{
	 					chooseDrink = drink;
	 					jLabel5.setIcon((new ImageIcon(drink.getDrinkImg())));
	 					jLabel3.setText(drink.getPrice()+"円");
	 					price = drink.getPrice();
	 					need = price;	//设置还需的金额
	 					jLabel5.updateUI();
 					}
 				}
 			});
         	jPanel1.add(jb);
         }
    }
    
    
    //计算处理投币的方法
    private void computing(){
    	int repayment = 0;	//おつり
		int oncePay = 0;	//First inserted amount
		String s = jTextField1.getText().trim();
		if(!s.equals("")){
			 oncePay = Integer.parseInt(s);//Get the amount of coin
		} 
		
		if(price==0){
			
			if(oncePay!=0){
				JOptionPane.showMessageDialog(thisJframe, "商品を選択し、お金をいれてください！！");
				JOptionPane.showMessageDialog(thisJframe, "お金をお受け取りください！！");
				jTextField1.setText("");
			}else{
				JOptionPane.showMessageDialog(thisJframe, "商品を選択してください");
				jTextField1.setText("");
			}
		}else if(price!=0 && oncePay==0){
			JOptionPane.showMessageDialog(thisJframe, "お金をいれてください");
			jTextField1.setText("");
		}else{
			
			switch (oncePay) {
			case 10:
					need = need - 10;
					if(need!=0){
						JOptionPane.showMessageDialog(thisJframe, "必要なお金："+need+"円");
					}
					pay += oncePay;	//
					break;
			case 50:
					if(need<50){	//
						repayment = 50 - need;
						need = 0;	//金额付满
					}else{//支付的5元钱小于于还需的金额,还需继续付钱
						need = need - 50;	
						if(need!=0){
							JOptionPane.showMessageDialog(thisJframe, "必要なお金："+need+"円");
						}
					}
					pay += oncePay;	//得到一共支付的金额
					break;
			case 100:
					if(need<100){	//
						repayment = 100 - need;
						need = 0;	//金额付满
					}else{//支付的5元钱小于于还需的金额,还需继续付钱
						need = need - 100;	
						if(need!=0){
							JOptionPane.showMessageDialog(thisJframe, "必要なお金："+need+"円");
						}
					}
					pay += oncePay;	//得到一共支付的金额
					break;
//				    need -= 10;
//					if(need!=0){
//
//						JOptionPane.showMessageDialog(thisJframe, "Amount needed："+need+"?");
//					}
//					pay += oncePay;	//得到一共支付的金额
//					break;
			case 500:
					if(need<500){	//
					repayment = 500 - need;
					need = 0;	//金额付满
					}else{//支付的5元钱小于于还需的金额,还需继续付钱
						need = need - 500;	
						if(need!=0){
						JOptionPane.showMessageDialog(thisJframe, "必要なお金："+need+"円");
						}
					}
				pay += oncePay;	//得到一共支付的金额
				break;
			case 1000:
				if(need<1000){	//
				repayment = 1000 - need;
				need = 0;	//金额付满
				}else{//支付的5元钱小于于还需的金额,还需继续付钱
					need = need - 1000;	
					if(need!=0){
					JOptionPane.showMessageDialog(thisJframe, "必要なお金："+need+"円");
					}
				}
				pay += oncePay;	//得到一共支付的金额
				break;
				
			case 5000:
				if(need<5000){	//
				repayment = 5000 - need;
				need = 0;	//金额付满
				}else{//支付的5元钱小于于还需的金额,还需继续付钱
					need = need - 5000;	
					if(need!=0){
					JOptionPane.showMessageDialog(thisJframe, "必要なお金："+need+"円");
					}
				}
				pay += oncePay;	//得到一共支付的金额
				break;
				
			case 10000:
				if(need<10000){	//
				repayment = 10000 - need;
				need = 0;	//金额付满
				}else{//支付的5元钱小于于还需的金额,还需继续付钱
					need = need - 10000;	
					if(need!=0){
					JOptionPane.showMessageDialog(thisJframe, "必要なお金："+need+"円");
					}
				}
			pay += oncePay;	//得到一共支付的金额
			break;
			default:
					JOptionPane.showMessageDialog(thisJframe, "この硬貨は使用できません");
					JOptionPane.showMessageDialog(thisJframe, "お金を受け取りなさい");
					jTextField1.setText("");
					break;
			}
			
			
			if(repayment!=0){
				JOptionPane.showMessageDialog(thisJframe, "お返し金は："+repayment+"円");
			}
			if(price!=0 && need==0){//付款成功
				JOptionPane.showMessageDialog(thisJframe, "完成！商品が出るまでお待ちください！！");
				//对应的饮料数量需要减少!!
				//顾客操作的帮助类实现饮料数量的减少
				CustomerManageHelper helper = new CustomerManageHelper();
				helper.buyDrink(chooseDrink);//购买饮料
				//添加顾客购买的纪录
				PurchaseRecords record = new PurchaseRecords();
				record.setDrinkName(chooseDrink.getDrinkName());
				record.setPrice(chooseDrink.getPrice());
				record.setPayment(pay);	//总共支付的金额
				record.setRepayment(repayment);
				helper.addPurchaseRecords(record);
				//找回零钱之后需要将饮料机的零钱数减少
				AdminManageHelper adminManageHelper = new AdminManageHelper();
				VendingMachine.getInstance().setCoin(VendingMachine.getInstance().getCoin()-repayment);//减去找回的零钱
				//饮料机的总金额要增加
				VendingMachine.getInstance().setTotalAmount(VendingMachine.getInstance().getTotalAmount()+oncePay);//增加支付的钱
				adminManageHelper.updateVendingMachine(VendingMachine.getInstance());
				
				//更新界面
				jPanel1.removeAll();//移除面板上的控件
				jPanel1.updateUI();
				upateJpanel();	//更新面板上的按钮
				jPanel1.updateUI();
				need = 0;	//设置回原来的值
				price = 0;	//设置回原来的值
				pay = 0;	//设置回原来的值
				jLabel5.setIcon(null);
				jLabel5.updateUI();
			}
			jTextField1.setText("");
			jLabel3.setText(need+"円");
		}
		
    }
}
