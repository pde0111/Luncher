package Login.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Login.Member;

public class DatabaseServiceImpl implements DatabaseService{
	
	final static String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final static String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	final static String user = "system";
	final static String pass = "oracle";
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private List<Object> list = new ArrayList();
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Insert(Member member) throws SQLException {
		
		try {
			//member.get ~ 로 되어있으니 나중에 공통 Bean 파일 생성시 그쪽으로 옮길것.
			con = DriverManager.getConnection(url, user, pass);
			String sql = "insert into member_1 values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, member.getId());
			ps.setString(2, member.getPw());
			ps.setString(3, member.getName());
//			ps.setString(4, member.getCardNum()); 카드번호는 받지 않는 것으로.
			int res = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean Select(String id, String pw) {
		boolean result = true;
		
		try {
			con = DriverManager.getConnection(url, user, pass);
			String sql = "select * from member_1 where id=? and pw=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			if (rs.next() == false) {
				return false;
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
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
	public void member() {
		// TODO Auto-generated method stub
		
	}

}
