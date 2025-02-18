package test;

import java.sql.Connection;

import database.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
//		System.out.println(connection);
		
		JDBCUtil.printInfo(connection);
		
		JDBCUtil.closeConnection(connection);
		
//		JDBCUtil.printInfo(connection);
	}
	
}