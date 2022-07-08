package project1st;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Signupview extends JFrame {
	private JFrame jf;
	private int result = 2;
	public Signupview() {
		SignupViewGui();

	}

	public void SignupViewGui() {
		setTitle("도서관 관리 프로그램");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(null);
		setBackground(Color.DARK_GRAY);

		Button btncancel = new Button("취소");
		btncancel.setBounds(251, 401, 97, 23);
		getContentPane().add(btncancel);

		JLabel lbid = new JLabel("아이디");
		lbid.setBounds(83, 89, 48, 15);
		getContentPane().add(lbid);

		JLabel lbpwd = new JLabel("비밀번호");
		lbpwd.setBounds(83, 124, 58, 15);
		getContentPane().add(lbpwd);

		JLabel lbpwdck = new JLabel("비밀번호 확인");
		lbpwdck.setBounds(83, 162, 87, 15);
		getContentPane().add(lbpwdck);

		JLabel lbname = new JLabel("이름");
		lbname.setBounds(83, 198, 36, 15);
		getContentPane().add(lbname);

		JLabel lbtel = new JLabel("전화번호");
		lbtel.setBounds(83, 268, 58, 15);
		getContentPane().add(lbtel);

		JLabel lbemail = new JLabel("이메일");
		lbemail.setBounds(83, 303, 43, 15);
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
		lbgender.setBounds(83, 338, 36, 15);
		getContentPane().add(lbgender);

		JLabel lbtitle = new JLabel("회원가입");
		lbtitle.setFont(new Font("굴림", Font.BOLD, 21));
		lbtitle.setBounds(177, 22, 97, 41);
		getContentPane().add(lbtitle);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);

		JLabel lbbirth = new JLabel("생년월일");
		lbbirth.setBounds(83, 233, 58, 15);
		getContentPane().add(lbbirth);

		TextField tfid = new TextField();
		tfid.setBounds(176, 81, 116, 23);
		getContentPane().add(tfid);

		TextField passwordField = new TextField();
		passwordField.setBounds(176, 116, 116, 23);
		getContentPane().add(passwordField);
		passwordField.setEchoChar('*');

		TextField passwordckField = new TextField();
		passwordckField.setBounds(176, 154, 116, 23);
		getContentPane().add(passwordckField);
		passwordckField.setEchoChar('*');

		TextField tfname = new TextField();
		tfname.setBounds(176, 190, 116, 23);
		getContentPane().add(tfname);

		TextField tfbirth = new TextField();
		tfbirth.setBounds(176, 225, 116, 23);
		getContentPane().add(tfbirth);

		TextField tftel = new TextField();
		tftel.setBounds(176, 260, 116, 23);
		getContentPane().add(tftel);

		TextField tfemail = new TextField();
		tfemail.setBounds(176, 295, 116, 23);
		getContentPane().add(tfemail);

		Button btnoverlap = new Button("중복확인");
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
		btnoverlap.setBounds(308, 81, 74, 23);
		getContentPane().add(btnoverlap);
		
		
		Button btnok = new Button("확인");
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

		setVisible(true);

	}
}
