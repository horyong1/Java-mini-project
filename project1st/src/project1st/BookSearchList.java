package project1st;

import java.util.ArrayList;

public class BookSearchList {
	private ArrayList<BookVo> data;
	
	//Jtable 전체 목록
	public Object[][] resultAll() {
		BookDAO bd = new BookDAO();
		Object[][] list;

		data = bd.selectAll();
		list = new Object[data.size()][5];

		System.out.println(data);

		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 5; j++) {
				list[i][j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getGenre();
				list[i][++j] = data.get(i).getPublication_date();
			}
		}
		return list;

	}
	//Jtable 제목 검색 후 목록
	public Object[][] resultTitle(String title) {
		BookDAO bd = new BookDAO();
		Object[][] list;
		
		data = bd.selectTitle(title);
		list = new Object[data.size()][5];

		System.out.println(data);

		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 5; j++) {
				list[i][j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getGenre();
				list[i][++j] = data.get(i).getPublication_date();
			}
		}
		return list;

	}
	
	public Object[][] returnAll(String id) {
		BookDAO bd = new BookDAO();
		Object[][] list;
		
		data = bd.retunAll(id);
		list = new Object[data.size()][6];
		
		System.out.println(data);
		
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 5; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getCheckout_date();
				list[i][++j] = data.get(i).getReturn_date();
			}
		}
		return list;
		
	}
	//Jtable 제목 검색 후 목록
	public Object[][] returntitle(String title) {
		BookDAO bd = new BookDAO();
		Object[][] list;
		
		data = bd.selectTitle(title);
		list = new Object[data.size()][5];
		
		System.out.println(data);
		
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 5; j++) {
				list[i][j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getGenre();
				list[i][++j] = data.get(i).getPublication_date();
			}
		}
		return list;
		
	}


}
