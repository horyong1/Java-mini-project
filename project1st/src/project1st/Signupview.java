package project1st;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Signupview extends JFrame {
	private JFrame jf;
	private JTextField tfid;
	private JTextField tfname;
	private JTextField tftel;
	private JTextField tfemail;
	private JPasswordField passwordField;
	private JPasswordField passwordckField;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Signupview() {
		setTitle("\uB3C4\uC11C\uAD00 \uAD00\uB9AC \uD504\uB85C\uADF8\uB7A8");
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(null);
		setBackground(Color.DARK_GRAY);

		JButton btnok = new JButton("\uD655\uC778");
		btnok.setBounds(97, 370, 97, 23);
		getContentPane().add(btnok);

		JButton btncancel = new JButton("\uCDE8\uC18C");
		btncancel.setBounds(251, 370, 97, 23);
		getContentPane().add(btncancel);

		JLabel lbid = new JLabel("\uC544\uC774\uB514");
		lbid.setBounds(108, 86, 48, 15);
		getContentPane().add(lbid);

		JLabel lbpwd = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lbpwd.setBounds(108, 121, 58, 15);
		getContentPane().add(lbpwd);

		JLabel lbpwdck = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		lbpwdck.setBounds(108, 159, 87, 15);
		getContentPane().add(lbpwdck);

		JLabel lbname = new JLabel("\uC774\uB984");
		lbname.setBounds(108, 199, 36, 15);
		getContentPane().add(lbname);

		JLabel lbtel = new JLabel("\uC804\uD654\uBC88\uD638");
		lbtel.setBounds(108, 238, 58, 15);
		getContentPane().add(lbtel);

		JLabel lbemail = new JLabel("\uC774\uBA54\uC77C");
		lbemail.setBounds(108, 274, 43, 15);
		getContentPane().add(lbemail);

		tfid = new JTextField();
		tfid.setBounds(214, 83, 116, 21);
		getContentPane().add(tfid);
		tfid.setColumns(10);

		tfname = new JTextField();
		tfname.setBounds(214, 196, 116, 21);
		getContentPane().add(tfname);
		tfname.setColumns(10);

		tftel = new JTextField();
		tftel.setColumns(10);
		tftel.setBounds(214, 235, 116, 21);
		getContentPane().add(tftel);

		tfemail = new JTextField();
		tfemail.setColumns(10);
		tfemail.setBounds(214, 271, 116, 21);
		getContentPane().add(tfemail);

		passwordField = new JPasswordField();
		passwordField.setBounds(214, 118, 116, 21);
		getContentPane().add(passwordField);

		passwordckField = new JPasswordField();
		passwordckField.setBounds(214, 156, 116, 21);
		getContentPane().add(passwordckField);

		JRadioButton rbtngender1 = new JRadioButton("\uB0A8");
		rbtngender1.setSelected(true);
		rbtngender1.setBounds(230, 309, 48, 23);
		getContentPane().add(rbtngender1);

		JRadioButton rbtngender2 = new JRadioButton("\uC5EC");
		rbtngender2.setBounds(282, 309, 48, 23);
		getContentPane().add(rbtngender2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtngender1);
		bg.add(rbtngender2);

		JLabel lbgender = new JLabel("\uC131\uBCC4");
		lbgender.setBounds(108, 313, 36, 15);
		getContentPane().add(lbgender);

		JLabel lbtitle = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lbtitle.setFont(new Font("굴림", Font.PLAIN, 21));
		lbtitle.setBounds(177, 22, 80, 41);
		getContentPane().add(lbtitle);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		panel.setBounds(0, 0, 10, 10);
		getContentPane().add(panel);

		btnok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(getContentPane(),"회원 가입이 완료되었습니다!", "Message",
						JOptionPane.INFORMATION_MESSAGE);

				dispose();
				new Loginview();
			}
		});

		btncancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Loginview();
			}
		});

		setVisible(true);

	}
}
