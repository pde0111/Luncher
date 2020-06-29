package State;

import java.util.List;

import FXML.CommonService;
import FXML.CommonServiceImpl;
import Login.DAO.DatabaseService;
import Login.DAO.DatabaseServiceImpl;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Stateimply implements Stateserv {

	DatabaseService db = new DatabaseServiceImpl();
	CommonService comserv = new CommonServiceImpl();
	ActionEvent e;
	String id = "aaa"; //임시 유저 아이디 getter 
	int time; //임시 줄어들 시간 getter
	int set=55;  //임시 컴퓨터 자리 getter
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
	@Override
	public void test(ActionEvent e) {
	
	}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
	@Override
	public void Countime(Parent root) {//시간 추가방법 구상
		// TODO Auto-generated method stub
		TextField timetxt = (TextField)root.lookup("#time");
		TextField name = (TextField)root.lookup("#name");
		TextField com = (TextField)root.lookup("#com");
		TextField total = (TextField)root.lookup("#total");
		
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				String computer = Integer.toString(set);
				com.setText(computer);
				List a = db.UserInfo(id); //<= getter 로 받을 것
				time=(int) a.get(2);
				System.out.println(time);
				name.setText((String)a.get(3));
				System.out.println(time+"시작시간"); 
				
				
				while(time>0) {
				time++;
				System.out.println(time+"줄어든");
				Platform.runLater(() -> {
					int fee = ((time/60)*1000)+1000; // +getter음식요금 and setter넘기기
					String feetxt =Integer.toString(fee);
					total.setText(feetxt+"원");
					
					int hour = (time/60);
					int min	 = (time%60);
					
					String totaltimehour = Integer.toString(hour);
					String totaltimemin = Integer.toString(min);
					
					timetxt.setText(totaltimehour+"시간"+totaltimemin+"분");
				db.update(id, time); //<=시간값과 총이용금액 setter 로 보낼것
				
				}); //1000 -> 1초
				try {Thread.sleep(1000);}catch(InterruptedException inter) {}
				}	
			}
		};
		thread.setDaemon(true);
		thread.start();
	}

}
