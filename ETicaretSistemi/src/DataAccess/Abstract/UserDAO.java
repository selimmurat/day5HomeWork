package DataAccess.Abstract;

import java.util.List;

import Entities.Concrete.User;

public interface UserDAO {

	void add(User user);

	void delete(User user);

	void update(User user);	

	User get(int id);

	List<User> getAll();

}
