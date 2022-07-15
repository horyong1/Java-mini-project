package project1st;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
//		selectview();
	}

	public void selectview() {
		JFrame frame = new JFrame("������ ���� ���α׷�");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 304, 374);
		Dimension frameSize = this.getSize(); // ������ ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ������
		frame.setLocation(700,200);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);

		JButton btnsearch = new JButton("���� �˻�");
		btnsearch.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnsearch.setBounds(50, 94, 188, 23);
		panel.add(btnsearch);

		JButton btnupdate = new JButton("ȸ�� ����");
		btnupdate.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnupdate.setBounds(50, 167, 188, 23);
		panel.add(btnupdate);

		JButton btnreturn = new JButton("���� �ݳ�");
		btnreturn.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnreturn.setBounds(50, 129, 188, 23);
		panel.add(btnreturn);

		JButton btnwithdrawal = new JButton("ȸ�� Ż��");
		btnwithdrawal.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnwithdrawal.setBounds(99, 286, 93, 23);
		panel.add(btnwithdrawal);

		JButton btnout = new JButton("�α� �ƿ�");
		btnout.setFont(new Font("���ʷҵ���", Font.PLAIN, 12));
		btnout.setBounds(50, 204, 188, 23);
		panel.add(btnout);
		
		//���� �˻� ���
		btnsearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LibrarysearchView lb = new LibrarysearchView();
				lb.setId(id);
				lb.setPwd(pwd);
				lb.booksearchGui();
				frame.dispose();
			}
		});
		//���� �ݳ� ���
		btnreturn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LibraryReturnView lbr = new LibraryReturnView();
				lbr.setId(id);
				lbr.setPwd(pwd);
				lbr.mainGui();
				frame.dispose();
			}
		});
		
		//ȸ������ ���
		btnupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberupdateView mv = new MemberupdateView();
				mv.setId(id);
				mv.setPwd(pwd);
				frame.dispose();
				mv.MemberupdateViewGui();
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
		
		//ȸ�� Ż�� ���
		btnwithdrawal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberDAO bd = new MemberDAO();
				Loginview lv = new Loginview();
				
				System.out.println(id+" "+pwd);
				int var = JOptionPane.showConfirmDialog(frame, "ȸ��Ż�� �Ͻðڽ��ϱ�?", "ȸ��Ż��", 
						JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null);
				
				if (var == 0) {
					int var2 = JOptionPane.showConfirmDialog(frame, "���� ȸ��Ż�� �Ͻðڽ��ϱ�?", "ȸ��Ż��", 
							JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null);
					if(var2==0) {
						bd.deleteData(id, pwd);
						JOptionPane.showMessageDialog(frame,"ȸ�� Ż�� �Ϸ�", "Message",
								JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						lv.mainView();
						
					}
				}
			}

		});

		frame.getContentPane().add(panel);
		
		JLabel lbtop = new JLabel("\uBA54\uB274 \uC120\uD0DD");
		lbtop.setFont(new Font("���ʷҵ���", Font.PLAIN, 24));
		lbtop.setBounds(95, 23, 110, 35);
		panel.add(lbtop);
		frame.setVisible(true);
	}
}
