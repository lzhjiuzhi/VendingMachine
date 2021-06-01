package indi.cc.vendingmachine.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import indi.cc.vendingmachine.bean.Drink;
import indi.cc.vendingmachine.bean.PurchaseRecords;
import indi.cc.vendingmachine.bean.VendingMachine;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.dao.CustomerManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

public class MainFrame extends javax.swing.JFrame {
                        
	// 状態を入れるための変数
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
    
    private int price = 0;	// 支払に必要な金額
    private int need = 0;	// まだ必要な金額
    private Drink chooseDrink;	// 選択されたドリンク
    private int pay = 0;	// 総支払額
    
    public MainFrame() {
    	// 飲料機オブジェクトの初期化
    	AdminManageHelper helper = new AdminManageHelper();	// 管理者ヘルパークラスをインスタンス化
    	helper.getVendingMachine(); // 飲料機の初期化
        initComponents();
        upateJpanel();
        WindowUtil.setFrameCenter(this);	// ウインドウにフレームをセット
        this.setResizable(false);	// サイズ変更は不可
        this.setVisible(true);	// フレームを表示
    }

    // コンストラクタで呼び出せれる
    private void initComponents() {
    	// メンバ変数に値を格納していく
    	this.thisJframe = this;
        jButton1 = new JButton();
        jLabel1 = new JLabel();
        jTextField1 = new JTextField();
        jButton2 = new JButton();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane(jPanel1);	// スクロール可能なビュー
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jLabel5 = new JLabel();
        jPanel1.setLayout(new GridLayout(0,2));	// グリッドレイアウトを設定する。2列の表示になる。行は任意の数
      
        // WindowConstants -> ウィンドウのクローズ操作を制御する定数
        // EXIT_ON_CLOSE -> 終了するアプリケーションのデフォルトのウィンドウにクローズ・オペレーション
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);	// デフォルトのクローズ操作の指定
        setTitle("自動販売機");	// タイトル(画面最上部)
        setBackground(new java.awt.Color(245, 140, 100));	// 背景色をRGBで設定、変えても変化なし

        // 直線ボーダーを作成し、スクロールパネルに追加
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        // 数字のみの入力制限（テンプレートコード）
        // キーボードが押されたときのイベントを追加
        jTextField1.addKeyListener(new KeyAdapter(){
        	// キーボードを入力するときに呼び出せれる。
            public void keyTyped(KeyEvent e) {
                int keyChar = e.getKeyChar();	// イベントに関連する文字を返す
                // ASCII 文字の 0 以上 9以下か確認する
                if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
                      
                }else{
                    e.consume();	// 不正な入力をブロックする。
                }
            }
        });
        
        jButton1.setFont(new java.awt.Font("幼圆", 1, 12)); // ボタンのフォントを指定
        jButton1.setText("管理人入り口");	// ボタンのテキストを指定
        
        // 登録の問題
        // ボタンにアクションイベントを受け取れるようにする
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thisJframe.dispose();	// ウインドウを破棄して、リソースを解放
				LoginFrame loginFrame = new LoginFrame();	// ログインフレームを作成

				
			}
		});
        jLabel1.setText("お金投入口：");	// 文字の指定

        jButton2.setFont(new java.awt.Font("幼圆", 1, 15)); // フォントを指定
        jButton2.setText("お金を確認");		// 文字の指定
        
        // ボタンにアクションイベントを追加
        // 計算する処理を行う
        jButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				computing();	// お金と飲み物を使って計算
				
			}
		});
       
        // 文字の記入
        jLabel2.setText("还应投入：");

        jLabel3.setText("0元");

        jLabel4.setText("选中的饮料：");

        // フレームはペインと呼ばれる層が重なって成り立っている
        // getContentPane(ボタンなどのコンポーネントを含める層)を取得
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);	// layoutを設定
        
        // 水平軸に沿ってコンポーネントの配置とサイズを指定するように設定
        // 横方向の要素の整列
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(
	    		layout.createParallelGroup()
	    		.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
	//        		.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
//	                .addGap(18, 18, 18)
	            .addComponent(jButton1)
	            .addComponent(jLabel2)
	            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addComponent(jLabel1)
	            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel4)
                .addComponent(jSeparator1)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
    	);
        
   
    
//    	hGroup.addGroup(
//    			layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                // ラベル
//                .addComponent(jLabel2)
//                .addGap(10, 10, 10)
//                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
//                
//                .addComponent(jLabel1)
//                .addGap(18, 18, 18)
//                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
//                
//                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addComponent(jLabel4)
//                .addComponent(jSeparator1)
//                .addGap(5, 5, 5)
//                
//                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
//                
//        );
        
        layout.setHorizontalGroup(hGroup);
        
        
        // 縦方向の要素の整列
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        vGroup.addGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		.addComponent(jButton1)
                .addGap(10, 10, 10)
        );
        
        vGroup.addGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
        );
        
        vGroup.addGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addGap(33, 33, 33)
        );
        
        vGroup.addGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(3, 3, 3)
                            .addComponent(jLabel1))
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
        );
        
        vGroup.addGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		.addComponent(jButton2)
                .addGap(10, 10, 10)
        );
        
        vGroup.addGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		.addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
        );
        
        vGroup.addGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		 .addComponent(jLabel4)
        		 .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        layout.setVerticalGroup(vGroup);

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
         		s = drink.getDrinkName()+"|已售空";
         		jb = new JButton(s,new ImageIcon(drink.getDrinkImg()));
         		jb.setEnabled(false);//设置不可用
         	}else{
         		s = drink.getDrinkName()+"|价格:"+drink.getPrice()+"元|数量:"+drink.getQuantity();
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
 						JOptionPane.showMessageDialog(thisJframe, "请完成支付!!");
 					}else{
	 					chooseDrink = drink;
	 					jLabel5.setIcon((new ImageIcon(drink.getDrinkImg())));
	 					jLabel3.setText(drink.getPrice()+"元");
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
    	int repayment = 0;	//找回金额
		int oncePay = 0;	//一次支付金额
		String s = jTextField1.getText().trim();
		if(!s.equals("")){
			 oncePay = Integer.parseInt(s);//得到投币的金额
		} 
		
		if(price==0){
			
			if(oncePay!=0){
				JOptionPane.showMessageDialog(thisJframe, "请选择一款饮料再投币!!");
				JOptionPane.showMessageDialog(thisJframe, "请您取回你的钱!!");
				jTextField1.setText("");
			}else{
				JOptionPane.showMessageDialog(thisJframe, "请选择一款饮料!!");
				jTextField1.setText("");
			}
		}else if(price!=0 && oncePay==0){
			JOptionPane.showMessageDialog(thisJframe, "请投币!!");
			jTextField1.setText("");
		}else{
			
			switch (oncePay) {
			case 1:
					need = need - 1;
					if(need!=0){
						JOptionPane.showMessageDialog(thisJframe, "还需投入："+need+"元");
					}
					pay += oncePay;	//得到一共支付的金额
					break;
			case 5:
					if(need<5){	//支付的5元钱大于还需的金额,则找回钱
						repayment = 5 - need;
						need = 0;	//金额付满
					}else{//支付的5元钱小于于还需的金额,还需继续付钱
						need = need - 5;	
						if(need!=0){
							JOptionPane.showMessageDialog(thisJframe, "还需投入："+need+"元");
						}
					}
					pay += oncePay;	//得到一共支付的金额
					break;
			case 10:
				    need -= 10;
					if(need!=0){

						JOptionPane.showMessageDialog(thisJframe, "还需投入："+need+"元");
					}
					pay += oncePay;	//得到一共支付的金额
					break;
					
			default:
					JOptionPane.showMessageDialog(thisJframe, "请投入1元硬币或5元纸币,10元纸币!!");
					JOptionPane.showMessageDialog(thisJframe, "请您取回你的钱!!");
					jTextField1.setText("");
					break;
			}
			
			
			if(repayment!=0){
				JOptionPane.showMessageDialog(thisJframe, "一共找回您："+repayment+"元");
			}
			if(price!=0 && need==0){//付款成功
				JOptionPane.showMessageDialog(thisJframe, "您已经成功购买该饮料,请等待出柜!!");
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
			jLabel3.setText(need+"元");
		}
		
    }
}
