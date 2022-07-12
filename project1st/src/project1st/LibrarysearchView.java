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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Button;
import java.awt.Font;

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
	private Button btnsearch;
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
		//booksearchGui();
	}

	public void booksearchGui() {
		
		Dimension dim = new Dimension(800, 650);
		frame = new JFrame("������ ���� ���α׷�");
		BookDAO bd = new BookDAO();
		BookSearchList bsl = new BookSearchList();

		frame.setLocation(200, 200);
		frame.setPreferredSize(dim);
		frame.getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBounds(0, 131, 784, 400);
		frame.getContentPane().add(panel);
		frame.pack();
		frame.setVisible(true);

		tfsearch = new JTextField();
		tfsearch.setBounds(80, 100, 147, 21);
		frame.getContentPane().add(tfsearch);
		tfsearch.setColumns(10);
		tfsearch.setText("");
		

		lbsearch = new JLabel("���� ���� : ");
		lbsearch.setBounds(12, 103, 73, 15);
		frame.getContentPane().add(lbsearch);

		btnsearch = new Button("�˻�");
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
					result = null;
					result = bsl.resultAll();
					String[] header = { "���� ����", "����", "���ǻ�", "�帣", "������" };
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
					title = tfsearch.getText();
					System.out.println(title);
					result = null;
					result = bsl.resultTitle(title);
					String[] header = { "���� ����", "����", "���ǻ�", "�帣", "������" };
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

		String[] header = { "���� ����", "����", "���ǻ�", "�帣", "������" };
		result = bsl.resultAll();
		model = new DefaultTableModel(result, header);
		panel.setLayout(null);
		table = new JTable(model);
		sp = new JScrollPane(table);
		sp.setBounds(12, 0, 760, 390);
		panel.add(sp);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(new DefaultTableModel(result, header) {
			public boolean isCellEditable(int row, int column) {

				return false;
			}

		});
		
		Clicked();
		
		//���� �ϱ� ��ư ��� 
		Button btncheckout = new Button("�����ϱ�");
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
					CheckOut co = new CheckOut();
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
		Button btnback = new Button("�ڷΰ���");
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
	
	//��ü �˻� �� ArrayList�� list 2���� �迭�� ��ȯ
//	public Object[][] resultAll() {
//		BookDAO bd = new BookDAO();
//		Object[][] list;
//
//		data = bd.selectAll();
//		list = new Object[data.size()][5];
//
//		System.out.println(data);
//
//		for (int i = 0; i < data.size(); i++) {
//			for (int j = 0; j < 5; j++) {
//				list[i][j] = data.get(i).getTitle();
//				list[i][++j] = data.get(i).getAuthor();
//				list[i][++j] = data.get(i).getPublisher();
//				list[i][++j] = data.get(i).getGenre();
//				list[i][++j] = data.get(i).getPublication_date();
//			}
//		}
//		return list;
//
//	}
	
	//���� ���� �˻� �� ArrayList�� list 2���� �迭�� ��ȯ
//	public Object[][] resultTitle() {
//		BookDAO bd = new BookDAO();
//		Object[][] list;
//
//		title = tfsearch.getText();
//
//		data = bd.selectTitle(title);
//		list = new Object[data.size()][5];
//
//		System.out.println(data);
//
//		for (int i = 0; i < data.size(); i++) {
//			for (int j = 0; j < 5; j++) {
//				list[i][j] = data.get(i).getTitle();
//				list[i][++j] = data.get(i).getAuthor();
//				list[i][++j] = data.get(i).getPublisher();
//				list[i][++j] = data.get(i).getGenre();
//				list[i][++j] = data.get(i).getPublication_date();
//			}
//		}
//		return list;
//
//	}
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
