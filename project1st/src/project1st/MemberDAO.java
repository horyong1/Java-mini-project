package project1st;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "C##green";
	String password = "green1234";

	private Connection con;
	private PreparedStatement  pstmt;
	private ResultSet rs;

	// 1. insert ok
	public int insertData(MemberVo vo) {

		int result = 0;
//		pstmt = null;
//		rs = null;
		
		try {
			connDB();
		
			String query;

			query = "insert into MEMBERDATA(id, pwd, name,tel,email,birth,gender)";
			query += " values(?,?,?,?,?,?,?)";
			System.out.println(query);
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getTel());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getBirth());
			pstmt.setString(7, vo.getGender());
			
			
			
			result = pstmt.executeUpdate();

			pstmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	// 2.update
	public int updateData(MemberVo vo) {
		int result = 0;
		String query;

		try {
			
			query = "update MEMBERDATA set pwd=?, tel=?,email=?";
			query += "where id=?";

			pstmt = con.prepareStatement(query);

			pstmt.setString(1, vo.getPwd());
			pstmt.setString(2, vo.getTel());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 3.delete ok
	public int deleteData(String id, String pw) {
		int result = 0;
		String query;
		try {
			connDB();

			query = "delete MEMBERDATA where id=? and pwd=?";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);



			result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// 4.selectAll

	public List<MemberVo> getList() {
		List<MemberVo> list = new ArrayList<MemberVo>();
		String query;

		try {
			
			query = "selet * from MEMBERDATA order by name";

			pstmt = con.prepareStatement(query);
			
			
			rs = pstmt.executeQuery();

			while (rs.next()) {

				MemberVo mbo = new MemberVo();

				mbo.setId(rs.getString("id"));
				mbo.setPwd(rs.getString("pwd"));
				mbo.setName(rs.getString("name"));
				mbo.setTel(rs.getString("tel"));
				mbo.setEmail(rs.getString("email"));
				mbo.setBirth(rs.getString("birth"));
				mbo.setGender(rs.getString("gender"));

				list.add(mbo);

			}

			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 5.searchId
	public List<MemberVo> getList(String id) {

		List<MemberVo> lists = new ArrayList<MemberVo>();
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
	//6. Login result 값 1로 반환하여 출력 ok
	public int LoginData(String id,String pwd) {
		int result = 0;
		String query;
		
		try {
			con = null;
			pstmt = null;
			rs = null;
			connDB();

			query = "select ID, PWD FROM MEMBERDATA ";
			query += "where ID= ? AND PWD= ?";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
			MemberVo mbv = new MemberVo();
			String id1 = rs.getString("id");
			String pwd1 = rs.getString("pwd");
			mbv.setId(id1);
			mbv.setPwd(pwd1);
			}
			
			result = pstmt.executeUpdate();
			rs.close();
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	//아이디 중복 체크 ok
	public int idCheck(String id) {
		int result = 0;
		String query;
		
		try {
			con = null;
			pstmt = null;
			rs = null;
			connDB();

			query = "select ID FROM MEMBERDATA ";
			query += "where ID= ? ";
			pstmt = con.prepareStatement(query);

			pstmt.setString(1, id);
			
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { 
			MemberVo mbv = new MemberVo();
			String id1 = rs.getString("id");
			mbv.setId(id1);
			
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
