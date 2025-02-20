package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.KhachHang;
import model.Sach;

public class KhachHangDAO implements DAOInterface<KhachHang>{

	public static KhachHangDAO getInstance() {
		return new KhachHangDAO();
	}
	
	@Override
	public int insert(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(KhachHang t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<KhachHang> selectAll() {
		ArrayList<KhachHang> ketQua = new ArrayList<KhachHang>();
		try {
			Connection con = JDBCUtil.getConnection();
			
			Statement st = con.createStatement();
			
			
			String sql = "SELECT * FROM khachHang";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String hoVaTen = rs.getString("hoVaTen");
				Date ngaySinh = rs.getDate("ngaySinh");
				String diaChi = rs.getString("diaChi");
				
				KhachHang kh = new KhachHang(id, hoVaTen, ngaySinh, diaChi);
				ketQua.add(kh);
			}
			
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

	@Override
	public KhachHang selectById(KhachHang t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}