package project1st;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
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

public class Signupview extends JFrame {
	private JFrame jf;
	private int result = 2;
	public Signupview() {
		//SignupViewGui();

	}

	public void SignupViewGui() {
		setTitle("도서관 관리 프로그램");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(null);
		setBackground(Color.DARK_GRAY);

		JButton btncancel = new JButton("취소");
		btncancel.setBounds(251, 401, 97, 23);
		getContentPane().add(btncancel);

		JLabel lbid = new JLabel("아이디");
		lbid.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbid.setBounds(112, 85, 48, 15);
		getContentPane().add(lbid);

		JLabel lbpwd = new JLabel("비밀번호");
		lbpwd.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbpwd.setBounds(100, 120, 58, 15);
		getContentPane().add(lbpwd);

		JLabel lbpwdck = new JLabel("비밀번호 확인");
		lbpwdck.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbpwdck.setBounds(73, 158, 87, 15);
		getContentPane().add(lbpwdck);

		JLabel lbname = new JLabel("이름");
		lbname.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbname.setBounds(124, 196, 36, 15);
		getContentPane().add(lbname);
		

		JLabel lbtel = new JLabel("전화번호");
		lbtel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbtel.setBounds(100, 268, 58, 15);
		getContentPane().add(lbtel);

		JLabel lbemail = new JLabel("이메일");
		lbemail.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbemail.setBounds(112, 303, 43, 15);
		getContentPane().add(lbemail);

		JRadioButton rbtngender1 = new JRadioButton("남");
		rbtngender1.setSelected(true);
		rbtngender1.setBounds(188, 330, 48, 23);
		getContentPane().add(rbtngender1);

		JRadioButton rbtngender2 = new JRadioButton("여");
		rbtngender2.setBounds(244, 330, 48, 23);
		getContentPane().add(rbtngender2);

		// 라디오 버튼 그룹 생성------------------
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtngender1);
		bg.add(rbtngender2);

		JLabel lbgender = new JLabel("성별");
		lbgender.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbgender.setBounds(124, 334, 36, 15);
		getContentPane().add(lbgender);

		JLabel lbtitle = new JLabel("회원가입");
		lbtitle.setFont(new Font("함초롬돋움", Font.BOLD, 25));
		lbtitle.setBounds(176, 21, 116, 41);
		getContentPane().add(lbtitle);

		JLabel lbbirth = new JLabel("생년월일");
		lbbirth.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbbirth.setBounds(100, 230, 58, 15);
		getContentPane().add(lbbirth);

		JTextField tfid = new JTextField();
		tfid.setBounds(176, 81, 116, 23);
		getContentPane().add(tfid);
		

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(176, 116, 116, 23);
		getContentPane().add(passwordField);
		passwordField.setEchoChar('*');

		JPasswordField passwordckField = new JPasswordField();
		passwordckField.setBounds(176, 154, 116, 23);
		getContentPane().add(passwordckField);
		passwordckField.setEchoChar('*');

		JTextField tfname = new JTextField();
		tfname.setBounds(176, 190, 116, 23);
		getContentPane().add(tfname);

		JTextField tfbirth = new JTextField();
		tfbirth.setBounds(176, 225, 116, 23);
		getContentPane().add(tfbirth);
		

		JTextField tftel = new JTextField();
		tftel.setBounds(176, 260, 116, 23);
		getContentPane().add(tftel);

		JTextField tfemail = new JTextField();
		tfemail.setBounds(176, 295, 116, 23);
		getContentPane().add(tfemail);

		JButton btnoverlap = new JButton("중복확인");
		btnoverlap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO mbd = new MemberDAO();
				result = mbd.idCheck(tfid.getText());
				
				if(tfid.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "아이디를 입력하세요", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					result = 2;
					
				}
				else if(result==1) {
					JOptionPane.showMessageDialog(getContentPane(), "중복된 아이디 입니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					result = 2;
				}else if(result==0) {
					JOptionPane.showMessageDialog(getContentPane(), "사용 가능한 아이디 입니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnoverlap.setBounds(308, 81, 81, 23);
		getContentPane().add(btnoverlap);
		
		
		JButton btnok = new JButton("확인");
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO mbd = new MemberDAO();
				MemberVo mbv = new MemberVo();
				Effectiveness ef = new Effectiveness();
				String pf = passwordField.getText();
				String pfk = passwordckField.getText();
				if (tfid.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "아이디를 입력하세요.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}else if(result==2){
					JOptionPane.showMessageDialog(getContentPane(), "아이디 중복체크를 확인하세요.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}else if (!(tfid.getText().length() >= 5 && tfid.getText().length() <= 15)) {
				
					JOptionPane.showMessageDialog(getContentPane(), "아이디 5~15자로 입력하세요.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "비밀번호를 입력하세요", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (!(passwordField.getText().length() >= 8 && passwordField.getText().length() <= 16)) {
					JOptionPane.showMessageDialog(getContentPane(), "비밀번호는 8~16자로 입력 가능합니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (passwordckField.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "비밀번호 확인을 입력하세요.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (!(pfk.equals(pf))) {
					JOptionPane.showMessageDialog(getContentPane(), "비밀번호가 다릅니다. 다시 확인 하세요 ", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfname.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "이름을 입력하세요 ", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (ef.isAlphaNumeric(tfname.getText()) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "이름은 한글과 영어만 입력 가능합니다.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfbirth.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "생년월일을 입력하세요", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (!(ef.isNumeric(tfbirth.getText()))
						|| !((tfbirth.getText().length() <= 6 && tfbirth.getText().length() > 0))) {
					JOptionPane.showMessageDialog(getContentPane(), "올바른 형식의 생년월일을 입력하세요\n  예) 091201", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}else if (tftel.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "전화번호를 입력하세요", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}else if(ef.isTel(tftel.getText()) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "올바른 형식의 전화번호를 입력하세요\n  예) 010-1111-2222", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if (tfemail.getText().length()!=0&&ef.isValidEmail(tfemail.getText()) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "올바른 형식의 이메일을 입력하세요\n  예) asdf@naver.com", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if(result==0){

					mbv.setId(tfid.getText());
					mbv.setPwd(passwordField.getText());
					mbv.setName(tfname.getText());
					mbv.setTel(tftel.getText());
					mbv.setEmail(tfemail.getText());
					mbv.setBirth(tfbirth.getText());
					if (rbtngender1.isSelected() == true) {
						mbv.setGender(rbtngender1.getText());

					} else if (rbtngender2.isSelected() == true) {
						mbv.setGender(rbtngender2.getText());
					}

					mbd.insertData(mbv);
					JOptionPane.showMessageDialog(getContentPane(), "회원 가입이 완료되었습니다!", "Message",
							JOptionPane.INFORMATION_MESSAGE);

					dispose();
					new Loginview().mainView();
				}

			}

		});
		btnok.setBounds(98, 401, 97, 23);
		getContentPane().add(btnok);
		
		

		// 취소버튼 기능---------------------------------------
		btncancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Loginview().mainView();;
			}
		});
		setLocation(700, 200);
		setVisible(true);

	}
}
