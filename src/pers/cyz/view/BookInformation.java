package pers.cyz.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import pers.cyz.controller.BookAction;
import pers.cyz.util.BackgroundImage;
import pers.cyz.util.FrameOption;
import pers.cyz.util.LimitTextLength;
import pers.cyz.util.MenuBar;
import pers.cyz.util.SetTableColumnCenter;


/**
 * 图书信息管理界面类
 * 
 * @author 1651200111 陈彦志
 */
@SuppressWarnings("serial")
public class BookInformation extends JFrame {
	
	JFrame frame = new JFrame("个人书屋");
	Container container = frame.getContentPane();
	
	
	// 增加、删除、修改按钮
	JButton buttonAdd, buttonDel, buttonChange,buttonReset; 
	
	// ISBN、图书名称、图书价格、图书作者文本框
	JTextField textFieldISBN, textFieldBookName, textFieldPrice, textFieldAuthor;
	// 出版社、图书分类号、借书人姓名文本框
	JTextField textFieldPublishedHouse, textFieldBookCategory;
	// 借书人姓名、借书人电话
	JTextField textFieldBorrowName, textFieldBorrowPhone;
	
	// 表格
	JTable table;
	// 显示表格的滚动面板
	JScrollPane scrollPane;
	
	BookAction bookAction;
	
	public BookInformation()  {

		frame.setLayout(null);
		
		// 设置背景图片
		new BackgroundImage(frame,container,"BookInformation.jpg");
		// 添加工具栏以及各组件和监听事件
		new MenuBar(frame);
		
		bookAction = new BookAction();
		
		// ISBN文本框
		textFieldISBN = new JTextField();
		setTextFieldISBN();		
		// 图书名称文本框
		textFieldBookName = new JTextField();
		setTextFieldBookName();
		// 图书价格文本框
		textFieldPrice = new JTextField();
		setTextFieldBookPrice();
		// 图书作者文本框
		textFieldAuthor = new JTextField();
		setTextFieldAuthor();
		// 出版社文本框
		textFieldPublishedHouse = new JTextField();
		setTextFieldPublishedHouse();	
		// 图书分类号文本框
		textFieldBookCategory = new JTextField();
		setTextFieldBookCategory();	
		// 借书人姓名文本框
		textFieldBorrowName = new JTextField();
		setTextFieldBorrowName();
		// 借书人电话文本框
		textFieldBorrowPhone = new JTextField();
		setTextFieldBorrowPhone();
		
		// 设置窗体表格
		setTable();
		
		// 增加按钮
		buttonAdd = new JButton();
		setButtonAdd();	
		// 删除按钮
		buttonDel = new JButton();
		setButtonDel();		
		// 修改按钮
		buttonChange = new JButton();
		setButtonChange();	
		// 重置按钮
		buttonReset = new JButton();
		setButtonReset();
	
		container.add(scrollPane);
		
		container.add(buttonAdd);
		container.add(buttonDel);
		container.add(buttonReset);
		container.add(buttonChange);
		
		container.add(textFieldISBN);
		container.add(textFieldBookName);
		container.add(textFieldAuthor);
		container.add(textFieldPrice);
		container.add(textFieldBookCategory);
		container.add(textFieldPublishedHouse);
		container.add(textFieldBorrowName);
		container.add(textFieldBorrowPhone);

		// 设置窗口大小、位置、可视、默认关闭方式等
		new FrameOption(frame);
	}


	/**
	 * 设置借书人电话文本框
	 */
	private void setTextFieldBorrowPhone() {
		textFieldBorrowPhone.setBounds(490,312,232,23);
	}


	/**
	 * 设置借书人姓名文本框
	 */
	private void setTextFieldBorrowName() {
		textFieldBorrowName.setBounds(150,312,200,23);
	}


	/**
	 * 设置修改按钮
	 */
	private void setButtonChange() {
		buttonChange.setBounds(470,390,60,25);
		buttonChange.setIcon(new ImageIcon("res/button_change.jpg"));
		buttonChange.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {	
				try {
					bookAction.changeBookInformation(textFieldISBN, textFieldBookName
							,textFieldPrice, textFieldAuthor, textFieldPublishedHouse
							, textFieldBookCategory, textFieldBorrowName, textFieldBorrowPhone, table);		
					frame.setVisible(false);
					new BookInformation();				
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"表中没有该数据","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}

			}
		});
	}


	/**
	 * 设置图书分类号文本框
	 */
	private void setTextFieldBookCategory() {
		textFieldBookCategory.setBounds(582,340,140,23);
	}


	/**
	 * 设置出版社文本框
	 */
	private void setTextFieldPublishedHouse() {
		textFieldPublishedHouse.setBounds(348,340,140,23);
	}


	/**
	 * 设置图书作者文本框
	 */
	private void setTextFieldAuthor() {
		textFieldAuthor.setBounds(586,280,140,23);
	}


	/**
	 * 设置图书价格文本框
	 */
	private void setTextFieldBookPrice() {
		textFieldPrice.setBounds(120,340,140,23);
	}


	/**
	 * 设置图书名称文本框
	 */
	private void setTextFieldBookName() {
		textFieldBookName.setBounds(348,280,140,23);
	}


	/**
	 * 设置ISBN文本框
	 */
	private void setTextFieldISBN() {
		// 限制文本框长度为17
		textFieldISBN.setDocument(new LimitTextLength(17));
		textFieldISBN.setBounds(120,280,140,23);
	}


	/**
	 * 设置删除按钮
	 */
	private void setButtonDel() {
		buttonDel.setBounds(580,390,60,25);
		buttonDel.setIcon(new ImageIcon("res/button_del.jpg"));
		buttonDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					bookAction.delBookInformation(table);
					frame.setVisible(false);	
					new BookInformation();
				} catch(Exception e1) {
					e1.printStackTrace();
				}			
			}
		});
	}

	/**
	 * 设置文本框重置按钮
	 */
	private void setButtonReset() {
		buttonReset.setBounds(270,390,150,25);
		buttonReset.setIcon(new ImageIcon("res/button_textReset.jpg"));
		buttonReset.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textFieldBookName.setText("");
				textFieldAuthor.setText("");
				textFieldISBN.setText("");
				textFieldPrice.setText("");
				textFieldBookCategory.setText("");
				textFieldPublishedHouse.setText("");
				
			}
		});
	}


	/**
	 * 设置添加按钮
	 */
	private void setButtonAdd() {
		buttonAdd.setBounds(700,390,60,25);
		buttonAdd.setIcon(new ImageIcon("res/button_add.jpg"));
		buttonAdd.addActionListener(new ActionListener() {		
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(textFieldISBN.getText().length() == 0) {
					JOptionPane.showMessageDialog(null,"ISBN号不能为空","错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
					
				else if(textFieldISBN.getText().length() != 17) {	
					JOptionPane.showMessageDialog(null,"ISBN号位数必须是13位","错误"
							, JOptionPane.PLAIN_MESSAGE);	
				}
				else if(textFieldBookName.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "图书名称不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
					
				else if(textFieldAuthor.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "图书作者不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textFieldPrice.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "图书价格不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textFieldPublishedHouse.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "出版社不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textFieldBookCategory.getText().length() == 0) {
					JOptionPane.showMessageDialog(null, "图书分类号不能为空", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else if(textFieldPrice.getText().length() > 4) {
					JOptionPane.showMessageDialog(null, "图书价格不能超过4位数", "错误"
							, JOptionPane.PLAIN_MESSAGE);
				}
				else {
					try {
						bookAction.addBookInformation(textFieldISBN, textFieldBookName, textFieldPrice,textFieldAuthor
								,textFieldPublishedHouse,textFieldBookCategory,textFieldBorrowName,textFieldBorrowPhone);		
						frame.setVisible(false);	
						new BookInformation();
					}catch(Exception e1) {
						e1.printStackTrace();
					}
				}
			
			}
		});
	}


	/**
	 * 设置窗体表格
	 */
	private void setTable() {
		String[] columnNames = {"ID", "图书名称","图书作者","图书价格(元)","ISBN"
				,"出版社","分类号", "借书人姓名", "借书人电话"
				};	
		try {
			BookAction bookAction = new BookAction();
			Object[][] results = bookAction.initializTable(columnNames);
		
			table = new JTable(results,columnNames);
			// 设置表格字段居中
			new SetTableColumnCenter(table);
			scrollPane = new JScrollPane(table);
			scrollPane.setViewportView(table);
			scrollPane.setBounds(20,80,760,190);			
			table.addMouseListener(new MouseListener() {			
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub			
				}			
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub	
				}				
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub					
				}				
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub					
				}			
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					String ISBN,  bookName, price, author;
					String publishedHouse, category, borrowName, borrowPhone;
					
					int selRow = table.getSelectedRow();
			
					bookName = table.getValueAt(selRow, 1).toString();
					author = table.getValueAt(selRow, 2).toString();
					price = table.getValueAt(selRow, 3).toString();
					ISBN = table.getValueAt(selRow, 4).toString();
					publishedHouse = table.getValueAt(selRow, 5).toString();
					category = table.getValueAt(selRow, 6).toString();	
						
					if (table.getValueAt(selRow, 7).toString() == null) {
						borrowName = "";
					}
					else {
						borrowName = table.getValueAt(selRow, 7).toString();
					}
					
					if (table.getValueAt(selRow, 8).toString() == null) {
						borrowPhone = "";
					}
					else {
						borrowPhone = table.getValueAt(selRow, 8).toString();
					}			
					textFieldBookName.setText(bookName);
					textFieldAuthor.setText(author);
					textFieldPrice.setText(price);
					textFieldISBN.setText(ISBN);
					textFieldPublishedHouse.setText(publishedHouse);
					textFieldBookCategory.setText(category);
					textFieldBorrowName.setText(borrowName);
					textFieldBorrowPhone.setText(borrowPhone);
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
