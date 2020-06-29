package Login.Service;

import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class MembershipServiceImpl implements MembershipService{

	@Override
	public boolean comparePW(String pw, String pwOk) {
		
		return pw.contentEquals(pwOk);
	}

	@Override
	public String getCardNum(Parent membershipForm) {
		TextField cardNum = (TextField)membershipForm.lookup("#cardNum");
		
		if(cardNum == null) {
			return "";
		}
		return cardNum.toString();
	}

}
