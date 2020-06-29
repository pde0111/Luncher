package Login.DAO;

import java.sql.SQLException;
import java.util.List;

import Login.Member;

public interface DatabaseService {
	public void member () ; // 회원 등록 
	public void Insert(Member member) throws SQLException;
	public boolean Select(String id, String pw);
	public void update(String id,int time);
	public List<Object> UserInfo(String id);
}
