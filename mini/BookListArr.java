package project1st;

import java.util.ArrayList;

public class BookListArr {
	private ArrayList<BookVo> data;

	// Jtable ��ü ���
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

	// Jtable ���� �˻� �� ���
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

	// Jtable ���� �˻� �� ���
	public Object[][] returnTitle(String id, String title) {
		BookDAO bd = new BookDAO();
		Object[][] list;

		data = bd.returnTitle(id, title);
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

	// ������ ���� - ��� ��ü ��ȸ
	public Object[][] adminAll() {
		BookDAO bd = new BookDAO();
		Object[][] list;

		data = bd.AllList();
		list = new Object[data.size()][7];

		System.out.println(data);

		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 7; j++) {
				list[i][j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getGenre();
				list[i][++j] = data.get(i).getPublication_date();
				list[i][++j] = data.get(i).getPurchase_date();
				list[i][++j] = data.get(i).getAmount();
			}
		}
		return list;

	}

	// ������ ��������- ���� �˻� �� ���
	public Object[][] adminTitle(String title) {
		BookDAO bd = new BookDAO();
		Object[][] list;

		data = bd.Allselect(title);
		list = new Object[data.size()][7];

		System.out.println(data);

		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 7; j++) {
				list[i][j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getGenre();
				list[i][++j] = data.get(i).getPublication_date();
				list[i][++j] = data.get(i).getPurchase_date();
				list[i][++j] = data.get(i).getAmount();
			}
		}
		return list;

	}

	// ������ ���� ���� ����- ��ü ��� ��ȸ
	public Object[][] adminReturnAll(int combo) {
		BookDAO bd = new BookDAO();
		Object[][] list;
		System.out.println(combo);
		data = bd.adRetunAll(combo);
		list = new Object[data.size()][7];

		System.out.println(data);

		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 7; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getCheckout_date();
				list[i][++j] = data.get(i).getReturn_date();
				if (data.get(i).getLate() == 0) {

					list[i][++j] = "";
				} else {
					list[i][++j] = data.get(i).getLate()+"��";
				}
			}
		}
		return list;
	}

//	public Object[][] adminReturnSearch(String combo) {
//		BookDAO bd = new BookDAO();
//		Object[][] list;
//
//		data = bd.returnTitle(combo);
//		list = new Object[data.size()][6];
//
//		System.out.println(data);
//
//		for (int i = 0; i < data.size(); i++) {
//			for (int j = 0; j < 6; j++) {
//				list[i][j] = data.get(i).getId();
//				list[i][++j] = data.get(i).getTitle();
//				list[i][++j] = data.get(i).getAuthor();
//				list[i][++j] = data.get(i).getPublisher();
//				list[i][++j] = data.get(i).getCheckout_date();
//				list[i][++j] = data.get(i).getReturn_date();
//			}
//		}
//		return list;
//	}

	// ������ ���� ���� ���� - ��� Ŭ�� �� ���� ������ ���� ǥ��
	public Object[][] adminReturnSelect(String id, String name) {
		BookDAO bd = new BookDAO();
		Object[][] list;

		data = bd.returnTitle(id, name);
		list = new Object[data.size()][7];

		System.out.println(data);

		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 7; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getCheckout_date();
				list[i][++j] = data.get(i).getReturn_date();
//				if (data.get(i).getLate() == 0) {
//
//					list[i][++j] = "";
//				} else {
					list[i][++j] = data.get(i).getLate();
//				}
			}
		}
		return list;
	}
	//������ ���� ���� ��� - ���̵� �˻�
	public Object[][] adminReturnidSelect(String id) {
		BookDAO bd = new BookDAO();
		Object[][] list;
		
		data = bd.adreturnid(id);
		list = new Object[data.size()][7];
		
		System.out.println(data);
		
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 7; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getCheckout_date();
				list[i][++j] = data.get(i).getReturn_date();
//				if (data.get(i).getLate() == 0) {
//
//					list[i][++j] = "";
//				} else {
				list[i][++j] = data.get(i).getLate();
//				}
			}
		}
		return list;
	}
	//������ ���� ���� ��� - ���� ���� �˻�
	public Object[][] adminReturntitleSelect(String title) {
		BookDAO bd = new BookDAO();
		Object[][] list;
		
		data = bd.adreturnTitle(title);
		list = new Object[data.size()][7];
		
		System.out.println(data);
		
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 7; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getCheckout_date();
				list[i][++j] = data.get(i).getReturn_date();
//				if (data.get(i).getLate() == 0) {
//
//					list[i][++j] = "";
//				} else {
				list[i][++j] = data.get(i).getLate();
//				}
			}
		}
		return list;
	}
	
	public Object[][] adminReturnLate() {
		BookDAO bd = new BookDAO();
		Object[][] list;
		
		data = bd.adReturnLate();
		list = new Object[data.size()][7];
		
		System.out.println(data);
		
		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 7; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getTitle();
				list[i][++j] = data.get(i).getAuthor();
				list[i][++j] = data.get(i).getPublisher();
				list[i][++j] = data.get(i).getCheckout_date();
				list[i][++j] = data.get(i).getReturn_date();
//				if (data.get(i).getLate() == 0) {
//
//					list[i][++j] = "";
//				} else {
				list[i][++j] = data.get(i).getLate()+"��";
//				}
			}
		}
		return list;
	}

}
