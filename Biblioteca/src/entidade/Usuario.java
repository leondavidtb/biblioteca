package entidade;

public class Usuario {

	private int id;
	private String nome;
	private int cod_contato;
	private String senha;
	private int nivel;

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	private int limite;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		if (id >= 0) {
			this.id = id;
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
		if (cod_contato >= 0) {
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

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		if (limite >= 0) {
			this.limite = limite;
		}
	}

}
