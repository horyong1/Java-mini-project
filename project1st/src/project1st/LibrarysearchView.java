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
		frame = new JFrame("������ ���� ���α׷�");
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
		

		lbsearch = new JLabel("���� ���� : ");
		lbsearch.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		lbsearch.setBounds(12, 103, 73, 15);
		frame.getContentPane().add(lbsearch);

		btnsearch = new JButton("�˻�");
		btnsearch.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnsearch.setBounds(244, 100, 76, 23);
		frame.getContentPane().add(btnsearch);
		
		lblNewLabel = new JLabel("���� �˻�");
		lblNewLabel.setFont(new Font("����", Font.BOLD, 30));
		lblNewLabel.setBounds(317, 29, 147, 49);
		frame.getContentPane().add(lblNewLabel);

		// ��ư Ŭ���� �˻�(���� �˻� �� ��ü ��� ���)
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
		
		//���� �ϱ� ��ư ��� 
		JButton btncheckout = new JButton("�����ϱ�");
		btncheckout.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btncheckout.setBounds(12, 537, 133, 49);
		frame.getContentPane().add(btncheckout);
		btncheckout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(jtitle==null||jtitle.length()==0) {
					JOptionPane.showMessageDialog(getContentPane(),"���� �Ϸ��� å�� �����ϼ���", "Infomation",
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
		
		//�ڷ� ���� ��ư ���
		JButton btnback = new JButton("�ڷΰ���");
		btnback.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
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
	
	
	//jtable �� ���� �� ���� ���� ������ �������� ���
	public String title() {
		
		int a = table.getSelectedRow();
		int b = table.getSelectedColumn();
		jtitle= (String) table.getValueAt(a, 0);
		return jtitle;
	}


	
	public void BookAllList() {
		
		BookSearchList bsl = new BookSearchList();
		String[] header = { "���� ����", "����", "���ǻ�", "�帣", "������" };
		result = bsl.resultAll();
		model = new DefaultTableModel(result, header);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		table = new JTable(model);
		table.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		table.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
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
		String[] header = { "���� ����", "����", "���ǻ�", "�帣", "������" };
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
	//���콺 Ŭ�� �޼ҵ�
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
