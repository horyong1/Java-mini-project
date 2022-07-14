package project1st;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MemberupdateView extends JFrame {

	
	private String id, pwd;
	private ArrayList<MemberVo> data;

	public MemberupdateView() {
//		MemberupdateViewGui();

	}

	public void MemberupdateViewGui() {
		
		
		setTitle("도서관 관리 프로그램");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 333, 500);
		getContentPane().setLayout(null);
		setBackground(Color.DARK_GRAY);

		JButton btncancel = new JButton("취소");
		btncancel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btncancel.setBounds(185, 400, 97, 23);
		getContentPane().add(btncancel);

		JLabel lbid = new JLabel("아이디");
		lbid.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbid.setBounds(70, 100, 48, 15);
		getContentPane().add(lbid);

		JLabel lbpwd = new JLabel("비밀번호");
		lbpwd.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbpwd.setBounds(60, 135, 58, 15);
		getContentPane().add(lbpwd);

		JLabel lbpwdck = new JLabel("비밀번호 확인");
		lbpwdck.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbpwdck.setBounds(33, 173, 87, 15);
		getContentPane().add(lbpwdck);

		JLabel lbname = new JLabel("이름");
		lbname.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbname.setBounds(84, 211, 36, 15);
		getContentPane().add(lbname);

		JLabel lbtel = new JLabel("전화번호");
		lbtel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbtel.setBounds(60, 283, 58, 15);
		getContentPane().add(lbtel);

		JLabel lbemail = new JLabel("이메일");
		lbemail.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbemail.setBounds(70, 318, 43, 15);
		getContentPane().add(lbemail);

		JLabel lbtitle = new JLabel("회원정보 수정");
		lbtitle.setFont(new Font("함초롬돋움", Font.BOLD, 25));
		lbtitle.setBounds(79, 20, 168, 41);
		getContentPane().add(lbtitle);

		JLabel lbbirth = new JLabel("생년월일");
		lbbirth.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbbirth.setBounds(60, 245, 58, 15);
		getContentPane().add(lbbirth);

		JTextField tfid = new JTextField();
		tfid.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfid.setEditable(false);
		tfid.setBounds(137, 96, 116, 23);
		getContentPane().add(tfid);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		passwordField.setBounds(137, 131, 116, 23);
		getContentPane().add(passwordField);
		passwordField.setEchoChar('*');

		JPasswordField passwordckField = new JPasswordField();
		passwordckField.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		passwordckField.setBounds(137, 169, 116, 23);
		getContentPane().add(passwordckField);
		passwordckField.setEchoChar('*');

		JTextField tfname = new JTextField();
		tfname.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfname.setEditable(false);
		tfname.setBounds(137, 205, 116, 23);
		getContentPane().add(tfname);

		JTextField tfbirth = new JTextField();
		tfbirth.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfbirth.setEditable(false);
		tfbirth.setBounds(137, 240, 116, 23);
		getContentPane().add(tfbirth);

		JTextField tftel = new JTextField();
		tftel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tftel.setBounds(137, 275, 116, 23);
		getContentPane().add(tftel);

		JTextField tfemail = new JTextField();
		tfemail.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfemail.setBounds(137, 310, 116, 23);
		getContentPane().add(tfemail);
		
		JButton btnok = new JButton("확인");
		btnok.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnok.setBounds(47, 400, 97, 23);
		getContentPane().add(btnok);

		Object [][] info1 = searchID(id);
		tfid.setText((String) info1[0][0]);
		tfname.setText((String) info1[0][1]);
		tftel.setText((String) info1[0][2]);
		tfbirth.setText((String) info1[0][3]);
		tfemail.setText((String) info1[0][4]);
		
		
		
		
		//확인 버튼 기능
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO mbd = new MemberDAO();
				MemberVo mbv = new MemberVo();
				SelectView sv = new SelectView();
				Effectiveness ef = new Effectiveness();
				String pf = passwordField.getText();
				String pfk = passwordckField.getText();

				if (passwordField.getText().equals("")) {
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

				} else if (tftel.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "전화번호를 입력하세요", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (ef.isTel(tftel.getText()) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "올바른 형식의 전화번호를 입력하세요\n  예) 010-1111-2222",
							"Message", JOptionPane.INFORMATION_MESSAGE);

				} else if (tfemail.getText().length() != 0 && ef.isValidEmail(tfemail.getText()) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "올바른 형식의 이메일을 입력하세요\n  예) asdf@naver.com",
							"Message", JOptionPane.INFORMATION_MESSAGE);

				} else {

					mbv.setPwd(passwordField.getText());
					mbv.setTel(tftel.getText());
					mbv.setEmail(tfemail.getText());
					mbv.setId(id);
					int result = mbd.updateData(mbv);
					if(result == 1) {
						System.out.println(result);
						JOptionPane.showMessageDialog(getContentPane(), "회원정보 수정이 완료되었습니다!", "Message",
								JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(getContentPane(), "다시 로그인 해주세요", "Message",
								JOptionPane.INFORMATION_MESSAGE);
						sv.setId(id);
						sv.setPwd(pwd);
						dispose();
						new Loginview().mainView();						
					}else {
						JOptionPane.showMessageDialog(getContentPane(), "회원정보 수정에 실패했습니다.", "Message",
								JOptionPane.INFORMATION_MESSAGE);
						
					}
				}

			}

		});
		
		
		// 취소버튼 기능---------------------------------------
		btncancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SelectView sv = new SelectView();
				sv.setId(id);
				sv.setPwd(pwd);
				dispose();
				sv.selectview();

			}
		});
		setLocation(700, 200);
		setVisible(true);

	}
	
	public Object[][] searchID(String id) {
		MemberDAO md = new MemberDAO();
		Object[][] list;
		
		data = md.getIdLis(id);
		list = new Object[data.size()][5];

		System.out.println(data);

		for (int i = 0; i < data.size(); i++) {
			for (int j = 0; j < 5; j++) {
				list[i][j] = data.get(i).getId();
				list[i][++j] = data.get(i).getName();
				list[i][++j] = data.get(i).getTel();
				list[i][++j] = data.get(i).getBirth();
				list[i][++j] = data.get(i).getEmail();
			}
		}
		return list;

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
