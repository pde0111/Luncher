package Login;

import java.net.URL;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

import Login.DAO.DatabaseService;
import Login.DAO.DatabaseServiceImpl;
import Login.Service.CommonService;
import Login.Service.CommonServiceImpl;
import Login.Service.MembershipService;
import Login.Service.MembershipServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MembershipController extends Controller implements Initializable{
	
	private Parent root;
	private CommonService comSrv;
	private MembershipService memSrv;
	
	
	
	@FXML private CheckBox ckBox;
	@FXML private Button memBtn;
	
	
	
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//회원가입 버튼 disable 을 통해 클릭 못하도록 설정
		memBtn.setDisable(true);

		
		comSrv = new CommonServiceImpl();
		memSrv = new MembershipServiceImpl();
	}
	
	public void CheckProc(ActionEvent event) {
		//체크박스 체크시 회원가입 버튼 disable 비활성화. 클릭가능하게 설정
		if (ckBox.isSelected()) {
			memBtn.setDisable(false);
		} else if(!ckBox.isSelected()) {
			//다시 체크박스가 헤제될시 회원가입 버튼 비활성화
			memBtn.setDisable(true);
		}
	}
	
	public void CancelProc(ActionEvent event) {
		comSrv.CloseWindow(event);
	}
	
	private boolean isCheck(Map<String, TextField> txtFldMap, String[] txtFldArr, String[] list) {
		
		if(comSrv.isEmpty(txtFldMap, txtFldArr, list)) {
			return false;
		}
		
		String pw = txtFldMap.get(txtFldArr[2]).getText();
		String pwOk = txtFldMap.get(txtFldArr[3]).getText();
		if(!memSrv.comparePW(pw, pwOk)) {
			comSrv.ErrorMsg("Error", "입력하신 패스워드와 일치하지 않습니다.", "다시 확인해 주세요.");
			txtFldMap.get(txtFldArr[2]).clear();
			txtFldMap.get(txtFldArr[2]).requestFocus();
			txtFldMap.get(txtFldArr[3]).clear();
			return false;
		}
		return true;
	}
	
	public void MembershipProc() throws SQLException{
		String []txtFldArr = {"#txtName", "#txtID","#txtPw","#txtPwOk","#cardNum"};
		String []list = {"이름", "아이디", "암호", "암호확인","카드번호"};
		Map<String, TextField> txtFldMap = comSrv.getTextFldInfo(root, txtFldArr);
		
		if(!isCheck(txtFldMap, txtFldArr, list)) {
			return;
		}
		
		if(comSrv.isEmpty(txtFldMap, txtFldArr, list)) {
			comSrv.ErrorMsg("Error", "비어있는 항목이 있습니다.", "다시 확인해 주세요");
			return;
		}
		
		Member member = new Member();
		member.setName(txtFldMap.get(txtFldArr[0]).getText());
		member.setId(txtFldMap.get(txtFldArr[1]).getText());
		member.setPw(txtFldMap.get(txtFldArr[2]).getText());
		member.setCardNum(txtFldMap.get(txtFldArr[4]).getText());
		
		if(member.getCardNum().matches("\\d{16}")) {
			System.out.println("16자 제한 성공");
		} else {
			comSrv.ErrorMsg("Error", "카드번호는 16자리 여야 합니다", "다시 확인해 주세요");
			return;
		}
		
		
		//테스트 메세지 출력. 최종 기능 확인시 삭제
		System.out.println("MembershipProc() getId : "+member.getId());
		System.out.println("MembershipProc() getPw : "+member.getPw());
		System.out.println("MembershipProc() getName : "+member.getName());
		System.out.println("MembershipProc() getCardNum : "+member.getCardNum());
		
		DatabaseService db = new DatabaseServiceImpl();
		
		db.Insert(member);
		comSrv.InfoMsg("Information", "회원 가입이 완료되었습니다", "로그인 하시기 바랍니다.");
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
		
	}
	

}
