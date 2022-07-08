package project1st;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class BookDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "C##green";
	String password = "green1234";

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private PreparedStatement pstmtAdd = null;
	private PreparedStatement pstmtDel = null;
	private PreparedStatement pstmtUpdate = null;

	private Vector title = null;
	private Vector data;
	
	//전체 목록 조회 ok
	public ArrayList<BookVo> selectAll() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		
		String query;
		
		try {
			connDB();
			query = "select title,author,publisher,genre,publication_date from book_list order by title";
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String title=rs.getString("title");
				String author=rs.getString("author");
				String publisher=rs.getString("publisher");
				String genre=rs.getString("genre");
				String publication_date=rs.getString("publication_date");
			
//				System.out.println(title+" "+author+" "
//						+publisher+" "+genre+" "+publication_date);

				list.add(new BookVo(title,author,publisher,genre,publication_date));
			}
			rs.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; 
	}
	
	//도서 제목 검색
	public ArrayList<BookVo> selectTitle(String title){
		ArrayList<BookVo> titlelist = new ArrayList<BookVo>();
		String query;
		
		
		try {
			
			query = "select title,author,publisher,genre,publication_date from book_list ";
			query += "where title like "+"'"+"%"+title+"%"+"'"+" order by title";
			System.out.println(query);
			
//			pstmt=conn.prepareStatement(query);
//			
//			pstmt.setString(1, title);
			conn = DriverManager.getConnection(url, user, password);
			stmt=conn.createStatement();
			rs= stmt.executeQuery(query);
			
			while(rs.next()) {
				String title1=rs.getString("title");
				String author=rs.getString("author");
				String publisher=rs.getString("publisher");
				String genre=rs.getString("genre");
				String publication_date=rs.getString("publication_date");
				
				titlelist.add(new BookVo(title1,author,publisher,genre,publication_date));
			}
			conn.close();
			stmt.close();
			rs.close();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titlelist;
	}

	

	public void connDB() {
		try {

			Class.forName(driver);
			// System.out.println("jdbc.driver loading success");

			conn = DriverManager.getConnection(url, user, password);
			// System.out.println("oracle connection sucess.");

			pstmt = conn.prepareStatement(driver);
			// System.out.println("statement create success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}




}
