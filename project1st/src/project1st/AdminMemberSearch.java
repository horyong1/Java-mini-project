package project1st;

import java.util.ArrayList;

public class AdminMemberSearch {
	private ArrayList<MemberVo> data;
	
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
	
	public Object[][]idSelect(String id){
		MemberDAO md = new MemberDAO();
		Object[][] list;
		
		data = md.getIdLis(id);
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
		
		data = md.getIdLis(name);
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
		
		return null;
		
	}
	
	
}
