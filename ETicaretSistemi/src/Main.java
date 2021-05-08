import Business.Abstract.UserService;
import Business.Concrete.UserManager;
import Core.Concrete.JGoogleManagerAdapter;
import DataAccess.Concrete.HibernateUserDAO;
import Entities.Concrete.User;
import JGoogle.JGoogleManager;

public class Main {

	public static void main(String[] args) {

		UserService userService1 = new UserManager(new HibernateUserDAO());
		
		User user1=new User(1, "Sel", "Murat", "selim.murat@windowslive.com", "123456");
		userService1.add(user1);
		
		// Bussiness i� kurallar�ndan ge�tiken sonra user kaydedilir ve mailin bir tane aktivasyon linki yollan�r. Kullan�c� linke t�klayark
		// aktif etti�ini d���n�rsek
		// aktif etmezse false oluca��ndan giri� ba�ar�s�z hesab�n�z aktif de�ildir aktif ediniz mesaj� yans�t�l�yor.
		
		user1.setActive(true);		
		userService1.login(user1);
		
		
		//////////////////////////////////////////////////////////////////////////////////
		
		User googleUser = new User(2, "Yavuz Selim", "Murat", "yavuzselimmurat@gmail.com", "123456789");
		UserService userGoogleService = new UserManager(new JGoogleManagerAdapter());
		userGoogleService.add(googleUser);
	}

}
