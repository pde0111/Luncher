package Login.DAO;

import java.sql.SQLException;

import Login.Member;

public interface DatabaseService {
	public void Insert(Member member) throws SQLException;
	public boolean Select(String id, String pw);
}
