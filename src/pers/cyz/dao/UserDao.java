package pers.cyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pers.cyz.model.User;
import pers.cyz.util.DBUtil;

/**
 * 用户表信息数据访问对象类，包含更改用户信息
 * 
 * @author 1651200111 陈彦志
 */
public class UserDao {
	    

	/**
	 * 更改用户信息
	 */
    public void updateUser (User user, String username, String passwd) throws SQLException{
    	// 首先拿到数据库的连接
        Connection con = DBUtil.getConnection();
        String sql="update tb_user "
        		// 参数用?表示，相当于占位符
        		+"set user=?,passwd=? "
        		+ "where id=1";
        //预编译sql语句
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        //先对应SQL语句，给SQL语句传递参数
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, passwd);
        //执行SQL语句
        preparedStatement.execute();    
    }

	
	/**
	 * 查询用户信息(测试用)
	 * 
	 * @return
	 * 		userList
	 */
	public List<User> query() throws Exception{	       
		Connection con = DBUtil.getConnection();	        
		Statement stmt = con.createStatement();	       
		ResultSet rs = stmt.executeQuery("select user,passwd from tb_user");	      
		List<User> userList = new ArrayList<User>();	       
		User user = null;	     
		// 如果对象中有数据，就会循环打印出来
		while (rs.next()){	           
			user = new User();	           
			user.setUser(rs.getString("user"));	       
			user.setPasswd(rs.getString("passwd"));
			userList.add(user);	        
		}	       
		return userList;	  
	}
	

	/**
	 * '测试，是否可以得到用户表各数据段信息
	 */
    public static void main(String[] args) throws Exception {
        UserDao userDao = new UserDao();
        List<User> userList=userDao.query();
        for (User goddess : userList) {
            System.out.println(goddess.getUser()+","+goddess.getPasswd());
        }
    }
	
}
