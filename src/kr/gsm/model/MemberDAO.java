package kr.gsm.model;

import java.awt.List;
import java.sql.*;
import java.util.*;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public Connection getDbConnection() {
		String URL="jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user="hr";
		String password="hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(URL, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public int memInsert(MemberVO vo) {
		conn = getDbConnection();
		String SQL="INSERT into tblmem values(seq_num.nextval,?,?,?,?,?)";
		int cnt=-1;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setInt(1, vo.getBun());
			ps.setString(2, vo.getName());
			ps.setString(3, vo.getTel());
			ps.setString(4, vo.getEmail());
			ps.setString(5, vo.getAddr());
			cnt = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return cnt;
	}
	
	public int memUpdate(MemberVO vo) {
		conn = getDbConnection();
		String SQL="UPDATE tblmem SET tel=?, email=?, addr=? where num=?";
		int state = 0;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setString(1, vo.getTel());
			ps.setString(2, vo.getEmail());
			ps.setString(3, vo.getAddr());
			ps.setInt(4, vo.getNum());
			state = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return state;
	}
	
	public int memDelete(String num) {
		conn = getDbConnection();
		String SQL="Delete from tblmem where num=?";
		int state = 0;
		try {
			ps=conn.prepareStatement(SQL);
			ps.setString(1, num);
			state = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return state;
	}
	
	public ArrayList<MemberVO> getAllList() {
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		conn = getDbConnection();
		String SQL="SELECT * from tblmem order by num desc";
		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				int bun = rs.getInt("bun");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String addr = rs.getString("addr");
				
				MemberVO vo = new MemberVO(num, bun, name, tel, email, addr);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}
	
	public void dbClose() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO memContent(int num) {
		conn = getDbConnection();
		String SQL="select * from tblmem where num=?";
		MemberVO vo = null;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				num = rs.getInt("num");
				int bun = rs.getInt("bun");
				String name = rs.getString("name");
				String tel = rs.getString("tel");
				String email = rs.getString("email");
				String addr = rs.getString("addr");
				vo = new MemberVO(num, bun, name, tel, email, addr);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	
		
}
