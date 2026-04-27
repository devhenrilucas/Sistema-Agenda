package view;

import controller.Conexao;

public class Principal {

	public static void main(String[] args) {
		Conexao.conectar();
		Conexao.desconectar();

	}

}
