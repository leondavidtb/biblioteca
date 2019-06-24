package entidade;

public class Autor {
	private int id;
	private String nome;
	private String bibliografia;

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

	public String getBibliografia() {
		return bibliografia;
	}

	public void setBiblioteca(String bibliografia) {
		if (bibliografia != null) {
			this.bibliografia = bibliografia;
		}
	}

}
