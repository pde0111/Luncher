package UserState;

import java.util.List;

import DataBase.DataServ;
import DataBase.Dataimply;
import FXML.comimply;
import FXML.comserv;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Stateimply implements Stateserv {

	DataServ db = new Dataimply();
	comserv comserv = new comimply();
	ActionEvent e;
	String id = "aaa"; //임시 유저 아이디
	int time; //줄어들 시간
	
	
	@Override
	public void test(ActionEvent e) {
		
		
	}
	@Override
	public void Countime(Parent root) {//시간 추가방법 구상
		// TODO Auto-generated method stub
		TextField timetxt = (TextField)root.lookup("#time");
		TextField name = (TextField)root.lookup("#name");
		
		List a = db.UserInfo(id);
		time=(int) a.get(2);
		System.out.println(time);
		name.setText((String)a.get(3));
		System.out.println(time+"들어온");
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				
				while(time>0) {
				time--;
				System.out.println(time+"줄어든");
				Platform.runLater(() -> {
					String txt2 = Integer.toString(time);
					System.out.println(time+"출력될");
					timetxt.setText(txt2);
					time=Integer.parseInt(txt2);
				db.update(id, time); //줄어든 시간을 데이터베이스에 업데이트
				
				}); //1000 -> 1초
				try {Thread.sleep(1000);}catch(InterruptedException inter) {}
				}	
			}
		};
		thread.setDaemon(true);
		thread.start();
	}

}
