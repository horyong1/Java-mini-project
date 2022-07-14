package project1st;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class LibrarysearchView extends JFrame {

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
	private JButton btnsearch;
	private JFrame frame;
	private JPanel panel;
	private JScrollPane sp;
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<BookVo> data;

	private String id;
	private String pwd;
	
	

	private static final long serialVersionUID = 1L;
	private JTextField tfsearch;
	private String title;
	private Object[][] result;
	String jtitle;
	private JLabel lblNewLabel;
	
	
	public LibrarysearchView() {
//		booksearchGui();
	}

	public void booksearchGui() {
		
		Dimension dim = new Dimension(800, 650);
		frame = new JFrame("도서관 관리 프로그램");
		BookDAO bd = new BookDAO();
		BookSearchList bsl = new BookSearchList();

	
		frame.setPreferredSize(dim);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(12, 131, 760, 400);
		frame.setLocation(500, 200);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

		tfsearch = new JTextField();
		tfsearch.setBounds(80, 100, 147, 21);
		frame.getContentPane().add(tfsearch);
		tfsearch.setColumns(10);
		tfsearch.setText("");
		

		lbsearch = new JLabel("도서 제목 : ");
		lbsearch.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbsearch.setBounds(12, 103, 73, 15);
		frame.getContentPane().add(lbsearch);

		btnsearch = new JButton("검색");
		btnsearch.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnsearch.setBounds(244, 100, 76, 23);
		frame.getContentPane().add(btnsearch);
		
		lblNewLabel = new JLabel("도서 검색");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 30));
		lblNewLabel.setBounds(317, 29, 147, 49);
		frame.getContentPane().add(lblNewLabel);

		// 버튼 클릭시 검색(공백 검색 시 전체 목록 출력)
		btnsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.remove(sp);
				if (tfsearch.getText().equals("")) {
					BookAllList();
					Clicked();
				
				} else if (!(tfsearch.getText().equals(""))) {
					BookselectList(tfsearch.getText());
					Clicked();
					
				}

			}

		});

		BookAllList();
		Clicked();
		
		//대출 하기 버튼 기능 
		JButton btncheckout = new JButton("대출하기");
		btncheckout.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btncheckout.setBounds(12, 537, 133, 49);
		frame.getContentPane().add(btncheckout);
		btncheckout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(jtitle==null||jtitle.length()==0) {
					JOptionPane.showMessageDialog(getContentPane(),"대출 하려는 책을 선택하세요", "Infomation",
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					CheckOutView co = new CheckOutView();
					System.out.println(id);
					System.out.println(pwd);
					co.setId(id);
					co.setPwd(pwd);
					co.setTitle(jtitle);
					System.out.println(jtitle);
					co.CheckoutView();
					
				}
				
			}
		});
		
		//뒤로 가기 버튼 기능
		JButton btnback = new JButton("뒤로가기");
		btnback.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnback.setBounds(674, 537, 100, 49);
		frame.getContentPane().add(btnback);
		
		btnback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				SelectView sv =new SelectView();
				sv.selectview();
				sv.setId(id);
				sv.setPwd(pwd);
			}
		});

	}
	
	
	//jtable 행 선택 시 도서 제목 데이터 가져오는 기능
	public String title() {
		
		int a = table.getSelectedRow();
		int b = table.getSelectedColumn();
		jtitle= (String) table.getValueAt(a, 0);
		return jtitle;
	}


	
	public void BookAllList() {
		
		BookSearchList bsl = new BookSearchList();
		String[] header = { "도서 제목", "저자", "출판사", "장르", "출판일" };
		result = bsl.resultAll();
		model = new DefaultTableModel(result, header);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 760, 400);
		panel.add(sp);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(result, header) {
			public boolean isCellEditable(int row, int column) {

				return false;
			}

		});
		
	}
	
	
	public void BookselectList(String title) {
		
		BookSearchList bsl = new BookSearchList();
		title = tfsearch.getText();
		System.out.println(title);
		result = null;
		result = bsl.resultTitle(title);
		String[] header = { "도서 제목", "저자", "출판사", "장르", "출판일" };
		model = new DefaultTableModel(result, header);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 760, 400);
		panel.add(sp);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(result, header) {
			public boolean isCellEditable(int row, int column) {
				
				return false;
			}

		});
		
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
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getJtitle() {
		return jtitle;
	}

	public void setJtitle(String jtitle) {
		this.jtitle = jtitle;
	}
}
