package indi.cc.vendingmachine.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import indi.cc.vendingmachine.bean.Administrator;
import indi.cc.vendingmachine.dao.AdminManageHelper;
import indi.cc.vendingmachine.util.WindowUtil;

public class SumofMoneyFrame extends javax.swing.JDialog {

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
     * @param owner 它的父窗口
     * @param title 窗口名
     * @param modal 指定的模式窗口，还有非模式窗口
     */
    public SumofMoneyFrame(JFrame owner, String title, boolean modal){
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
        AdminManageHelper manageHelper = new AdminManageHelper();

        jLabel1.setText("売上高は"+manageHelper.getAllSum()+"円");

        jLabel2.setText("パスワード");

        jLabel3.setText("パスワード");



        jButton1.setText("作成");
        jButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                String username = jTextField1.getText().trim();
                String password = String.valueOf(jPasswordField1.getPassword());
                String rePassword = String.valueOf(jPasswordField2.getPassword());
                if(username.equals("")){
                    JOptionPane.showMessageDialog(jd, "ユーザー名を記入してください");
                    return ;
                }else if(password.equals("")){
                    JOptionPane.showMessageDialog(jd, "パスワードを記入してください");
                    return ;
                }else if(rePassword.equals("")){
                    JOptionPane.showMessageDialog(jd, "パスワードを記入してください");
                    return ;
                }else if(!password.equals(rePassword)){
                    JOptionPane.showMessageDialog(jd, "パスワードは一致していません");
                    return ;
                }else {
                    Administrator admin = new Administrator(username, password);
                    AdminManageHelper manageHelper = new AdminManageHelper();
                    if(manageHelper.addAdmin(admin)){
                        JOptionPane.showMessageDialog(jd, "成功");
                        jd.dispose();
                        return ;
                    }else{
                        JOptionPane.showMessageDialog(jd, "失败");
                        jd.dispose();
                        return ;
                    }
                }
            }
        });

        jButton2.setText("戻る");
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
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
//                                                        .addGroup(layout.createSequentialGroup()
//                                                                .addComponent(jLabel3)
//                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                                                                .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                                                        .addComponent(jLabel1)
                                                                        // .addComponent(jLabel2))
                                                                        .addGap(15, 15, 15)
                                                                        //.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER, true)
                                                                        //   .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                                                        //.addComponent(jPasswordField1)))
                                                                        // .addContainerGap(67, Short.MAX_VALUE))
                                                                        .addGroup(layout.createSequentialGroup()))))))));
        //.addComponent(jButton1)
        //.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
        //.addComponent(jButton2)
        //.addGap(59, 59, 59))))

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20,20,20)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                                        .addComponent(jLabel1)
                                        //.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addGap(28, 28, 28)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jLabel2)
//                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                                .addGap(25, 25, 25)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                                        .addComponent(jLabel3)
//                                        .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30,30,30))
                                //.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                //.addComponent(jButton1)
                                //.addComponent(jButton2))
                                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }






}
