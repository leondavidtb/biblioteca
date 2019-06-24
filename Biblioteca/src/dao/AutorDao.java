package dao;

import java.sql.PreparedStatement;

import conexao.ConnectionFactory;
import entidade.Autor;

public class AutorDao {

	public void salvar(Autor a) {
		String sql = "INSERT INTO Autor VALUES (default, ?, ?)";
		
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, a.getNome());
			stmt.setString(2, a.getBibliografia());
			
			stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
