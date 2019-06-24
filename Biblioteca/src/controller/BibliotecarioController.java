package controller;

import java.util.ArrayList;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

import dao.AutorDao;
import dao.ContatoDao;
import dao.DevolucaoDao;
import dao.EditoraDao;
import dao.EmprestimoDao;
import dao.ExemplarDao;
import dao.LivroDao;
import dao.ReservaDao;
import dao.UsuarioDao;
import entidade.Autor;
import entidade.Contato;
import entidade.Editora;
import entidade.Exemplar;
import entidade.Livro;
import entidade.Usuario;
import view.BibliotecarioView;

public class BibliotecarioController {

	private ArrayList<Object> vec = new ArrayList<Object>();
	private ArrayList<Object> vec1 = new ArrayList<Object>();
	private ArrayList<Object> vec2 = new ArrayList<Object>();
	private ArrayList<Object> vec3 = new ArrayList<Object>();
	private ArrayList<Object> vec4 = new ArrayList<Object>();
	private ArrayList<Object> vec5 = new ArrayList<Object>();
	private BibliotecarioView bibliotecarioView;
	private LivroDao livroDao;
	private UsuarioDao usuarioDao;
	private ExemplarDao exemplarDao;
	private ContatoDao contatoDao;
	private AutorDao autorDao;
	private EditoraDao editoraDao;
	private EmprestimoDao emprestimoDao;
	private ReservaDao reservaDao;
	private DevolucaoDao devolucaoDao;
	private Livro livro;
	private Exemplar exemplar;
	private Contato contato;
	private Usuario usuario;
	private Autor autor;
	private Editora editora;
	
	public BibliotecarioController(BibliotecarioView bibliotecarioView) {
		this.bibliotecarioView = bibliotecarioView;
	}

	public void setEvent(SelectionEvent se, int radio) {
		if ((se.getSource() instanceof Button)) {
			switch (radio) {
			case 1:
				// Livro
				livroDao = new LivroDao();
				livroDao.busca(bibliotecarioView.getBusca(), vec);
				bibliotecarioView.resultBusca(vec, radio);
				vec.clear();
			case 2:
				// Usuario
				usuarioDao = new UsuarioDao();
				usuarioDao.busca(bibliotecarioView.getBusca(), vec);
				bibliotecarioView.resultBusca(vec, radio);
				vec.clear();
			case 3:
				// Emprestimo
				emprestimoDao = new EmprestimoDao();
				emprestimoDao.busca(bibliotecarioView.getBusca(), vec);
				bibliotecarioView.resultBusca(vec, radio);
				vec.clear();
			case 4:
				// Reserva
				reservaDao = new ReservaDao();
				reservaDao.busca(bibliotecarioView.getBusca(), vec);
				bibliotecarioView.resultBusca(vec, radio);
				vec.clear();
			case 5:
				// Devolução
				devolucaoDao = new DevolucaoDao();
				devolucaoDao.busca(bibliotecarioView.getBusca(), vec);
				bibliotecarioView.resultBusca(vec, radio);
				vec.clear();
			}
		}
	}

	public void setEventCadastroLivro(SelectionEvent se) {
		if ((se.getSource() instanceof Button)) {
			if (((Button) se.getSource()).getText().equals("Cadastrar")) {
				bibliotecarioView.getValuesCadastroLivro(vec);
				livro = new Livro();

				livro.setTitulo(vec.get(0).toString());
				livro.setId_autor(Integer.parseInt(vec.get(1).toString()));
				livro.setCod_editora(Integer.parseInt(vec.get(2).toString()));
				livro.setCod_categoria(Integer.parseInt(vec.get(3).toString()));
				livro.setCapa(vec.get(4).toString());
				livro.setAno_publicacao(Integer.parseInt(vec.get(5).toString()));
				livro.setSinopse(vec.get(6).toString());

				livroDao = new LivroDao();
				livroDao.salvar(livro);
				bibliotecarioView.mensagemCadastro();
				bibliotecarioView.limparTelaCadastroLivro();
			}
		}
	}

	public void setEventCadastroExemplar(SelectionEvent se) {
		if ((se.getSource() instanceof Button)) {
			if (((Button) se.getSource()).getText().equals("Cadastrar")) {
				bibliotecarioView.getValuesCadastroExemplar(vec1);
				exemplar = new Exemplar();

				exemplar.setCod_livro(Integer.parseInt(vec1.get(0).toString()));
				exemplar.setEdicao(vec1.get(1).toString());
				exemplar.setAno(Integer.parseInt(vec1.get(2).toString()));
				exemplar.setCod_estado(Integer.parseInt(vec1.get(3).toString()));
				exemplar.setCod_disponibilidade(Integer.parseInt(vec1.get(4).toString()));

				exemplarDao = new ExemplarDao();
				exemplarDao.salvar(exemplar);
				bibliotecarioView.mensagemCadastro();
				bibliotecarioView.limparTelaCadastroExemplar();
			}
		}
	}

	public void setEventCadastroContato(SelectionEvent se) {
		if ((se.getSource() instanceof Button)) {
			if (((Button) se.getSource()).getText().equals("Cadastrar")) {
				bibliotecarioView.getValuesCadastroContato(vec2);
				contato = new Contato();

				contato.setEmail(vec2.get(0).toString());
				contato.setTelefone(vec2.get(1).toString());

				contatoDao = new ContatoDao();
				contatoDao.salvar(contato);
				bibliotecarioView.mensagemCadastro();
				bibliotecarioView.limparTelaCadastroContato();
			}
		}
		
	}

	public void setEventCadastroUsuario(SelectionEvent se) {
		if ((se.getSource() instanceof Button)) {
			if (((Button) se.getSource()).getText().equals("Cadastrar")) {
				bibliotecarioView.getValuesCadastroUsuario(vec3);
				usuario = new Usuario();

				usuario.setNome(vec3.get(0).toString());
				usuario.setCod_contato(Integer.parseInt(vec3.get(1).toString()));
				usuario.setSenha(vec3.get(2).toString());
				usuario.setLimite(Integer.parseInt(vec3.get(3).toString()));

				usuarioDao = new UsuarioDao();
				usuarioDao.salvar(usuario);
				bibliotecarioView.mensagemCadastro();
				bibliotecarioView.limparTelaCadastroUsuario();
			}
		}
		
	}

	public void setEventCadastroAutor(SelectionEvent se) {
		if ((se.getSource() instanceof Button)) {
			if (((Button) se.getSource()).getText().equals("Cadastrar")) {
				bibliotecarioView.getValuesCadastroAutor(vec4);
				autor = new Autor();

				autor.setNome(vec4.get(0).toString());
				autor.setBiblioteca(vec4.get(1).toString());

				autorDao = new AutorDao();
				autorDao.salvar(autor);
				bibliotecarioView.mensagemCadastro();
				bibliotecarioView.limparTelaCadastroAutor();
			}
		}	
	}
	
	public void setEventCadastroEditora(SelectionEvent se) {
		if ((se.getSource() instanceof Button)) {
			if (((Button) se.getSource()).getText().equals("Cadastrar")) {
				bibliotecarioView.getValuesCadastroEditora(vec5);
				editora = new Editora();

				editora.setNome(vec5.get(0).toString());
				editora.setCod_contato(Integer.parseInt(vec5.get(1).toString()));
				editora.setCnpj(Integer.parseInt(vec5.get(2).toString()));
				
				editoraDao = new EditoraDao();
				editoraDao.salvar(editora);
				bibliotecarioView.mensagemCadastro();
				bibliotecarioView.limparTelaCadastroEditora();
			}
		}
		
	}
}
