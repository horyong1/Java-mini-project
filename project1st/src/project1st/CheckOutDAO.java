package project1st;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckOutDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "C##green";
	String password = "green1234";

	private Connection con;
	private PreparedStatement  pstmt;
	private ResultSet rs;
	
	//대출 목록 추가
	public int insertCheckout(CheckOutVo vo) {

		int result = 0;
//		pstmt = null;
//		rs = null;
		
		try {
			connDB();
		
			String query;

			query = "insert into checkout(id, title,checkout_date,return_date)";
			query += " values(?,?,?,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getTitle());
			pstmt.setString(3, vo.getCheckout_date());
			pstmt.setString(4, vo.getReturn_date());
							
			
			result = pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	
	
	
	
	//대출 목록 확인
		public int titleCheck(String title) {
			int result = 0;
			String query;
			
			try {
				con = null;
				pstmt = null;
				rs = null;
				connDB();

				query = "select title FROM checkout ";
				query += "where title = ? ";
				pstmt = con.prepareStatement(query);

				pstmt.setString(1, title);
				
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) { 
				CheckOutVo cov  = new CheckOutVo();
				String bookname = rs.getString("title");
				cov.setId(bookname);
				
				result = pstmt.executeUpdate();
				}
				
				rs.close();
				

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		

	
	
	
	public void connDB() {
		try {

			Class.forName(driver);
			//System.out.println("jdbc.driver loading success");

			con = DriverManager.getConnection(url, user, password);
			//System.out.println("oracle connection sucess.");

			pstmt = con.prepareStatement(driver);
			//System.out.println("statement create success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
