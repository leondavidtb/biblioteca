package entidade;

public class Acervo {

	private int codigo;
	private String estante;
	private String prateleira;
	private Categoria cod_categoria;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		if (codigo >= 0) {
			this.codigo = codigo;
		}
	}

	public String getEstante() {
		return estante;
	}

	public void setEstante(String estante) {
		if (estante != null) {
			this.estante = estante;
		}
	}

	public String getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(String prateleira) {
		if (prateleira != null) {
			this.prateleira = prateleira;
		}
	}

	public Categoria getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(Categoria cod_categoria) {
		if (cod_categoria != null) {
			this.cod_categoria = cod_categoria;
		}
	}
}
