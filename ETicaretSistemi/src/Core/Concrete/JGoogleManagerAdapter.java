package Core.Concrete;



import Core.Abstract.GoogleService;
import Entities.Concrete.User;
import JGoogle.JGoogleManager;

public class JGoogleManagerAdapter implements GoogleService {

	@Override
	public void addGoogleUser(User user) {
		System.out.println("Google Hesabý ile kayýt olunmuþtur. " + user.getFristName() + " "+ user.getLastName());
		
	}

	

	
	
	

}
