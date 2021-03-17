package kr.hr.gui;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kr.hr.model.SubmitDAO;
import kr.hr.model.SubmitVO;

public class result {

   private JFrame frame;
   private JTable table;
   private JLabel lbl_background;
   
   public result(String mil_id) {
		initialize(mil_id);
		frame.setVisible(true);
	}

   private void initialize(String mil_id) {
      frame = new JFrame();
      frame.setBounds(300, 150, 960, 540);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(66, 214, 798, 159);
      frame.getContentPane().add(scrollPane);
      
      table = new JTable();
      scrollPane.setViewportView(table);
      
      // table 보여주기. 가변 배열로!
      SubmitDAO dao = new SubmitDAO();
      ArrayList<SubmitVO> list = dao.resultSelect(mil_id);
      String[] column = {"관리자 군번", "이름", "휴가시작일", "휴가종류", "사유", "허가여부", "비고"};
      Object[][] data = new Object[list.size()][column.length];

      for (int i = 0; i < list.size(); i++) {
         data[i][0] = list.get(i).getManager_id();
         data[i][1] = list.get(i).getName();
         data[i][2] = list.get(i).getSub_date();
         data[i][3] = list.get(i).getVac_type();
         data[i][4] = list.get(i).getReason();
         data[i][5] = list.get(i).getYn();
         data[i][6] = list.get(i).getNote();
      }
      
      table.setModel(new DefaultTableModel(data, column));
      Image image = new ImageIcon("image/result.png").getImage();
      
      JLabel lbl_background1 = new JLabel("");
      lbl_background1.setIcon(new ImageIcon(image.getScaledInstance(960, 540, Image.SCALE_SMOOTH)));
      lbl_background1.setBounds(0, 0, 960, 540);
      frame.getContentPane().add(lbl_background1);
      
      JLabel lblNewLabel = new JLabel("");
      lblNewLabel.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      	  	frame.dispose();
      	}
      });
      lblNewLabel.setBounds(763, 412, 128, 83);
      frame.getContentPane().add(lblNewLabel);
      

      
   }
}