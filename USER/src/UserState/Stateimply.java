package UserState;

import java.util.List;

import DataBase.DataServ;
import DataBase.Dataimply;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class Stateimply implements Stateserv {

	DataServ db = new Dataimply();

	
	String id = "aaa"; //임시 유저 아이디
	
	int time;
	
	@Override
	public void test(Parent root) {
		
	}
	
	@Override
		public void userinfo(Parent root) {
			// TODO Auto-generated method stub
		List a = db.UserInfo(id);
		TextField name = (TextField)root.lookup("#name");
		name.setText((String)a.get(3));
		System.out.println("인포실행");
		}

	@Override
	public void Countime(Parent root) {
		// TODO Auto-generated method stub
		TextField timetxt = (TextField)root.lookup("#time");
		List a = db.UserInfo(id);
		time = (int) a.get(2);
		System.out.println(time);
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				
				while(time>0) {
				System.out.println(time+"들어온");
				time--;
				System.out.println(time+"줄어든");
				Platform.runLater(() -> {
					String txt2 = Integer.toString(time);
					System.out.println(time+"출력될");
					timetxt.setText(txt2);
					time=Integer.parseInt(txt2);//타임값을 getter setter에 보내서 재활용할 순 없을까
				}); //1000 -> 1초
				try {Thread.sleep(100);}catch(InterruptedException inter) {}
				}	
			}
		};
		thread.setDaemon(true);
		thread.start();
	}
}
