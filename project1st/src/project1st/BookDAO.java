package project1st;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "C##green";
	String password = "green1234";

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	
	//search all
	public ArrayList<BookVo> getList() {
		ArrayList<BookVo> list = new ArrayList<BookVo>();
		String query;

		try {
			connDB();
			
			
			query = "select title, author, publisher,Publication_date, purchase_date";
			query +=" from Book_list order by title";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				BookVo bv = new BookVo();
				
				
				bv.setTitle(rs.getString("title"));
				bv.setAuthor(rs.getString("author"));
				bv.setPublisher(rs.getString("publisher"));
				bv.setPublication_date(rs.getString("Publication_date"));
				bv.setPurchase_date(rs.getString("purchase_date"));
				
				


				list.add(bv);
				System.out.println(list);
				
			}

			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	} 
	
	
	
	
	//search title
	public List<BookVo> getList(String title) {

		List<BookVo> lists = new ArrayList<BookVo>();
		String query;

		try {

			query = "select * from MEMBERDATA";
			query = "where title =?";

			pstmt = con.prepareStatement(query);
			pstmt.setString(1, title);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				BookVo bv = new BookVo();

				bv.setBook_id(rs.getInt("book_id"));
				bv.setTitle(rs.getString("title"));
				bv.setAuthor(rs.getString("author"));
				bv.setGendre(rs.getString("publisher"));
				bv.setPublication_date(rs.getString("setPublication_date"));
				bv.setPurchase_date(rs.getString("purchase_date"));
				bv.setAmount(rs.getInt("amount"));

				lists.add(bv);
			}

			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lists;

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
