package kr.hr.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SubmitDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	private void getConnect() {
		String URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "hr";
		String password = "hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void getClose() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int complete(SubmitVO vo) {
		int result = 0;
		try {
			getConnect();
			String sql = "insert into submit (sub_date,end_date,reason,vac_type,mil_id,sub_number)"
					+ " values (?,?,?,?,?,num_seq.nextval)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getSub_date());
			psmt.setInt(2, vo.getEnd_date());
			psmt.setString(3, vo.getReason());
			psmt.setString(4, vo.getVac_type());
			psmt.setString(5, vo.getMil_id());
			result = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return result;
	}

	public ArrayList<SubmitVO> resultSelect(String mil_id) {
		ArrayList<SubmitVO> list = new ArrayList<SubmitVO>();
		try {
			getConnect();
			String sql = "select * from result where mil_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, mil_id);
			rs = psmt.executeQuery();
			while (rs.next()) {
				String manager_id = rs.getString(1);
				String name = rs.getString(2);
				int sub_date = rs.getInt(3);
				String vac_type = rs.getString(4);
				String reason = rs.getString(5);
				String yn = rs.getString(6);
				String note = rs.getString(7);
				SubmitVO dto = new SubmitVO(sub_date, reason, vac_type, mil_id, name, yn, note, manager_id);
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return list;
	}

	

}
