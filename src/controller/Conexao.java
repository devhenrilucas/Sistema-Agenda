package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	private static String server = "jdbc:sqlserver://127.0.0.1:1433;";
	private static String banco = "databaseName=DA123_EXERC_G10;";
	private static String user = "user=sa;password=Gdbv1840@;encrypt=false;trustServerCertificate=true;loginTimeout=30;";

	public static Connection conexao; 
	public static void conectar() { 
		try {
			conexao = DriverManager.getConnection(server + banco + user); 
			JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso!");
		} catch (SQLException ex) {
			 JOptionPane.showMessageDialog(null, "Erro de conexão!\nERRO: "+ ex.getMessage());
		}
	}
	public static void desconectar() {
	try {
		conexao.close(); 
		JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!");
	} catch (SQLException ex) {
		JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão!\nERRO: " + ex.getMessage());
	}
	}
}
