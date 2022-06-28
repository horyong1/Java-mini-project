package project1st;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Color;

public class Signupview extends JFrame {

	private JPanel contentPane;
	private JTextField tfid;
	private JPasswordField fdpwd;
	private JLabel lbname;
	private JTextField tfname;
	private JLabel lbtel;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField tfymd;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Signupview() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lbtitle = new JLabel("\uD68C\uC6D0 \uAC00\uC785");
		lbtitle.setForeground(Color.WHITE);
		lbtitle.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 20));
		
		JLabel lbid = new JLabel("\uC544\uC774\uB514");
		lbid.setForeground(Color.WHITE);
		lbid.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		
		tfid = new JTextField();
		tfid.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		tfid.setColumns(10);
		
		JLabel lbpwd = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbpwd.setForeground(Color.WHITE);
		lbpwd.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		
		fdpwd = new JPasswordField();
		
		lbname = new JLabel("\uC774\uB984");
		lbname.setForeground(Color.WHITE);
		lbname.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		
		tfname = new JTextField();
		tfname.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		tfname.setColumns(10);
		
		lbtel = new JLabel("\uC804\uD654\uBC88\uD638");
		lbtel.setForeground(Color.WHITE);
		lbtel.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		
		textField = new JTextField();
		textField.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		textField.setColumns(10);
		
		JRadioButton rbtngender1 = new JRadioButton("\uB0A8\uC790");
		rbtngender1.setForeground(Color.WHITE);
		rbtngender1.setBackground(Color.GRAY);
		rbtngender1.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		
		JRadioButton rbtngender2 = new JRadioButton("\uC5EC\uC790");
		rbtngender2.setForeground(Color.WHITE);
		rbtngender2.setBackground(Color.GRAY);
		rbtngender2.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		
		JLabel lblNewLabel = new JLabel("\uC131\uBCC4");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		
		JLabel lbemail = new JLabel("\uC774\uBA54\uC77C");
		lbemail.setForeground(Color.WHITE);
		lbemail.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JButton btnok = new JButton("\uD655\uC778");
		
		JButton btncancel = new JButton("\uCDE8\uC18C");
		
		JLabel lbpwdck = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lbpwdck.setForeground(Color.WHITE);
		lbpwdck.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		
		passwordField = new JPasswordField();
		
		JLabel lbymd = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lbymd.setForeground(Color.WHITE);
		lbymd.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		
		tfymd = new JTextField();
		tfymd.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		tfymd.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(171)
					.addComponent(lbtitle)
					.addContainerGap(171, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(75, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lbid)
								.addComponent(lbpwd)
								.addComponent(lbpwdck)
								.addComponent(lbname)
								.addComponent(lbtel)
								.addComponent(lbemail)
								.addComponent(lbymd)
								.addComponent(lblNewLabel))
							.addGap(51))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnok)
							.addGap(27)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rbtngender1)
							.addGap(18)
							.addComponent(rbtngender2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
							.addGap(106))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(44)
							.addComponent(btncancel)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(textField_1, Alignment.LEADING)
								.addComponent(textField, Alignment.LEADING)
								.addComponent(tfname, Alignment.LEADING)
								.addComponent(passwordField, Alignment.LEADING)
								.addComponent(fdpwd, Alignment.LEADING)
								.addComponent(tfid, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
								.addComponent(tfymd, Alignment.LEADING))
							.addContainerGap())))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lbtitle)
							.addGap(86))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbid)
								.addComponent(tfid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbpwd, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(fdpwd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(2)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbpwdck)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbname)
						.addComponent(tfname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbtel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbemail)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbymd)
						.addComponent(tfymd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(rbtngender1)
						.addComponent(rbtngender2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnok, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btncancel))
					.addGap(67))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(339)
					.addComponent(lblNewLabel)
					.addContainerGap(143, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		btnok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Loginview();
			}
		});
		
		btncancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Loginview();
			}
		});
		
		
		
		
		
		setVisible(true);
		
	}
	
	
	
	 
}
