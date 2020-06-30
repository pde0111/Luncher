package Charge;

import java.net.URL;
import java.util.ResourceBundle;

import DataBase.Dataimply;
import FXML.Control;
import FXML.comimply;
import FXML.comserv;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ChargeController extends Control implements Initializable{
	String name = "민수"; // 임시
	String payment = "1000"; // 임시
	
	private Parent root;
	
	@FXML
	private TextField txt1;
	@FXML
	private TextField txt2;
	
	@FXML
	private Button btn;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub	
		txt1.setText(name);
		txt2.setText(payment);
		btn.setOnAction(Event -> Platformexit(Event));
	}
	public void Platformexit(ActionEvent e) {
		comserv com = new comimply();
		com.allclose();
	}
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}
	
}
