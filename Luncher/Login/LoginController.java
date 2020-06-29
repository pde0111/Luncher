

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import Login.Service.LoginService;
import Login.Service.MembershipService;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class LoginController extends Control implements Initializable{

	private Parent root;
	private CommonService comSrv;
	private LoginService loginSrv;
	private MembershipService memSrv;
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		comSrv = new CommonServiceImpl();
		loginSrv = new LoginServiceImpl();
		memSrv = new MembershipServiceImpl();
	}

	public void LoginProc() {
		//로그인 기능 구현
		String []txtFldArr = {"#idTxt", "#pwTxt"};
		String []list = {"아이디", "패스워드"};
		Map<String, TextField> txtFldMap = comSrv.getTextFldInfo(root, txtFldArr);
		
		if (comSrv.isEmpty(txtFldMap, txtFldArr, list)) {
			
			return;
		}
		
		//상태창 오픈
		loginSrv.OpenUserStateForm();
	}
	
	public void CancelProc(ActionEvent event) {
		comSrv.CloseWindow(event);
	}
	
	public void OpenMembershipForm() {
		Parent form = loginSrv.OpenMembershipForm();
	}
	
}
