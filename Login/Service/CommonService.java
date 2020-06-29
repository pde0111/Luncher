package Login.Service;

import java.util.Map;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public interface CommonService {
	//공통적으로 사용하는 기능 넣어주시면 됩니다.
	public void CloseWindow(ActionEvent event);//Window 닫기
	public Parent ShowWindow(Stage s, String formPath);//Window 열기
	public Map<String, TextField> getTextFldInfo(Parent root, String[] txtFldArr);
	public boolean isEmpty(Map<String, TextField> txtFldMap, String[] txtFldArr, String[] list);
	public void ErrorMsg(String title, String headerTxt, String contentTxt);
	public void InfoMsg(String title, String headerTxt, String contentTxt);
}
