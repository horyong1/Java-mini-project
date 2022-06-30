package project1st;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Library extends JFrame implements ActionListener {

	private JPanel contentPane,bottompanel,leftpanel,center,pid,pname,pphone,padd,pcom;
	private JLabel label,id,name,phone,address,company;
	private JButton add,delete,update,clear,all,sbutton;
	private JTextField tfid,tfname,tfphone,tfaddress,tfcompany,tfsearch;
	private JComboBox combo;
	private JScrollPane sp;
	private JTable table;
	private DefaultTableModel model;
	private String items[] = {"�̸�", "�ּ�","ȸ��"};
	private Vector outer,title,noresult,msg ;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	
	
	
	public Library() {
		makeGui();
	
	}
	
	public void makeGui() {
		JFrame frame = new JFrame("table");
		JPanel panel = new JPanel();
	
		String [] headings = new String[] {"Id", "Name","Tel","Email","Birth","Gender"};
		Object[][] data = new Object[][] {
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			{"1","Daniel","131321","asd@naver.com", "3132214","��"},
			{"2","Daniel","131321","asd@naver.com", "3132214","��"},
			{"3","Daniel","131321","asd@naver.com", "3132214","��"},
			
		};
		panel.setLayout(null);
		JTable table = new JTable(data,headings);
		table.setPreferredScrollableViewportSize(new Dimension(400, 300));
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		
		table.setModel(new DefaultTableModel(data,headings) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	       
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(287, 97, 455, 328);
		panel.add(scrollPane);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		setTitle("\uB3C4\uC11C\uAD00 \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		label = new JLabel("Address Book",JLabel.CENTER);
//		
//		pid = new JPanel();
//		id = new JLabel(" ID : ",JLabel.CENTER);
//		tfid = new JTextField(15);
//		pid.add(id);
//		pid.add(tfid);
//		
//		pname = new JPanel();
//		name = new JLabel("�̸� : ");
//		tfname = new JTextField(15);
//		pname.add(name);
//		pname.add(tfname);
//		
//		pphone = new JPanel();
//		phone = new JLabel("��ȭ : ");
//		tfphone = new JTextField(15);
//		pphone.add(phone);
//		pphone.add(tfphone);
//		
//		padd = new JPanel();
//		address = new JLabel("�ּ� : ");
//		tfaddress = new JTextField(15);
//		padd.add(address);
//		padd.add(tfaddress);
//		
//		pcom = new JPanel();
//		pcom.setForeground(Color.BLACK);
//		FlowLayout flowLayout = (FlowLayout) pcom.getLayout();
//		company = new JLabel("ȸ�� : ");
//		tfcompany = new JTextField(15);
//		pcom.add(company);
//		pcom.add(tfcompany);
//		
//		leftpanel = new JPanel();
//		leftpanel.setLayout(new GridLayout(5,1));
//		leftpanel.add(pid);
//		leftpanel.add(pname);
//		leftpanel.add(pphone);
//		leftpanel.add(padd);
//		leftpanel.add(pcom);
//		
//		add = new JButton("�߰�");
//		add.addActionListener(this);
//		delete = new JButton("����");
//		delete.addActionListener(this);
//		update = new JButton("����");
//		update.addActionListener(this);
//		
//		combo = new JComboBox(items);
//		
//		tfsearch = new JTextField(15);
//		tfsearch.addActionListener(this);
//		
//		sbutton = new JButton("�˻�");
//		sbutton.addActionListener(this);
//		
//		clear = new JButton("�����");
//		clear.addActionListener(this);
//		all = new JButton("��ü����");
//		all.addActionListener(this);
//		
//		bottompanel = new JPanel();
//		bottompanel.add(add);
//		bottompanel.add(delete);
//		bottompanel.add(update);
//		bottompanel.add(combo);
//		bottompanel.add(tfsearch);
//		bottompanel.add(sbutton);
//		bottompanel.add(clear);
//		bottompanel.add(all);
//		
		
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
