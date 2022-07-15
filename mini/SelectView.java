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
		JFrame frame = new JFrame("도서관 관리 프로그램");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 304, 374);
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		frame.setLocation(700,200);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);

		JButton btnsearch = new JButton("도서 검색");
		btnsearch.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnsearch.setBounds(50, 94, 188, 23);
		panel.add(btnsearch);

		JButton btnupdate = new JButton("회원 수정");
		btnupdate.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnupdate.setBounds(50, 167, 188, 23);
		panel.add(btnupdate);

		JButton btnreturn = new JButton("도서 반납");
		btnreturn.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnreturn.setBounds(50, 129, 188, 23);
		panel.add(btnreturn);

		JButton btnwithdrawal = new JButton("회원 탈퇴");
		btnwithdrawal.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnwithdrawal.setBounds(99, 286, 93, 23);
		panel.add(btnwithdrawal);

		JButton btnout = new JButton("로그 아웃");
		btnout.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnout.setBounds(50, 204, 188, 23);
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
				frame.dispose();
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
		lbtop.setFont(new Font("함초롬돋움", Font.PLAIN, 24));
		lbtop.setBounds(95, 23, 110, 35);
		panel.add(lbtop);
		frame.setVisible(true);
	}
}
