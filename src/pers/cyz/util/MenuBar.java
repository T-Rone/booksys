package pers.cyz.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import pers.cyz.view.BookBorrow;
import pers.cyz.view.BookInformation;
import pers.cyz.view.ChangeUserInformation;
import pers.cyz.view.Login;

/**
 * 菜单栏类，包含图书类别管理、图书信息管理、更改密码、退出系统菜单项以及进入各窗体触发事件
 * 
 * @author 1651200111 陈彦志
 */
public class MenuBar {
	
	JMenuBar menuBar;
	JMenuItem menuItemBookInformation;
	JMenuItem menuItemBorrowManage;
	JMenuItem menuItemChangUser;
	JMenuItem menuItemExit;
	
	
	public MenuBar(JFrame frame) {
		
		menuBar = new JMenuBar();
		
		// 图书信息管理菜单项
		menuItemBookInformation = new JMenuItem();	 
		setMenuItemBookInformationn(frame);
	
		// 图书借阅管理菜单项
		menuItemBorrowManage = new JMenuItem();
		setMenuItemBorrowManage(frame);
		
		// 用户信息更改菜单项
		menuItemChangUser = new JMenuItem();
		setMenuItemChangeUser(frame);
		
		// 退出系统菜单项
		menuItemExit = new JMenuItem();
		setMenuItemExit(frame);
			
		menuBar.add(menuItemBorrowManage);
		menuBar.add(menuItemBookInformation);
		menuBar.add(menuItemChangUser);
		menuBar.add(menuItemExit);
		
		frame.setJMenuBar(menuBar);
	}


	
	/**
	 * 设置退出系统菜单项
	 */
	private void setMenuItemExit(final JFrame frame) {
		menuItemExit.setIcon(new ImageIcon("res/menuItemExit.jpg"));
		menuItemExit.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new Login();
			}
		});
	}


	private void setMenuItemChangeUser(final JFrame frame) {
		menuItemChangUser.setIcon(new ImageIcon("res/menuItemChangePassword.jpg"));
		menuItemChangUser.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new ChangeUserInformation();
			}
		});
	}


	private void setMenuItemBorrowManage(final JFrame frame) {
		menuItemBorrowManage.setIcon(new ImageIcon("res/menuBookCategoryManage.jpg"));
		menuItemBorrowManage.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);
				new BookBorrow();
			}
		});
	}


	private void setMenuItemBookInformationn(final JFrame frame) {
		menuItemBookInformation.setIcon(new ImageIcon("res/menuBookInformationManage.jpg"));
		menuItemBookInformation.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// 使父窗体不可见
				frame.setVisible(false);	
				new BookInformation();
			}
		});
	}
	

}
