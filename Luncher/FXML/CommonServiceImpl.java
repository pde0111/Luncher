package FXML;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonServiceImpl implements CommonService{

	@Override
	public void CloseWindow(ActionEvent event) {
		Parent root = (Parent)event.getSource();
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}

	@Override
	public Parent ShowWindow(Stage s, String formPath) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource(formPath));
		Parent root = null;
		
		try {
			root = loader.load();
			s.setScene(new Scene(root));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Control ctrler = loader.getController();
		ctrler.setRoot(root);
		s.show();
		return root;
	}

	@Override
	public Map<String, TextField> getTextFldInfo(Parent root, String[] txtFldArr) {
		Map<String, TextField> txtFldMap = new HashMap<String, TextField>();
		for (String txtFldId : txtFldArr) {
			TextField txtFld = (TextField)root.lookup(txtFldId);
			txtFldMap.put(txtFldId, txtFld);
		}
		return txtFldMap;
	}

	@Override
	public boolean isEmpty(Map<String, TextField> txtFldMap, String[] txtFldArr, String[] list) {
		CommonService comSrv = new CommonServiceImpl();
		int count = 0;
		for (String txtFldId : txtFldArr) {
			TextField txtFld = txtFldMap.get(txtFldId);
			if (txtFld.getText().isEmpty()) {
				txtFld.requestFocus();
				comSrv.ErrorMsg("Error", list[count]+"이(가) 비어 있습니다.", "다시 확인해 주세요");
				return true;
			}
			count++;
		}
		return false;
	}

	@Override
	public void ErrorMsg(String title, String headerTxt, String contentTxt) {
		Alert alert = new Alert(AlertType.WARNING);
		alert.setTitle(title);
		alert.setHeaderText(headerTxt);
		alert.setContentText(contentTxt);
		alert.show();
	}

	@Override
	public void InfoMsg(String title, String headerTxt, String contentTxt) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(headerTxt);
		alert.setContentText(contentTxt);
		alert.show();
		
	}
	

}
