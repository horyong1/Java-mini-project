package project1st;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class AdminView extends JFrame {

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

	public AdminView() {
//		adminGui();
	}

	public void adminGui() {
		JFrame frame = new JFrame("������ ���� ���α׷�");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 304, 374);
		Dimension frameSize = this.getSize(); // ������ ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ������
		frame.setLocation(700,200);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);

		JButton btnsearch = new JButton("���� ��� ����");
		btnsearch.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnsearch.setBounds(52, 120, 188, 23);
		panel.add(btnsearch);

		JButton btnupdate = new JButton("ȸ�� ����");
		btnupdate.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnupdate.setBounds(52, 193, 188, 23);
		panel.add(btnupdate);

		JButton btnreturn = new JButton("���� ���� ����");
		btnreturn.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnreturn.setBounds(52, 155, 188, 23);
		panel.add(btnreturn);

		JButton btnout = new JButton("�α� �ƿ�");
		btnout.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnout.setBounds(100, 273, 93, 23);
		panel.add(btnout);
		
		
		//���� �˻� ���� ���
		btnsearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminBookList abl = new AdminBookList();
				abl.mainGui();
				frame.dispose();
			}
		});
		
		
		//���� ���� ���� ���
		btnreturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			new AdminMemberList().mainGui();
				frame.dispose();
			}
		});
		
		//ȸ���� ���
		btnupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new AdminMemberList().mainGui();
				frame.dispose();
			}
		});;
	
		
		//�α׾ƿ� ���
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

		frame.getContentPane().add(panel);
		
		JLabel lbtop = new JLabel(" ������");
		lbtop.setFont(new Font("���ʷҵ���", Font.PLAIN, 24));
		lbtop.setBounds(106, 42, 84, 35);
		panel.add(lbtop);
		frame.setVisible(true);
	}
}
