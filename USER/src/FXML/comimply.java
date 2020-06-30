package FXML;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class comimply implements comserv{

	@Override
	public Parent WinShow(Stage stage, String Path) {
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader(getClass().getResource(Path));
		Parent root = null;

		try {
			root = (Parent) loader.load();
			stage.setScene(new Scene(root));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Control ctrler = (Control) loader.getController();
		ctrler.setRoot(root);
		stage.show();

		return root;
	}

	@Override
	public void WinClose(ActionEvent e) {
		// TODO Auto-generated method stub
		Parent root = (Parent)e.getSource();
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}

	@Override
	public void allclose() {
		// TODO Auto-generated method stub
		Platform.exit();
	}
	

}
