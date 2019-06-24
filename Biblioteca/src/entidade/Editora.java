package entidade;

public class Editora {
	private int codigo;
	private String nome;
	private int cod_contato;
	private int cnpj;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo >= 0) {
			this.codigo = codigo;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}
	}

	public int getCod_contato() {
		return cod_contato;
	}

	public void setCod_contato(int cod_contato) {
		this.cod_contato = cod_contato;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		if (cnpj >= 0) {
			this.cnpj = cnpj;
		}
	}

}
