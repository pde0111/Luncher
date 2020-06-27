package UserState;

import FXML.comimply;
import FXML.comserv;
import javafx.application.Application;
import javafx.stage.Stage;

public class StateMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		comserv com = new comimply();
		com.WinShow(primaryStage, "userfxml.fxml");
	}
	public static void main(String[] args) {
		launch(args);
	}
}
