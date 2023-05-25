package boardmake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Vector;

public class BoardDDL {
	// AllSelect
	public static int getAllSelect() {

		int allCount = 0;
		String sql = "select count(*) from bbs";

		try (Connection conn = new DBConnect().getConn();
				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery(sql)) {
			while (rs.next()) {
				allCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return allCount;
	}

	// select1 -freeboard
	public static Vector<BoardDTO> getSelect1() {

		String sql = "SELECT * FROM bbs WHERE bbsnum = 1";

		Vector<BoardDTO> data = new Vector<>();

		try (Connection conn = new DBConnect().getConn();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

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
			System.out.println("자유게시판입력 중 예외 발생");
			e.printStackTrace();
		}
		return data;
	}

	// select0 -notice
	public static Vector<BoardDTO> getSelect0() {

		String sql = "SELECT * FROM bbs WHERE bbsnum = 0";

		Vector<BoardDTO> data = new Vector<>();
		try (Connection conn = new DBConnect().getConn();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

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
			System.out.println("공지입력 중 예외 발생");
			e.printStackTrace();
		}
		return data;
	}

	// 글쓰기 DB에 추가.
	public int insertWrite(BoardDTO dto) {

		int result = 0;
		String query = "INSERT INTO bbs (bbsnum, userid, userpass, username, useremail, wdate, uip, count, title, content) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = new DBConnect().getConn();
				// INSERT 쿼리문 작성
				PreparedStatement pstmt = conn.prepareStatement(query)) {
			pstmt.setInt(1, dto.getBbsnum());
			pstmt.setString(2, dto.getUserid());
			pstmt.setString(3, dto.getUserpass());
			pstmt.setString(4, dto.getUsername());
			pstmt.setString(5, dto.getUseremail());
			pstmt.setTimestamp(6, dto.getWdate() != null ? Timestamp.valueOf(dto.getWdate())
					: Timestamp.valueOf(LocalDateTime.now()));
			pstmt.setString(7, dto.getUip());
			pstmt.setInt(8, dto.getCount());
			pstmt.setString(9, dto.getTitle());
			pstmt.setString(10, dto.getContent());

			result = pstmt.executeUpdate(); // INSERT 쿼리 실행
		} catch (Exception e) {
			System.out.println("게시물 입력 중 예외 발생");
			e.printStackTrace();
		}
		return result;
	}

	// 글누르면 상세보기
	public BoardDTO selectView(String num) {
		BoardDTO dto = null;

		String query = "SELECT * FROM bbs WHERE num = ?";

		try (Connection conn = new DBConnect().getConn(); PreparedStatement psmt = conn.prepareStatement(query)) {
			psmt.setString(1, num); // Set parameter as num

			try (ResultSet rs = psmt.executeQuery()) {
				// 결과 처리

				if (rs.next()) {
					dto = new BoardDTO();
					dto.setNum(rs.getInt("num"));
					dto.setBbsnum(rs.getInt("bbsnum"));
					dto.setUserid(rs.getString("userid"));
					dto.setUserpass(rs.getString("userpass"));
					dto.setUsername(rs.getString("username"));
					dto.setUseremail(rs.getString("useremail"));
					dto.setWdate(rs.getTimestamp("wdate").toLocalDateTime());
					dto.setUip(rs.getString("uip"));
					dto.setCount(rs.getInt("count"));
					dto.setTitle(rs.getString("title"));
					dto.setContent(rs.getString("content"));
				}
			}

		} catch (Exception e) {
			System.out.println("게시물 보기 중 예외 발생");
			e.printStackTrace();
		}

		return dto;

	}

	// 지정한 게시물의 조회수를 1 증가시킵니다.
	public void updateVisitCount(String num) {
		// 쿼리문 준비
		String query = "UPDATE bbs SET count=count+1 WHERE num=?";

		try (Connection conn = new DBConnect().getConn(); PreparedStatement psmt = conn.prepareStatement(query)) {
			psmt.setString(1, num); // 인파라미터를 일련번호로 설정

			int updatedRows = psmt.executeUpdate();
			if (updatedRows > 0) {
				// count가 성공적으로 증가되었을 때의 추가 로직을 처리할 수 있습니다.
			} else {
				System.out.println("count가 증가되지 않았습니다.");
			}
		} catch (Exception e) {
			System.out.println("count 증가 중 예외 발생");
			e.printStackTrace();
		}
	}

	// 게시물 수정
	public int updateEdit(BoardDTO dto) {
		int result = 0;
		String query = "UPDATE bbs SET title=?, content=? WHERE num=?";

		try (Connection conn = new DBConnect().getConn(); PreparedStatement psmt = conn.prepareStatement(query)) {

			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getContent());
			psmt.setInt(3, dto.getNum());

			// 쿼리문 실행
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외 발생");
			e.printStackTrace();
		}

		return result; // 결과 반환
	}

	// 게시물 삭제
	public int deletePost(BoardDTO dto) {
		int result = 0;
		String query = "DELETE FROM bbs WHERE num=?";
		try (Connection conn = new DBConnect().getConn(); PreparedStatement psmt = conn.prepareStatement(query)) {

			psmt.setInt(1, dto.getNum());
			// 쿼리문 실행
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 삭제 중 예외 발생");
			e.printStackTrace();
		}
		return result;

	}

}
