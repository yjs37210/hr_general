package kr.hr.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import kr.hr.model.SubmitDAO;
import kr.hr.model.SubmitVO;

public class MainPanel {

	private JFrame frame;
	private JTextField txt_reason;
	private JCalendar calendar;
	private String start;
	private String temp;

	private String reason;
	private String vac_type;
	private int start1;
	private int temp1;

	public MainPanel(String mil_id) {
		initialize(mil_id);
		frame.setVisible(true);
	}

	private void initialize(String mil_id) {
		frame = new JFrame();
		frame.setBounds(300, 150, 970, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JComboBox cmb_type = new JComboBox();
		cmb_type.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 19));
		cmb_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JPanel jpanel = calendar.getDayChooser().getDayPanel();
				Component component[] = jpanel.getComponents();
				int offset = 8;

				for (int i = 0; i < component.length - offset; i++) {
					component[i + offset].setBackground(new JButton().getBackground());
				}

				Calendar cal = calendar.getCalendar();
				Date date = calendar.getDate();
				SimpleDateFormat df = new SimpleDateFormat("dd");

				String start = df.format(date);
				start1 = Integer.parseInt(start);

				try {
					date = df.parse(start);
				} catch (ParseException e2) {
					e2.printStackTrace();
				}

				cal.setTime(date);
				int choose = cmb_type.getSelectedIndex();

				switch (choose) {
				case 0:

				case 1:
					cal.add(Calendar.DAY_OF_MONTH, 10);

					break;
				case 2:
					cal.add(Calendar.DAY_OF_MONTH, 4);
					break;
				case 3:
					cal.add(Calendar.DAY_OF_MONTH, 2);
					break;
				case 4:
					cal.add(Calendar.DAY_OF_MONTH, 6);
					break;
				case 5:
					cal.add(Calendar.DAY_OF_MONTH, 1);
					break;

				}

				String temp = df.format(cal.getTime());
				temp1 = Integer.parseInt(temp);

				for (int i = start1; i < temp1; i++) {
					component[i + offset].setBackground(Color.LIGHT_GRAY);
				}
			}
		});
		cmb_type.setModel(new DefaultComboBoxModel(new String[] { "\uBC84\uD2BC\uC744\uB20C\uB7EC\uC8FC\uC138\uC694",
				"\uC815\uAE30\uD734\uAC00(9\uBC15 10\uC77C)", "\uC815\uAE30\uC678\uBC15(3\uBC15 4\uC77C)",
				"\uD2B9\uBCC4\uC678\uBC15(1\uBC152\uC77C)",
				"\uC815\uAE30\uC678\uBC15 + \uD2B9\uBCC4\uC678\uBC15(5\uBC15 6\uC77C)",
				"\uC815\uAE30\uC678\uCD9C (1\uC77C)" }));
		cmb_type.setBounds(500, 92, 254, 46);
		frame.getContentPane().add(cmb_type);

		txt_reason = new JTextField();
		txt_reason.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		txt_reason.setColumns(10);
		txt_reason.setBounds(500, 214, 344, 191);
		frame.getContentPane().add(txt_reason);

		calendar = new JCalendar();
		calendar.getDayChooser().addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
//				JDateChooser chooser = new JDateChooser();
			}
		});
		calendar.setBounds(12, 51, 476, 354);
		frame.getContentPane().add(calendar);
		Image image = new ImageIcon("image/start3.png").getImage();

		JLabel lbl_background = new JLabel("");
		lbl_background.setIcon(new ImageIcon(image.getScaledInstance(960, 540, Image.SCALE_SMOOTH)));
		lbl_background.setBounds(0, 0, 960, 540);
		frame.getContentPane().add(lbl_background);

		JLabel lbl_finish = new JLabel("");
		lbl_finish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new apply(mil_id);
				frame.dispose();

			}
		});
		lbl_finish.setBounds(484, 439, 246, 83);
		frame.getContentPane().add(lbl_finish);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				reason = txt_reason.getText();
				vac_type = (String) cmb_type.getSelectedItem();

				SubmitVO vo = new SubmitVO(start1, temp1, reason, vac_type, mil_id);
				SubmitDAO dao = new SubmitDAO();
				int count = dao.complete(vo);
				//int count2 = dao.complete2(vo);

				if (count > 0) {
					complete.main(null);
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "ÈÞ°¡ ½ÅÃ» ¿À·ù", "ÈÞ°¡½ÅÃ»", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lblNewLabel_1.setBounds(766, 439, 150, 83);
		frame.getContentPane().add(lblNewLabel_1);

	}
}