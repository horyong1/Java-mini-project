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
		setTitle("������ ���� ���α׷�");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(null);
		setBackground(Color.DARK_GRAY);

		JButton btncancel = new JButton("���");
		btncancel.setBounds(251, 401, 97, 23);
		getContentPane().add(btncancel);

		JLabel lbid = new JLabel("���̵�");
		lbid.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		lbid.setBounds(112, 85, 48, 15);
		getContentPane().add(lbid);

		JLabel lbpwd = new JLabel("��й�ȣ");
		lbpwd.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		lbpwd.setBounds(100, 120, 58, 15);
		getContentPane().add(lbpwd);

		JLabel lbpwdck = new JLabel("��й�ȣ Ȯ��");
		lbpwdck.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		lbpwdck.setBounds(73, 158, 87, 15);
		getContentPane().add(lbpwdck);

		JLabel lbname = new JLabel("�̸�");
		lbname.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		lbname.setBounds(124, 196, 36, 15);
		getContentPane().add(lbname);
		

		JLabel lbtel = new JLabel("��ȭ��ȣ");
		lbtel.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		lbtel.setBounds(100, 268, 58, 15);
		getContentPane().add(lbtel);

		JLabel lbemail = new JLabel("�̸���");
		lbemail.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		lbemail.setBounds(112, 303, 43, 15);
		getContentPane().add(lbemail);

		JRadioButton rbtngender1 = new JRadioButton("��");
		rbtngender1.setSelected(true);
		rbtngender1.setBounds(188, 330, 48, 23);
		getContentPane().add(rbtngender1);

		JRadioButton rbtngender2 = new JRadioButton("��");
		rbtngender2.setBounds(244, 330, 48, 23);
		getContentPane().add(rbtngender2);

		// ���� ��ư �׷� ����------------------
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtngender1);
		bg.add(rbtngender2);

		JLabel lbgender = new JLabel("����");
		lbgender.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		lbgender.setBounds(124, 334, 36, 15);
		getContentPane().add(lbgender);

		JLabel lbtitle = new JLabel("ȸ������");
		lbtitle.setFont(new Font("���ʷҵ���", Font.BOLD, 25));
		lbtitle.setBounds(176, 21, 116, 41);
		getContentPane().add(lbtitle);

		JLabel lbbirth = new JLabel("�������");
		lbbirth.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
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

		JButton btnoverlap = new JButton("�ߺ�Ȯ��");
		btnoverlap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO mbd = new MemberDAO();
				result = mbd.idCheck(tfid.getText());
				
				if(tfid.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���̵� �Է��ϼ���", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					result = 2;
					
				}
				else if(result==1) {
					JOptionPane.showMessageDialog(getContentPane(), "�ߺ��� ���̵� �Դϴ�.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					result = 2;
				}else if(result==0) {
					JOptionPane.showMessageDialog(getContentPane(), "��� ������ ���̵� �Դϴ�.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
		});
		btnoverlap.setBounds(308, 81, 81, 23);
		getContentPane().add(btnoverlap);
		
		
		JButton btnok = new JButton("Ȯ��");
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO mbd = new MemberDAO();
				MemberVo mbv = new MemberVo();
				Effectiveness ef = new Effectiveness();
				String pf = passwordField.getText();
				String pfk = passwordckField.getText();
				if (tfid.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���̵� �Է��ϼ���.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}else if(result==2){
					JOptionPane.showMessageDialog(getContentPane(), "���̵� �ߺ�üũ�� Ȯ���ϼ���.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}else if (!(tfid.getText().length() >= 5 && tfid.getText().length() <= 15)) {
				
					JOptionPane.showMessageDialog(getContentPane(), "���̵� 5~15�ڷ� �Է��ϼ���.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "��й�ȣ�� �Է��ϼ���", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (!(passwordField.getText().length() >= 8 && passwordField.getText().length() <= 16)) {
					JOptionPane.showMessageDialog(getContentPane(), "��й�ȣ�� 8~16�ڷ� �Է� �����մϴ�.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (passwordckField.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "��й�ȣ Ȯ���� �Է��ϼ���.", "Message",
							JOptionPane.INFORMATION_MESSAGE);
				} else if (!(pfk.equals(pf))) {
					JOptionPane.showMessageDialog(getContentPane(), "��й�ȣ�� �ٸ��ϴ�. �ٽ� Ȯ�� �ϼ��� ", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfname.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "�̸��� �Է��ϼ��� ", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (ef.isAlphaNumeric(tfname.getText()) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "�̸��� �ѱ۰� ��� �Է� �����մϴ�.", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (tfbirth.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "��������� �Է��ϼ���", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (!(ef.isNumeric(tfbirth.getText()))
						|| !((tfbirth.getText().length() <= 6 && tfbirth.getText().length() > 0))) {
					JOptionPane.showMessageDialog(getContentPane(), "�ùٸ� ������ ��������� �Է��ϼ���\n  ��) 091201", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				}else if (tftel.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "��ȭ��ȣ�� �Է��ϼ���", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}else if(ef.isTel(tftel.getText()) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "�ùٸ� ������ ��ȭ��ȣ�� �Է��ϼ���\n  ��) 010-1111-2222", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					
				}
				else if (tfemail.getText().length()!=0&&ef.isValidEmail(tfemail.getText()) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "�ùٸ� ������ �̸����� �Է��ϼ���\n  ��) asdf@naver.com", "Message",
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
					JOptionPane.showMessageDialog(getContentPane(), "ȸ�� ������ �Ϸ�Ǿ����ϴ�!", "Message",
							JOptionPane.INFORMATION_MESSAGE);

					dispose();
					new Loginview().mainView();
				}

			}

		});
		btnok.setBounds(98, 401, 97, 23);
		getContentPane().add(btnok);
		
		

		// ��ҹ�ư ���---------------------------------------
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