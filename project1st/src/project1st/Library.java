package project1st;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
import java.awt.Button;
import java.awt.TextField;
import java.awt.Label;

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
	private Object [][] data;
	
	
	
	public Library() {
		makeGui();
	
	}
	
	public void makeGui() {
		JFrame frame = 
				new JFrame("table");
		JPanel panel1 = new JPanel();
		panel1.setBackground(SystemColor.menu);
		JTabbedPane tab = new JTabbedPane(JTabbedPane.LEFT);
		tab.setFont(new Font("Gulim", Font.PLAIN, 12));
		tab.setForeground(new Color(0, 0, 0));
		tab.setBackground(new Color(192, 192, 192));
		tab.setBounds(60, 50, 690, 475);
		
		String [] headings = new String[] {"도서 제목", "저자","장르","출판사","출판일"};
		BookVo bv = new BookVo();
		BookDAO bd = new BookDAO();
		
			data = new Object[][] {{bd.getList().get(0).getTitle()}};
		
//		bd.getList();
//		Object[][] data = new Object[][] {{bv.getTitle(),bv.getAuthor()
//			,bv.getGendre(),bv.getPublisher(),bv.getPublication_date()}};

//		for(int i = 0 ; i<data.length; i++) {
//			for(int j = 0; j<data.length;j++) {
//				data [i][j]= {{bv.getTitle(), bv.getAuthor(), bv.getGendre(),
//					bv.getPublisher(), bv.getPublication_date()}};
//
//				
//			}
//		}
	
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
		scrollPane.setBounds(0, 67, 639, 403);
		panel1.add(scrollPane);
		
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		
		
		
		tab.addTab("검색",panel1);
		
		Button btnsearch = new Button("\uAC80\uC0C9");
		btnsearch.setBounds(187, 26, 66, 23);
		panel1.add(btnsearch);
		
		TextField textField = new TextField();
		textField.setBounds(72, 26, 99, 23);
		panel1.add(textField);
		
		Label lbtitle = new Label("\uCC45 \uC774\uB984 :");
		lbtitle.setBounds(13, 26, 53, 23);
		panel1.add(lbtitle);
		tab.addTab("대출", panel2);
		tab.addTab("반납", panel3);
		

		frame.getContentPane().add(tab);
		
		Button btnWithdrawal = new Button("\uD68C\uC6D0 \uC218\uC815");
		btnWithdrawal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		btnWithdrawal.setBounds(668, 10, 76, 23);
		frame.getContentPane().add(btnWithdrawal);
		frame.setVisible(true);
		frame.setSize(800,600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
