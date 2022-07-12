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
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

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
		JFrame frame = new JFrame("도서관 관리 프로그램");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 270, 307);
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);

		Button btnsearch = new Button("도서 검색");
		btnsearch.setBounds(30, 63, 188, 23);
		panel.add(btnsearch);

		Button btnupdate = new Button("회원 수정");
		btnupdate.setBounds(30, 136, 188, 23);
		panel.add(btnupdate);

		Button btnreturn = new Button("도서 반납");
		btnreturn.setBounds(30, 98, 188, 23);
		panel.add(btnreturn);

		Button btnwithdrawal = new Button("회원 탈퇴");
		btnwithdrawal.setBounds(87, 230, 76, 23);
		panel.add(btnwithdrawal);

		Button btnout = new Button("로그 아웃");
		btnout.setBounds(30, 173, 188, 23);
		panel.add(btnout);
		
		//도서 검색 기능
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
		//도서 반납 기능
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
		
		//회원수정 기능
		btnupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberupdateView mv = new MemberupdateView();
				mv.setId(id);
				mv.setPwd(pwd);
				dispose();
				mv.MemberupdateViewGui();
			}
		});;
	
		
		//로그아웃 기능
		btnout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int var = JOptionPane.showConfirmDialog(frame, "로그아웃 하시겠습니까?", "로그아웃", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null);
				if (var == 0) {
					frame.dispose();
					new Loginview().mainView();;

				}
			}
		});
		
		//회원 탈퇴 기능
		btnwithdrawal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MemberDAO bd = new MemberDAO();
				Loginview lv = new Loginview();
				
				System.out.println(id+" "+pwd);
				int var = JOptionPane.showConfirmDialog(frame, "회원탈퇴 하시겠습니까?", "회원탈퇴", 
						JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null);
				
				if (var == 0) {
					int var2 = JOptionPane.showConfirmDialog(frame, "정말 회원탈퇴 하시겠습니까?", "회원탈퇴", 
							JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE, null);
					if(var2==0) {
						bd.deleteData(id, pwd);
						JOptionPane.showMessageDialog(frame,"회원 탈퇴 완료", "Message",
								JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						lv.mainView();
						
					}
				}
			}

		});

		frame.getContentPane().add(panel);
		
		JLabel lbtop = new JLabel("\uBA54\uB274 \uC120\uD0DD");
		lbtop.setFont(new Font("굴림", Font.PLAIN, 24));
		lbtop.setBounds(69, 10, 110, 35);
		panel.add(lbtop);
		frame.setVisible(true);
	}
}
