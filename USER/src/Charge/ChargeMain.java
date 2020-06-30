package Charge;

import FXML.comimply;
import FXML.comserv;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChargeMain extends Application{
	public void start(Stage primaryStage) throws Exception  {
		
		// TODO Auto-generated method stub	
		comserv com = new comimply();
		com.WinShow(primaryStage, "Charge.fxml");
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
