package view;

import dao.DaoFactory;
import dao.UserDAO;
import dao.imp.UserDaoJDBC;
import model.entities.User;

public class teste {
 public static void main(String[] args) {
	 UserDAO userDao = DaoFactory.createUserDao();
	 System.out.println("oi");
	 User user = new User(null, "papa", "a@g", "3");
	 userDao.insert(user);
	 System.out.println("deu certo!" + user.getId());
 }
}
