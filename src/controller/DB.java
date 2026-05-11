package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.exception.DbException;

public class DB {

private static String server = "jdbc:sqlserver://127.0.0.1:1433;";
private static String data = "databaseName=DA123_EXERC_G10;";
private static String user = "user=sa;password=Gdbv1840@;encrypt=false;trustServerCertificate=true;loginTimeout=30;";
private static String url = server + data + user;

private static Connection conn = null;

public static Connection getConnection() {

  if (conn == null) {
   try {
    conn = DriverManager.getConnection(url);
   } catch (SQLException e) {
    throw new DbException("Falha ao conectar ao banco de dados!");
   }
  }
  return conn;

}

public static void closeConnection() {
  if (conn != null) {
   try {
    conn.close();
    conn = null;
   } catch (SQLException e) {
    throw new DbException("Falha ao desconectar do banco de dados!");
   }
  }
}

public static void closeResultSet(ResultSet rs) {

  if(rs != null) {
   try {
    rs.close();
   } catch (SQLException e) {
    throw new DbException(e.getMessage());
   } 
  }

}

public static void closeStatment(Statement st) {

  if(st != null) {
   try {
    st.close();
   } catch (SQLException e) {
    throw new DbException(e.getMessage());
   }
  }
}

}
 