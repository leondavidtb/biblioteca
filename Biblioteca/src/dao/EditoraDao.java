package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.ConnectionFactory;
import entidade.Editora;

public class EditoraDao {

	public void salvar(Editora ed) {
		String sql = "INSERT INTO Editora VALUES (default, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, ed.getNome());
			stmt.setInt(2, ed.getCod_contato());
			stmt.setInt(3, ed.getCnpj());
			
			stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void busca(String valor, ArrayList<Object> vetor) {
		String sql = "SELECT * FROM Editora WHERE codigo = ? || nome = ?";
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			ResultSet rs;

			if (valor.matches("[0-9]*") && !valor.isEmpty()) {
				stmt.setInt(1, Integer.parseInt(valor));
			} else {
				stmt.setInt(1, 0);
			}
			stmt.setString(2, valor);

			rs = stmt.executeQuery();

			while (rs.next()) {
				vetor.add(rs.getInt("codigo"));
				vetor.add(rs.getString("nome"));
				vetor.add(rs.getInt("cod_contato"));
				vetor.add(rs.getInt("cnpj"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
