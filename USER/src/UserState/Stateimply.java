package UserState;

import java.util.List;

import DataBase.DataServ;
import DataBase.Dataimply;

public class Stateimply implements Stateserv {

	DataServ db = new Dataimply();
	
	@Override
	public String userinfo() {
		// TODO Auto-generated method stub
		
		
		String id = "aaa"; //임시 유저 아이디
		List user = db.UserInfo(id);
		
		return null;
	}

}
