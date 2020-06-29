package Login.Service;

import javafx.scene.Parent;

public interface LoginService {
	//로그인 서비스
	public void LoginProc(Parent root);//로그인 기능 구현
	public Parent OpenMembershipForm();//회원가입 창 열기
	public Parent OpenUserStateForm();//유저상태창 열기
}
