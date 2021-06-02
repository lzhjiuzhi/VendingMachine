package indi.cc.vendingmachine.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.Timer;

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
//    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JSeparator jSeparator2;
    private JTextField jTextField1;
    private JFrame thisJframe;
    
    private int price = 0;	// 支払に必要な金額
    private int need = 0;	// まだ必要な金額
    private Drink chooseDrink;	// 選択されたドリンク
    private int pay = 0;	// 総支払額
    
    int second = 31;
    Timer timer;
    
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
        jSeparator1 = new JSeparator();
        jSeparator2 = new JSeparator();
        jLabel5 = new JLabel();
        jPanel1.setLayout(new GridLayout(0,3));	// グリッドレイアウトを設定する。2列の表示になる。行は任意の数
      
        // WindowConstants -> ウィンドウのクローズ操作を制御する定数
        // EXIT_ON_CLOSE -> 終了するアプリケーションのデフォルトのウィンドウにクローズ・オペレーション
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);	// デフォルトのクローズ操作の指定
        setTitle("自動販売機");	// タイトル(画面最上部)
        setBackground(new java.awt.Color(245, 140, 100));	// タイトルバーをRGBで設定
        jPanel1.setBackground(Color.GRAY);


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
        jButton1.setText("管理人入口");	// ボタンのテキストを指定
        
        // 登録の問題
        // ボタンにアクションイベントを受け取れるようにする
        jButton1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				thisJframe.dispose();	// ウインドウを破棄して、リソースを解放
				LoginFrame loginFrame = new LoginFrame();	// ログインフレームを作成

				
			}
		});
//        jLabel1.setText("お金投入口：");	// 文字の指定
        jLabel1.setText("買いたい商品を選んでください");	// 文字の指定
        jLabel1.setOpaque(true);
        jLabel1.setBackground(Color.YELLOW);

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
        jLabel2.setText("金額：");

        jLabel3.setText("0元");

        jLabel4.setText("ドリンク：");

        // フレームはペインと呼ばれる層が重なって成り立っている
        // getContentPane(ボタンなどのコンポーネントを含める層)を取得
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);	// layoutを設定
        
        
        // 水平軸に沿ってコンポーネントの配置とサイズを指定するように設定
        // 横方向の要素の整列
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
        hGroup.addGroup(
	    		layout.createParallelGroup()
	    		.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
	            .addGroup(layout.createSequentialGroup()
	            		.addGap(300, 310, 320)
	            		.addComponent(jLabel1)
	            		.addGap(160, 170, 180)
	            		.addComponent(jButton1)
	            		.addGap(5, 10, 20))
    	);
        
        layout.setHorizontalGroup(hGroup);
        
        
        // 縦方向の要素の整列
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
        vGroup.addGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        
        vGroup.addGroup(
        		layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
        		.addComponent(jLabel1)
        		.addComponent(jButton1)
                .addGap(10, 10, 10)
        );
        
        layout.setVerticalGroup(vGroup);

        pack();
    }
              
    
    private void upateJpanel(){
    	AdminManageHelper manageHelper = new AdminManageHelper();
    	Vector<Drink> drinks = manageHelper.getAllDrink();	// 飲み物をすべて手に入れる
    	 for(int i=0;i<drinks.size();i++){
         	Drink drink = drinks.get(i);   	
         	String s;
         	JButton jb;	// ボタン
         	// 数量0の飲料を判定・加工
         	if(drinks.get(i).getQuantity()==0){
         		s = drink.getDrinkName()+"|完売";
         		jb = new JButton(s,new ImageIcon(drink.getDrinkImg()));
         		jb.setEnabled(false);	// 利用できない状態
         	}else{
         		s = drink.getDrinkName()+"|価格:"+drink.getPrice()+"元|数量:"+drink.getQuantity();
         		jb = new JButton(s,new ImageIcon(drink.getDrinkImg()));
         	}
         	// 飲料機の変化が10回未満の場合（変化が見られない場合）を判定・処理
         	if(VendingMachine.getInstance().getCoin()<10){
         		jb.setEnabled(false);	// 利用できない状態
         	}
         	jb.setOpaque(true);
            jb.setBackground(Color.GRAY);
         	
         	jb.addActionListener(new ActionListener() {
 				
 				@Override
 				public void actionPerformed(ActionEvent e) {
 					
 					if(pay!=0){
 						JOptionPane.showMessageDialog(thisJframe, "支払いを完了してください!!");
 					}else{
	 					chooseDrink = drink;
//	 					Timelimit.main(null);
	 					jLabel5.setIcon((new ImageIcon(drink.getDrinkImg())));
	 					jLabel3.setText(drink.getPrice()+"元");
	 					jLabel4.setText(drink.getDrinkName());
	 					price = drink.getPrice();
	 					need = price;	// 残額を設定する
	 					jLabel5.updateUI();
 					}

 			        // モーダルで表示
 					JDialog dialog = new JDialog(thisJframe, true);
 					dialog.setLayout(new GridBagLayout());
 					
 					GridBagConstraints gbc = new GridBagConstraints();
 					gbc.gridx = 0;
 					gbc.gridy = 0;
 					
 					// 画像と商品の説明、タイマーのレイアウト
 					JPanel panel1 = new JPanel();
 					panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
 					panel1.add(jLabel5);
 					
 					JPanel panel1_1 = new JPanel();
 					panel1_1.setLayout(new GridLayout(0, 1, 10, 10));
 					panel1_1.add(jLabel4);
 					panel1_1.add(jLabel3);
 					panel1_1.add(new Label("を選択中"));
 					panel1_1.add(jTextField1);
 					
 					// タイマーの設置
 					JLabel counterLabel= new JLabel("  ");
 			        counterLabel.setFont(new Font("Arial", Font.PLAIN, 32));
 			        
 			       
 			        
 			        timer = new Timer(1000, new ActionListener() {
 			            
 			            @Override
 			            public void actionPerformed(ActionEvent e) {
 			                
 			                second -= 8;
 			                
 			                counterLabel.setText(""+ second);
 			                if (second <= 0)
 			                {
 			                    timer.stop();
 			                    dialog.dispose();
 			                   second = 31;
 			                }
 			            }
 			        });
 			        
 			       timer.start();
 			         			        
 			        panel1_1.add(counterLabel);
 			       
 			       	panel1.add(panel1_1);
					dialog.add(panel1, gbc);
 			       
 			       
 					// フッターのレイアウト
 					JPanel panel2 = new JPanel();
 					panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
 					
 					JButton jButton3 = new JButton("戻る");
// 					jButton3.setText("戻る");
 					jButton3.addActionListener(new ActionListener() {
 						
 						@Override
 						public void actionPerformed(ActionEvent e) {
 							dialog.dispose();
 						}
 					});
 					
 					panel2.add(jButton3);
 					panel2.add(jButton2);
 					
 					gbc.gridx = 0;
 					gbc.gridy = 1;
 					dialog.add(panel2, gbc);
 					
 					jLabel2.setPreferredSize(new Dimension(100, 70)); 					
 					
 					dialog.setResizable(false);
 					dialog.setLocationRelativeTo(null);
 					dialog.pack();
 					dialog.show(); 					
 				}
 			});
         	
         	jPanel1.add(jb);
         }
    }
    
    
    // コインの取り扱い方法を計算する
    private void computing(){
    	int repayment = 0;	//找回金额
		int oncePay = 0;	//一次支付金额
		String s = jTextField1.getText().trim();
		if(!s.equals("")){
			 oncePay = Integer.parseInt(s);//得到投币的金额
		} 
		
		if(price==0){
			
			if(oncePay!=0){
				JOptionPane.showMessageDialog(thisJframe, "ドリンクを選んでコインを追加してください!!");
				JOptionPane.showMessageDialog(thisJframe, "お金を返してください!!");
				jTextField1.setText("");
			}else{
				JOptionPane.showMessageDialog(thisJframe, "ドリンクを選んでください!!");
				jTextField1.setText("");
			}
		}else if(price!=0 && oncePay==0){
			JOptionPane.showMessageDialog(thisJframe, "コインをください!!");
			jTextField1.setText("");
		}else{
			
			switch (oncePay) {
			case 1:
					need = need - 1;
					if(need!=0){
						JOptionPane.showMessageDialog(thisJframe, "投資が必要："+need+"元");
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
							JOptionPane.showMessageDialog(thisJframe, "投資が必要："+need+"元");
						}
					}
					pay += oncePay;	//得到一共支付的金额
					break;
			case 10:
				    need -= 10;
					if(need!=0){

						JOptionPane.showMessageDialog(thisJframe, "投資が必要："+need+"元");
					}
					pay += oncePay;	//得到一共支付的金额
					break;
					
			default:
					JOptionPane.showMessageDialog(thisJframe, "1元硬貨または5元札、10元札を入れてください!!");
					JOptionPane.showMessageDialog(thisJframe, "お金を返してください!!");
					jTextField1.setText("");
					break;
			}
			
			
			if(repayment!=0){
				JOptionPane.showMessageDialog(thisJframe, "完全に取り戻す："+repayment+"元");
			}
			if(price!=0 && need==0){//付款成功
				JOptionPane.showMessageDialog(thisJframe, "ドリンクの購入に成功しました。出てくるまでお待ちください!!");
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


