package project1st;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "C##green";
	String password = "green1234";

	private Connection con;
	private PreparedStatement  pstmt;
	private ResultSet rs;
	
	public List<BookVo> getList(String id) {

		List<BookVo> lists = new ArrayList<BookVo>();
		String query;

		try {
			
			query = "select * from MEMBERDATA";
			query = "where id =?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVo mbv = new MemberVo();

				mbv.setId(rs.getString("id"));
				mbv.setPwd(rs.getString("pwd"));
				mbv.setName(rs.getString("name"));
				mbv.setTel(rs.getString("tel"));
				mbv.setEmail(rs.getString("email"));
				mbv.setBirth(rs.getString("birth"));
				mbv.setGender(rs.getString("gender"));
                  
				lists.add(mbv);
			}
			
			rs.close();
			pstmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lists;

	}
	
}
