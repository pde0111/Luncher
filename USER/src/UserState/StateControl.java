package UserState;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import DataBase.DataServ;
import DataBase.Dataimply;
import FXML.Control;
import FXML.comimply;
import FXML.comserv;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class StateControl extends Control implements Initializable {

		private Parent root;
		private DataServ db;
		private Stateserv state;
		private comserv com;
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root=root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		db = new Dataimply();
		state = new Stateimply();
		com = new comimply();
		
	}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
	public void test (ActionEvent e) {
		state.userinfo(root);
	}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
	
	public void order (ActionEvent e) {
		//음식 주문
	}
	
	public void addtime (ActionEvent e) {
		//시간 충전
	}
	
	public void end (ActionEvent e) {
	
	}
	
	public void Countime (ActionEvent e) { //상태창으로 넘어오기전에 이 메소드부터 넘겨보자 콤보박스처럼
		state.Countime(root);
	}	
}
