package boardmake;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	/*
	 * private final String url =
	 * "jdbc:mysql://localhost/myboard?useUnicode=true&characterEncoding=UTF-8";
	 * private final String uid = "root"; private final String pass = "1234";
	 * private final String driver = "com.mysql.cj.jdbc.Driver";
	 * 
	 * private Connection conn = null;
	 * 
	 * public DBConnect() { try { conn = DriverManager.getConnection(url, uid,
	 * pass); Class.forName(driver); } catch (Exception e) { e.printStackTrace(); }
	 * }
	 * 
	 * // 메소드 public Connection getConn() {
	 * 
	 * return conn; }
	 */

	private static String uid = "root";
	private static String pass = "1234";
	private static String url = "jdbc:mysql://localhost:3306/myboard";
	private static String opt = "useUnicode=true&characterEncoding=UTF-8";
	static {
		url = url + "?" + opt;
	}

	public static Connection initConnection() {

		Connection conn = null;
		try {
			// JDBC 클래스를 찾는다.
			Class.forName("com.mysql.cj.jdbc.Driver");

			// DB연결
			conn = DriverManager.getConnection(url, uid, pass);
			System.out.println("접속 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
