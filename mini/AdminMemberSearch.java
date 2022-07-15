package project1st;

import java.util.ArrayList;

public class AdminMemberSearch {
	private ArrayList<MemberVo> data;
	//회원 패스워드 제외 전체 목록
	public Object [][] memberAll(){
		MemberDAO md = new MemberDAO();
		Object[][] list;
		
		data = md.memberAllList();
		list = new Object[data.size()][6];
		
		for(int i = 0; i<data.size(); i++) {
			for(int j = 0; j < 6; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getName();
				list[i][++j] = data.get(i).getBirth();
				list[i][++j] = data.get(i).getTel();
				list[i][++j] = data.get(i).getEmail();
				list[i][++j] = data.get(i).getGender();
				
			}
		}
		return list;
	}
	//회원 패스워드 포함 목록
	public Object [][] memberidSelect(String id){
		MemberDAO md = new MemberDAO();
		Object[][] list;
		
		data = md.adSelectID(id);
		list = new Object[data.size()][7];
		
		for(int i = 0; i<data.size(); i++) {
			for(int j = 0; j < 7; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getPwd();
				list[i][++j] = data.get(i).getName();
				list[i][++j] = data.get(i).getBirth();
				list[i][++j] = data.get(i).getTel();
				list[i][++j] = data.get(i).getEmail();
				list[i][++j] = data.get(i).getGender();
				
			}
		}
		return list;
	}
	
	public Object[][]idSelect(String id){
		MemberDAO md = new MemberDAO();
		Object[][] list;
		
		data = md.getIdList(id);
		list = new Object[data.size()][6];
		
		for(int i = 0; i<data.size(); i++) {
			for(int j = 0; j < 6; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getName();
				list[i][++j] = data.get(i).getBirth();
				list[i][++j] = data.get(i).getTel();
				list[i][++j] = data.get(i).getEmail();
				list[i][++j] = data.get(i).getGender();
				
				
			}
		}
		
		return list;
		
	}
	
	public Object[][]nameSelect(String name){
		MemberDAO md = new MemberDAO();
		Object[][] list;
		
		data = md.getnameList(name);
		list = new Object[data.size()][6];
		
		for(int i = 0; i<data.size(); i++) {
			for(int j = 0; j <6; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getName();
				list[i][++j] = data.get(i).getBirth();
				list[i][++j] = data.get(i).getTel();
				list[i][++j] = data.get(i).getEmail();
				list[i][++j] = data.get(i).getGender();
				
				
			}
		}
		
		return list;
		
	}
	
	
}
