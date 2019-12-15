package pers.cyz.controller;

import java.util.List;

import javax.swing.JTable;

import pers.cyz.dao.BookDao;
import pers.cyz.model.Book;

/**
 * 借还书行为控制类，包含初始化借还书管理窗体表格以及归还图书
 * 
 * @author 1651200111 陈彦志
 */
public class BorrowAction {

	
	BookDao borrowerDao;
    
	/**
	 * 初始化借还书管理窗体表格
	 * @return
	 * 		results
	 */
	@SuppressWarnings("rawtypes")
	public Object[][] initializTable(String[] columnNames) throws Exception{
		borrowerDao = new BookDao();
		List list = borrowerDao.borrowQuery();
		Object[][] results = new Object[list.size()][columnNames.length];
		
		for(int i = 0; i < list.size(); i++) {		
			Book book = (Book)list.get(i);			
			
			results[i][0] = book.getID();
			results[i][1] = book.getBookName();	
			results[i][2] = book.getBorrowerName();		
			results[i][3] = book.getBorrowerPhone();
		}	   	
		return results;
	}
	
	
	/**
	 * 归还图书
	 */
	public void BorrowBook (JTable table) throws Exception{
		
        borrowerDao=new BookDao();
        Book book=new Book();     
       
		int selRow = table.getSelectedRow();
		int ID = Integer.parseInt(table.getValueAt(selRow, 0).toString());	
	
        book.setID(ID);
        book.setBorrowerName(null);
        book.setBorrowerPhone(null);
        
        // 归还图书
        borrowerDao.returnBook(book);
	}
	
	
	
}
