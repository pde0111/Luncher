package Login;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Login.Service.CommonService;
import Login.Service.CommonServiceImpl;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


	public class SeatControl extends Controller implements Initializable {
	
	@FXML private Button ok;
	@FXML private ToggleButton a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12;
	@FXML private ToggleButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	@FXML private ToggleButton c1,c2,c3,c6,c7,c8,c9,c10,c11,c12;
	@FXML private ToggleButton d1,d2,d3,d6,d7,d8,d9,d10,d11,d12;
	@FXML private Label lbl;
	private Parent root; 
	
	
	
	
	public void setRoot(Parent root) {
		// TODO Auto-generated method stub
		this.root = root;
	}

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		CommonService comSrv = new CommonServiceImpl();
		// 토글그룹 변수
		ToggleGroup group = new ToggleGroup();
		
		// 토글버튼 리스트에 추가
		ArrayList<ToggleButton> list = new ArrayList<ToggleButton>();
		list.add(a1);list.add(a2);list.add(a3);list.add(a4);list.add(a5);list.add(a6);
		list.add(a7);list.add(a8);list.add(a9);list.add(a10);list.add(a11);list.add(a12);	
		list.add(b1);list.add(b2);list.add(b3);list.add(b4);list.add(b5);list.add(b6);
		list.add(b7);list.add(b8);list.add(b9);list.add(b10);list.add(b11);list.add(b12);		
		list.add(c1);list.add(c2);list.add(c3);list.add(c6);list.add(c7);
		list.add(c8);list.add(c9);list.add(c10);list.add(c11);list.add(c12);		
		list.add(d1);list.add(d2);list.add(d3);list.add(d6);list.add(d7);
		list.add(d8);list.add(d9);list.add(d10);list.add(d11);list.add(d12);
	
		
		// 토글버튼을 그룹에 추가
		for(int k=0;k<list.size();k++) {
			list.get(k).setToggleGroup(group);
		}
		
		
	    // 좌석 칸에 뜨는 좌석 번호 초기화 변수(1 ~ 12까지만 뜸)
		int cnt = 1;
		
		// 좌석 번호 표시
		// A열
		for(int i=0;i<12;i++) {
			String a = "a"+(i+1);		
			list.get(i).setOnAction(e->{lbl.setText(a);});	
		}	
		
		// B열
		for(int i=12;i<24;i++) {
			String b = "b"+cnt;			
			list.get(i).setOnAction(e->{lbl.setText(b);});	
			cnt += 1;
			if(cnt>12) {
				cnt = 1;
			}
		}	
		
		// C열
		for(int i=24;i<34;i++) {
			String c = "c"+cnt;
			list.get(i).setOnAction(e->{lbl.setText(c);});	
			if(i==26) {
				cnt += 2;
			}
			cnt += 1;
			if(cnt>12) {
				cnt = 1;
			}
		}	
		
		// D열
		for(int i=34;i<44;i++) {
			String d = "d"+cnt;		
			list.get(i).setOnAction(e->{lbl.setText(d);});	
			if(i==36) {
				cnt += 2;
			}
			cnt += 1;
			if(cnt>12) {
				cnt = 1;
			}
		}
		
		
		// 확인 버튼 클릭시 로그인 팝업창
		ok.setOnAction(e-> {
			Stage LoginForm = new Stage();
			System.out.println("test");
			Parent form = comSrv.ShowWindow(LoginForm, "../Login.fxml");
			// 결제완료 후 적용 할 기능
			String lblck = lbl.getText();
			
			for(int i=0;i<list.size();i++) {
				if(list.get(i).getId().equals(lblck)) {
					list.get(i).setDisable(true);list.get(i).setStyle("-fx-background-color:skyblue; -fx-background-radius:10px");
				}
				
			}
		});
	}
	
}
	
