package entidade;

import java.sql.Date;

public class Reserva {

	private Usuario id_usuario;
	private Livro cod_livro;
	private Date data;
	private Date previsao;

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		if (id_usuario != null) {
			this.id_usuario = id_usuario;
		}
	}

	public Livro getCod_livro() {
		return cod_livro;
	}

	public void setCod_livro(Livro cod_livro) {
		if (cod_livro != null) {
			this.cod_livro = cod_livro;
		}
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		if (data != null) {
			this.data = data;
		}
	}

	public Date getPrevisao() {
		return previsao;
	}

	public void setPrevisao(Date previsao) {
		if (previsao != null) {
			this.previsao = previsao;
		}
	}

}
