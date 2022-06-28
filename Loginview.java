package project1st;



import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.Color;


public class Loginview extends JFrame {
	private JTextField tfid;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public Loginview() {
		getContentPane().setBackground(Color.GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 220);

		JLabel title = new JLabel("\uB85C\uADF8\uC778");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.BOLD, 14));

		JLabel lbid = new JLabel("\uC544\uC774\uB514");
		lbid.setForeground(Color.WHITE);
		lbid.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));

		tfid = new JTextField();
		tfid.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		tfid.setColumns(10);

		JLabel lbpwd = new JLabel("\uD328\uC2A4\uC6CC\uB4DC");
		lbpwd.setForeground(Color.WHITE);
		lbpwd.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));
		JButton btnlogin = new JButton("\uB85C\uADF8\uC778");
		btnlogin.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));

		JButton btncancel = new JButton("\uCDE8\uC18C");
		btncancel.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));

		JButton btnsignup = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnsignup.setFont(new Font("«‘√ ∑“µ∏øÚ", Font.PLAIN, 12));

		passwordField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addGap(132)
						.addComponent(title, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE).addGap(107))
				.addGroup(groupLayout.createSequentialGroup().addGap(34).addComponent(btnlogin)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btncancel, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnsignup)
						.addContainerGap(33, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup().addGap(50)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lbpwd).addGap(18)
										.addComponent(passwordField))
								.addGroup(groupLayout.createSequentialGroup().addGap(12).addComponent(lbid).addGap(18)
										.addComponent(tfid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(72, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(title).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(tfid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lbid))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lbpwd).addComponent(
								passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnlogin)
								.addComponent(btncancel).addComponent(btnsignup))
						.addContainerGap(32, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

		btnsignup.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Signupview();
			}
		});

		btncancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				

			}
		});
		setVisible(true);
	}
}
