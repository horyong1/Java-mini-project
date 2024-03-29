package project1st;



import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;


public class Loginview extends JFrame {
	private JTextField tfid;
	private JPasswordField  passwordField;
	private String id;
	private String pwd;
	/**
	 * Create the frame.
	 */
	public Loginview() {

//		mainView();

	}
	
	public void mainView() {		
	setTitle("\uB3C4\uC11C\uAD00 \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 354, 230);
	getContentPane().setLayout(null);
	
	JLabel title = new JLabel("\uB85C\uADF8\uC778");
	title.setFont(new Font("굴림", Font.BOLD, 22));
	title.setBounds(140, 10, 68, 26);
	getContentPane().add(title);
	
	JLabel lbid = new JLabel("\uC544\uC774\uB514");
	lbid.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
	lbid.setBounds(36, 89, 45, 15);
	getContentPane().add(lbid);
	
	tfid = new JTextField();
	tfid.setBounds(93, 86, 116, 21);
	getContentPane().add(tfid);
	tfid.setColumns(10);
	
	JLabel lbpwd = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
	lbpwd.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
	lbpwd.setBounds(24, 130, 56, 15);
	getContentPane().add(lbpwd);
	
	passwordField = new JPasswordField ();
	passwordField.setBounds(92, 127, 116, 21);
	getContentPane().add(passwordField);
	passwordField.setEchoChar('*');
	
	JRadioButton rbtnp = new JRadioButton("\uAC1C\uC778");
	rbtnp.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
	rbtnp.setSelected(true);
	rbtnp.setBounds(91, 42, 56, 23);
	getContentPane().add(rbtnp);
	
	JRadioButton rbtna = new JRadioButton("\uAD00\uB9AC\uC790");
	rbtna.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
	rbtna.setBounds(149, 42, 70, 23);
	getContentPane().add(rbtna);
	setVisible(true);
	
	ButtonGroup jg = new ButtonGroup();
	jg.add(rbtna);
	jg.add(rbtnp);
	
	JButton btnlogin = new JButton("\uB85C\uADF8\uC778");
	btnlogin.setBackground(UIManager.getColor("Button.background"));
	btnlogin.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
	btnlogin.setBounds(224, 72, 87, 48);
	getContentPane().add(btnlogin);
	
	JButton btnsignup = new JButton("\uD68C\uC6D0\uAC00\uC785");
	btnsignup.setBackground(UIManager.getColor("Button.background"));
	btnsignup.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
	btnsignup.setBounds(224, 126, 87, 23);
	getContentPane().add(btnsignup);
	
	btnlogin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String adminId = "admin"; 
			String adminPwd = "admin"; 
			MemberVo mbv = new MemberVo();
			MemberDAO mbd = new MemberDAO();
			id=tfid.getText();
			pwd=passwordField.getText();
			System.out.println(id+" "+pwd);
			System.out.println(rbtna.getText());
			System.out.println(rbtnp.getText());
			
			if((tfid.getText().equals(adminId) && passwordField.getText().equals(adminPwd))
					&& (rbtna.isSelected()==true)) {
				JOptionPane.showMessageDialog(getContentPane(),"관리자 로그인 완료", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				
				dispose();
				new AdminView().adminGui();
				
				
			}else if((tfid.getText()==adminId && passwordField.getText()==adminPwd)
					&& (rbtna.isSelected()==false)) {
				JOptionPane.showMessageDialog(getContentPane(),"아이디와 비밀번호 확인하세요1", "Message",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if((mbd.LoginData(tfid.getText(),passwordField.getText())==1)
					&& (rbtnp.isSelected()==true)) {
				JOptionPane.showMessageDialog(getContentPane(),"로그인 완료", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				SelectView sv = new SelectView();
				sv.setId(id);
				sv.setPwd(pwd);
				dispose();
				sv.selectview();
			}else {
				JOptionPane.showMessageDialog(getContentPane(),"아이디와 비밀번호를 확인하세요", "Message",
						JOptionPane.INFORMATION_MESSAGE);
				
			}
		}
	});
	
	
	btnsignup.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dispose();
			new Signupview().SignupViewGui();;
		}
	});;
	
	setLocation(700, 200);
	setVisible(true);
		
	}
	public String []idpwdlist(String id, String pwd) {
		String[] list = {this.id,this.pwd};
		return list;
	}
}
