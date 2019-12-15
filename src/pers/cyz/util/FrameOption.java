package pers.cyz.util;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 窗口设置类，包含每个窗口所必须设置的大小、位置、默认关闭方式等
 * 
 * @author 1651200111 陈彦志
 */
public class FrameOption {
	
	public FrameOption(JFrame frame) {
		
		frame.setVisible(true);
		// 窗口不可调整大小
		frame.setResizable(false);
		frame.setSize(800, 508);
		frame.setLocation(200,100);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);	
		
	}
	
	

}
