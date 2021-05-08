import Business.Abstract.UserService;
import Business.Concrete.UserManager;
import Core.Concrete.JGoogleManagerAdapter;
import DataAccess.Concrete.HibernateUserDAO;
import Entities.Concrete.User;
import JGoogle.JGoogleManager;

public class Main {

	public static void main(String[] args) {		
		

		UserService userService1 = new UserManager(new HibernateUserDAO());
		User user1 = new User(1, "Se", "Murat", "selim.murat@windowslive.com", "123456");
		userService1.add(user1);
		
		UserService userService2 = new UserManager(new HibernateUserDAO());
		User user2 = new User(1, "Selim", "Mu", "selim.murat@windowslive.com", "123456");
		userService2.add(user2);
		
		UserService userService3 = new UserManager(new HibernateUserDAO());
		User user3 = new User(1, "Selim", "Murat", "selim.muratwindowslive.com", "123456");
		userService3.add(user3);
		
		UserService userService4 = new UserManager(new HibernateUserDAO());
		User user4 = new User(1, "Selim", "Murat", "selim.murat@windowslive.com", "12345");
		userService4.add(user4);
		
		UserService userService5 = new UserManager(new HibernateUserDAO());
		User user5 = new User(1, "Selim", "Murat", "selim.murat@windowslive.com", "123456");
		userService5.add(user5);
		
		UserService userService6 = new UserManager(new HibernateUserDAO());
		User user6 = new User(2, "Ramazan", "Murat", "ramazan.murat@windowslive.com", "1234567");
		userService6.add(user6);
		

		// Bussiness iþ kurallarýndan geçtiken sonra user kaydedilir ve mailin bir tane
		// aktivasyon linki yollanýr. Kullanýcý linke týklayark
		// aktif ettiðini düþünürsek
		// aktif etmezse false olucaðýndan giriþ baþarýsýz hesabýnýz aktif deðildir
		// aktif ediniz mesajý yansýtýlýyor.

		user5.setActive(true);
		userService5.login(user5);
		userService6.login(user6);
		
		/////////////////////////////////////////////////////////////////////////////////////
		
		User googleUser = new User(2, "Yavuz Selim", "Murat", "yavuzselimmurat@gmail.com", "123456789");
		UserService userGoogleService = new UserManager(new JGoogleManagerAdapter());
		userGoogleService.add(googleUser);		
		
	}

}
