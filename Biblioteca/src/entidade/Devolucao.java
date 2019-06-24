package entidade;

import java.sql.Date;

public class Devolucao {

	private Emprestimo cod_emprestimo;
	private Exemplar cod_exemplar;
	private Date data_devolucao;
	private Usuario id_bibliotecario;
	private float multa;

	public Emprestimo getCod_emprestimo() {
		return cod_emprestimo;
	}

	public void setCod_emprestimo(Emprestimo cod_emprestimo) {
		if (cod_emprestimo != null) {
			this.cod_emprestimo = cod_emprestimo;
		}
	}

	public Exemplar getCod_exemplar() {
		return cod_exemplar;
	}

	public void setCod_exemplar(Exemplar cod_exemplar) {
		if (cod_exemplar != null) {
			this.cod_exemplar = cod_exemplar;
		}
	}

	public Date getData_devolucao() {
		return data_devolucao;
	}

	public void setData_devolucao(Date data_devolucao) {
		if (data_devolucao != null) {
			this.data_devolucao = data_devolucao;
		}
	}

	public Usuario getId_bibliotecario() {
		return id_bibliotecario;
	}

	public void setId_bibliotecario(Usuario id_bibliotecario) {
		if (id_bibliotecario != null) {
			this.id_bibliotecario = id_bibliotecario;
		}
	}

	public float getMulta() {
		return multa;
	}

	public void setMulta(float multa) {
		if (multa >= 0) {
			this.multa = multa;
		}
	}

}
