package pers.cyz.controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;

import pers.cyz.dao.BookDao;
import pers.cyz.model.Book;


/**
 * 图书信息行为控制类，包含增加图书、删除图书
 * 、 修改图书、和初始化个人书库管理窗体表格
 * 
 * @author 1651200111 陈彦志
 */
public class BookAction {
	
 
        
	/**
	 * 初始化窗体表格
	 * @return
	 * 		results
	 */
	@SuppressWarnings("rawtypes")
	public Object[][] initializTable(String[] columnNames) throws Exception{
		BookDao bookDao = new BookDao();
		List list = bookDao.query();
		Object[][] results = new Object[list.size()][columnNames.length];
		
		for(int i = 0; i < list.size(); i++) {
			Book book = (Book)list.get(i);				
	
			results[i][0] = book.getID();
			results[i][1] = book.getBookName();
			results[i][2] = book.getAuthor();
			results[i][3] = book.getPrice();
			results[i][4] = book.getISBN();
			results[i][5] = book.getPublishHouse();
			results[i][6] = book.getBookCategory();	
	
			String borrowerName =  book.getBorrowerName();
			if (borrowerName == null) {	
				borrowerName = "";	
				results[i][7] = borrowerName;
			}
			else {	
				results[i][7] = borrowerName;
			}
			
			String borrowerPhone = book.getBorrowerPhone();	
			if (borrowerPhone == null) {		
				borrowerPhone = "";	
				results[i][8] = borrowerPhone;
			}	
			else {	
				results[i][8] = borrowerPhone;
			}
		}	   	
		return results;
}
	
	
 	/**
 	 * 添加图书信息
 	 */
	public void addBookInformation (JTextField textFieldISBN, JTextField textFieldName
			,JTextField textFieldPrice, JTextField textFieldAuthor, JTextField textFieldPublishedHouse
			, JTextField textFieldBookCategory, JTextField textFieldBorrowName
			, JTextField textFieldBorrowPhone) throws Exception {
	
        BookDao bookDao=new BookDao();
        Book book=new Book();     
        
        book.setISBN(textFieldISBN.getText());      
        book.setBookName(textFieldName.getText());
        float price = Float.parseFloat(textFieldPrice.getText());
        book.setPrice(price);
        book.setAuthor(textFieldAuthor.getText());
        book.setPublishHouse(textFieldPublishedHouse.getText());
        book.setBookCategory(textFieldBookCategory.getText());
        
        if (textFieldBorrowName.getText() == null ||textFieldBorrowName.getText() == "" ) {
        	book.setBorrowerName(null);
        }
        else {
        	 book.setBorrowerName(textFieldBorrowName.getText());
        }
       
        if (textFieldBorrowPhone.getText() == null || textFieldBorrowPhone.getText() == "") {
        	book.setBorrowerPhone(null);
        }
        else {
        	book.setBorrowerPhone(textFieldBorrowPhone.getText());
        }
        
        //添加图书
        bookDao.addBook(book);
	}
	
	

	/**
	 * 删除图书信息
	 */
	public void delBookInformation (JTable table) throws Exception {
	
		int selRow = table.getSelectedRow();
		int ID = Integer.parseInt(table.getValueAt(selRow, 0).toString());
		
        BookDao bookDao=new BookDao();
        Book book=new Book();     
        
        book.setID(ID);
   
        // 删除图书信息
        bookDao.delBook(ID);
	}
	
	
	/**
	 * 修改图书信息
	 */
	public void changeBookInformation (JTextField textFieldISBN, JTextField textFieldName
			,JTextField textFieldPrice, JTextField textFieldAuthor, JTextField textFieldPublishedHouse
			, JTextField textFieldBookCategory, JTextField textFieldBorrowerName
			, JTextField textFieldBorrowerPhone, JTable table) throws Exception{
		
        BookDao bookDao=new BookDao();
        Book book=new Book();     
       
		int selRow = table.getSelectedRow();
		int ID = Integer.parseInt(table.getValueAt(selRow, 0).toString());	
        book.setID(ID);
        
        book.setISBN(textFieldISBN.getText());      
        book.setBookName(textFieldName.getText());
        book.setAuthor(textFieldAuthor.getText());
        float price = Float.parseFloat(textFieldPrice.getText());
        book.setPrice(price);
        book.setPublishHouse(textFieldPublishedHouse.getText());
        book.setBookCategory(textFieldBookCategory.getText());
        book.setBorrowerName(textFieldBorrowerName.getText());
    	book.setBorrowerPhone(textFieldBorrowerPhone.getText());
         
        //修改图书
        bookDao.changeBook(book);       
	}
	
	
}
    
    
    



