package main;

import java.sql.Connection;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;

public class MainTeste {

	public static void main(String[] args) {
		Connection con = null;
		con = ConnectionFactory.getConnection();
		if(con!=null) {
			JOptionPane.showMessageDialog(null, "Sucesso na conexão!", "Sucesso", 1);

		}
	}

}
