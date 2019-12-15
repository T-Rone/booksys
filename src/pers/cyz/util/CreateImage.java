package pers.cyz.util;

import javax.swing.ImageIcon;

/**
 * 指定路径加载图片
 * 
 * @author 1651200111 陈彦志
 */
public class CreateImage {
	
	public static ImageIcon add(String ImageName) {	
		// 加载图片
		ImageIcon icon= new ImageIcon("res/" + ImageName);	
		return icon;
	}
	

}
