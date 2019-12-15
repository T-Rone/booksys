package pers.cyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pers.cyz.model.Book;
import pers.cyz.util.DBUtil;

/**
 * 数据库图书表信息数据访问对象类，包含增加图书信息、删除图书信息
 * 、更新图书信息、查询图书信息、查询借阅信息和归还图书
 * 
 * @author 1651200111 陈彦志
 */
public class BookDao {


	/**
	 * 增加图书信息
	 */
    public void addBook(Book book) throws Exception{
    	// 首先拿到数据库的连接
        Connection con = DBUtil.getConnection();
        String sql="insert into tb_books"
        		// ISBN、书名、图书价格、图书作者、出版社
        		+ "(ISBN, book_name, book_price, book_author, published_house,"
        		// 分类号、借书人姓名、借书人电话、借书日期，已借天数
        		+ "book_category, borrower_name, borrower_phone) "
        		+ "values("
        		/*
        		 * 参数用?表示，相当于占位符，然后在对参数进行赋值。当真正执行时，
        		 * 这些参数会加载在SQL语句中，把SQL语句拼接完整才去执行。这样就会减少对数据库的操作
        		 */
        		+ "?,?,?,?,?,?,?,?)";
        /*
         * prepareStatement这个方法会将SQL语句加载到驱动程序conn集成程序中，
         * 但是并不直接执行,而是当它调用execute()方法的时候才真正执行；
         */
        PreparedStatement psmt = con.prepareStatement(sql);
        // 先对应SQL语句，给SQL语句传递参数
        psmt.setString(1, book.getISBN());
        psmt.setString(2, book.getBookName());
        psmt.setFloat(3, book.getPrice());
        psmt.setString(4, book.getAuthor());
        psmt.setString(5, book.getPublishHouse());
        psmt.setString(6, book.getBookCategory());
        
        if (book.getBorrowerName() == null || book.getBorrowerName() == "") {
        	psmt.setString(7, null);
        }
        else {
        	  psmt.setString(7, book.getBorrowerName());
        }
      
        if (book.getBorrowerPhone() == null || book.getBorrowerPhone() == "") {
        	 psmt.setString(8, null);  
        }
        else {
        	psmt.setString(8, book.getBorrowerPhone());  
        }
        
        //执行SQL语句
        psmt.execute();

    }
	
  
    /**
     * 删除图书信息
     */
      public void delBook(int ID) throws SQLException{
    	  // 首先拿到数据库的连接
          Connection con=DBUtil.getConnection();
          String sql="" + 
                  "DELETE FROM tb_books "+               
                  // 参数用?表示，相当于占位符
                  "WHERE ID = ?";
          // 预编译sql语句
          PreparedStatement psmt = con.prepareStatement(sql);
          // 先对应SQL语句，给SQL语句传递参数
          psmt.setInt(1, ID);
          // 执行SQL语句
          psmt.execute();    
      }
	    

	/**
	 * 更新图书信息
	 */
    public void changeBook(Book book) throws SQLException{
    	// 首先拿到数据库的连接
        Connection con=DBUtil.getConnection();
        String sql="update tb_books "
        		+ "set ISBN = ?, book_name = ?, book_price = ?, book_author = ?"
                + ",published_house = ?, book_category = ?, borrower_name = ?, borrower_phone = ? "
                // 参数用?表示，相当于占位符 
        		+ "where ID = ?";
        // 预编译sql语句
        PreparedStatement psmt = con.prepareStatement(sql);
        // 先对应SQL语句，给SQL语句传递参数
        psmt.setString(1, book.getISBN());
        psmt.setString(2, book.getBookName());
        psmt.setFloat(3, book.getPrice());
        psmt.setString(4, book.getAuthor());
        psmt.setString(5, book.getPublishHouse());
        psmt.setString(6, book.getBookCategory());
        if (book.getBorrowerName().equals("")) {
        	psmt.setString(7, null);
        }
        else {
        	 psmt.setString(7, book.getBorrowerName());
        }
       
        if (book.getBorrowerPhone().equals("")) {
        	psmt.setString(8, null);
        }
        else {
        	 psmt.setString(8, book.getBorrowerPhone());
        }
        psmt.setInt(9, book.getID());
        // 执行SQL语句
        psmt.execute();    
    }

	        

	/**
	 * 查询书籍信息
	 */
	public List<Book> query() throws Exception{	       
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("select "
				// ISBN、书名、作者、图书价格、出版社
				+ "ID, ISBN, book_name, book_author, book_price, published_house, "
				// 分类号、借书人姓名、借书人电话
				+ "book_category, borrower_name, borrower_phone "
				+ "from tb_books");	      
		List<Book> bookList = new ArrayList<Book>();	       
		Book book = null;	   
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	           
			book = new Book();	     
			book.setID(rs.getInt("ID"));
			book.setISBN(rs.getString("ISBN"));
			book.setBookName(rs.getString("book_name"));	       
			book.setAuthor(rs.getString("book_author"));
			book.setPrice(rs.getFloat("book_price"));
			book.setPublishHouse(rs.getString("published_house"));
			book.setBookCategory(rs.getString("book_category"));
			book.setBorrowerName(rs.getString("borrower_name"));
			book.setBorrowerPhone(rs.getString("borrower_phone"));
			bookList.add(book);	        
		}	       
		return bookList;	  
	}


	/**
	 * 查询借阅信息
	 * 
	 * @return
	 * 		bookList
	 */
	public List<Book> borrowQuery() throws Exception{	       
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery(""
				// ID、书名、借书人姓名、借书人电话
				+ "SELECT ID, book_name, borrower_name, borrower_phone "
				+ "FROM tb_books "
				+ "WHERE borrower_name IS NOT NULL"
				);	      
		List<Book> bookList = new ArrayList<Book>();	       
		Book book = null;	     
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	           
			book = new Book();	     
			book.setID(rs.getInt("ID"));
			book.setBookName(rs.getString("book_name"));	       
			book.setBorrowerName(rs.getString("borrower_name"));
			book.setBorrowerPhone(rs.getString("borrower_phone"));
			bookList.add(book);	        
		}	       
		return bookList;	  
	}

	/**
	 * 更新图书信息，归还图书
	 */
    public void returnBook(Book book) throws SQLException{
    	// 首先拿到数据库的连接
        Connection con=DBUtil.getConnection();
        String sql="UPDATE tb_books "
        		// ISBN、图书名称、作者、价格
        		+ "SET "
        		// 借书人姓名、借书人电话
        		+ "borrower_name = ?, borrower_phone = ? "
                // 参数用?表示，相当于占位符 
        		+ "WHERE ID = ?";
        // 预编译sql语句
        PreparedStatement psmt = con.prepareStatement(sql);
        // 先对应SQL语句，给SQL语句传递参数
        psmt.setString(1, book.getBorrowerName());
        psmt.setString(2, book.getBorrowerPhone());
        psmt.setInt(3, book.getID());
        // 执行SQL语句
        psmt.execute();    
    }
	

}
