package pers.cyz.model;

/**
 * 图书模型类,包含数据库图书表各对应的字段get、set方法
 * 
 * @author 1651200111 陈彦志
 */
public class Book {
	private int ID;
	// ISBN号
	private String ISBN;
	// 图书名称
	private String bookName;
	// 图书价格
	private float price;
	// 图书作者
	private String author;
	// 出版社
	private String publishedHouse;
	// 图书分类号
	private String bookCategory;
	// 借书人姓名
	private String borrowerName;
	// 借书人电话
	private String borrowerPhone;

	/**
	 * 获取ID
	 */
	public int getID() {
		return ID;
	}
	/**
	 * 设置ID
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	/**
	 * 获取ISBN
	 */
	public String getISBN() {
		return ISBN;
	}
	/**
	 * 设置ISBN
	 */
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	
	
	/**
	 * 获取图书名称
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * 设置图书名称
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	
	/**
	 * 获取图书价格
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * 设置图书价格
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	
	
	/**
	 * 获取图书作者
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置图书作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	/**
	 * 获取出版社
	 */
	public String getPublishHouse() {
		return publishedHouse;
	}
	/**
	 * 设置出版社
	 */
	public void setPublishHouse(String publishedHouse) {
		this.publishedHouse = publishedHouse;
	}
	
	
	/**
	 * 获取图书分类信息
	 */
	public String getBookCategory() {
		return bookCategory;
	}
	/**
	 * 设置图书分类信息
	 */
	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}
	
	
	/**
	 * 获取借书人姓名
	 */
	public String getBorrowerName() {
		return borrowerName;
	}
	/**
	 * 设置借书人姓名
	 */
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	
	
	/**
	 * 获取借书人电话
	 */
	public String getBorrowerPhone() {
		return borrowerPhone;
	}
	/**
	 * 设置借书人电话
	 */
	public void setBorrowerPhone(String borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}


}
