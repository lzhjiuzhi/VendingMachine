package indi.cc.vendingmachine.bean;

import indi.cc.vendingmachine.dao.AdminManageHelper;

//�Ԅ�؜�әC�Υ��饹
public class VendingMachine {
	private int totalAmount;	//����Ӌ�κ�Ӌ���~
	private int coin;	//Ӳ؛

	
	 //static��ʹ�������󥹥��󥹤򱣴椹��
    private static VendingMachine instance;  
    // private��ʹ�����}�����Ԅ�؜�әC�Υ��󥹥��󥹤����ɤ���뤳�Ȥ����
    private VendingMachine(){  
      
    }  
    //static�᥽�åɤǥ��󥹥��󥹤����
    public static VendingMachine getInstance(){  
        //���󥹥��󥹤�����ǰ�ˡ����󥹥��󥹤⤦�Ȥ˴��ڤ��Ƥ��뤫�ɤ���������å�
        if(instance == null){  
            //���ڤ��ʤ��ʤ顢�¤������󥹥��󥹤�����  
            instance = new VendingMachine();  
        }  
        //�����ꂎ�����饹�Υ��󥹥���   
        return instance;      
    }  
	
	

	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getCoin() {
		return coin;
	}
	public void setCoin(int coin) {
		this.coin = coin;
	}

	
}
