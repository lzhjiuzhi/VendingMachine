package indi.cc.vendingmachine.ui;

import java.awt.Color;
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

	// ״�B�����뤿��Ή���
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

	private int price = 0;	// ֧�B�˱�Ҫ�ʽ��~
	private int need = 0;	// �ޤ���Ҫ�ʽ��~
	private Drink chooseDrink;	// �x�k���줿�ɥ��
	private int pay = 0;	// �t֧�B�~

	int second = 31;
	Timer timer;
	JDialog dialog;

	public MainFrame() {
		// ��ϙC���֥������Ȥγ��ڻ�
		AdminManageHelper helper = new AdminManageHelper();	// �����ߥإ�ѩ`���饹�򥤥󥹥��󥹻�
		helper.getVendingMachine(); // ��ϙC�γ��ڻ�
		initComponents();
		upateJpanel();
		WindowUtil.setFrameCenter(this);	// ������ɥ��˥ե�`��򥻥å�
		this.setResizable(false);	// ����������ϲ���
		this.setVisible(true);	// �ե�`����ʾ
	}

	// ���󥹥ȥ饯���Ǻ��ӳ������
	private void initComponents() {
		// ���Љ����˂����{���Ƥ���
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
		jPanel1.setLayout(new GridLayout(0,3));	// ����åɥ쥤�����Ȥ��O�����롣2�Фα�ʾ�ˤʤ롣�Ф��������

		// WindowConstants -> ������ɥ��Υ���`���������������붨��
		// EXIT_ON_CLOSE -> �K�ˤ��륢�ץꥱ�`�����Υǥե���ȤΥ�����ɥ��˥���`��?���ڥ�`�����
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);	// �ǥե���ȤΥ���`��������ָ��
		setTitle("�Ԅ�؜�әC");	// �����ȥ�(�������ϲ�)
		setBackground(new java.awt.Color(245, 140, 100));	// �����ȥ�Щ`��RGB���O��
		jPanel1.setBackground(Color.GRAY);


		// ���֤Τߤ��������ޣ��ƥ�ץ�`�ȥ��`�ɣ�
		// ���`�ܩ`�ɤ�Ѻ���줿�Ȥ��Υ��٥�Ȥ�׷��
		jTextField1.addKeyListener(new KeyAdapter(){
			// ���`�ܩ`�ɤ���������Ȥ��˺��ӳ�����롣
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();	// ���٥�Ȥ��v�B�������֤򷵤�
				// ASCII ���֤� 0 ���� 9���¤��_�J����
				if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){

				}else{
					e.consume();	// ������������֥�å����롣
				}
			}
		});

		jButton1.setFont(new java.awt.Font("��Բ", 1, 12)); // �ܥ���Υե���Ȥ�ָ��
		jButton1.setText("���������");	// �ܥ���Υƥ����Ȥ�ָ��

		// ���h�Ά��}
		// �ܥ���˥�������󥤥٥�Ȥ��ܤ�ȡ���褦�ˤ���
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thisJframe.dispose();	// ������ɥ����Ɨ����ơ��꥽�`������
				LoginFrame loginFrame = new LoginFrame();	// ������ե�`�������


			}
		});
//        jLabel1.setText("����Ͷ��ڣ�");	// ���֤�ָ��
		jLabel1.setText("�I��������Ʒ���x��Ǥ�������");	// ���֤�ָ��
		jLabel1.setOpaque(true);
//        jLabel1.setBackground(Color.YELLOW);

		jButton2.setFont(new java.awt.Font("��Բ", 1, 12)); // �ե���Ȥ�ָ��
		jButton2.setText("�����Ͷ��");		// ���֤�ָ��

		// �ܥ���˥�������󥤥٥�Ȥ�׷��
		// Ӌ�㤹��I����Ф�
		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				computing();	// ���������ʹ�ä�Ӌ��

			}
		});

		// ���֤�ӛ��
		jLabel2.setText("���~��");

		jLabel3.setText("0Ԫ");

		jLabel4.setText("�ɥ�󥯣�");

		// �ե�`��ϥڥ���Ⱥ��Ф��Ӥ��ؤʤäƳɤ����äƤ���
		// getContentPane(�ܥ���ʤɤΥ���ݩ`�ͥ�Ȥ򺬤���)��ȡ��
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);	// layout���O��


		// ˮƽ�S���ؤäƥ���ݩ`�ͥ�Ȥ����äȥ�������ָ������褦���O��
		// �᷽���Ҫ�ؤ�����
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


		// �k�����Ҫ�ؤ�����
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
		Vector<Drink> drinks = manageHelper.getAllDrink();	// ���򤹤٤��֤�����
		for(int i=0;i<drinks.size();i++){
			Drink drink = drinks.get(i);
			String s;
			JButton jb;	// �ܥ���
			// ����0����Ϥ��ж�?�ӹ�
			if(drinks.get(i).getQuantity()==0){
				s = drink.getDrinkName()+"<br>"+"���";
				jb = new JButton("<html>"+s+"</html>",new ImageIcon(drink.getDrinkImg()));
				jb.setEnabled(false);	// ���äǤ��ʤ�״�B
			}else{
				s = drink.getDrinkName()+"<br>"+"����:"+drink.getPrice()+"��"+"<br>"+"����:"+drink.getQuantity();
				jb = new JButton("<html>"+s+"</html>",new ImageIcon(drink.getDrinkImg()));
			}
			// ��ϙC�Ή仯��10��δ���Έ��ϣ��仯��Ҋ���ʤ����ϣ����ж�?�I��
			if(VendingMachine.getInstance().getCoin()<10){
				jb.setEnabled(false);	// ���äǤ��ʤ�״�B
			}
			jb.setOpaque(true);
			jb.setBackground(Color.WHITE);

			jb.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					if(pay!=0){
						JOptionPane.showMessageDialog(thisJframe, "֧�B�������ˤ��Ƥ�������!!");
					}else{
						chooseDrink = drink;
//	 					Timelimit.main(null);
						jLabel5.setIcon((new ImageIcon(drink.getDrinkImg())));
						jLabel3.setText(drink.getPrice()+"��");
						jLabel4.setText(drink.getDrinkName());
						price = drink.getPrice();
						need = price;	// ���~���O������
						jLabel5.updateUI();
					}

					// ��`����Ǳ�ʾ
					dialog = new JDialog(thisJframe, true);
					dialog.setLayout(new GridBagLayout());

					GridBagConstraints gbc = new GridBagConstraints();
					gbc.gridx = 0;
					gbc.gridy = 0;

					// �������Ʒ���h���������ީ`�Υ쥤������
					JPanel panel1 = new JPanel();
					panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 80, 20));
					panel1.add(jLabel5);

					JPanel panel1_1 = new JPanel();
					panel1_1.setLayout(new GridLayout(0, 1, 10, 1));
					panel1_1.add(jLabel4);
					panel1_1.add(jLabel3);
					panel1_1.add(new Label("���x�k��"));
					panel1_1.add(jTextField1);
					panel1_1.add(new Label(""));

					// �����ީ`���O��
					JLabel counterLabel= new JLabel("  ");
					counterLabel.setFont(new Font("Arial", Font.PLAIN, 19));




					timer = new Timer(1000, new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							second -= 1;

							counterLabel.setText(""+ second +"s");
							if (second <= 0)
							{
								timer.stop();
								JOptionPane.showMessageDialog(thisJframe, "Ͷ�뤷�����~"+pay+"�Ҥ򤪷������ޤ�");
								dialog.dispose();
								second = 31;

								jPanel1.removeAll();//移除面板上的控件
								jPanel1.updateUI();
								upateJpanel();	//更新面板上的按钮
								jPanel1.updateUI();
								need = 0;	//设置回原来的�?
								price = 0;	//设置回原来的�?
								pay = 0;	//设置回原来的�?
							}
						}
					});

					timer.start();

					panel1_1.add(counterLabel);

					panel1.add(panel1_1);
					dialog.add(panel1, gbc);


					// �եå��`�Υ쥤������
					JPanel panel2 = new JPanel();
					panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

					JButton jButton3 = new JButton("����");
// 					jButton3.setText("����");
					jButton3.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							timer.stop();
							JOptionPane.showMessageDialog(thisJframe, "Ͷ�뤷�����~"+pay+"�Ҥ򤪷������ޤ�");
							dialog.dispose();

							second = 31;

							jPanel1.removeAll();//移除面板上的控件
							jPanel1.updateUI();
							upateJpanel();	//更新面板上的按钮
							jPanel1.updateUI();
							need = 0;	//设置回原来的�?
							price = 0;	//设置回原来的�?
							pay = 0;	//设置回原来的�?
						}
					});

					panel2.add(jButton3);
					panel2.add(jButton2);

					gbc.gridx = 0;
					gbc.gridy = 1;
					dialog.add(panel2, gbc);

// 					jLabel2.setPreferredSize(new Dimension(100, 70));

					dialog.setResizable(false);
					dialog.setSize(300, 200);
					dialog.setLocationRelativeTo(null);



					dialog.pack();
					dialog.show();
				}
			});

			jPanel1.add(jb);
		}
	}


	// �������ȡ��Q��������Ӌ�㤹��
	private void computing(){
		int repayment = 0;	//���~��ȡ�ä���
		int oncePay = 0;	//1�ؒB���ν��~
		String s = jTextField1.getText().trim();
		if(!s.equals("")){
			oncePay = Integer.parseInt(s);//�õ�Ͷ�ҵĽ��
		}

		if(price==0){

			if(oncePay!=0){
				JOptionPane.showMessageDialog(thisJframe, "��Ʒ���x��ǥ������׷�Ӥ��Ƥ�������!!");
				JOptionPane.showMessageDialog(thisJframe, "����򷵤��Ƥ�������!!");
				jTextField1.setText("");
			}else{
				JOptionPane.showMessageDialog(thisJframe, "��Ʒ���x��Ǥ�������!!");
				jTextField1.setText("");
			}
		}else if(price!=0 && oncePay==0){
			JOptionPane.showMessageDialog(thisJframe, "������򤯤�����!!");
			jTextField1.setText("");
		}else{

			switch (oncePay) {
				case 10:
					need = need - 10;
					if(need!=0){
						JOptionPane.showMessageDialog(thisJframe, "��Ҫ�ʤ���"+need+"��");
					}
					pay += oncePay;	//
					break;
				case 50:
					if(need<50){	//
						repayment = 50 - need;
						need = 0;	//����
					}else{//֧����5ԪǮС���ڻ���Ľ��,���������Ǯ
						need = need - 50;
						if(need!=0){
							JOptionPane.showMessageDialog(thisJframe, "��Ҫ�ʤ���"+need+"��");
						}
					}
					pay += oncePay;	//�õ�һ��֧���Ľ��
					break;
				case 100:
					if(need<100){	//
						repayment = 100 - need;
						need = 0;	//����
					}else{//֧����5ԪǮС���ڻ���Ľ��,���������Ǯ
						need = need - 100;
						if(need!=0){
							JOptionPane.showMessageDialog(thisJframe, "��Ҫ�ʤ���"+need+"��");
						}
					}
					pay += oncePay;	//�õ�һ��֧���Ľ��
					break;
//				    need -= 10;
//					if(need!=0){
//
//						JOptionPane.showMessageDialog(thisJframe, "Amount needed��"+need+"?");
//					}
//					pay += oncePay;	//�õ�һ��֧���Ľ��
//					break;
				case 500:
					if(need<500){	//
						repayment = 500 - need;
						need = 0;	//����
					}else{//֧����5ԪǮС���ڻ���Ľ��,���������Ǯ
						need = need - 500;
						if(need!=0){
							JOptionPane.showMessageDialog(thisJframe, "��Ҫ�ʤ���"+need+"��");
						}
					}
					pay += oncePay;	//�õ�һ��֧���Ľ��
					break;
				case 1000:
					if(need<1000){	//
						repayment = 1000 - need;
						need = 0;	//����
					}else{//֧����5ԪǮС���ڻ���Ľ��,���������Ǯ
						need = need - 1000;
						if(need!=0){
							JOptionPane.showMessageDialog(thisJframe, "��Ҫ�ʤ���"+need+"��");
						}
					}
					pay += oncePay;	//�õ�һ��֧���Ľ��
					break;

				case 5000:
					if(need<5000){	//
						repayment = 5000 - need;
						need = 0;	//����
					}else{//֧����5ԪǮС���ڻ���Ľ��,���������Ǯ
						need = need - 5000;
						if(need!=0){
							JOptionPane.showMessageDialog(thisJframe, "��Ҫ�ʤ���"+need+"��");
						}
					}
					pay += oncePay;	//�õ�һ��֧���Ľ��
					break;

				case 10000:
					if(need<10000){	//
						repayment = 10000 - need;
						need = 0;	//����

					}else{//֧����5ԪǮС���ڻ���Ľ��,���������Ǯ
						need = need - 10000;
						if(need!=0){
							JOptionPane.showMessageDialog(thisJframe, "��Ҫ�ʤ���"+need+"��");
						}
					}
					pay += oncePay;	//�õ�һ��֧���Ľ��
					break;
				default:
					JOptionPane.showMessageDialog(thisJframe, "����Ӳ؛��ʹ�äǤ��ޤ���");
					JOptionPane.showMessageDialog(thisJframe, "������ܤ�ȡ��ʤ���");
					jTextField1.setText("");
					break;
			}




			if(repayment!=0){
				JOptionPane.showMessageDialog(thisJframe, "��ឤ��"+repayment+"��");
			}
			if(price!=0 && need==0){//����ɹ�
				JOptionPane.showMessageDialog(thisJframe, "�ɥ�󥯤�ُ��˳ɹ����ޤ��������Ƥ���ޤǤ�������������!!");
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
				timer.stop();
				//JOptionPane.showMessageDialog(thisJframe, "Ͷ�뤷�ƽ��~"+pay+"�Ҥ򤪷������ޤ�");
				dialog.dispose();
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
			jLabel3.setText(need+"��");
		}

	}



}


