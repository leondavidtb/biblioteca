package entidade;

public class Livro {

	private int codigo;
	private String titulo;
	private int id_autor;
	private int cod_editora;
	private int cod_categoria;
	private String capa;
	private int ano_publicacao;
	private String sinopse;

	public int getAno_publicacao() {
		return ano_publicacao;
	}

	public void setAno_publicacao(int ano_publicacao) {
		this.ano_publicacao = ano_publicacao;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo >= 0) {
			this.codigo = codigo;
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo != null) {
			this.titulo = titulo;
		}
	}

	public int getId_autor() {
		return id_autor;
	}

	public void setId_autor(int id_autor) {
		if (id_autor >= 0) {
			this.id_autor = id_autor;
		}
	}

	public int getCod_editora() {
		return cod_editora;
	}

	public void setCod_editora(int cod_editora) {
		this.cod_editora = cod_editora;

	}

	public int getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(int cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	public String getCapa() {
		return capa;
	}

	public void setCapa(String capa) {
		if (capa != null) {
			this.capa = capa;
		}
	}
}
