package kr.hr.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import kr.hr.model.InformationDAO;

public class login {

	private JFrame frame;
	private JTextField txt_id;
	private JPasswordField txt_pw;
	private JLabel lblNewLabel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setForeground(Color.BLACK);
		frame.setTitle("\uC758\uACBD \uC601\uC678\uD65C\uB3D9 \uAD00\uB9AC \uC2DC\uC2A4\uD15C");
		frame.setBounds(300, 150, 960, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txt_id = new JTextField();
		txt_id.setFont(new Font("Dialog", Font.BOLD, 18));
		txt_id.setBackground(new Color(255, 255, 255));
		txt_id.setBounds(192, 401, 167, 31);
		frame.getContentPane().add(txt_id);
		txt_id.setColumns(10);

		// 투명하게 만드는 코드
		txt_id.setOpaque(false);
		txt_id.setBorder(null);

		txt_pw = new JPasswordField();
		txt_pw.setFont(new Font("Dialog", Font.BOLD, 18));
		txt_pw.setBackground(new Color(255, 255, 255));
		txt_pw.setBounds(547, 401, 167, 31);
		txt_pw.setOpaque(false);
		txt_pw.setBorder(null);

		frame.getContentPane().add(txt_pw);

		Image image = new ImageIcon("image/start1.png").getImage();
		JLabel lbl_background = new JLabel("");

		lbl_background.setIcon(new ImageIcon(image.getScaledInstance(960, 540, Image.SCALE_SMOOTH)));
		lbl_background.setBounds(0, 0, 960, 540);
		frame.getContentPane().add(lbl_background);

		lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String mil_id = txt_id.getText();
				int pw = Integer.parseInt(txt_pw.getText());
				InformationDAO dao = new InformationDAO();
				String name = dao.userlogin(mil_id, pw);

				if (name != null) {
					new apply(mil_id);
					frame.dispose();

				}

			}
		});
		lblNewLabel.setBounds(754, 388, 106, 56);
		frame.getContentPane().add(lblNewLabel);

	}
}