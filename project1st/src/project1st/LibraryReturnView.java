package project1st;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class LibraryReturnView extends JFrame {

	private JLabel lbsearch = null;
	private JLabel lbauthor = null;
	private JLabel lbpublisher = null;
	private JLabel lbgenre = null;
	private JLabel lbpublication_date = null;
	private JLabel lbtitle;
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
	private String jtitle;
	private String jid;
	private String []arr = new String[2];
	
	public LibraryReturnView() {
		//mainGui();
	}
	
	public void  mainGui() {
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
		
		lbtitle = new JLabel("���� �ݳ�");
		lbtitle.setFont(new Font("����", Font.BOLD, 30));
		lbtitle.setBounds(317, 29, 147, 49);
		frame.getContentPane().add(lbtitle);
		
		Button btnreturn = new Button("�ݳ��ϱ�");
		btnreturn.setBounds(12, 537, 133, 49);
		frame.getContentPane().add(btnreturn);
		
		Button btnback = new Button("�ڷΰ���");
		btnback.setBounds(674, 537, 100, 49);
		frame.getContentPane().add(btnback);
		
		btnreturn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jtitle==null||jtitle.length()==0||jid==null||jid.length()==0) {
					JOptionPane.showMessageDialog(getContentPane(),"�ݳ� �Ϸ��� å�� �����ϼ���", "Infomation",
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					int var = JOptionPane.showConfirmDialog(frame, jtitle+" å�� �ݳ� �Ͻðڽ��ϱ�?", "Infomation", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null);
					if(var==0) {
						int result = bd.deleteData(arr[0], arr[1]);
						if(result==1) {
							JOptionPane.showMessageDialog(getContentPane(),"�ݳ��� �Ϸ� �Ǿ����ϴ�.", "Infomation",
									JOptionPane.INFORMATION_MESSAGE);
							
						}
					}
					
					
				}
				
			}
			
		});
		
		
		btnback.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SelectView sv = new SelectView();
				sv.setId(id);
				sv.setPwd(pwd);
				frame.dispose();
				sv.selectview();
			}
			
		});
		
		

		// ��ư Ŭ���� �˻�(���� �˻� �� ��ü ��� ���)
		btnsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.remove(sp);
				if (tfsearch.getText().equals("")) {
					result = null;
					result = bsl.returnAll(id);
					String[] header = { "���̵�" ,"���� ����", "����", "���ǻ�", "������", "�ݳ���" };
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
					String[] header = {"���̵�","���� ����", "����", "���ǻ�", "������", "�ݳ���" };
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

		String[] header = { "���̵�","���� ����", "����", "���ǻ�", "������", "�ݳ���" };
		result = bsl.returnAll(id);
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
		
		frame.setVisible(true);
	}
	
	

		//jtable �� ���� �� ���� ���� ������ �������� ���
		public String[] title() {
			int a = table.getSelectedRow();
			int b = table.getSelectedColumn();
			jid = (String) table.getValueAt(a,0); 
			jtitle= (String) table.getValueAt(a, 1);
			arr[0]=jid;
			arr[1]=jtitle;
			
			return arr;
		}
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
