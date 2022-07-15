package project1st;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CheckOutView extends JFrame {
	private JFrame frame;
	private JPanel panel; 
	private String title;
	private String id;
	private String pwd;
	private Dialog dl;
	

	public CheckOutView() {
//		CheckoutView();
	}
	
	public void CheckoutView() {
		CheckOutDAO cod = new CheckOutDAO();
		CheckOutVo cov = new CheckOutVo();
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatedNow = now.format(formatter);
			
				 
		frame = new JFrame("도서 대출");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 393, 425);

		panel = new JPanel();
		panel.setBounds(0, 0, 377, 386);
		
		panel.setLayout(null);
		
		JLabel lbtitle = new JLabel("제목");
		lbtitle.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbtitle.setBounds(201, 86, 68, 23);
		JLabel lbauthor = new JLabel("저자");
		lbauthor.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbauthor.setBounds(201, 126, 50, 23);
		JLabel lbpublisher = new JLabel("출판사");
		lbpublisher.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbpublisher.setBounds(188, 166, 50, 23);
		JLabel lbgenre = new JLabel("장르");
		lbgenre.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbgenre.setBounds(201, 206, 50, 23);
		JLabel lbpublication_date = new JLabel("출판일");
		lbpublication_date.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbpublication_date.setBounds(190, 246, 50, 23);
		
		JTextField tftitle = new JTextField();
		tftitle.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tftitle.setBounds(240, 86, 97, 23);
//		tftitle.setEnabled(false);
		tftitle.setEditable(false);
		JTextField tfauthor = new JTextField();
		tfauthor.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfauthor.setBounds(240, 126, 97, 23);
//		tfauthor.setEnabled(false);
		tfauthor.setEditable(false);
		JTextField tfpublisher = new JTextField();
		tfpublisher.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfpublisher.setBounds(240, 166, 97, 23);
//		tfpublisher.setEnabled(false);
		tfpublisher.setEditable(false);
		JTextField tfgenre = new JTextField();
		tfgenre.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfgenre.setBounds(240, 206, 97, 23);
//		tfgenre.setEnabled(false);
		tfgenre.setEditable(false);
		JTextField tfpublication_date = new JTextField();
		tfpublication_date.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		tfpublication_date.setBounds(240, 246, 97, 23);
//		tfpublication_date.setEnabled(false);
		tfpublication_date.setEditable(false);		
		JTextField tfischeckout = new JTextField();
		tfischeckout.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
//		tfischeckout.setEnabled(false);
		tfischeckout.setBounds(240, 286, 97, 23);
		tfischeckout.setEditable(false);
		
		JButton btnloans = new JButton("대출하기");
		btnloans.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btnloans.setBounds(64, 333, 88, 23);
		JButton btncancel = new JButton("뒤로가기");
		btncancel.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		btncancel.setBounds(228, 333, 88, 23);
	
		JLabel lbischeckout = new JLabel("대출여부");
		lbischeckout.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		lbischeckout.setBounds(178, 286, 68, 23);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(142, 27, 90, 31);

		System.out.println(title);
		System.out.println(id);
		System.out.println(pwd);
		
		//textfield에 책 정보 보이기
		BookListArr bsl = new BookListArr();
		Object [][] info1 = bsl.resultTitle(title);
		if(info1.length!=0) {
			tftitle.setText((String) info1[0][0]);
			tfauthor.setText( (String) info1[0][1]);
			tfpublisher.setText( (String) info1[0][2]);
			tfgenre.setText( (String) info1[0][3]);
			tfpublication_date.setText((String) info1[0][4]);
			
		}
		
		int num = cod.titleCheck(title);
		System.out.println(num);
		
		if(num ==1) {
			tfischeckout.setText("대출중");
		}else if(num==0) {
			tfischeckout.setText("대출가능");
			
		}
		
		//버튼 취소 기능
		btncancel.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LibrarysearchView lb = new LibrarysearchView();
				lb.setId(id);
				lb.setPwd(pwd);
				frame.dispose();
				
				
			}
		});
		
		//버튼 대출 기능
		btnloans.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				Calendar calendar = new GregorianCalendar();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String chkDate = sdf.format(calendar.getTime());
				LibrarysearchView lb = new LibrarysearchView();
				
			
				
				//bd.selectTitle(tl);
				if(tfischeckout.getText().equals("대출가능")) {
					int var = JOptionPane.showConfirmDialog(frame, "대출 하시겠습니까?", "대출하기", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null);
					if(var==0) {
				
						cov.setId(id);
						System.out.println(id);
						cov.setTitle(tftitle.getText());
						System.out.println(tftitle.getText());
						cov.setCheckout_date(chkDate);
						System.out.println(chkDate);
						calendar.add(Calendar.DATE, 5);
						chkDate = sdf.format(calendar.getTime());
						cov.setReturn_date(chkDate);
						System.out.println(chkDate);
					
						
						int result = cod.insertCheckout(cov);
						
						if(result == 1) {
							JOptionPane.showMessageDialog(getContentPane(),"대출 성공", "Information",
									JOptionPane.INFORMATION_MESSAGE);
							lb.setId(id);
							lb.setPwd(pwd);
							frame.dispose();
							
							
						}else
							JOptionPane.showMessageDialog(getContentPane(),"대출 실패", "Inforation",
									JOptionPane.INFORMATION_MESSAGE);
						
					}
					
				}else if(tfischeckout.getText().equals("대출중")) {
					JOptionPane.showMessageDialog(getContentPane(),"대출중 입니다", "Information",
							JOptionPane.INFORMATION_MESSAGE);
					}
			}
		});
		
		panel.add(lbtitle);
		panel.add(tftitle);
		panel.add(lbauthor);
		panel.add(tfauthor);
		panel.add(lbpublisher);
		panel.add(tfpublisher);
		panel.add(lbgenre);
		panel.add(tfgenre);
		panel.add(lbpublication_date);
		panel.add(tfpublication_date);
		panel.add(btnloans);
		panel.add(btncancel);
		panel.add(tfischeckout);
		panel.add(lbischeckout);
		panel.add(lblNewLabel);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(12, 86, 164, 192);
		panel.add(panel_1);
		panel_1.setLayout(null);
		JButton btninfo = new JButton("\uB3C4\uC11C \uC815\uBCF4");
		btninfo.setBounds(34, 157, 97, 25);
		panel_1.add(btninfo);
		btninfo.setFont(new Font("함초롬돋움", Font.PLAIN, 12));
		JLabel lbimage = new JLabel("image");
		lbimage.setHorizontalAlignment(SwingConstants.CENTER);
		lbimage.setBounds(12, 5, 140, 152);
		panel_1.add(lbimage);
		
		//책 정보 기능
		btninfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String result1 = title.replaceAll(" ", "");
					Desktop desktop = Desktop.getDesktop();
					URI uri = new URI("https://book.naver.com/"
							+ "search/search.naver?sm=sta_hty.book&sug="
							+ "&where=nexearch&query="+result1);
					
					//URLEncoder.encode(uri,"UTF-8");
					
						desktop.browse(uri);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				catch (URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		
		
		
		frame.setVisible(true);
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
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
	
}
