package pers.cyz.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * 键盘事件类，按下回车则模拟鼠标点击登录、确认按钮（用在登录窗体和更改密码窗体）
 * 
 * @author 1651200111 陈彦志
 */
public class KeyListener {
	
	public KeyListener(JTextField text,final JButton button) {
		
		// 键盘事件，如果按下回车则模拟鼠标点击登录按钮
		text.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent paramKeyEvent) {
	            if(paramKeyEvent.getKeyChar()=='\n'){
	            	button.doClick();
	            }
	        }
	    });
	}
	
	public KeyListener(JPasswordField passwd,final JButton button) {
		// 键盘事件，如果按下回车则模拟鼠标点击登录按钮
		passwd.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent paramKeyEvent) {
	            if(paramKeyEvent.getKeyChar()=='\n'){
	            	button.doClick();
	            }
	        }
	    });
	}

}
