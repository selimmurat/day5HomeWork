package DataAccess.Concrete;

import java.util.ArrayList;
import java.util.List;

import Core.Abstract.GoogleService;
import DataAccess.Abstract.UserDAO;
import Entities.Concrete.User;

public class HibernateUserDAO implements UserDAO {

	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {

		users.add(user);
		System.out.println("Hibernate ile kullan�c� kaydedilmi�tir: " + user.getFristName() + " " + user.getLastName());

	}

	@Override
	public void delete(User user) {

		users.remove(user);
		System.out.println("Kullan�c� silinmi�tir. " + user.getFristName() + "  " + user.getLastName());

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void login(String eMail, String password) {
		System.out.println("Sisteme ba�ar�l� giri� yap�lm��t�r.");
	}

	@Override
	public boolean isActive(User user) {
		if (user.isActive()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}
}
