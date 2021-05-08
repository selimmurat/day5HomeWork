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
		
		// Bussiness iþ kurallarýndan geçtiken sonra user kaydedilir ve mailin bir tane aktivasyon linki yollanýr. Kullanýcý linke týklayark
		// aktif ettiðini düþünürsek
		// aktif etmezse false olucaðýndan giriþ baþarýsýz hesabýnýz aktif deðildir aktif ediniz mesajý yansýtýlýyor.
		
		user1.setActive(true);		
		userService1.login(user1);
		
		
		//////////////////////////////////////////////////////////////////////////////////
		
		User googleUser = new User(2, "Yavuz Selim", "Murat", "yavuzselimmurat@gmail.com", "123456789");
		UserService userGoogleService = new UserManager(new JGoogleManagerAdapter());
		userGoogleService.add(googleUser);
	}

}
