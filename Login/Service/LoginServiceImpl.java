package Login.Service;

import Login.DAO.DatabaseService;
import Login.DAO.DatabaseServiceImpl;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginServiceImpl implements LoginService{

	@Override
	public void LoginProc(Parent root) {
		TextField idTxt = (TextField)root.lookup("#idTxt");
		TextField pwTxt = (TextField)root.lookup("#pwTxt");
		
		DatabaseService db = new DatabaseServiceImpl();
		boolean login = db.Select(idTxt.getText(), pwTxt.getText());
		CommonService comSrv = new CommonServiceImpl();
		
		if(login) {
			comSrv.InfoMsg("Information", "정상적으로 로그인 되었습니다.", "");
		} else {
			comSrv.ErrorMsg("Error", "아이디 또는 패스워드가 틀립니다.", "다시 시도해 주세요");
		}
		//최종 정상 기능시 삭제. 테스트 출력 메세지.
		System.out.println("LoginProc() Test Message:\nID : "+idTxt.getText()+"\nPW : "+pwTxt.getText());
	}

	@Override
	public Parent OpenMembershipForm() {
		CommonService comSrv = new CommonServiceImpl();
		Stage membershipForm = new Stage();
		Parent form = comSrv.ShowWindow(membershipForm, "../Membership.fxml");
		//최종 정상 기능시 삭제. 테스트 출력 메세지
		
		System.out.println("정상적으로 OpenMembershipForm() 기능");
		return form;
	}
	
}
