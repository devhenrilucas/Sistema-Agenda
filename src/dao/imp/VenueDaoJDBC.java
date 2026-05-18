package dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import controller.DB;
import dao.VenueDAO;
import model.entities.Venue;
import model.exception.DbException;



public class VenueDaoJDBC implements VenueDAO {

private Connection conn;

public VenueDaoJDBC(Connection conn) {
	super();
	this.conn = conn;
}

@Override
public void insert(Venue obj) {

  PreparedStatement st = null;

  try {
   st = conn.prepareStatement("INSERT INTO Locais " + " (nome_espaco, capacidade_maxima) " + " VALUES" + " (?, ?)",
     Statement.RETURN_GENERATED_KEYS);

   st.setString(1, obj.getVenueName());
   st.setInt(2, obj.getMaxCapacity());

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
public void update(Venue obj) {

  PreparedStatement st = null;

  try {
   st = conn.prepareStatement("UPDATE Locais " + "SET nome_espaco = ?, capacidade_maxima = ? " + "WHERE Id = ?");

   st.setString(1, obj.getVenueName());
   st.setInt(2, obj.getMaxCapacity());
   st.setInt(3, obj.getId());

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
   st = conn.prepareStatement("DELETE FROM Lugares " + "WHERE Id = ?");

   st.setInt(1, id);
   st.executeUpdate();

  } catch (SQLException e) {

   throw new DbException("Erro ao deletar local");

  } finally {

   DB.closeStatment(st);

  }

}

@Override
public Venue findById(Integer id) {

  PreparedStatement st = null;
  ResultSet rs = null;

  try {

   st = conn.prepareStatement("SELECT * FROM Locais "
     + "WHERE id_local = ?");

   st.setInt(1,  id);

   rs = st.executeQuery();

   if (rs.next()) {
    Venue user = instatiateVenue(rs);
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
public List<Venue> findAll() {

  PreparedStatement st = null;
  ResultSet rs = null;

  try {

   st = conn.prepareStatement("SELECT * FROM Pessoa "
     + "ORDER BY Pessoa.name");

   rs = st.executeQuery();
   List<Venue> user = new ArrayList<Venue>();

   while (rs.next()) {
    Venue obj = instatiateVenue(rs);
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

public Venue instatiateVenue(ResultSet rs){
  try {
   Venue venue = new Venue();
   venue.setId(rs.getInt("id_local"));
   venue.setVenueName(rs.getString("nome_espaco"));
   venue.setMaxCapacity(rs.getInt("capacidade_maxima"));
   return venue;
  } catch (SQLException e) {
   throw new DbException("Falha ao instanciar unma pessoa");
  }

}

}
 