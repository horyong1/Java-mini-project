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

import javax.swing.JButton;
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

public class AdminBookList extends JFrame {

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

	private static final long serialVersionUID = 1L;
	private JTextField tfsearch;
	private String title;
	private Object[][] result;
	private Object[][] infolist;
	private String jtitle;
	private boolean isinsert = false;
	private boolean isupdate = false;
	private JLabel lblNewLabel;
	private JLabel lbintitle;
	private JLabel lbinauthor;
	private JLabel lbinpublisher;
	private JLabel lbingenre;
	private JLabel lbpublication_date;
	private JLabel lbinpurchase_date;
	private JLabel lbamount;
	private JTextField tfintitle;
	private JTextField tfinauthor;
	private JTextField tfinpublisher;
	private JTextField tfingenre;
	private JTextField tfinpublication_date;
	private JTextField tfinpurchase_date;
	private JTextField tfinamount;
	private JButton btninsert;
	private JButton btnupdate;
	private JButton btndelete;
	private JButton btnok;
	private JButton btnreset;
	private JButton btncancel;
	private JTextField tfincheckout;

	public AdminBookList() {
//		mainGui();
	}

	public void mainGui() {

		Dimension dim = new Dimension(800, 650);
		frame = new JFrame("도서관 관리 프로그램");
		BookDAO bd = new BookDAO();
		BookSearchList bsl = new BookSearchList();

		frame.setPreferredSize(new Dimension(1500, 650));
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(12, 131, 1135, 400);
		frame.setLocation(250, 200);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

		tfsearch = new JTextField();
		tfsearch.setBounds(80, 100, 147, 21);
		frame.getContentPane().add(tfsearch);
		tfsearch.setColumns(10);
		tfsearch.setText("");

		lbsearch = new JLabel("도서 제목 : ");
		lbsearch.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbsearch.setBounds(12, 102, 73, 15);
		frame.getContentPane().add(lbsearch);

		btnsearch = new JButton("검색");
		btnsearch.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnsearch.setBounds(244, 99, 76, 23);
		frame.getContentPane().add(btnsearch);

		lblNewLabel = new JLabel("도서 관리");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 30));
		lblNewLabel.setBounds(662, 32, 147, 49);
		frame.getContentPane().add(lblNewLabel);

		btninsert = new JButton("도서 등록");
		btninsert.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btninsert.setBounds(12, 537, 133, 49);
		frame.getContentPane().add(btninsert);

		JButton btnback = new JButton("뒤로가기");
		btnback.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnback.setBounds(1372, 537, 100, 49);
		frame.getContentPane().add(btnback);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		panel_1.setBounds(1159, 131, 313, 400);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lbintitle = new JLabel("도서 제목");
		lbintitle.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbintitle.setBounds(66, 50, 57, 15);
		panel_1.add(lbintitle);

		tfintitle = new JTextField();
		tfintitle.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfintitle.setEditable(false);
		tfintitle.setBounds(135, 48, 116, 21);
		panel_1.add(tfintitle);
		tfintitle.setColumns(10);

		lbinauthor = new JLabel("저자");
		lbinauthor.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbinauthor.setBounds(95, 90, 35, 15);
		panel_1.add(lbinauthor);

		tfinauthor = new JTextField();
		tfinauthor.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinauthor.setEditable(false);
		tfinauthor.setColumns(10);
		tfinauthor.setBounds(135, 88, 116, 21);
		panel_1.add(tfinauthor);

		lbinpublisher = new JLabel("출판사");
		lbinpublisher.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbinpublisher.setBounds(83, 128, 57, 15);
		panel_1.add(lbinpublisher);

		tfinpublisher = new JTextField();
		tfinpublisher.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinpublisher.setEditable(false);
		tfinpublisher.setColumns(10);
		tfinpublisher.setBounds(135, 126, 116, 21);
		panel_1.add(tfinpublisher);

		lbingenre = new JLabel("장르");
		lbingenre.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbingenre.setBounds(95, 168, 57, 15);
		panel_1.add(lbingenre);

		tfingenre = new JTextField();
		tfingenre.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfingenre.setEditable(false);
		tfingenre.setColumns(10);
		tfingenre.setBounds(135, 166, 116, 21);
		panel_1.add(tfingenre);

		lbpublication_date = new JLabel("출판일");
		lbpublication_date.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbpublication_date.setBounds(83, 205, 57, 15);
		panel_1.add(lbpublication_date);

		tfinpublication_date = new JTextField();
		tfinpublication_date.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinpublication_date.setEditable(false);
		tfinpublication_date.setColumns(10);
		tfinpublication_date.setBounds(135, 203, 116, 21);
		panel_1.add(tfinpublication_date);

		lbinpurchase_date = new JLabel("구매일");
		lbinpurchase_date.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbinpurchase_date.setBounds(83, 246, 57, 15);
		panel_1.add(lbinpurchase_date);

		tfinpurchase_date = new JTextField();
		tfinpurchase_date.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinpurchase_date.setEditable(false);
		tfinpurchase_date.setColumns(10);
		tfinpurchase_date.setBounds(135, 244, 116, 21);
		panel_1.add(tfinpurchase_date);

		lbamount = new JLabel("금액");
		lbamount.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbamount.setBounds(95, 283, 57, 15);
		panel_1.add(lbamount);

		tfinamount = new JTextField();
		tfinamount.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinamount.setEditable(false);
		tfinamount.setColumns(10);
		tfinamount.setBounds(135, 281, 116, 21);
		panel_1.add(tfinamount);

		btnok = new JButton("확인");
		btnok.setBackground(UIManager.getColor("Button.background"));
		btnok.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnok.setEnabled(false);
		btnok.setBounds(39, 356, 68, 23);
		panel_1.add(btnok);

		btnreset = new JButton("초기화");
		btnreset.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnreset.setEnabled(false);
		btnreset.setBounds(199, 356, 77, 23);
		panel_1.add(btnreset);

		btncancel = new JButton("\uCDE8\uC18C");
		btncancel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btncancel.setEnabled(false);
		btncancel.setBounds(119, 356, 68, 23);
		panel_1.add(btncancel);
		
		JLabel lbincheckout = new JLabel("대출 여부");
		lbincheckout.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbincheckout.setBounds(73, 317, 57, 15);
		panel_1.add(lbincheckout);
		
		tfincheckout = new JTextField();
		tfincheckout.setEditable(false);
		tfincheckout.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfincheckout.setColumns(10);
		tfincheckout.setBounds(135, 313, 116, 21);
		panel_1.add(tfincheckout);

		JLabel lblNewLabel_1 = new JLabel("도서 정보");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		lblNewLabel_1.setBounds(1160, 108, 73, 18);
		frame.getContentPane().add(lblNewLabel_1);

		btnupdate = new JButton("도서 수정");
		btnupdate.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnupdate.setBounds(173, 537, 133, 49);
		frame.getContentPane().add(btnupdate);

		btndelete = new JButton("도서 삭제");
		btndelete.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btndelete.setBounds(334, 537, 133, 49);
		frame.getContentPane().add(btndelete);

		listAll();
		Clicked();

		// 버튼 클릭시 검색(공백 검색 시 전체 목록 출력)
		btnsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.remove(sp);
				if (tfsearch.getText().equals("")) {
					tfintitle.setText("");
					tfinauthor.setText("");
					tfinpublisher.setText("");
					tfingenre.setText("");
					tfinpublication_date.setText("");
					tfinpurchase_date.setText("");
					tfinamount.setText("");
					tfincheckout.setText("");
					listAll();
					Clicked();
					

				} else if (!(tfsearch.getText().equals(""))) {
					tfintitle.setText("");
					tfinauthor.setText("");
					tfinpublisher.setText("");
					tfingenre.setText("");
					tfinpublication_date.setText("");
					tfinpurchase_date.setText("");
					tfinamount.setText("");
					tfincheckout.setText("");
					listselet(tfsearch.getText());
					Clicked();

				}

			}

		});

		// 도서 등록 하기 버튼 기능
		btninsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isinsert = true;
				tfintitle.setEditable(true);
				tfinauthor.setEditable(true);
				tfinpublisher.setEditable(true);
				tfingenre.setEditable(true);
				tfinpublication_date.setEditable(true);
				tfinpurchase_date.setEditable(true);
				tfinamount.setEditable(true);
				tfintitle.setText("");
				tfinauthor.setText("");
				tfinpublisher.setText("");
				tfingenre.setText("");
				tfinpublication_date.setText("");
				tfinpurchase_date.setText("");
				tfinamount.setText("");
				tfincheckout.setText("");
				btnok.setEnabled(true);
				btnreset.setEnabled(true);
				btncancel.setEnabled(true);
				btnupdate.setEnabled(false);
				btndelete.setEnabled(false);

			}
		});

		// 도서 수정 하기 버튼 기능
		btnupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (tfintitle.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "수정하려는 도서를 선택하세요", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					isupdate = true;
					tfintitle.setEditable(true);
					tfinauthor.setEditable(true);
					tfinpublisher.setEditable(true);
					tfingenre.setEditable(true);
					tfinpublication_date.setEditable(true);
					tfinpurchase_date.setEditable(true);
					tfinamount.setEditable(true);
//					tfintitle.setText("");
//					tfinauthor.setText("");
//					tfinpublisher.setText("");
//					tfingenre.setText("");
//					tfinpublication_date.setText("");
//					tfinpurchase_date.setText("");
//					tfinamount.setText("");

					btnok.setEnabled(true);
					btnreset.setEnabled(true);
					btncancel.setEnabled(true);
					btninsert.setEnabled(false);
					btndelete.setEnabled(false);
				}
			}
		});
		//도서 삭제 
		btndelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BookDAO bdao = new BookDAO();
				if (tfintitle.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "삭제 하려는 도서를 선택하세요", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					int var = JOptionPane.showConfirmDialog(frame, "'" + title() + "'" + " 책을 삭제 하시겠습니까?", "Information",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);

					if (var == 0) {
						int result = bdao.deleteBook(jtitle);
						if (result == 1) {
							JOptionPane.showMessageDialog(getContentPane(), "도서 삭제 완료", "Information",
									JOptionPane.INFORMATION_MESSAGE);
							panel.remove(sp);
							listAll();
						} else {
							JOptionPane.showMessageDialog(getContentPane(), "대출중인 도서로 삭제 불가", "Information",
									JOptionPane.INFORMATION_MESSAGE);
						}

					}

				}
			}
		});
		
		// 책 정보란 확인 버튼
		btnok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BookDAO bdao = new BookDAO();
				BookVo bvo = new BookVo();
				Effectiveness etv  = new Effectiveness();
				String publication = tfinpublication_date.getText();
				String purchase = tfinpurchase_date.getText();
				String amount = tfinamount.getText();
				if (tfintitle.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "도서 이름을 입력하세요", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else if (tfinauthor.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "저자를 입력하세요", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfinpublisher.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "출판사를 입력하세요", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfingenre.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "장르를 입력하세요", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				} else if(publication.length()!=0&&etv.isDate(publication)==false){
					JOptionPane.showMessageDialog(getContentPane(), "출판일에 올바른 날짜 형식을 입력하세요\n 예) yyyy-MM-dd", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else if(purchase.length()!=0&&etv.isDate(purchase)==false) {
					JOptionPane.showMessageDialog(getContentPane(), "구매일에 올바른 날짜 형식을 입력하세요\n 예) yyyy-MM-dd", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					
				} else if(amount.length()!=0&&etv.isNumeric(amount)==false) {
					JOptionPane.showMessageDialog(getContentPane(), "금액은 숫자만 입력하세요", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				
				
				else if (isinsert) {
					bvo.setTitle(tfintitle.getText());
					bvo.setAuthor(tfinauthor.getText());
					bvo.setPublisher(tfinpublisher.getText());
					bvo.setGenre(tfingenre.getText());
					bvo.setPublication_date(tfinpublication_date.getText());
					bvo.setPurchase_date(tfinpurchase_date.getText());
					bvo.setAmount(tfinamount.getText());
					isinsert = false;
					int result = bdao.insertData(bvo);
					if (result == 1) {
						bookinfoSet();
						btninsert.setEnabled(true);
						btnupdate.setEnabled(true);
						btndelete.setEnabled(true);
						
					}else {
						isinsert= true;
						JOptionPane.showMessageDialog(getContentPane(), "이미 등록된 도서입니다.", "Information",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else if (isupdate) {
					bvo.setTitle(tfintitle.getText());
					bvo.setAuthor(tfinauthor.getText());
					bvo.setPublisher(tfinpublisher.getText());
					bvo.setGenre(tfingenre.getText());
					bvo.setPublication_date(tfinpublication_date.getText());
					bvo.setPurchase_date(tfinpurchase_date.getText());
					bvo.setAmount(tfinamount.getText());
					bvo.setChtitle((String) infolist[0][0]);
					isinsert = false;
					int result = bdao.updateData(bvo);
					if (result == 1) {
						bookinfoSet();
						btninsert.setEnabled(true);
						btnupdate.setEnabled(true);
						btndelete.setEnabled(true);
					
					}
				
				
				} else {

					JOptionPane.showMessageDialog(getContentPane(), "도서 등록 실패", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}

		});

		// 취소 버튼 기능 책 정보panel 모든 텍스트 필드 및 버튼 비활성화
		btncancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfintitle.setText("");
				tfinauthor.setText("");
				tfinpublisher.setText("");
				tfingenre.setText("");
				tfinpublication_date.setText("");
				tfinpurchase_date.setText("");
				tfinamount.setText("");
				tfincheckout.setText("");
				tfintitle.setEditable(false);
				tfinauthor.setEditable(false);
				tfinpublisher.setEditable(false);
				tfingenre.setEditable(false);
				tfinpublication_date.setEditable(false);
				tfinpurchase_date.setEditable(false);
				tfinamount.setEditable(false);
				btnok.setEnabled(false);
				btnreset.setEnabled(false);
				btncancel.setEnabled(false);

				btninsert.setEnabled(true);
				btnupdate.setEnabled(true);
				btndelete.setEnabled(true);
			}
		});

		// 초기화 버튼
		btnreset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfintitle.setText("");
				tfinauthor.setText("");
				tfinpublisher.setText("");
				tfingenre.setText("");
				tfinpublication_date.setText("");
				tfinpurchase_date.setText("");
				tfinamount.setText("");
				Clicked();
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

	public void listAll() {

		BookSearchList bsl = new BookSearchList();
		String[] header = { "도서 제목", "저자", "출판사", "장르", "출판일", "구매일", "금액" };
		result = bsl.adminAll();
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setToolTipText("");
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1135, 400);
		sp.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		panel.add(sp);

		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(result, header) {
			public boolean isCellEditable(int row, int column) {

				return false;
			}

		});
	}

	public void listselet(String title) {

		BookSearchList bsl = new BookSearchList();
		title = tfsearch.getText();
		System.out.println(title);
		result = null;
		result = bsl.adminTitle(title);
		String[] header = { "도서 제목", "저자", "출판사", "장르", "출판일", "구매일", "금액" };
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1135, 400);
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
	public String title() {

		int a = table.getSelectedRow();
		int b = table.getSelectedColumn();
		jtitle = (String) table.getValueAt(a, 0);
		return jtitle;
	}

	// 도서 신규 or 수정 후 책 정보란 비활성화
	public void bookinfoSet() {
		JOptionPane.showMessageDialog(getContentPane(), "도서 등록 완료", "Information", JOptionPane.INFORMATION_MESSAGE);
		tfintitle.setText("");
		tfinauthor.setText("");
		tfinpublisher.setText("");
		tfingenre.setText("");
		tfinpublication_date.setText("");
		tfinpurchase_date.setText("");
		tfinamount.setText("");
		tfincheckout.setText("");
		tfintitle.setEditable(false);
		tfinauthor.setEditable(false);
		tfinpublisher.setEditable(false);
		tfingenre.setEditable(false);
		tfinpublication_date.setEditable(false);
		tfinpurchase_date.setEditable(false);
		tfinamount.setEditable(false);
		btnok.setEnabled(false);
		btnreset.setEnabled(false);
		btncancel.setEnabled(false);
		panel.remove(sp);
		listAll();
		Clicked();
	}

	public String getJtitle() {
		return jtitle;
	}

	public void setJtitle(String jtitle) {
		this.jtitle = jtitle;
	}

	// 마우스 클릭 메소드
	public void Clicked() {
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 1) {
					String tname = title();
					BookSearchList bsl = new BookSearchList();
					CheckOutDAO cod = new CheckOutDAO();
					infolist = bsl.adminTitle(tname);
					tfintitle.setText((String) infolist[0][0]);
					tfinauthor.setText((String) infolist[0][1]);
					tfinpublisher.setText((String) infolist[0][2]);
					tfingenre.setText((String) infolist[0][3]);
					tfinpublication_date.setText((String) infolist[0][4]);
					tfinpurchase_date.setText((String) infolist[0][5]);
					tfinamount.setText((String) infolist[0][6]);

					int num = cod.titleCheck(jtitle);
					if (num == 1) {
						tfincheckout.setText("대출중");
					} else if (num == 0) {
						tfincheckout.setText("대출가능");
					}

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
}
