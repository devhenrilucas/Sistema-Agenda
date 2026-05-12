package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.DB;
import dao.UserDAO;
import model.entities.User;
import model.exception.DbException;



public class UserDaoJDBC implements UserDAO {

private Connection conn;

public UserDaoJDBC(Connection conn) {
  this.conn = conn;
}

@Override
public void insert(User obj) {

  PreparedStatement st = null;

  try {
   st = conn.prepareStatement("INSERT INTO Pessoa " + " (nome, email, telefone ) " + " VALUES" + " (?, ?, ?)",
     Statement.RETURN_GENERATED_KEYS);

   st.setString(1, obj.getName());
   st.setString(2, obj.getEmail());
   st.setString(3, obj.getPhone());

   int rowsAffected = st.executeUpdate();

   if (rowsAffected > 0) {
    ResultSet rs = st.getGeneratedKeys();
    if (rs.next()) {
     int id = rs.getInt(1);
     obj.setId(id);
    }
    DB.closeResultSet(rs);
   }

  } catch (SQLException e) {

   throw new DbException(e.getMessage());

  } finally {

   DB.closeStatment(st);

  }

}

@Override
public void update(User obj) {

  PreparedStatement st = null;

  try {
   st = conn.prepareStatement("UPDATE Pessoa " + "SET Name = ?, Email = ?, Telefone = ? " + "WHERE Id = ?");

   st.setString(1, obj.getName());
   st.setString(2, obj.getEmail());
   st.setString(3, obj.getPhone());
   st.setInt(4, obj.getId());

   st.executeUpdate();

  } catch (SQLException e) {

   throw new DbException("Erro ao atualizar a pessoa!");

  } finally {

   DB.closeStatment(st);

  }

}

@Override
public void deletById(Integer id) {

  PreparedStatement st = null;

  try {
   st = conn.prepareStatement("DELETE FROM Pessoa " + "WHERE Id = ?");

   st.setInt(1, id);
   st.executeUpdate();

  } catch (SQLException e) {

   throw new DbException("Erro ao deletar usuario");

  } finally {

   DB.closeStatment(st);

  }

}

@Override
public User findById(Integer id) {

  PreparedStatement st = null;
  ResultSet rs = null;

  try {

   st = conn.prepareStatement("SELECT * FROM Pessoa "
     + "WHERE id_pessoa = ?");

   st.setInt(1,  id);

   rs = st.executeQuery();

   if (rs.next()) {
    User user = instatiateUser(rs);
    return user;
   }

   return null;
  } catch (SQLException e) {
   throw new DbException(e.getMessage());
  } finally {

   DB.closeStatment(st);
   DB.closeResultSet(rs);

  }

}

@Override
public List<User> findAll() {

  PreparedStatement st = null;
  ResultSet rs = null;

  try {

   st = conn.prepareStatement("SELECT * FROM Pessoa "
     + "ORDER BY Pessoa.name");

   rs = st.executeQuery();
   List<User> user = new ArrayList<User>();

   while (rs.next()) {

    User obj = instatiateUser(rs);
    user.add(obj);
   }

   return user;
  } catch(SQLException e ) {
   throw new DbException(e.getMessage()); 

  } finally {

   DB.closeStatment(st);
   DB.closeResultSet(rs);

  }

}

public User instatiateUser(ResultSet rs){
  try {
   User user = new User();
   user.setId(rs.getInt("id_pessoa"));
   user.setName(rs.getString("nome"));
   user.setEmail(rs.getString("email"));
   user.setPhone(rs.getString("telefone"));
   return user;
  } catch (SQLException e) {
   throw new DbException("Falha ao instanciar unma pessoa");
  }

}

}
 