package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.Medico;

public class MedicoDao {
	public int create(Medico m) {
		Connection con = null;
		PreparedStatement stmt = null;
		String sqlInsert = "INSERT INTO usuario(Crm, Nome, Cpf, Especialidade) VALUE (?,?,?,?)";
		con = ConnectionFactory.getConnection();
		try {
			stmt = con.prepareStatement(sqlInsert);
			stmt.setInt(1, m.getCrm());
			stmt.setString(2, m.getNome());
			stmt.setString(3, m.getCpf());
			stmt.setInt(4, m.getEspecialidade());
			stmt.execute();
			return 1;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro na inserção do produto!", "Erro", 2);
			return 0;
		}
		finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
		
	}
}
