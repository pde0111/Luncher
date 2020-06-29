package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Dataimply implements DataServ {
	final static String DRIVER = ("oracle.jdbc.driver.OracleDriver");
	final static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	final static String user = "system";
	final static String pass = "oracle";
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private List<Object> list = new ArrayList(); //회원정보 리스트
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception var1) {
			var1.printStackTrace();
		}

	}
	@Override
	public List<Object> UserInfo(String id) { 
		// TODO Auto-generated method stub
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "oracle");
			String sql = "select * from comuser where id = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
			list.add(rs.getString("id"));
			list.add(rs.getString("pw"));
			list.add(rs.getInt("time"));
			list.add(rs.getString("name"));
			}
			
			int a = ps.executeUpdate();
			
				} catch (Exception e) {
					e.printStackTrace();
					}
		return list;
	}

	@Override
	public void update(String id,int time) {
		// TODO Auto-generated method stub
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "system", "oracle");
			String sql = "update comuser set time = ? where id = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, time);
			ps.setString(2, id);
			
			ps.executeUpdate();
			
			sql="commit";
			ps=con.prepareStatement(sql);
			
			ps.executeUpdate();
			System.out.println("업데이트완료");
			
			rs.close();
			ps.close();
			con.close();
			
				} catch (Exception e) {
					e.printStackTrace();
					}
	}
}
