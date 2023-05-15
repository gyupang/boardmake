package boardmake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardDDL {
	public static void main(String[] args) {
		DBConnect dbConnect = new DBConnect();
		Connection conn = dbConnect.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String query = "SELECT * FROM bbs";
			pstmt = conn.prepareStatement(query);

			rs = pstmt.executeQuery(query);

			// 데이터 출력
			while (rs.next()) {
				int bbsnum = rs.getInt("bbsnum");
				String userid = rs.getString("userid");
				String userpass = rs.getString("userpass");
				String username = rs.getString("username");
				String useremail = rs.getString("useremail");
				String uip = rs.getString("uip");
				int count = rs.getInt("count");
				String title = rs.getString("title");
				String content = rs.getString("content");

				// 출력 또는 처리할 작업 수행
				System.out.println("bbsnum: " + bbsnum);
				System.out.println("userid: " + userid);
				System.out.println("userpass: " + userpass);
				System.out.println("username: " + username);
				System.out.println("useremail: " + useremail);
				System.out.println("uip: " + uip);
				System.out.println("count: " + count);
				System.out.println("title: " + title);
				System.out.println("content: " + content);
				System.out.println("-------------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 리소스 정리
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
