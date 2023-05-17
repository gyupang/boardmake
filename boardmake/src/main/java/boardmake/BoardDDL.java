package boardmake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;

public class BoardDDL {
	// AllSelect
	public static int getAllSelect() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = null;
		int allCount = 0;
		sql = "select count(*) from bbs";

		try {

			conn = new DBConnect().getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				allCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}

		return allCount;
	}

	// select
	public static Vector<BoardDTO> getSelect() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		sql = "select * from bbs";
		Vector<BoardDTO> data = new Vector<>();
		conn = new DBConnect().getConn();
		try {

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

				while (rs.next()) {
					BoardDTO mb = new BoardDTO();
					mb.setNum(rs.getInt("num"));
					mb.setBbsnum(rs.getInt("bbsnum"));
					mb.setUserid(rs.getString("userid"));
					mb.setUserpass(rs.getString("userpass"));
					mb.setUsername(rs.getString("username"));
					mb.setUseremail(rs.getString("useremail"));
					mb.setWdate(rs.getTimestamp("wdate").toLocalDateTime());
					mb.setUip(rs.getString("uip"));
					mb.setCount(rs.getInt("count"));
					mb.setTitle(rs.getString("title"));
					mb.setContent(rs.getString("content"));
					data.add(mb);
				}

		} catch (SQLException e) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
			}
		}
		return data;
	}

	// 글쓰기 DB에 추가.
	public int insertWrite(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = new DBConnect().getConn();
			// INSERT 쿼리문 작성
			String query = "INSERT INTO bbs (bbsnum, userid, userpass, username, useremail, wdate, uip, count, title, content) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, dto.getBbsnum());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getUserpass());
			pstmt.setString(4, dto.getUsername());
			pstmt.setString(5, dto.getUseremail());
			pstmt.setTimestamp(6, Timestamp.valueOf(dto.getWdate()));
			pstmt.setString(7, dto.getUip());
			pstmt.setInt(8, dto.getCount());
			pstmt.setString(9, dto.getTitle());
			pstmt.setString(10, dto.getContent());

			result = pstmt.executeUpdate(); // INSERT 쿼리 실행
		} catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		} finally {
			// 리소스 정리
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
		}

}
