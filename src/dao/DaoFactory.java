package dao;

import dao.imp.UserDaoJDBC;
import dao.imp.VenueDaoJDBC;
import controller.DB;

public class DaoFactory {
	public static UserDAO createUserDao(){
	  return new UserDaoJDBC(DB.getConnection());
	}
	public static VenueDAO createVenueDAO() {
		return new VenueDaoJDBC(DB.getConnection());
	}
}

 