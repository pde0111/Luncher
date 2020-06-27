package UserState;

import java.net.URL;
import java.util.ResourceBundle;

import DataBase.DataServ;
import DataBase.Dataimply;
import FXML.Control;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class StateControl extends Control implements Initializable {

		private Parent root;
		private DataServ db;
		private Stateserv state;
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root=root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		db = new Dataimply();
	}

}
