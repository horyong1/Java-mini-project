package project1st;

import java.awt.Button;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
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

public class CheckOut extends JFrame {
	private JFrame frame;
	private JPanel panel; 
	private String title;
	private String id;
	private String pwd;
	
	

	public CheckOut() {
	//	LoansView();
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
		
		Label lbtitle = new Label("제목");
		lbtitle.setBounds(178, 86, 38, 23);
		Label lbauthor = new Label("저자");
		lbauthor.setBounds(178, 126, 38, 23);
		Label lbpublisher = new Label("출판사");
		lbpublisher.setBounds(166, 166, 50, 23);
		Label lbgenre = new Label("장르");
		lbgenre.setBounds(178, 206, 38, 23);
		Label lbpublication_date = new Label("출판일");
		lbpublication_date.setBounds(166, 246, 50, 23);
		JLabel lbimage = new JLabel("             image");
		lbimage.setBounds(12, 86, 140, 152);
		
		TextField tftitle = new TextField();
		tftitle.setBounds(240, 86, 97, 23);
//		tftitle.setEnabled(false);
		tftitle.setEditable(false);
		TextField tfauthor = new TextField();
		tfauthor.setBounds(240, 126, 97, 23);
//		tfauthor.setEnabled(false);
		tfauthor.setEditable(false);
		TextField tfpublisher = new TextField();
		tfpublisher.setBounds(240, 166, 97, 23);
//		tfpublisher.setEnabled(false);
		tfpublisher.setEditable(false);
		TextField tfgenre = new TextField();
		tfgenre.setBounds(240, 206, 97, 23);
//		tfgenre.setEnabled(false);
		tfgenre.setEditable(false);
		TextField tfpublication_date = new TextField();
		tfpublication_date.setBounds(240, 246, 97, 23);
//		tfpublication_date.setEnabled(false);
		tfpublication_date.setEditable(false);		
		TextField tfischeckout = new TextField();
//		tfischeckout.setEnabled(false);
		tfischeckout.setBounds(240, 286, 97, 23);
		tfischeckout.setEditable(false);
		
		Button btnloans = new Button("대출하기");
		btnloans.setBounds(64, 333, 76, 23);
		Button btncancel = new Button("뒤로가기");
		btncancel.setBounds(228, 333, 76, 23);
		JButton btninfo = new JButton("책 정보");
		btninfo.setBounds(29, 246, 97, 23);
	
		Label lbischeckout = new Label("대출여부");
		lbischeckout.setBounds(152, 286, 68, 23);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
		lblNewLabel.setBounds(142, 27, 90, 31);

		System.out.println(title);
		System.out.println(id);
		System.out.println(pwd);
		
		//textfield에 책 정보 보이기
		BookSearchList bsl = new BookSearchList();
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
							JOptionPane.showMessageDialog(getContentPane(),"대출 성공", "Infomation",
									JOptionPane.INFORMATION_MESSAGE);
							lb.setId(id);
							lb.setPwd(pwd);
							frame.dispose();
							
						}else
							JOptionPane.showMessageDialog(getContentPane(),"대출 실패", "Infomation",
									JOptionPane.INFORMATION_MESSAGE);
					}
					
				}else 
					JOptionPane.showMessageDialog(getContentPane(),"대출중 입니다", "Infomation",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});
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
		panel.add(lbimage);
		panel.add(btninfo);
		panel.add(tfischeckout);
		panel.add(lbischeckout);
		panel.add(lblNewLabel);
		frame.getContentPane().add(panel);
		
		
		
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
