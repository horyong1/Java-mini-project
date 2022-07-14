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

	private Connection con;
	private Statement stmt;
	private ResultSet rs;
	private PreparedStatement pstmt;
	private PreparedStatement pstmtAdd = null;
	private PreparedStatement pstmtDel = null;
	private PreparedStatement pstmtUpdate = null;

	private Vector title = null;
	private Vector data;
	
	//1.관리자 insert 도서 신규 등록
	public int insertData(BookVo vo) {

		int result = 0;
		
		try {
			connDB();
		
			String query;

			query = "insert into Book_list(title, author, publisher, genre, publication_date, purchase_date,amount)";
			query += " values(?,?,?,?,?,?,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getAuthor());
			pstmt.setString(3, vo.getPublisher());
			pstmt.setString(4, vo.getGenre());
			pstmt.setString(5, vo.getPublication_date());
			pstmt.setString(6, vo.getPurchase_date());
			pstmt.setString(7, vo.getAmount());
			
			
			
			result = pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}
	//2.관리자 update 도서 수정 
	public int updateData(BookVo vo) {
		int result = 0;
		String query;
		
		try {
			
			connDB();
			query = "update Book_list set title=?, author=?, publisher=?, "
					+ "genre=?, publication_date=?, purchase_date=?, amount=? "
					+ "where title=?";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getAuthor());
			pstmt.setString(3, vo.getPublisher());
			pstmt.setString(4, vo.getGenre());
			pstmt.setString(5, vo.getPublication_date());
			pstmt.setString(6, vo.getPurchase_date());
			pstmt.setString(7, vo.getAmount());
			pstmt.setString(8, vo.getChtitle());
			
			result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public int deleteBook(String title) {
		int result = 0;
		String query;
		try {
			connDB();

			query = "delete Book_list where title=?";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, title);



			result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	

	
	//3. 관리자 모든 책 리스트 조회
	public ArrayList<BookVo> AllList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		
		String query;
		
		try {
			connDB();
			query = "select * from book_list order by title";
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String genre = rs.getString("genre");
				String publication_date = rs.getString("publication_date");
				String purchase_date = rs.getString("purchase_date");
				String amount = rs.getString("amount");
			


				list.add(new BookVo(title,author,publisher,genre,publication_date, purchase_date, amount));
			}
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; 
	}
	
	//4. 관리자 책 제목으로 검색
	public ArrayList<BookVo> Allselect(String title){
		ArrayList<BookVo> titlelist = new ArrayList<BookVo>();
		String query;
		
		
		try {
			
			query = "select * from book_list ";
			query += "where title like "+"'"+"%"+title+"%"+"'"+" order by title";
			System.out.println(query);
			
//			pstmt=conn.prepareStatement(query);
//			
//			pstmt.setString(1, title);
			con = DriverManager.getConnection(url, user, password);
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			
			while(rs.next()) {
				String title1 = rs.getString("title");
				String author = rs.getString("author");
				String publisher = rs.getString("publisher");
				String genre = rs.getString("genre");
				String publication_date = rs.getString("publication_date");
				String purchase_date = rs.getString("purchase_date");
				String amount = rs.getString("amount");
				
				titlelist.add(new BookVo(title1,author,publisher,genre,publication_date, purchase_date, amount));
			}
			rs.close();
			stmt.close();
			con.close();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titlelist;
	}
	
	
	
	
	//5.회원 제목, 저자, 출판사,장르, 출판일 목록 조회 ok
	public ArrayList<BookVo> selectAll() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		
		String query;
		
		try {
			connDB();
			query = "select title,author,publisher,genre,publication_date from book_list order by title";
			pstmt = con.prepareStatement(query);
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
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list; 
	}
	
	//6. 회원 도서 제목 검색
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
			con = DriverManager.getConnection(url, user, password);
			stmt=con.createStatement();
			rs= stmt.executeQuery(query);
			
			while(rs.next()) {
				String title1=rs.getString("title");
				String author=rs.getString("author");
				String publisher=rs.getString("publisher");
				String genre=rs.getString("genre");
				String publication_date=rs.getString("publication_date");
				
				titlelist.add(new BookVo(title1,author,publisher,genre,publication_date));
			}
			rs.close();
			stmt.close();
			con.close();
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return titlelist;
	}
	
	//7. 회원 대출 리스트 delete 삭제
		public int deleteData(String id, String title) {
			int result = 0;
			String query;
			try {
				connDB();

				query = "delete checkout where id=? and title=?";
				pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, id);
				pstmt.setString(2, title);



				result = pstmt.executeUpdate();
				
				pstmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		
		
		//8. 회원 도서 반납 목록
		public ArrayList<BookVo> retunAll(String Id) {
			ArrayList<BookVo> list = new ArrayList<BookVo>();
			
			String query;
			
			try {
				connDB();
				query = "SELECT MEMBERDATA.id, book_list.title, book_list.author, book_list.publisher, "
						+ "CHECKOUT.CHECKOUT_DATE, CHECKOUT.RETURN_DATE FROM book_list, CHECKOUT, MEMBERDATA "
						+ "WHERE MEMBERDATA.id= ? and  "
						+ "MEMBERDATA.ID = CHECKOUT.ID AND book_list.TITLE = checkout.title "
						+ "ORDER BY TITLE";
				pstmt = con.prepareStatement(query);
				
				pstmt.setString(1, Id);
				
				
				rs = pstmt.executeQuery();
				while(rs.next()) {
					String id=rs.getString("id");
					String title=rs.getString("title");
					String author=rs.getString("author");
					String publisher=rs.getString("publisher");
					String checkout_date=rs.getString("CHECKOUT_DATE");
					String return_date=rs.getString("RETURN_DATE");
					
//					System.out.println(title+" "+author+" "
//							+publisher+" "+genre+" "+publication_date);
					
					list.add(new BookVo(id,title,author,publisher,checkout_date,return_date));
				}
				rs.close();
				pstmt.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list; 
		}
		
		//9. 회원 도서 반납 도서 제목으로 검색
		public ArrayList<BookVo> returnTitle(String Id,String Title){
			ArrayList<BookVo> titlelist = new ArrayList<BookVo>();
			String query;
			
			
			try {
				connDB();
				query = "SELECT MEMBERDATA.id, book_list.title, book_list.author, book_list.publisher, "
						+ "CHECKOUT.CHECKOUT_DATE, CHECKOUT.RETURN_DATE FROM book_list, CHECKOUT, MEMBERDATA "
						+ "WHERE MEMBERDATA.id="+"'"+Id+"' and book_list.title like "+"'%"+Title+"%' and "
						+ "MEMBERDATA.ID = CHECKOUT.ID AND book_list.TITLE = checkout.title "
						+ "ORDER BY 2";
				

				con = DriverManager.getConnection(url, user, password);
				stmt=con.createStatement();
				rs= stmt.executeQuery(query);

				while(rs.next()) {
					String id=rs.getString("id");
					String title=rs.getString("title");
					String author=rs.getString("author");
					String publisher=rs.getString("publisher");
					String checkout_date=rs.getString("CHECKOUT_DATE");
					String return_date=rs.getString("RETURN_DATE");
					
					titlelist.add(new BookVo(id,title,author,publisher,checkout_date,return_date));
				}
				
				rs.close();
				pstmt.close();
				con.close();
				
			
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

			con = DriverManager.getConnection(url, user, password);
			// System.out.println("oracle connection sucess.");

			pstmt = con.prepareStatement(driver);
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
