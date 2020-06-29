package Charge;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class main extends Application{
	String name = "박민수";
	int payment = 111;
	@Override
	public void start(Stage primaryStage) throws Exception  {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("charge.fxml"));		
		Scene scene = new Scene(root);				
		Pane pane = new Pane();		 		
		
		Label lbl1 = new Label("이름");
		Label lbl2 = new Label("요금");
		
		TextField txt1 = new TextField(name);
		// db에 저장된 사용자의 이름을 불러오는 명령어
		String a = Integer.toString(payment);
		
		TextField txt2 = new TextField(a);
		// db에 저장된 사용자의 요금을 불러오는 명령어
		
		Button btn1 = new Button("결제");		
		//pane.getChildren().add(btn1);
 
		//btn1.setOnAction(event ->
		// 결제 버튼 클릭 후에 나올 명령어
		//{
			//WindowClose(scene);
			// 화면 종료 명령어  (Commonsrv안에)
		//});
		
		primaryStage.setTitle("요금창");
		primaryStage.setScene(scene);
		primaryStage.show();
	}		
	public static void main(String[] args) {
		launch(args);
	}
	
}
