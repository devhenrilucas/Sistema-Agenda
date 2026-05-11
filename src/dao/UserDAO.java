package dao;

import java.util.List;

import model.entities.User;

public interface UserDAO {

 void insert(User obj);
 void update(User obj);
 void deletById(Integer id);
 User findById(Integer id);
 List<User> findAll();
 
}
 