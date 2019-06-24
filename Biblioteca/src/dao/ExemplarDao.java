package dao;

import java.sql.PreparedStatement;

import conexao.ConnectionFactory;
import entidade.Exemplar;

public class ExemplarDao {

	public void salvar(Exemplar e) {
		String sql = "INSERT INTO Exemplar VALUES (default, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
			stmt.setInt(1, e.getCod_livro());
			stmt.setString(2, e.getEdicao());
			stmt.setInt(3, e.getAno());
			stmt.setInt(4, e.getCod_estado());
			stmt.setInt(5, e.getCod_disponibilidade());

			stmt.execute();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
