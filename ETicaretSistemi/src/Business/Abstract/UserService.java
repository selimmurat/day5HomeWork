package Business.Abstract;

import java.util.List;

import Entities.Concrete.User;

public interface UserService {

	void add(User user);

	void delete(User user);

	void update(User user);

	void login(User user);

	void sendMail(String eMail, String activationLink);

	User get(int id);

	List<User> getAll();

	boolean validateEmail(User user);

	boolean validatePassword(User user);
	
	boolean isUserActive(User user);

}
