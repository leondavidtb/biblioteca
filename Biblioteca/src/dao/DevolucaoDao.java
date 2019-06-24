package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.ConnectionFactory;

public class DevolucaoDao {

	public void busca(String valor, ArrayList<Object> vetor) {
		String sql = "SELECT * FROM Devolucao WHERE cod_emprestimo = ? || cod_exemplar = ? || data_devolucao = ?";
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
			
			stmt.setString(3,  valor);

			rs = stmt.executeQuery();

			while (rs.next()) {
				vetor.add(rs.getInt("cod_emprestimo"));
				vetor.add(rs.getInt("cod_exemplar"));
				vetor.add(rs.getString("data_devolucao"));
				vetor.add(rs.getFloat("multa"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
