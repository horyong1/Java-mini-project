package project1st;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;

public class Loans extends JFrame {
	private JFrame frame;
	private JPanel panel; 
	private String title;
	
	
	public Loans() {
		
	}
	
	public void LoansView() {
		frame = new JFrame("���� ����");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 393, 425);

		panel = new JPanel();
		panel.setBounds(0, 0, 377, 386);
		
		panel.setLayout(null);
		
		Label lbtitle = new Label("����");
		lbtitle.setBounds(165, 86, 69, 23);
		
		TextField tftitle = new TextField();
		tftitle.setBounds(240, 86, 97, 23);
		tftitle.setEnabled(false);
		
		Label lbauthor = new Label("����");
		lbauthor.setBounds(165, 126, 69, 23);
		
		TextField tfauthor = new TextField();
		tfauthor.setBounds(240, 126, 97, 23);
		tfauthor.setEnabled(false);
		
		Label lbpublisher = new Label("���ǻ�");
		lbpublisher.setBounds(165, 166, 69, 23);
		
		TextField tfpublisher = new TextField();
		tfpublisher.setBounds(240, 166, 97, 23);
		tfpublisher.setEnabled(false);
		
		Label lbgenre = new Label("�帣");
		lbgenre.setBounds(165, 206, 69, 23);
		
		TextField tfgenre = new TextField();
		tfgenre.setBounds(240, 206, 97, 23);
		tfgenre.setEnabled(false);
		
		Label lbpublication_date = new Label("������");
		lbpublication_date.setBounds(165, 246, 69, 23);
		
		TextField tfpublication_date = new TextField();
		tfpublication_date.setBounds(240, 246, 97, 23);
		tfpublication_date.setEnabled(false);
		
		Button btnloans = new Button("���� �ϱ�");
		btnloans.setBounds(64, 333, 76, 23);
		
		Button btncancel = new Button("���");
		btncancel.setBounds(228, 333, 76, 23);
		
		
		
		System.out.println(title);
		
		
		
		//��ư ��� ���
		btncancel.addActionListener(new ActionListener() {
		
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.dispose();
				
			}
		});
		//��ư ���� ���
		btnloans.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				//bd.selectTitle(tl);
				
				// TODO Auto-generated method stub
				int var = JOptionPane.showConfirmDialog(frame, "���� �Ͻðڽ��ϱ�?", "�����ϱ�", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null);
				if(var==0) {
					JOptionPane.showMessageDialog(getContentPane(),"���� ����", "Infomation",
							JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
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
		frame.getContentPane().add(panel);
		frame.setVisible(true);
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
