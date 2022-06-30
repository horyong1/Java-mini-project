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


public class Loginview extends JFrame {
	private JTextField tfid;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Loginview() {
		setTitle("\uB3C4\uC11C\uAD00 \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 340, 230);
		getContentPane().setLayout(null);
		
		JLabel title = new JLabel("\uB85C\uADF8\uC778");
		title.setFont(new Font("����", Font.BOLD, 22));
		title.setBounds(119, 10, 68, 26);
		getContentPane().add(title);
		
		JLabel lbid = new JLabel("\uC544\uC774\uB514");
		lbid.setBounds(35, 79, 45, 15);
		getContentPane().add(lbid);
		
		tfid = new JTextField();
		tfid.setBounds(92, 76, 116, 21);
		getContentPane().add(tfid);
		tfid.setColumns(10);
		
		JLabel lbpwd = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lbpwd.setBounds(24, 118, 56, 15);
		getContentPane().add(lbpwd);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(92, 115, 116, 21);
		getContentPane().add(passwordField);
		
		JButton btnlogin = new JButton("\uB85C\uADF8\uC778");
		btnlogin.setBounds(220, 70, 92, 32);
		getContentPane().add(btnlogin);
		
		JButton btnsignup = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnsignup.setBounds(220, 114, 92, 23);
		getContentPane().add(btnsignup);
		
		JRadioButton rbtnp = new JRadioButton("\uAC1C\uC778");
		rbtnp.setSelected(true);
		rbtnp.setBounds(71, 42, 56, 23);
		getContentPane().add(rbtnp);
		
		JRadioButton rbtna = new JRadioButton("\uAD00\uB9AC\uC790");
		rbtna.setBounds(129, 42, 70, 23);
		getContentPane().add(rbtna);
		setVisible(true);
		
		ButtonGroup jg = new ButtonGroup();
		jg.add(rbtna);
		jg.add(rbtnp);
		
		//�α��� ��ư Ŭ�� �̺�Ʈ
		btnlogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String adminId = "admin"; 
				String adminPwd = "admin"; 
				MemberVo mbv = new MemberVo();
				MemberDAO mbd = new MemberDAO();
				System.out.println(rbtna.getText());
				System.out.println(rbtnp.getText());
				
				if((tfid.getText().equals(adminId) && passwordField.getText().equals(adminPwd))
						&& (rbtna.isSelected()==true)) {
					JOptionPane.showMessageDialog(getContentPane(),"������ �α��� �Ϸ�", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
					dispose();
					new Library();
					
				}else if((tfid.getText()==adminId && passwordField.getText()==adminPwd)
						&& (rbtna.isSelected()==false)) {
					JOptionPane.showMessageDialog(getContentPane(),"���̵�� ��й�ȣ Ȯ���ϼ���1", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if((mbd.LoginData(tfid.getText(),passwordField.getText())==1)
						&& (rbtnp.isSelected()==true)) {
					JOptionPane.showMessageDialog(getContentPane(),"�α��� �Ϸ�", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
					dispose();
					new Library();
				
				}else {
					JOptionPane.showMessageDialog(getContentPane(),"���̵�� ��й�ȣ�� Ȯ���ϼ���", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
				
				
			}
		});
		
		
		
		
		
		
		btnsignup.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				new Signupview();
			}
		});
		
		setVisible(true);

	}
}
