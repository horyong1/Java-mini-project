package project1st;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

public class MemberupdateView extends JFrame {

	private JFrame jf;
	private int result = 2;
	private String id, pwd;

	public MemberupdateView() {
		MemberupdateViewGui();

	}

	public void MemberupdateViewGui() {
		setTitle("������ ���� ���α׷�");

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 333, 500);
		getContentPane().setLayout(null);
		setBackground(Color.DARK_GRAY);

		Button btncancel = new Button("���");
		btncancel.setBounds(185, 400, 97, 23);
		getContentPane().add(btncancel);

		JLabel lbid = new JLabel("���̵�");
		lbid.setBounds(69, 84, 48, 15);
		getContentPane().add(lbid);

		JLabel lbpwd = new JLabel("��й�ȣ");
		lbpwd.setBounds(59, 119, 58, 15);
		getContentPane().add(lbpwd);

		JLabel lbpwdck = new JLabel("��й�ȣ Ȯ��");
		lbpwdck.setBounds(32, 157, 87, 15);
		getContentPane().add(lbpwdck);

		JLabel lbname = new JLabel("�̸�");
		lbname.setBounds(83, 195, 36, 15);
		getContentPane().add(lbname);

		JLabel lbtel = new JLabel("��ȭ��ȣ");
		lbtel.setBounds(59, 267, 58, 15);
		getContentPane().add(lbtel);

		JLabel lbemail = new JLabel("�̸���");
		lbemail.setBounds(69, 302, 43, 15);
		getContentPane().add(lbemail);

		JRadioButton rbtngender1 = new JRadioButton("��");
		rbtngender1.setSelected(true);
		rbtngender1.setBounds(147, 329, 48, 23);
		getContentPane().add(rbtngender1);

		JRadioButton rbtngender2 = new JRadioButton("��");
		rbtngender2.setBounds(203, 329, 48, 23);
		getContentPane().add(rbtngender2);

		// ���� ��ư �׷� ����------------------
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtngender1);
		bg.add(rbtngender2);

		JLabel lbgender = new JLabel("����");
		lbgender.setBounds(81, 333, 36, 15);
		getContentPane().add(lbgender);

		JLabel lbtitle = new JLabel("ȸ������ ����");
		lbtitle.setFont(new Font("����", Font.BOLD, 25));
		lbtitle.setBounds(79, 20, 168, 41);
		getContentPane().add(lbtitle);

		JLabel lbbirth = new JLabel("�������");
		lbbirth.setBounds(59, 229, 58, 15);
		getContentPane().add(lbbirth);

		TextField tfid = new TextField();
		tfid.setEditable(false);
		tfid.setBounds(135, 80, 116, 23);
		getContentPane().add(tfid);

		TextField passwordField = new TextField();
		passwordField.setBounds(135, 115, 116, 23);
		getContentPane().add(passwordField);
		passwordField.setEchoChar('*');

		TextField passwordckField = new TextField();
		passwordckField.setBounds(135, 153, 116, 23);
		getContentPane().add(passwordckField);
		passwordckField.setEchoChar('*');

		TextField tfname = new TextField();
		tfname.setEditable(false);
		tfname.setBounds(135, 189, 116, 23);
		getContentPane().add(tfname);

		TextField tfbirth = new TextField();
		tfbirth.setEditable(false);
		tfbirth.setBounds(135, 224, 116, 23);
		getContentPane().add(tfbirth);

		TextField tftel = new TextField();
		tftel.setBounds(135, 259, 116, 23);
		getContentPane().add(tftel);

		TextField tfemail = new TextField();
		tfemail.setBounds(135, 294, 116, 23);
		getContentPane().add(tfemail);

		
		
		
		Button btnok = new Button("Ȯ��");
		btnok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberDAO mbd = new MemberDAO();
				MemberVo mbv = new MemberVo();
				Effectiveness ef = new Effectiveness();
				String pf = passwordField.getText();
				String pfk = passwordckField.getText();

				if (passwordField.getText().equals("")) {
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

				} else if (tftel.getText().equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "��ȭ��ȣ�� �Է��ϼ���", "Message",
							JOptionPane.INFORMATION_MESSAGE);

				} else if (ef.isTel(tftel.getText()) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "�ùٸ� ������ ��ȭ��ȣ�� �Է��ϼ���\n  ��) 010-1111-2222",
							"Message", JOptionPane.INFORMATION_MESSAGE);

				} else if (tfemail.getText().length() != 0 && ef.isValidEmail(tfemail.getText()) == false) {
					JOptionPane.showMessageDialog(getContentPane(), "�ùٸ� ������ �̸����� �Է��ϼ���\n  ��) asdf@naver.com",
							"Message", JOptionPane.INFORMATION_MESSAGE);

				} else if (result == 0) {

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
		
		btnok.setBounds(47, 400, 97, 23);
		getContentPane().add(btnok);

		
		
		
		
		
		// ��ҹ�ư ���---------------------------------------
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

		setVisible(true);

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
