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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;

public class Library extends JFrame implements ActionListener {

	private JPanel contentPane,bottompanel,leftpanel,center,pid,pname,pphone,padd,pcom;
	private JLabel label,id,name,phone,address,company;
	private JButton add,delete,update,clear,all,sbutton;
	private JTextField tfid,tfname,tfphone,tfaddress,tfcompany,tfsearch;
	private JComboBox combo;
	private JScrollPane sp;
	private JTable table;
	private DefaultTableModel model;
	private String items[] = {"이름", "주소","회사"};
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
		JPanel panel1 = new JPanel();
		panel1.setBackground(SystemColor.menu);
		JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
		tab.setFont(new Font("Gulim", Font.PLAIN, 12));
		tab.setForeground(new Color(0, 0, 0));
		tab.setBackground(new Color(192, 192, 192));
		tab.setBounds(58, 29, 684, 475);
		
		String [] headings = new String[] {"도서 제목", "Name","Tel","Email","Birth","Gender"};
		Object[][] data = new Object[][] {
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			{"1","Daniel","131321","asd@naver.com", "3132214","남"},
			{"2","Daniel","131321","asd@naver.com", "3132214","남"},
			{"3","Daniel","131321","asd@naver.com", "3132214","남"},
			
		};
		panel1.setLayout(null);
		
		JTable table = new JTable(data,headings);
		table.setPreferredScrollableViewportSize(new Dimension(400, 300));
		table.setFillsViewportHeight(true);
		table.getTableHeader().setReorderingAllowed(false);
		table.getTableHeader().setResizingAllowed(false);
		frame.getContentPane().setLayout(null);
		
		
		table.setModel(new DefaultTableModel(data,headings) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
	       
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 67, 634, 403);
		panel1.add(scrollPane);
		
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		
		
		tab.addTab("검색",panel1);
		tab.addTab("대출", panel2);
		tab.addTab("반납", panel3);
		

		frame.getContentPane().add(tab);
		frame.setVisible(true);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
