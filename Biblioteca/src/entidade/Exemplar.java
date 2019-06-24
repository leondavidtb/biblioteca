package entidade;

public class Exemplar {

	private int codigo;
	private int cod_livro;
	private String edicao;
	private int ano;
	private int cod_estado;
	private int cod_disponibilidade;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo >= 0) {
			this.codigo = codigo;
		}
	}

	public int getCod_livro() {
		return cod_livro;
	}

	public void setCod_livro(int cod_livro) {
		this.cod_livro = cod_livro;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		if (edicao != null) {
			this.edicao = edicao;
		}
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		if (ano >= 0) {
			this.ano = ano;
		}
	}

	public int getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(int cod_estado) {
		this.cod_estado = cod_estado;
	}

	public int getCod_disponibilidade() {
		return cod_disponibilidade;
	}

	public void setCod_disponibilidade(int cod_disponibilidade) {

		this.cod_disponibilidade = cod_disponibilidade;

	}

}
