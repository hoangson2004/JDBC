package test;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import database.JDBCUtil;



public class TestJDBCUtil {
	public static void main(String[] args) {
		try {
			Connection connection = JDBCUtil.getConnection();
			
			Statement st = connection.createStatement();

			String sql = "INSERT INTO persons(last_name, first_name, gender, dob, income)"
					+ "VALUES (\"Tran\", \"Thi\", \"C\", \"2000-09-10\", 10000000)";
			
			int check = st.executeUpdate(sql);
			
			System.out.println("Changed line: " + check);
			
			if (check>0) {
				System.out.println("Insert data successfully");
			} else {
				System.out.println("Error");
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}