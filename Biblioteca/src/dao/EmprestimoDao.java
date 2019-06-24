package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.ConnectionFactory;

public class EmprestimoDao {

	public void busca(String valor, ArrayList<Object> vetor) {
		String sql = "SELECT * FROM Emprestimo WHERE codigo = ? || cod_exemplar = ?";
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);

			ResultSet rs;

			if (valor.matches("[0-9]*") && !valor.isEmpty()) {
				stmt.setInt(1, Integer.parseInt(valor));
			} else {
				stmt.setInt(1, 0);
			}
			
			if (valor.matches("[0-9]*") && !valor.isEmpty()) {
				stmt.setInt(2, Integer.parseInt(valor));
			} else {
				stmt.setInt(2, 0);
			}

			rs = stmt.executeQuery();

			while (rs.next()) {
				vetor.add(rs.getInt("codigo"));
				vetor.add(rs.getInt("cod_exemplar"));
				vetor.add(rs.getInt("prazo"));
				vetor.add(rs.getInt("id_usuario"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
