package Codetest.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Codetest.Model.LoginBean;
import Codetest.Model.UserBean;

public class UserRepository {

	public int insertUser(UserBean bean) {
		int i = 0;
		Connection con = MyConnection.getConnection();
		String sql = "insert into users(name,email,password,role) values ( ?,?,?,?)";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getEmail());
			ps.setString(3, bean.getPassword());
			ps.setString(4, bean.getRole());
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("Insert user is error.");
		}
		return i;
	}
	
	public boolean checkEmail(String email) {
		boolean check = false;
		Connection con = MyConnection.getConnection();
		String sql = "SELECT * FROM users WHERE email =?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				check = true;
			}
			System.out.println("Check email is success");
		} catch (Exception e) {
			System.out.println("Check email is not success "+ e.getMessage());
		}
		return check;
	}
	
	public UserBean loginUser(LoginBean bean) {
		UserBean user = null;
		Connection con = MyConnection.getConnection();
		String sql = "select * from users where email =? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, bean.getEmail());
			ps.setString(2, bean.getPassword());
			
			ResultSet rs = ps.executeQuery();
			System.out.println("Login is success");
			while(rs.next()) {
				user = new UserBean();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			System.out.println("login user error : " + e.getMessage());
		}
		return user;
	}
}
