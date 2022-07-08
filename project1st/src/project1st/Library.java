package project1st;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;

public class Library extends JFrame {

	private JLabel lbsearch = null;
	private JLabel lbauthor = null;
	private JLabel lbpublisher = null;
	private JLabel lbgenre = null;
	private JLabel lbpublication_date = null;
	private JTextField tftitle = null;
	private JTextField tfauthor = null;
	private JTextField tfpublisher = null;
	private JTextField tfgenre = null;
	private JTextField tfpublication_date = null;
	private Button btnsearch;
	private JFrame frame;
	private JPanel panel;
	private JScrollPane sp;
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<BookVo> data;

	private static final long serialVersionUID = 1L;
	private JTextField tfsearch;
	private String title;
	private Object[][] result;
	String jtitle;
	public Library() {

	}

	public void booksearchGui() {

		Dimension dim = new Dimension(800, 650);
		frame = new JFrame("도서관 관리 프로그램");
		BookDAO bd = new BookDAO();

		frame.setLocation(200, 200);
		frame.setPreferredSize(dim);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 69, 784, 453);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

		tfsearch = new JTextField();
		tfsearch.setBounds(80, 31, 147, 21);
		frame.getContentPane().add(tfsearch);
		tfsearch.setColumns(10);
		tfsearch.setText("");

		lbsearch = new JLabel("도서 제목 : ");
		lbsearch.setBounds(12, 34, 73, 15);
		frame.getContentPane().add(lbsearch);

		btnsearch = new Button("검색");
		btnsearch.setBounds(244, 31, 76, 23);
		frame.getContentPane().add(btnsearch);

		// 버튼 클릭시 검색(공백 검색 시 전체 목록 출력)
		btnsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.remove(sp);
				if (tfsearch.getText().equals("")) {
					result = null;
					result = resultAll();
					String[] header = { "도서 제목", "저자", "출판사", "장르", "출판일" };
					model = new DefaultTableModel(result, header);
					panel.setLayout(null);
					table = new JTable(model);
					sp = new JScrollPane(table);
					sp.setBounds(12, 0, 760, 539);
					panel.add(sp);
					table.getTableHeader().setReorderingAllowed(false);
					table.setModel(new DefaultTableModel(result, header) {
						public boolean isCellEditable(int row, int column) {

							return false;
						}

					});
					Clicked();
				
				} else if (!(tfsearch.getText().equals(""))) {
					result = null;
					result = resultTitle();
					String[] header = { "도서 제목", "저자", "출판사", "장르", "출판일" };
					model = new DefaultTableModel(result, header);
					panel.setLayout(null);
					table = new JTable(model);
					sp = new JScrollPane(table);
					sp.setBounds(12, 0, 760, 539);
					panel.add(sp);
					table.getTableHeader().setReorderingAllowed(false);
					table.setModel(new DefaultTableModel(result, header) {
						public boolean isCellEditable(int row, int column) {
							
							return false;
						}

					});
					Clicked();
					
				}

			}

		});

		String[] header = { "도서 제목", "저자", "출판사", "장르", "출판일" };
		result = resultAll();
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setBounds(12, 0, 760, 451);
		panel.add(sp);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(result, header) {
			public boolean isCellEditable(int row, int column) {

				return false;
			}

		});
		
		Clicked();
		
		//대출 하기 버튼 기능 
		Button btnloans = new Button("대출하기");
		btnloans.setBounds(12, 537, 133, 49);
		frame.getContentPane().add(btnloans);
		btnloans.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Loans l = new Loans();
				l.setTitle(jtitle);
				System.out.println(jtitle);
				l.LoansView();
				
			}
		});
		
		//뒤로 가기 버튼 기능
		Button btnback = new Button("\uB4A4\uB85C\uAC00\uAE30");
		btnback.setBounds(674, 537, 100, 49);
		frame.getContentPane().add(btnback);
		btnback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new SelectView().selectview();
			}
		});

	}
	
	
	//jtable 행 선택 시 도서 제목 데이터 가져오는 기능
	public String title() {
		
		int a = table.getSelectedRow();
		int b = table.getSelectedColumn();
		jtitle= (String) table.getValueAt(a, 0);
		System.out.println(jtitle);
		return jtitle;
	}
	
	//전체 검색 후 ArrayList를 list 2차원 배열로 변환
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
	
	//도서 제목 검색 후 ArrayList를 list 2차원 배열로 변환
	public Object[][] resultTitle() {
		BookDAO bd = new BookDAO();
		Object[][] list;

		title = tfsearch.getText();

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
	//마우스 클릭 메소드
	public void Clicked() {
		table.addMouseListener(new MouseListener() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 1) {
					title();
					
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
	}

	public String getJtitle() {
		return jtitle;
	}

	public void setJtitle(String jtitle) {
		this.jtitle = jtitle;
	}
}
