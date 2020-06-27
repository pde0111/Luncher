package DataBase;

import java.util.List;

public interface DataServ {
	public List<Object> UserInfo (String id); //남은시간을 불러옴
	public void update (String id,int time); // 종료시 남은시간 업데이트
}
