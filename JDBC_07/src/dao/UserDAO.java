package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.User;

public class UserDAO implements DAOInterface<User>{

	public static UserDAO getInstance() {
		return new UserDAO();
	}
	
	@Override
	public int insert(User t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "INSERT INTO User (username, password, hovaten) "+
					" VALUES (?,?,?)";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUsername());
			st.setString(2, t.getPassword());
			st.setString(3, t.getHovaten());
			
			ketQua = st.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int update(User t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "UPDATE User "+
					 " SET " +
					 " password=?"+
					 ", hovaten=?"+
					 " WHERE username=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getPassword());
			st.setString(2, t.getHovaten());
			st.setString(3, t.getUsername());

			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public int delete(User t) {
		int ketQua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "DELETE from User "+
					 " WHERE username=?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUsername());
			
			System.out.println(sql);
			ketQua = st.executeUpdate();
			
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public ArrayList selectAll() {
		ArrayList ketQua = new ArrayList();
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM user";
			PreparedStatement st = con.prepareStatement(sql);
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hovaten = rs.getString("hovaten");
				
				User User = new User(username, password, hovaten);
				ketQua.add(User);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public User selectById(User t) {
		User ketQua = null;
		try {
			Connection con = JDBCUtil.getConnection();
			
			String sql = "SELECT * FROM User where username=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, t.getUsername());
			
			System.out.println(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String hovaten = rs.getString("hovaten");
				
				ketQua = new User(username, password, hovaten);
				
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

	@Override
	public ArrayList selectByCondition(String condition) {
		ArrayList ketQua = new ArrayList();
	
		return ketQua;
	}

}