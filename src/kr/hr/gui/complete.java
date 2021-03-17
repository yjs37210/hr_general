package kr.hr.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class complete {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					complete window = new complete();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public complete() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(300, 150, 960, 540);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	      Image image = new ImageIcon("image/start4.png").getImage();
	      
	      JLabel lbl_background = new JLabel("");
	      lbl_background.setIcon(new ImageIcon(image.getScaledInstance(960, 540, Image.SCALE_SMOOTH)));
	      lbl_background.setBounds(0, 0, 960, 540);
		frame.getContentPane().add(lbl_background);
		
		JLabel lbl_back = new JLabel("");
		lbl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 login.main(null);
	               frame.dispose();
			}
		});
		lbl_back.setBounds(219, 316, 310, 93);
		frame.getContentPane().add(lbl_back);
		
		JLabel lbl_closee = new JLabel("");
		lbl_closee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
	               frame.dispose();
			}
		});
		lbl_closee.setBounds(626, 316, 136, 93);
		frame.getContentPane().add(lbl_closee);
	}
}
