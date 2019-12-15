package pers.cyz;


import javax.swing.JFrame;

import pers.cyz.view.Login;



/**
 * 主程序类
 * 
 * @author 1651200111 陈彦志
 */
@SuppressWarnings("serial")
public class BookManage extends JFrame {
	

	public BookManage() {
		
		new Login();
	}
	
	
	public static void main(String[] args) {
		
		new BookManage();
		
	}

}
