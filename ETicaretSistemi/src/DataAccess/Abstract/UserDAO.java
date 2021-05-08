package DataAccess.Abstract;

import java.util.List;

import Entities.Concrete.User;

public interface UserDAO {

	void add(User user);

	void delete(User user);

	void update(User user);
	
	void login(String eMail, String password);
	
	boolean isActive(User user);

	User get(int id);

	List<User> getAll();

}
