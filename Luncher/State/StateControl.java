package State;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import FXML.CommonService;
import FXML.CommonServiceImpl;
import FXML.Control;
import Login.DAO.DatabaseService;
import Login.DAO.DatabaseServiceImpl;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class StateControl extends Control implements Initializable {

		private Parent root;
		private DatabaseService db;
		private Stateserv state;
		private CommonService com;
	@Override
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root=root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		db = new DatabaseServiceImpl();
		state = new Stateimply();
		com = new CommonServiceImpl();
		
	}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
	public void test (ActionEvent e) {
		state.test(e);
	}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%//
	
	public void order (ActionEvent e) {
		//음식 주문
	}

	public void end (ActionEvent e) { //종료버튼
		com.CloseWindow(e);
	}
	
	public void Countime (ActionEvent e) { //상태창으로 넘어오기전에 이 메소드부터 넘겨보자 콤보박스처럼
		state.Countime(root);			   // 주문 버튼에 임시등록되어있음
	}	
}
