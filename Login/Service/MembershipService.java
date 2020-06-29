package Login.Service;

import javafx.scene.Parent;

public interface MembershipService {
	public boolean comparePW(String pw, String pwOk);
	public String getCardNum(Parent membershipForm);
	
}
