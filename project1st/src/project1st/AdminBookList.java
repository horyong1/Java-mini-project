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
		frame = new JFrame("������ ���� ���α׷�");
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

		lbsearch = new JLabel("���� ���� : ");
		lbsearch.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbsearch.setBounds(12, 102, 73, 15);
		frame.getContentPane().add(lbsearch);

		btnsearch = new JButton("�˻�");
		btnsearch.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnsearch.setBounds(244, 99, 76, 23);
		frame.getContentPane().add(btnsearch);

		lblNewLabel = new JLabel("���� ����");
		lblNewLabel.setFont(new Font("���ʷҵ���", Font.BOLD, 30));
		lblNewLabel.setBounds(662, 32, 147, 49);
		frame.getContentPane().add(lblNewLabel);

		btninsert = new JButton("���� ���");
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

		panel_1.setBounds(1159, 131, 313, 400);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);

		lbintitle = new JLabel("���� ����");
		lbintitle.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbintitle.setBounds(66, 50, 57, 15);
		panel_1.add(lbintitle);

		tfintitle = new JTextField();
		tfintitle.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfintitle.setEditable(false);
		tfintitle.setBounds(135, 48, 116, 21);
		panel_1.add(tfintitle);
		tfintitle.setColumns(10);

		lbinauthor = new JLabel("����");
		lbinauthor.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbinauthor.setBounds(95, 90, 35, 15);
		panel_1.add(lbinauthor);

		tfinauthor = new JTextField();
		tfinauthor.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfinauthor.setEditable(false);
		tfinauthor.setColumns(10);
		tfinauthor.setBounds(135, 88, 116, 21);
		panel_1.add(tfinauthor);

		lbinpublisher = new JLabel("���ǻ�");
		lbinpublisher.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbinpublisher.setBounds(83, 128, 57, 15);
		panel_1.add(lbinpublisher);

		tfinpublisher = new JTextField();
		tfinpublisher.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfinpublisher.setEditable(false);
		tfinpublisher.setColumns(10);
		tfinpublisher.setBounds(135, 126, 116, 21);
		panel_1.add(tfinpublisher);

		lbingenre = new JLabel("�帣");
		lbingenre.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbingenre.setBounds(95, 168, 57, 15);
		panel_1.add(lbingenre);

		tfingenre = new JTextField();
		tfingenre.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfingenre.setEditable(false);
		tfingenre.setColumns(10);
		tfingenre.setBounds(135, 166, 116, 21);
		panel_1.add(tfingenre);

		lbpublication_date = new JLabel("������");
		lbpublication_date.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbpublication_date.setBounds(83, 205, 57, 15);
		panel_1.add(lbpublication_date);

		tfinpublication_date = new JTextField();
		tfinpublication_date.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfinpublication_date.setEditable(false);
		tfinpublication_date.setColumns(10);
		tfinpublication_date.setBounds(135, 203, 116, 21);
		panel_1.add(tfinpublication_date);

		lbinpurchase_date = new JLabel("������");
		lbinpurchase_date.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbinpurchase_date.setBounds(83, 246, 57, 15);
		panel_1.add(lbinpurchase_date);

		tfinpurchase_date = new JTextField();
		tfinpurchase_date.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfinpurchase_date.setEditable(false);
		tfinpurchase_date.setColumns(10);
		tfinpurchase_date.setBounds(135, 244, 116, 21);
		panel_1.add(tfinpurchase_date);

		lbamount = new JLabel("�ݾ�");
		lbamount.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbamount.setBounds(95, 283, 57, 15);
		panel_1.add(lbamount);

		tfinamount = new JTextField();
		tfinamount.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfinamount.setEditable(false);
		tfinamount.setColumns(10);
		tfinamount.setBounds(135, 281, 116, 21);
		panel_1.add(tfinamount);

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

		btncancel = new JButton("\uCDE8\uC18C");
		btncancel.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btncancel.setEnabled(false);
		btncancel.setBounds(119, 356, 68, 23);
		panel_1.add(btncancel);
		
		JLabel lbincheckout = new JLabel("���� ����");
		lbincheckout.setFont(new Font("���ʷҵ���", Font.BOLD, 12));
		lbincheckout.setBounds(73, 317, 57, 15);
		panel_1.add(lbincheckout);
		
		tfincheckout = new JTextField();
		tfincheckout.setEditable(false);
		tfincheckout.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		tfincheckout.setColumns(10);
		tfincheckout.setBounds(135, 313, 116, 21);
		panel_1.add(tfincheckout);

		JLabel lblNewLabel_1 = new JLabel("���� ����");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("���ʷҵ���", Font.BOLD, 14));
		lblNewLabel_1.setBounds(1160, 108, 73, 18);
		frame.getContentPane().add(lblNewLabel_1);

		btnupdate = new JButton("���� ����");
		btnupdate.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnupdate.setBounds(173, 537, 133, 49);
		frame.getContentPane().add(btnupdate);

		btndelete = new JButton("���� ����");
		btndelete.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btndelete.setBounds(334, 537, 133, 49);
		frame.getContentPane().add(btndelete);

		listAll();
		Clicked();

		// ��ư Ŭ���� �˻�(���� �˻� �� ��ü ��� ���)
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

		// ���� ��� �ϱ� ��ư ���
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

		// ���� ���� �ϱ� ��ư ���
		btnupdate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (tfintitle.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "�����Ϸ��� ������ �����ϼ���", "Information",
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
		//���� ���� 
		btndelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BookDAO bdao = new BookDAO();
				if (tfintitle.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���� �Ϸ��� ������ �����ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else {

					int var = JOptionPane.showConfirmDialog(frame, "'" + title() + "'" + " å�� ���� �Ͻðڽ��ϱ�?", "Information",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null);

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
				BookDAO bdao = new BookDAO();
				BookVo bvo = new BookVo();
				Effectiveness etv  = new Effectiveness();
				String publication = tfinpublication_date.getText();
				String purchase = tfinpurchase_date.getText();
				String amount = tfinamount.getText();
				if (tfintitle.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���� �̸��� �Է��ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else if (tfinauthor.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���ڸ� �Է��ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfinpublisher.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���ǻ縦 �Է��ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfingenre.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "�帣�� �Է��ϼ���", "Information",
							JOptionPane.INFORMATION_MESSAGE);

				} else if(publication.length()!=0&&etv.isDate(publication)==false){
					JOptionPane.showMessageDialog(getContentPane(), "�����Ͽ� �ùٸ� ��¥ ������ �Է��ϼ���\n ��) yyyy-MM-dd", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} else if(purchase.length()!=0&&etv.isDate(purchase)==false) {
					JOptionPane.showMessageDialog(getContentPane(), "�����Ͽ� �ùٸ� ��¥ ������ �Է��ϼ���\n ��) yyyy-MM-dd", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					
				} else if(amount.length()!=0&&etv.isNumeric(amount)==false) {
					JOptionPane.showMessageDialog(getContentPane(), "�ݾ��� ���ڸ� �Է��ϼ���", "Information",
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
						JOptionPane.showMessageDialog(getContentPane(), "�̹� ��ϵ� �����Դϴ�.", "Information",
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

		// �ʱ�ȭ ��ư
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

	public void listAll() {

		BookSearchList bsl = new BookSearchList();
		String[] header = { "���� ����", "����", "���ǻ�", "�帣", "������", "������", "�ݾ�" };
		result = bsl.adminAll();
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		table.setToolTipText("");
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

	public void listselet(String title) {

		BookSearchList bsl = new BookSearchList();
		title = tfsearch.getText();
		System.out.println(title);
		result = null;
		result = bsl.adminTitle(title);
		String[] header = { "���� ����", "����", "���ǻ�", "�帣", "������", "������", "�ݾ�" };
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
	public void bookinfoSet() {
		JOptionPane.showMessageDialog(getContentPane(), "���� ��� �Ϸ�", "Information", JOptionPane.INFORMATION_MESSAGE);
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

	// ���콺 Ŭ�� �޼ҵ�
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
						tfincheckout.setText("������");
					} else if (num == 0) {
						tfincheckout.setText("���Ⱑ��");
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
