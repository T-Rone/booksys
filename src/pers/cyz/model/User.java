package pers.cyz.model;

/**
 * 用户模型类,包含数据库用户表各对应的字段get、set方法
 * 
 * @author 1651200111 陈彦志
 */
public class User {
	
	private int ID;
	// 用户名
	private String userName;
	// 密码
	private String passwd;
	
	
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
	 * 获取用户名
	 */
	public String getUser() {
		return userName;
	}
	/**
	 * 设置用户名
	 */
	public void setUser(String userName) {
		this.userName = userName;
	}
	
	/**
	 * 获取用户密码
	 */
	public String getPasswd() {
		return passwd;
	}
	/**
	 * 设置用户密码
	 */
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

}
