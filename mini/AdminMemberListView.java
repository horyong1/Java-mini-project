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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class AdminMemberListView extends JFrame {

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
	private int overlap=2;

	private static final long serialVersionUID = 1L;
	private JTextField tfsearch;
	private String title;
	private Object[][] result;
	private Object[][] infolist;
	private String jtitle;
	private boolean isinsert = false;
	private boolean isupdate = false;
	private JLabel lblNewLabel;
	private JLabel lbinid;
	private JLabel lbinpwd;
	private JLabel lbinname;
	private JLabel lbinbirth;
	private JLabel lbintel;
	private JLabel lbinemail;
	private JLabel lbamount;
	private JTextField tfinid;
	private JPasswordField tfinpwd;
	private JTextField tfinname;
	private JTextField tfinbirth;
	private JTextField tfintel;
	private JTextField tfinemail;
	private JButton btninsert;
	private JButton btnupdate;
	private JButton btndelete;
	private JButton btnok;
	private JButton btnreset;
	private JButton btncancel;
	private JRadioButton rbtngender,rbtngender1;
	private ButtonGroup jg;

	public AdminMemberListView() {
//		mainGui();
	}

	public void mainGui() {

		Dimension dim = new Dimension(800, 650);
		frame = new JFrame("도서관 관리 프로그램");
		BookDAO bd = new BookDAO();
		BookListArr bsl = new BookListArr();

		frame.setPreferredSize(new Dimension(1500, 650));
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(12, 131, 1084, 400);
		frame.setLocation(250, 200);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

		tfsearch = new JTextField();
		tfsearch.setBounds(98, 100, 147, 21);
		frame.getContentPane().add(tfsearch);
		tfsearch.setColumns(10);
		tfsearch.setText("");

		btnsearch = new JButton("검색");
		btnsearch.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnsearch.setBounds(258, 98, 76, 23);
		frame.getContentPane().add(btnsearch);

		lblNewLabel = new JLabel("회원 관리");
		lblNewLabel.setFont(new Font("함초롬돋움", Font.BOLD, 30));
		lblNewLabel.setBounds(662, 32, 147, 49);
		frame.getContentPane().add(lblNewLabel);

		btninsert = new JButton("회원 등록");
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

		panel_1.setBounds(1108, 131, 364, 400);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lbinid = new JLabel("아이디");
		lbinid.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbinid.setBounds(75, 59, 57, 15);
		panel_1.add(lbinid);

		tfinid = new JTextField();
		tfinid.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinid.setEditable(false);
		tfinid.setBounds(127, 55, 116, 21);
		panel_1.add(tfinid);
		tfinid.setColumns(10);

		lbinpwd = new JLabel("비밀번호");
		lbinpwd.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbinpwd.setBounds(65, 99, 57, 15);
		panel_1.add(lbinpwd);

		tfinpwd = new JPasswordField();
		tfinpwd.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinpwd.setEditable(false);
		tfinpwd.setColumns(10);
		tfinpwd.setBounds(127, 95, 116, 21);
		panel_1.add(tfinpwd);

		lbinname = new JLabel("이름");
		lbinname.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbinname.setBounds(87, 137, 57, 15);
		panel_1.add(lbinname);

		tfinname = new JTextField();
		tfinname.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinname.setEditable(false);
		tfinname.setColumns(10);
		tfinname.setBounds(127, 133, 116, 21);
		panel_1.add(tfinname);

		lbinbirth = new JLabel("생년월일");
		lbinbirth.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbinbirth.setBounds(65, 177, 57, 15);
		panel_1.add(lbinbirth);

		tfinbirth = new JTextField();
		tfinbirth.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinbirth.setEditable(false);
		tfinbirth.setColumns(10);
		tfinbirth.setBounds(127, 173, 116, 21);
		panel_1.add(tfinbirth);

		lbintel = new JLabel("전화번호");
		lbintel.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbintel.setBounds(65, 214, 57, 15);
		panel_1.add(lbintel);

		tfintel = new JTextField();
		tfintel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfintel.setEditable(false);
		tfintel.setColumns(10);
		tfintel.setBounds(127, 210, 116, 21);
		panel_1.add(tfintel);

		lbinemail = new JLabel("이메일");
		lbinemail.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbinemail.setBounds(75, 255, 57, 15);
		panel_1.add(lbinemail);

		tfinemail = new JTextField();
		tfinemail.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfinemail.setEditable(false);
		tfinemail.setColumns(10);
		tfinemail.setBounds(127, 251, 116, 21);
		panel_1.add(tfinemail);

		lbamount = new JLabel("성별");
		lbamount.setFont(new Font("함초롬돋움", Font.BOLD, 12));
		lbamount.setBounds(87, 290, 57, 15);
		panel_1.add(lbamount);

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

		btncancel = new JButton("취소");
		btncancel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btncancel.setEnabled(false);
		btncancel.setBounds(119, 356, 68, 23);
		panel_1.add(btncancel);
		
		rbtngender = new JRadioButton("남");
		rbtngender.setEnabled(false);
		rbtngender.setBounds(135, 290, 45, 23);
		panel_1.add(rbtngender);
		
		rbtngender1 = new JRadioButton("여");
		rbtngender1.setEnabled(false);
		rbtngender1.setBounds(198, 290, 45, 23);
		panel_1.add(rbtngender1);

		jg = new ButtonGroup();
		jg.add(rbtngender);
		jg.add(rbtngender1);
		
		JButton btnoverlap = new JButton("중복확인");
		
		btnoverlap.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnoverlap.setEnabled(false);
		btnoverlap.setBackground(SystemColor.menu);
		btnoverlap.setBounds(255, 53, 97, 23);
		panel_1.add(btnoverlap);
		
		JButton btninupdate = new JButton("수정");
		btninupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btninupdate.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btninupdate.setEnabled(false);
		btninupdate.setBackground(SystemColor.menu);
		btninupdate.setBounds(255, 94, 97, 23);
		panel_1.add(btninupdate);
		
		
		JLabel lblNewLabel_1 = new JLabel("도서 정보");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("함초롬돋움", Font.BOLD, 14));
		lblNewLabel_1.setBounds(1108, 110, 73, 18);
		frame.getContentPane().add(lblNewLabel_1);

		btnupdate = new JButton("회원 수정");
		btnupdate.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnupdate.setBounds(173, 537, 133, 49);
		frame.getContentPane().add(btnupdate);

		btndelete = new JButton("회원 삭제");
		btndelete.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btndelete.setBounds(334, 537, 133, 49);
		frame.getContentPane().add(btndelete);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "이름", "아이디" }));
		comboBox.setBounds(12, 98, 73, 23);
		frame.getContentPane().add(comboBox);
		comboBox.getSelectedItem().toString();
		listAll();
		Clicked();

		// 버튼 클릭시 검색(공백 검색 시 전체 목록 출력)
		btnsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.remove(sp);
				String sh = comboBox.getSelectedItem().toString();
				System.out.println(sh);
				if (sh.equals("아이디")) {
					if (tfsearch.getText().equals("")) {
						Enabled();
						listAll();
						Clicked();

					} else if (!(tfsearch.getText().equals(""))) {
						Enabled();
						listselet(tfsearch.getText());
						Clicked();

					}
				}else if(sh.equals("이름")) {
					if (tfsearch.getText().equals("")) {
						Enabled();
						listAll();
						Clicked();

					} else if (!(tfsearch.getText().equals(""))) {
						Enabled();
						nlistselet(tfsearch.getText());
						Clicked();

					}
					
				}
			}

		});

		// 회원 등록 하기 버튼 기능
		btninsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				isinsert = true;
				tfinid.setEditable(true);
				tfinpwd.setEditable(true);
				tfinname.setEditable(true);
				tfinbirth.setEditable(true);
				tfintel.setEditable(true);
				tfinemail.setEditable(true);
				rbtngender.setEnabled(true);
				rbtngender.setSelected(true);
				rbtngender1.setEnabled(true);
				
				tfinid.setText("");
				tfinpwd.setText("");
				tfinname.setText("");
				tfinbirth.setText("");
				tfintel.setText("");
				tfinemail.setText("");
				btnoverlap.setEnabled(true);
				btnok.setEnabled(true);
				btnreset.setEnabled(true);
				btncancel.setEnabled(true);
				btnupdate.setEnabled(false);
				btndelete.setEnabled(false);

			}
		});

		// 회원 수정 하기 버튼 기능
		btnupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (tfinid.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "수정하려는 회원을 선택하세요", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					isupdate = true;
					tfinid.setEditable(false);
					tfinpwd.setEditable(false);
					tfinname.setEditable(true);
					tfinbirth.setEditable(true);
					tfintel.setEditable(true);
					tfinemail.setEditable(true);
					rbtngender.setEnabled(true);
					rbtngender1.setEnabled(true);
					btninupdate.setEnabled(true);
					btnok.setEnabled(true);
					btnreset.setEnabled(true);
					btncancel.setEnabled(true);
					btninsert.setEnabled(false);
					btndelete.setEnabled(false);
				}
			}
		});
		// 회원 삭제
		btndelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberDAO md = new MemberDAO();
				if (tfinid.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "삭제 하려는 회원 선택하세요", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					int var = JOptionPane.showConfirmDialog(frame, "'" + title() + "'" + " 회원 삭제 하시겠습니까?",
							"Information", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);

					if (var == 0) {
						String pwd = tfinpwd.getText();
						int result = md.deleteData(jtitle,pwd);
						if (result == 1) {
							JOptionPane.showMessageDialog(getContentPane(), "회원 삭제 완료", "Information",
									JOptionPane.INFORMATION_MESSAGE);
							panel.remove(sp);
							listAll();
						} else {
							JOptionPane.showMessageDialog(getContentPane(), "회원 삭제 실패", "Information",
									JOptionPane.INFORMATION_MESSAGE);
						}

					}

				}
			}
		});
		//회원 등록 시 중복 체크
		btnoverlap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO mbd = new MemberDAO();
				overlap = mbd.idCheck(tfinid.getText());
				
				if(tfinid.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "아이디를 입력하세요", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					overlap = 2;
				}
				else if(overlap==1) {
					JOptionPane.showMessageDialog(getContentPane(), "중복된 아이디 입니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					overlap = 2;
				}else if(overlap==0) {
					JOptionPane.showMessageDialog(getContentPane(), "사용 가능한 아이디 입니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
				
			
		});
		
		//회원 수정 패스워드 수정 시 클릭하여 tfinpwd 활성화
		btninupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfinpwd.setEditable(true);
			}
		});
		
		// 책 정보란 확인 버튼
		btnok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberDAO md = new MemberDAO();
				MemberVo mv = new MemberVo();
				Effectiveness etv = new Effectiveness();
				String id = tfinid.getText();
				String pwd = tfinpwd.getText();
				String name = tfinname.getText();
				String birth = tfinbirth.getText();
				String tel = tfintel.getText();
				String email = tfinemail.getText();
				
				if (id.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "아이디를 입력하세요.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}else if (!(id.length() >= 5 && id.length() <= 15)) {
				
					JOptionPane.showMessageDialog(getContentPane(), "아이디 5~15자로 입력하세요.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (pwd.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "비밀번호를 입력하세요", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (!(pwd.length() >= 8 && pwd.length() <= 16)) {
					JOptionPane.showMessageDialog(getContentPane(), "비밀번호는 8~16자로 입력 가능합니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (name.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "이름을 입력하세요 ", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (etv.isAlphaNumeric(name) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "이름은 한글과 영어만 입력 가능합니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (birth.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "생년월일을 입력하세요", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (!(etv.isNumeric(birth))
						|| !((birth.length() <= 6 && birth.length() > 0))) {
					JOptionPane.showMessageDialog(getContentPane(), "올바른 형식의 생년월일을 입력하세요\n  예) 091201", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}else if (tel.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "전화번호를 입력하세요", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}else if(etv.isTel(tel) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "올바른 형식의 전화번호를 입력하세요\n  예) 010-1111-2222", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if (email.length()!=0&&etv.isValidEmail(email) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "올바른 형식의 이메일을 입력하세요\n  예) asdf@naver.com", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}else if (isinsert) {
					
					 if(overlap==2){
						JOptionPane.showMessageDialog(getContentPane(), "아이디 중복체크를 확인하세요.", "Message",
								JOptionPane.INFORMATION_MESSAGE);
					}
					 
					mv.setId(tfinid.getText());
					mv.setPwd(tfinpwd.getText());
					mv.setName(tfinname.getText());
					mv.setBirth(tfinbirth.getText());
					mv.setTel(tfintel.getText());
					mv.setEmail(tfinemail.getText());
					if(rbtngender.isSelected()==true) {
						mv.setGender(rbtngender.getText());
					}else if(rbtngender1.isSelected()==true) {
						mv.setGender(rbtngender1.getText());
					}
					
					isinsert = false;
					int result = md.insertData(mv);
					if (result == 1) {
						memberinfoSet();
						btninsert.setEnabled(true);
						btnupdate.setEnabled(true);
						btndelete.setEnabled(true);
						btnoverlap.setEnabled(false);
						btninupdate.setEnabled(false);

					} else {
						isinsert = false;
						JOptionPane.showMessageDialog(getContentPane(), "이미 등록된 회원입니다.", "Information",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else if (isupdate) {
					mv.setId(tfinid.getText());
					mv.setPwd(tfinpwd.getText());
					mv.setName(tfinname.getText());
					mv.setBirth(tfinbirth.getText());
					mv.setTel(tfintel.getText());
					mv.setEmail(tfinemail.getText());
					if(rbtngender.isSelected()) {
						mv.setGender("남");
						
					}else if(rbtngender1.isSelected()) {
						mv.setGender("여");
					}
					
					
					isinsert = false;
					int result = md.updateData(mv);
					if (result == 1) {
						memberinfoSet();
						btninsert.setEnabled(true);
						btnupdate.setEnabled(true);
						btndelete.setEnabled(true);
						btnoverlap.setEnabled(false);
						btninupdate.setEnabled(false);

					}

				} else {

					JOptionPane.showMessageDialog(getContentPane(), "회원 수정 실패", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}

		});

		// 취소 버튼 기능 책 정보panel 모든 텍스트 필드 및 버튼 비활성화
		btncancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				tfinid.setText("");
				tfinpwd.setText("");
				tfinname.setText("");
				tfinbirth.setText("");
				tfintel.setText("");
				tfinemail.setText("");

				tfinid.setEditable(false);
				tfinpwd.setEditable(false);
				tfinname.setEditable(false);
				tfinbirth.setEditable(false);
				tfintel.setEditable(false);
				tfinemail.setEditable(false);
				rbtngender.setEnabled(false);
				rbtngender.setSelected(false);
				rbtngender1.setEnabled(false);
				btnok.setEnabled(false);
				btnreset.setEnabled(false);
				btncancel.setEnabled(false);
				btnoverlap.setEnabled(false);
				btninupdate.setEnabled(false);
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
				tfinid.setText("");
				tfinpwd.setText("");
				tfinname.setText("");
				tfinbirth.setText("");
				tfintel.setText("");
				tfinemail.setText("");
				
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
	public void Enabled () {
		tfinid.setText("");
		tfinpwd.setText("");
		tfinname.setText("");
		tfinbirth.setText("");
		tfintel.setText("");
		tfinemail.setText("");
		rbtngender.setSelected(false);
		rbtngender1.setSelected(false);
	}
	
	public void listAll() {

		AdminMemberSearch ams = new AdminMemberSearch();
		String[] header = { "ID", "이름", "생년월일", "전화번호", "이메일", "성별" };
		result = ams.memberAll();
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setToolTipText("");
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1084, 400);
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

		AdminMemberSearch ams = new AdminMemberSearch();
		title = tfsearch.getText();
		System.out.println(title);
		result = null;
		result = ams.idSelect(title);
		String[] header = { "ID", "이름", "생년월일", "전화번호", "이메일", "성별" };
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1084, 400);
		sp.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		panel.add(sp);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(result, header) {
			public boolean isCellEditable(int row, int column) {

				return false;
			}

		});
	}
	public void nlistselet(String name) {

		AdminMemberSearch ams = new AdminMemberSearch();
		name = tfsearch.getText();
		System.out.println(name);
		result = null;
		result = ams.nameSelect(name);
		String[] header = { "ID", "이름", "생년월일", "전화번호", "이메일", "성별" };
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1084, 400);
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
	public void memberinfoSet() {
		JOptionPane.showMessageDialog(getContentPane(), "회원 등록/수정 완료", "Information", JOptionPane.INFORMATION_MESSAGE);
		tfinid.setText("");
		tfinpwd.setText("");
		tfinname.setText("");
		tfinbirth.setText("");
		tfintel.setText("");
		tfinemail.setText("");
		tfinid.setEditable(false);
		tfinpwd.setEditable(false);
		tfinname.setEditable(false);
		tfinbirth.setEditable(false);
		tfintel.setEditable(false);
		tfinemail.setEditable(false);
		btnok.setEnabled(false);
		btnreset.setEnabled(false);
		btncancel.setEnabled(false);
		rbtngender.setEnabled(false);
		rbtngender1.setEnabled(false);
		panel.remove(sp);
		listAll();
		Clicked();
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

	// 마우스 클릭 메소드
	public void Clicked() {
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 1) {
					String tname = title();
					AdminMemberSearch ams = new AdminMemberSearch();
					infolist = ams.memberidSelect(tname);
					tfinid.setText((String) infolist[0][0]);
					tfinpwd.setText((String) infolist[0][1]);
					tfinname.setText((String) infolist[0][2]);
					tfinbirth.setText((String) infolist[0][3]);
					tfintel.setText((String) infolist[0][4]);
					tfinemail.setText((String) infolist[0][5]);
					if(((String) infolist[0][6]).equals("남")) {
						rbtngender.setSelected(true);
						rbtngender1.setSelected(false);
					}else if(((String) infolist[0][6]).equals("여")) {
						rbtngender.setSelected(false);
						rbtngender1.setSelected(true);
						
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
