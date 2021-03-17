package kr.hr.gui;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class apply {

	private JFrame frame;

	// main문 없애고 아래 추가해줌으로써 login 클래스에서 준 mil_id를 받을 수 있음
	public apply(String mil_id) {
		initialize(mil_id);
		frame.setVisible(true);
	}

	private void initialize(String mil_id) {
		frame = new JFrame();
		frame.setBounds(300, 150, 960, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// 이미지 경로
	      Image image = new ImageIcon("image/start2.png").getImage();
	      
		JLabel lbl_background = new JLabel("");
		lbl_background.setIcon(new ImageIcon(image.getScaledInstance(960, 540, Image.SCALE_SMOOTH)));
		lbl_background.setBounds(0, 0, 960, 540);
		frame.getContentPane().add(lbl_background);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// MainPanel 클래스에 mil_id 보내기
				new MainPanel(mil_id);
				frame.dispose();
			}
		});
		lblNewLabel.setBounds(129, 140, 295, 262);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// result 클래스에 mil_id 보내기
				new result(mil_id);
				frame.dispose();
			}
		});
		lblNewLabel_1.setBounds(541, 140, 287, 262);
		frame.getContentPane().add(lblNewLabel_1);
		
		
	}

}
