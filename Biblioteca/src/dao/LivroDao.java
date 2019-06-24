package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import conexao.ConnectionFactory;
import entidade.Livro;

public class LivroDao {
	
	public void busca(String valor, ArrayList<Object> vetor) {
		String sql = "SELECT * FROM (Livro as L join Autor as A ON L.id_autor = A.id join "
				+ "Editora as E on L.cod_editora = E.codigo) WHERE L.titulo = ? "
				+ "|| A.nome = ? || E.nome = ? || L.codigo = ?";
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, valor);
			stmt.setString(2, valor);
			stmt.setString(3, valor);
			if(valor.matches("[0-9]*") && !valor.isEmpty()) {
				stmt.setInt(4, Integer.parseInt(valor));
			} else {
				stmt.setInt(4, 0);
			}
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				vetor.add(rs.getInt("L.codigo"));
				vetor.add(rs.getString("L.titulo"));
				vetor.add(rs.getString("A.nome"));
				vetor.add(rs.getString("E.nome"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Livro l) {
		String sql = "INSERT INTO Livro VALUES (default, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, l.getTitulo());
			stmt.setInt(2, l.getId_autor());
			stmt.setInt(3, l.getCod_editora());
			stmt.setInt(4, l.getCod_categoria());
			stmt.setString(5, l.getCapa());
			stmt.setInt(6, l.getAno_publicacao());
			stmt.setString(7, l.getSinopse());
			
			stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}