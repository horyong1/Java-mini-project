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
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class AdminMemberList extends JFrame {

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
	private JLabel lbinid;
	private JLabel lbinpwd;
	private JLabel lbinname;
	private JLabel lbinbirth;
	private JLabel lbintel;
	private JLabel lbinemail;
	private JLabel lbamount;
	private JTextField tfinid;
	private JTextField tfinpwd;
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

	public AdminMemberList() {
		mainGui();
	}

	public void mainGui() {

		Dimension dim = new Dimension(800, 650);
		frame = new JFrame("������ ���� ���α׷�");
		BookDAO bd = new BookDAO();
		BookSearchList bsl = new BookSearchList();

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

		btnsearch = new JButton("�˻�");
		btnsearch.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnsearch.setBounds(258, 98, 76, 23);
		frame.getContentPane().add(btnsearch);

		lblNewLabel = new JLabel("ȸ�� ����");
		lblNewLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 30));
		lblNewLabel.setBounds(662, 32, 147, 49);
		frame.getContentPane().add(lblNewLabel);

		btninsert = new JButton("ȸ�� ���");
		btninsert.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btninsert.setBounds(12, 537, 133, 49);
		frame.getContentPane().add(btninsert);

		JButton btnback = new JButton("�ڷΰ���");
		btnback.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnback.setBounds(1372, 537, 100, 49);
		frame.getContentPane().add(btnback);

		JPanel panel_1 = new JPanel();
		panel_1.setForeground(new Color(0, 0, 0));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));

		panel_1.setBounds(1108, 131, 364, 400);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lbinid = new JLabel("���̵�");
		lbinid.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbinid.setBounds(75, 59, 57, 15);
		panel_1.add(lbinid);

		tfinid = new JTextField();
		tfinid.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfinid.setEditable(false);
		tfinid.setBounds(127, 55, 116, 21);
		panel_1.add(tfinid);
		tfinid.setColumns(10);

		lbinpwd = new JLabel("��й�ȣ");
		lbinpwd.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbinpwd.setBounds(65, 99, 57, 15);
		panel_1.add(lbinpwd);

		tfinpwd = new JTextField();
		tfinpwd.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfinpwd.setEditable(false);
		tfinpwd.setColumns(10);
		tfinpwd.setBounds(127, 95, 116, 21);
		panel_1.add(tfinpwd);

		lbinname = new JLabel("�̸�");
		lbinname.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbinname.setBounds(87, 137, 57, 15);
		panel_1.add(lbinname);

		tfinname = new JTextField();
		tfinname.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfinname.setEditable(false);
		tfinname.setColumns(10);
		tfinname.setBounds(127, 133, 116, 21);
		panel_1.add(tfinname);

		lbinbirth = new JLabel("�������");
		lbinbirth.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbinbirth.setBounds(65, 177, 57, 15);
		panel_1.add(lbinbirth);

		tfinbirth = new JTextField();
		tfinbirth.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfinbirth.setEditable(false);
		tfinbirth.setColumns(10);
		tfinbirth.setBounds(127, 173, 116, 21);
		panel_1.add(tfinbirth);

		lbintel = new JLabel("��ȭ��ȣ");
		lbintel.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbintel.setBounds(65, 214, 57, 15);
		panel_1.add(lbintel);

		tfintel = new JTextField();
		tfintel.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfintel.setEditable(false);
		tfintel.setColumns(10);
		tfintel.setBounds(127, 210, 116, 21);
		panel_1.add(tfintel);

		lbinemail = new JLabel("�̸���");
		lbinemail.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbinemail.setBounds(75, 255, 57, 15);
		panel_1.add(lbinemail);

		tfinemail = new JTextField();
		tfinemail.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfinemail.setEditable(false);
		tfinemail.setColumns(10);
		tfinemail.setBounds(127, 251, 116, 21);
		panel_1.add(tfinemail);

		lbamount = new JLabel("����");
		lbamount.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbamount.setBounds(87, 290, 57, 15);
		panel_1.add(lbamount);

		btnok = new JButton("Ȯ��");
		btnok.setBackground(UIManager.getColor("Button.background"));
		btnok.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnok.setEnabled(false);
		btnok.setBounds(39, 356, 68, 23);
		panel_1.add(btnok);

		btnreset = new JButton("�ʱ�ȭ");
		btnreset.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnreset.setEnabled(false);
		btnreset.setBounds(199, 356, 77, 23);
		panel_1.add(btnreset);

		btncancel = new JButton("���");
		btncancel.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btncancel.setEnabled(false);
		btncancel.setBounds(119, 356, 68, 23);
		panel_1.add(btncancel);
		
		rbtngender = new JRadioButton("��");
		rbtngender.setEnabled(false);
		rbtngender.setBounds(135, 290, 45, 23);
		panel_1.add(rbtngender);
		
		rbtngender1 = new JRadioButton("��");
		rbtngender1.setEnabled(false);
		rbtngender1.setBounds(198, 290, 45, 23);
		panel_1.add(rbtngender1);

		jg = new ButtonGroup();
		jg.add(rbtngender);
		jg.add(rbtngender1);
		
		JButton btnok_1 = new JButton("�ߺ�Ȯ��");
		btnok_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnok_1.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnok_1.setEnabled(false);
		btnok_1.setBackground(SystemColor.menu);
		btnok_1.setBounds(255, 53, 81, 23);
		panel_1.add(btnok_1);
		
		JButton btnok_1_1 = new JButton("����");
		btnok_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnok_1_1.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnok_1_1.setEnabled(false);
		btnok_1_1.setBackground(SystemColor.menu);
		btnok_1_1.setBounds(255, 94, 81, 23);
		panel_1.add(btnok_1_1);
		
		
		JLabel lblNewLabel_1 = new JLabel("���� ����");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("���ʷҵ���", Font.BOLD, 14));
		lblNewLabel_1.setBounds(1108, 110, 73, 18);
		frame.getContentPane().add(lblNewLabel_1);

		btnupdate = new JButton("ȸ�� ����");
		btnupdate.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnupdate.setBounds(173, 537, 133, 49);
		frame.getContentPane().add(btnupdate);

		btndelete = new JButton("ȸ�� ����");
		btndelete.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btndelete.setBounds(334, 537, 133, 49);
		frame.getContentPane().add(btndelete);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "�̸�", "���̵�" }));
		comboBox.setBounds(12, 98, 73, 23);
		frame.getContentPane().add(comboBox);
		comboBox.getSelectedItem().toString();
		listAll();
		Clicked();

		// ��ư Ŭ���� �˻�(���� �˻� �� ��ü ��� ���)
		btnsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.remove(sp);
				String sh = comboBox.getSelectedItem().toString();
				if (sh.equals("���̵�")) {
					if (tfsearch.getText().equals("")) {
						Enabled();
						listAll();
						Clicked();

					} else if (!(tfsearch.getText().equals(""))) {
						Enabled();
						listselet(tfsearch.getText());
						Clicked();

					}
				}else if(sh.equals("�̸�")) {
					if (tfsearch.getText().equals("")) {
						Enabled();
						listAll();
						Clicked();

					} else if (!(tfsearch.getText().equals(""))) {
						Enabled();
						listselet(tfsearch.getText());
						Clicked();

					}
					
				}
			}

		});

		// ȸ�� ��� �ϱ� ��ư ���
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
				rbtngender1.setEnabled(true);
				tfinid.setText("");
				tfinpwd.setText("");
				tfinname.setText("");
				tfinbirth.setText("");
				tfintel.setText("");
				tfinemail.setText("");

				btnok.setEnabled(true);
				btnreset.setEnabled(true);
				btncancel.setEnabled(true);
				btnupdate.setEnabled(false);
				btndelete.setEnabled(false);

			}
		});

		// ȸ�� ���� �ϱ� ��ư ���
		btnupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (tfinid.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "�����Ϸ��� ������ �����ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					isupdate = true;
					tfinid.setEditable(true);
					tfinpwd.setEditable(true);
					tfinname.setEditable(true);
					tfinbirth.setEditable(true);
					tfintel.setEditable(true);
					tfinemail.setEditable(true);
					rbtngender.setEnabled(true);
					rbtngender1.setEnabled(true);

					btnok.setEnabled(true);
					btnreset.setEnabled(true);
					btncancel.setEnabled(true);
					btninsert.setEnabled(false);
					btndelete.setEnabled(false);
				}
			}
		});
		// ���� ����
		btndelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BookDAO bdao = new BookDAO();
				if (tfinid.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���� �Ϸ��� ȸ�� �����ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					int var = JOptionPane.showConfirmDialog(frame, "'" + title() + "'" + " ȸ�� ���� �Ͻðڽ��ϱ�?",
							"Information", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);

					if (var == 0) {
						int result = bdao.deleteBook(jtitle);
						if (result == 1) {
							JOptionPane.showMessageDialog(getContentPane(), "���� ���� �Ϸ�", "Information",
									JOptionPane.INFORMATION_MESSAGE);
							panel.remove(sp);
							listAll();
						} else {
							JOptionPane.showMessageDialog(getContentPane(), "�������� ������ ���� �Ұ�", "Information",
									JOptionPane.INFORMATION_MESSAGE);
						}

					}

				}
			}
		});

		// å ������ Ȯ�� ��ư
		btnok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberDAO md = new MemberDAO();
				MemberVo mv = new MemberVo();
				Effectiveness etv = new Effectiveness();
				String publication = tfintel.getText();
				String purchase = tfinemail.getText();
				
				if (tfinid.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���̵� �Է��ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (tfinpwd.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���ڸ� �Է��ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfinname.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���ǻ縦 �Է��ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfinbirth.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "�帣�� �Է��ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (publication.length() != 0 && etv.isDate(publication) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "�����Ͽ� �ùٸ� ��¥ ������ �Է��ϼ���\n ��) yyyy-MM-dd",
							"Information", JOptionPane.INFORMATION_MESSAGE);
				} else if (purchase.length() != 0 && etv.isDate(purchase) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "�����Ͽ� �ùٸ� ��¥ ������ �Է��ϼ���\n ��) yyyy-MM-dd",
							"Information", JOptionPane.INFORMATION_MESSAGE);

				}else if (isinsert) {
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

					} else {
						isinsert = true;
						JOptionPane.showMessageDialog(getContentPane(), "�̹� ��ϵ� ȸ���Դϴ�.", "Information",
								JOptionPane.INFORMATION_MESSAGE);
					}

				} else if (isupdate) {
					mv.setId(tfinid.getText());
					mv.setPwd(tfinpwd.getText());
					mv.setName(tfinname.getText());
					mv.setBirth(tfinbirth.getText());
					mv.setTel(tfintel.getText());
					mv.setEmail(tfinemail.getText());
					mv.setAmount(tfinamount.getText());
					mv.setChtitle((String) infolist[0][0]);
					isinsert = false;
					int result = bdao.updateData(bvo);
					if (result == 1) {
						memberinfoSet();
						btninsert.setEnabled(true);
						btnupdate.setEnabled(true);
						btndelete.setEnabled(true);

					}

				} else {

					JOptionPane.showMessageDialog(getContentPane(), "���� ��� ����", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				}
			}

		});

		// ��� ��ư ��� å ����panel ��� �ؽ�Ʈ �ʵ� �� ��ư ��Ȱ��ȭ
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
				rbtngender1.setEnabled(false);
				btnok.setEnabled(false);
				btnreset.setEnabled(false);
				btncancel.setEnabled(false);

				btninsert.setEnabled(true);
				btnupdate.setEnabled(true);
				btndelete.setEnabled(true);
			}
		});

		// �ʱ�ȭ ��ư
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
		// �ڷ� ���� ��ư ���
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
		String[] header = { "ID", "�̸�", "�������", "��ȭ��ȣ", "�̸���", "����" };
		result = ams.memberAll();
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setToolTipText("");
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1084, 400);
		sp.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
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
		String[] header = { "ID", "�̸�", "�������", "��ȭ��ȣ", "�̸���", "����" };
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1135, 400);
		sp.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
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
		String[] header = { "ID", "�̸�", "�������", "��ȭ��ȣ", "�̸���", "����" };
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		sp = new JScrollPane(table);
		sp.setBounds(0, 0, 1135, 400);
		sp.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		panel.add(sp);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(result, header) {
			public boolean isCellEditable(int row, int column) {

				return false;
			}

		});
	}

	// jtable �� ���� �� ���� ���� ������ �������� ���
	public String title() {

		int a = table.getSelectedRow();
		int b = table.getSelectedColumn();
		jtitle = (String) table.getValueAt(a, 0);
		return jtitle;
	}

	// ���� �ű� or ���� �� å ������ ��Ȱ��ȭ
	public void memberinfoSet() {
		JOptionPane.showMessageDialog(getContentPane(), "���� ��� �Ϸ�", "Information", JOptionPane.INFORMATION_MESSAGE);
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

	// ���콺 Ŭ�� �޼ҵ�
	public void Clicked() {
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (e.getClickCount() == 1) {
					String tname = title();
					AdminMemberSearch ams = new AdminMemberSearch();
					infolist = ams.idSelect(tname);
					tfinid.setText((String) infolist[0][0]);
//					tfinpwd.setText((String) infolist[0][1]);
					tfinname.setText((String) infolist[0][1]);
					tfinbirth.setText((String) infolist[0][2]);
					tfintel.setText((String) infolist[0][3]);
					tfinemail.setText((String) infolist[0][4]);
					if(((String) infolist[0][5]).equals("��")) {
						rbtngender.setSelected(true);
						rbtngender1.setSelected(false);
					}else if(((String) infolist[0][5]).equals("��")) {
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