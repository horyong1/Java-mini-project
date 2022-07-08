package project1st;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;

public class SelectView extends JFrame {

	private JPanel contentPane;
	private String id;
	private String pwd;

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

	public SelectView() {
		
	}

	public void selectview() {
		JFrame frame = new JFrame("������ ���� ���α׷�");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 270, 266);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);

		Button btnsearch = new Button("���� �˻�");
		btnsearch.setBounds(31, 27, 188, 23);
		panel.add(btnsearch);

		Button btnupdate = new Button("ȸ�� ����");
		btnupdate.setBounds(31, 100, 188, 23);
		panel.add(btnupdate);

		Button btnback = new Button("���� �ݳ�");
		btnback.setBounds(31, 62, 188, 23);
		panel.add(btnback);

		Button btnwithdrawal = new Button("ȸ�� Ż��");
		btnwithdrawal.setBounds(88, 194, 76, 23);
		panel.add(btnwithdrawal);

		Button btnout = new Button("�α� �ƿ�");
		btnout.setBounds(31, 137, 188, 23);
		panel.add(btnout);

		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int var = JOptionPane.showConfirmDialog(frame, "�α׾ƿ� �Ͻðڽ��ϱ�?", "�α׾ƿ�", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null);
				if (var == 0) {
					frame.dispose();
					new Loginview().mainView();;

				}
			}
		});

		btnsearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				new Library().booksearchGui();
			}
		});

		btnwithdrawal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberDAO bd = new MemberDAO();
				Loginview lv = new Loginview();
				String id = getId();
				String pwd = getPwd();
				System.out.println(id+" "+pwd);
				int var = JOptionPane.showConfirmDialog(frame, "ȸ��Ż�� �Ͻðڽ��ϱ�?", "ȸ��Ż��", 
						JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null);
				
				if (var == 0) {
					bd.deleteData(id, pwd);
					JOptionPane.showMessageDialog(frame,"ȸ�� Ż�� �Ϸ�", "Message",
							JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					lv.mainView();
				}
			}

		});

		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
}
