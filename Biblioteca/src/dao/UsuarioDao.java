package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conexao.ConnectionFactory;
import entidade.Usuario;

public class UsuarioDao {

	// busca usuario
	public void busca(String valor, ArrayList<Object> vetor) {
		String sql = "SELECT * FROM Usuario WHERE id = ? || nome = ?";
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
				vetor.add(rs.getInt("id"));
				vetor.add(rs.getString("nome"));
				vetor.add(rs.getInt("cod_contato"));
				vetor.add(rs.getInt("limite"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// verificar login
	public boolean checkLogin(String nome, String senha) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt;
		ResultSet rs;

		boolean check = false;

		try {

			stmt = con.prepareStatement("SELECT * FROM Usuario WHERE nome = ? and senha = ?");
			stmt.setString(1, nome);
			stmt.setString(2, senha);

			rs = stmt.executeQuery();

			if (rs.next()) {

				check = true;
			}

			stmt.close();
			rs.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return check;

	}

	public void salvar(Usuario u) {
		String sql = "INSERT INTO Usuario (id, nome, cod_contato, senha, limite) VALUES (default, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = ConnectionFactory.getConnection().prepareStatement(sql);
			stmt.setString(1, u.getNome());
			stmt.setInt(2, u.getCod_contato());
			stmt.setString(3, u.getSenha());
			stmt.setInt(4, u.getLimite());
			
			stmt.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}