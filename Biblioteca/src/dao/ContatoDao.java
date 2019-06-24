package dao;

import java.sql.PreparedStatement;

import conexao.ConnectionFactory;
import entidade.Contato;

public class ContatoDao {

	public void salvar(Contato c) {
		String sql = "INSERT INTO Contato VALUES (default, ?, ?)";
		
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, c.getEmail());
			stmt.setString(2, c.getTelefone());
			
			stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
