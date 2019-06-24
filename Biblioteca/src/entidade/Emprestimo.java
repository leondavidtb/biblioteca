package entidade;

public class Emprestimo {
	private int codigo;
	private String nome;
	private Contato cod_contato;
	private String senha;

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

	public Contato getCod_contato() {
		return cod_contato;
	}

	public void setCod_contato(Contato cod_contato) {
		if (cod_contato != null) {
			this.cod_contato = cod_contato;
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha != null) {
			this.senha = senha;
		}
	}
}
