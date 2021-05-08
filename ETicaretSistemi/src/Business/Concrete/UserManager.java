package Business.Concrete;

import java.util.List;
import java.util.regex.Pattern;

import Business.Abstract.UserService;
import Core.Abstract.GoogleService;
import DataAccess.Abstract.UserDAO;
import Entities.Concrete.User;

public class UserManager implements UserService {

	private UserDAO userDAO;
	private GoogleService googleService;

	public UserManager(UserDAO userDAO) {
		this.userDAO = userDAO;		
	}

	public UserManager(GoogleService googleService) {		
		this.googleService = googleService;
	}

	@Override
	public void add(User user) {
		if (!validateEmail(user)) {
			System.out.println("E-posta alaný e-posta formatýnda olmalýdýr. ");
			return;
		} else if ((user.getFristName().length() < 3) || (user.getLastName().length() < 3)) {
			System.out.println("Ad ve soyad en az iki karakterden oluþmalýdýr.");
			return;

		} else if (!validatePassword(user)) {
			System.out.println("Parola en az 6 karakterden oluþmalýdýr.");
			return;
		}
		sendMail(user.geteMail(), "aktivasyon.html");
		if (this.userDAO!=null) {
			this.userDAO.add(user);
		}
		else if (this.googleService!=null) {
			this.googleService.addGoogleUser(user);
		}
	}

	@Override
	public boolean validateEmail(User user) {
		String emailRegex = "[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.[a-zA-Z]{2,3}[.] {0,1}[a-zA-Z]+";
		return Pattern.matches(emailRegex, user.geteMail());

	}

	@Override
	public boolean validatePassword(User user) {
		String passwordRegex = ".{6,}";
		return Pattern.matches(passwordRegex, user.getPassword());
	}

	@Override
	public void login(User user) {
		for (User user1 : this.userDAO.getAll()) {
			if (!(user1 == user)) {
				System.out.println("Böyle bir kullanýcý yok öncellikle üye olmaný gerekmektedir.");
			} else if (this.userDAO.isActive(user)) {
				System.out.println("Sisteme baþarýlý bir þekilde giriþ yaptýnýz.");
			} else {
				System.out.println(
						"Hesabýnýz aktif edilmemiþ.Mail hesabýnýza gönderilen aktivasyon linkini týklayarak hesabýnýzý aktif hale getirebilrisiniz.");
			}
		}

	}

	@Override
	public void sendMail(String eMail, String activationLink) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
