package project1st;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

public class AdminCheckOutView extends JFrame {

	private JLabel lbsearch = null;
	private JButton btnsearch;
	private JFrame frame;
	private JPanel panel;
	private JScrollPane sp;
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<BookVo> data;

	private String id;
	private String pwd;
	private int num;
	private String combo;
	private String jid;
	private String[] arr = new String[2];

	private static final long serialVersionUID = 1L;
	private JTextField tfsearch;
	private String title;
	private Object[][] result;
	private Object[][] infolist;
	private String jtitle;
	private boolean isinsert = false;
	private boolean isupdate = false;
	private JLabel lbtoptitle;
	private JLabel lbintitle;
	private JLabel lbinauthor;
	private JLabel lbinpublisher;
	private JLabel lbcheckout_date;
	private JLabel lbreturn_date;
	private JTextField tfintitle;
	private JTextField tfinauthor;
	private JTextField tfinpublisher;
	private JTextField tfingenre;
	private JTextField tfinpublication_date;
	private JButton btnlate;
	private JButton btnsendmail;
	private JTextField tfinid;
	private JTextField tfinlate;
	private JComboBox comboBox;

	public AdminCheckOutView() {
		mainGui();
	}

	public void mainGui() {

		Dimension dim = new Dimension(800, 650);
		frame = new JFrame("도서관 관리 프로그램");
		frame.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		frame.getContentPane().setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		BookDAO bd = new BookDAO();
		BookListArr bsl = new BookListArr();

		frame.setPreferredSize(new Dimension(1373, 650));
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(12, 131, 1034, 400);
		frame.setLocation(250, 200);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

		tfsearch = new JTextField();
		tfsearch.setBounds(97, 99, 147, 21);
		frame.getContentPane().add(tfsearch);
		tfsearch.setColumns(10);
		tfsearch.setText("");

		btnsearch = new JButton("검색");
		btnsearch.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnsearch.setBounds(254, 98, 76, 23);
		frame.getContentPane().add(btnsearch);

		lbtoptitle = new JLabel("도서 대출 관리");
		lbtoptitle.setFont(new Font("함초롬돋움", Font.BOLD, 30));
		lbtoptitle.setBounds(579, 33, 213, 49);
		frame.getContentPane().add(lbtoptitle);

		btnlate = new JButton("연체 목록 조회");
		btnlate.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnlate.setBounds(12, 537, 133, 49);
		frame.getContentPane().add(btnlate);

		JButton btnback = new JButton("뒤로가기");
		btnback.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnback.setBounds(1243, 537, 100, 49);
		frame.getContentPane().add(btnback);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		panel_1.setBounds(1059, 131, 284, 400);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lbintitle = new JLabel("도서 제목");
		lbintitle.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbintitle.setBounds(45, 92, 57, 15);
		panel_1.add(lbintitle);

		tfintitle = new JTextField();
		tfintitle.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfintitle.setEditable(false);
		tfintitle.setBounds(114, 90, 116, 21);
		panel_1.add(tfintitle);
		tfintitle.setColumns(10);

		lbinauthor = new JLabel("저자");
		lbinauthor.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbinauthor.setBounds(73, 138, 35, 15);
		panel_1.add(lbinauthor);

		tfinauthor = new JTextField();
		tfinauthor.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinauthor.setEditable(false);
		tfinauthor.setColumns(10);
		tfinauthor.setBounds(113, 136, 116, 21);
		panel_1.add(tfinauthor);

		lbinpublisher = new JLabel("출판사");
		lbinpublisher.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbinpublisher.setBounds(61, 184, 57, 15);
		panel_1.add(lbinpublisher);

		tfinpublisher = new JTextField();
		tfinpublisher.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinpublisher.setEditable(false);
		tfinpublisher.setColumns(10);
		tfinpublisher.setBounds(113, 182, 116, 21);
		panel_1.add(tfinpublisher);

		lbcheckout_date = new JLabel("대출일");
		lbcheckout_date.setHorizontalAlignment(SwingConstants.LEFT);
		lbcheckout_date.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbcheckout_date.setBounds(61, 228, 57, 15);
		panel_1.add(lbcheckout_date);

		tfingenre = new JTextField();
		tfingenre.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfingenre.setEditable(false);
		tfingenre.setColumns(10);
		tfingenre.setBounds(113, 226, 116, 21);
		panel_1.add(tfingenre);

		lbreturn_date = new JLabel("\uBC18\uB0A9\uC77C");
		lbreturn_date.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbreturn_date.setBounds(61, 273, 57, 15);
		panel_1.add(lbreturn_date);

		tfinpublication_date = new JTextField();
		tfinpublication_date.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinpublication_date.setEditable(false);
		tfinpublication_date.setColumns(10);
		tfinpublication_date.setBounds(113, 271, 116, 21);
		panel_1.add(tfinpublication_date);
		
		JLabel lbid = new JLabel("아이디");
		lbid.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbid.setBounds(61, 47, 57, 15);
		panel_1.add(lbid);
		
		tfinid = new JTextField();
		tfinid.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinid.setEditable(false);
		tfinid.setColumns(10);
		tfinid.setBounds(113, 43, 116, 21);
		panel_1.add(tfinid);
		
		JLabel lbpublication_date_1 = new JLabel("연체일");
		lbpublication_date_1.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbpublication_date_1.setBounds(61, 320, 57, 15);
		panel_1.add(lbpublication_date_1);
		
		tfinlate = new JTextField();
		tfinlate.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinlate.setEditable(false);
		tfinlate.setColumns(10);
		tfinlate.setBounds(113, 316, 116, 21);
		panel_1.add(tfinlate);

		JLabel lblNewLabel_1 = new JLabel("도서 정보");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		lblNewLabel_1.setBounds(1059, 109, 73, 18);
		frame.getContentPane().add(lblNewLabel_1);

		btnsendmail = new JButton("연체 메일 발송");
		btnsendmail.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnsendmail.setBounds(173, 537, 133, 49);
		frame.getContentPane().add(btnsendmail);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "이름", "아이디" }));
		comboBox.setBounds(12, 98, 73, 23);
		frame.getContentPane().add(comboBox);
		combo = comboBox.getSelectedItem().toString();
		

		BookAllList();
		Clicked();

		// 버튼 클릭시 검색(공백 검색 시 전체 목록 출력)
		btnsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(combo);
				panel.remove(sp);
				if (tfsearch.getText().equals("")) {
					tfintitle.setText("");
					tfinauthor.setText("");
					tfinpublisher.setText("");
					tfingenre.setText("");
					tfinpublication_date.setText("");

					
					BookAllList();
					Clicked();
					

				} else if (!(tfsearch.getText().equals(""))) {
					tfintitle.setText("");
					tfinauthor.setText("");
					tfinpublisher.setText("");
					tfingenre.setText("");
					tfinpublication_date.setText("");

				
					listselet(tfsearch.getText());
					Clicked();

				}

			}

		});

		// 연체 목록 조회 하기 버튼 기능
		btnlate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				

			}
		});

		// 연체 메일 보내기 버튼 기능
		btnsendmail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				
					JOptionPane.showMessageDialog(getContentPane(), "수정하려는 도서를 선택하세요", "Information",
							JOptionPane.INFORMATION_MESSAGE);
			
				}
		});
		
		// 뒤로 가기 버튼 기능
		btnback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.dispose();
				new AdminView().adminGui();
				;

			}
		});

	}

	public void BookAllList() {
		combo = comboBox.getSelectedItem().toString();
		BookListArr bsl = new BookListArr();
		String[] header = { "아이디", "도서 제목", "저자", "출판사", "대출일", "반납일","연체일" };
		result = bsl.adminReturnAll(combo);
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1034, 400);
		panel.add(sp);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(result, header) {

			public boolean isCellEditable(int row, int column) {

				return false;
			}

		});
	}
	public void BooktitleList(String title){
		//BookDAO bd = new BookDAO();
		BookListArr bsl = new BookListArr();
		
		title = tfsearch.getText();
		System.out.println(title);
		result = null;
		result = bsl.returnTitle(id, title);
		String[] header = { "아이디", "도서 제목", "저자", "출판사", "대출일", "반납일","연체일" };
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1034, 400);
		panel.add(sp);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(result, header) {
			public boolean isCellEditable(int row, int column) {

				return false;
			}

		});
	}

	public void listselet(String name) {

		BookListArr bsl = new BookListArr();
		name = tfsearch.getText();
		System.out.println(name);
		result = null;
		result = bsl.adminTitle(name);
		String[] header = { "아이디", "도서 제목","저자","출판사","대출일","반납일","연체일"  };
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1034, 400);
		sp.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		panel.add(sp);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(result, header) {
			public boolean isCellEditable(int row, int column) {

				return false;
			}

		});
	}

	// jtable 행 선택 시 도서 제목 데이터 가져오는 기능
	public String[] title() {
		int a = table.getSelectedRow();
		int b = table.getSelectedColumn();
		jid = (String) table.getValueAt(a, 0);
		jtitle = (String) table.getValueAt(a, 1);
		arr[0] = jid;
		arr[1] = jtitle;

		return arr;
	}


	// 마우스 클릭 메소드
	public void Clicked() {
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				//관리자 도서 대출 관리 - 목록 클릭 시 도서 정보란 정보 표시
				if (e.getClickCount() == 1) {
					String []tname = title();
					BookListArr bsl = new BookListArr();
					CheckOutDAO cod = new CheckOutDAO();
					infolist = bsl.adminReturnSelect(tname[0],tname[1]);
					tfinid.setText((String) infolist[0][0]);
					tfintitle.setText((String) infolist[0][1]);
					tfinauthor.setText((String) infolist[0][2]);
					tfinpublisher.setText((String) infolist[0][3]);
					tfingenre.setText((String) infolist[0][4]);
					tfinpublication_date.setText((String) infolist[0][5]);
					tfinlate.setText((String)infolist[0][6]+"일");		
							
					
					
					
				

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
