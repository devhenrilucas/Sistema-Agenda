package dao;

import dao.imp.UserDaoJDBC;
import controller.DB;

public class DaoFactory {


public static UserDAO createUserDao(){
  return new UserDaoJDBC(DB.getConnection());
}

}

 