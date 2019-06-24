package view;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

import controller.BibliotecarioController;

public class BibliotecarioView {
	private Display display = new Display();

	protected Shell shlTelaBibliotecario;
	private Text textBusca;
	private Table tableExibir;
	private int radio;
	private Text textTitulo;
	private Text textAutor;
	private Text textEditora;
	private Text textCategoria;
	private Text textCapa;
	private Text textAnoPublicacao;
	private Text textSinopse;
	private Text textCodLivro;
	private Text textEdicao;
	private Text textAno;
	private Text textEstado;
	private Text textDisponibilidade;
	private Text textNome;
	private Text textContato;
	private Text textSenha;
	private Text textEmail;
	private Text textTelefone;
	private Text textLimiteLivros;
	private Text textNomeAutor;
	private Text textBibliografia;
	private Text textNomeEditora;
	private Text textContatoEditora;
	private Text textCnpjEditora;
	private BibliotecarioController bibliotecarioController = new BibliotecarioController(this);
	private TableColumn tblclmnNewColumn_1;
	private TableColumn tblclmnNewColumn_2;
	private TableColumn tblclmnNewColumn_3;
	private TableColumn tblclmnNewColumn_4;
	private TableItem tableItem;
	private Text textIdAlunoEmprestimo;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public BibliotecarioView() {
		try {
			createContents();
			BibliotecarioView window = new BibliotecarioView();
			window.createContents();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {

	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlTelaBibliotecario = new Shell(display);
		shlTelaBibliotecario.setSize(1000, 500);
		shlTelaBibliotecario.setText("Tela Bibliotecario");

		TabFolder tabFolderBusca = new TabFolder(shlTelaBibliotecario, SWT.NONE);
		tabFolderBusca.setBounds(0, 0, 955, 461);

		TabItem tbtmBusca = new TabItem(tabFolderBusca, SWT.NONE);
		tbtmBusca.setText("Busca");

		Composite compositeBusca = new Composite(tabFolderBusca, SWT.NONE);
		compositeBusca.setBounds(0, 0, 750, 280);
		tbtmBusca.setControl(compositeBusca);

		textBusca = new Text(compositeBusca, SWT.BORDER);
		textBusca.setBounds(10, 10, 400, 29);

		Button btnRadioLivro = new Button(compositeBusca, SWT.RADIO);
		btnRadioLivro.setBounds(10, 45, 56, 17);
		btnRadioLivro.setText("Livro");

		Button btnRadioUsuario = new Button(compositeBusca, SWT.RADIO);
		btnRadioUsuario.setBounds(72, 45, 69, 17);
		btnRadioUsuario.setText("Usuário");

		Button btnRadioEmprestimo = new Button(compositeBusca, SWT.RADIO);
		btnRadioEmprestimo.setBounds(147, 45, 91, 17);
		btnRadioEmprestimo.setText("Empréstimo");

		Button btnRadioReserva = new Button(compositeBusca, SWT.RADIO);
		btnRadioReserva.setBounds(244, 45, 69, 17);
		btnRadioReserva.setText("Reserva");

		Button btnRadioDevolucao = new Button(compositeBusca, SWT.RADIO);
		btnRadioDevolucao.setBounds(319, 45, 91, 17);
		btnRadioDevolucao.setText("Devolução");

		tableExibir = new Table(compositeBusca, SWT.BORDER | SWT.FULL_SELECTION);
		tableExibir.setBounds(416, 10, 537, 387);
		tableExibir.setHeaderVisible(true);
		tableExibir.setLinesVisible(true);

		tblclmnNewColumn_1 = new TableColumn(tableExibir, SWT.NONE);
		tblclmnNewColumn_1.setWidth(124);
		tblclmnNewColumn_1.setText("New Column");

		tblclmnNewColumn_2 = new TableColumn(tableExibir, SWT.NONE);
		tblclmnNewColumn_2.setWidth(139);
		tblclmnNewColumn_2.setText("New Column");

		tblclmnNewColumn_3 = new TableColumn(tableExibir, SWT.NONE);
		tblclmnNewColumn_3.setWidth(131);
		tblclmnNewColumn_3.setText("New Column");

		tblclmnNewColumn_4 = new TableColumn(tableExibir, SWT.NONE);
		tblclmnNewColumn_4.setWidth(50);
		tblclmnNewColumn_4.setText("New Column");

		Button btnBuscar = new Button(compositeBusca, SWT.NONE);
		btnBuscar.setBounds(121, 139, 83, 34);
		btnBuscar.setText("Buscar");

		Button btnBuscarLimpar = new Button(compositeBusca, SWT.NONE);
		btnBuscarLimpar.setBounds(230, 139, 83, 34);
		btnBuscarLimpar.setText("Limpar");

		SelectionAdapter sa = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent se) {
				switch (((Button) se.getSource()).getText()) {
				case "Livro":
					radio = 1;
					break;
				case "Usuário":
					radio = 2;
					break;
				case "Empréstimo":
					radio = 3;
					break;
				case "Reserva":
					radio = 4;
					break;
				case "Devolução":
					radio = 5;
					break;
				}
				if (((Button) se.getSource()).getText().equals("Buscar")) {
					bibliotecarioController.setEvent(se, radio);
				}
			}
		};
		btnBuscar.addSelectionListener(sa);
		btnBuscarLimpar.addSelectionListener(sa);
		btnRadioLivro.addSelectionListener(sa);
		btnRadioUsuario.addSelectionListener(sa);
		btnRadioEmprestimo.addSelectionListener(sa);
		btnRadioReserva.addSelectionListener(sa);
		btnRadioDevolucao.addSelectionListener(sa);

		TabItem tbtmCadastro = new TabItem(tabFolderBusca, SWT.NONE);
		tbtmCadastro.setText("Cadastro");

		Composite compositeCadastro = new Composite(tabFolderBusca, SWT.NONE);
		tbtmCadastro.setControl(compositeCadastro);

		TabFolder tabFolderCompositeCadastro = new TabFolder(compositeCadastro, SWT.NONE);
		tabFolderCompositeCadastro.setBounds(0, 0, 953, 423);

		TabItem tbtmCadastroLivro = new TabItem(tabFolderCompositeCadastro, SWT.NONE);
		tbtmCadastroLivro.setText("Livro");

		Composite compositeCadastroLivro = new Composite(tabFolderCompositeCadastro, SWT.NONE);
		tbtmCadastroLivro.setControl(compositeCadastroLivro);

		Label lblTitulo = new Label(compositeCadastroLivro, SWT.NONE);
		lblTitulo.setBounds(10, 10, 58, 17);
		lblTitulo.setText("Título:");

		textTitulo = new Text(compositeCadastroLivro, SWT.BORDER);
		textTitulo.setBounds(10, 33, 324, 29);

		Label lblAutor = new Label(compositeCadastroLivro, SWT.NONE);
		lblAutor.setBounds(340, 10, 58, 17);
		lblAutor.setText("Autor:");

		textAutor = new Text(compositeCadastroLivro, SWT.BORDER);
		textAutor.setBounds(340, 33, 68, 29);

		Label lblEditora = new Label(compositeCadastroLivro, SWT.NONE);
		lblEditora.setBounds(414, 10, 58, 17);
		lblEditora.setText("Editora:");

		textEditora = new Text(compositeCadastroLivro, SWT.BORDER);
		textEditora.setBounds(414, 33, 68, 29);

		Label lblCapa = new Label(compositeCadastroLivro, SWT.NONE);
		lblCapa.setBounds(10, 80, 58, 17);
		lblCapa.setText("Capa:");

		textCapa = new Text(compositeCadastroLivro, SWT.BORDER);
		textCapa.setBounds(10, 103, 324, 29);

		Label lblAnoPublicacao = new Label(compositeCadastroLivro, SWT.NONE);
		lblAnoPublicacao.setBounds(340, 80, 105, 17);
		lblAnoPublicacao.setText("Ano de publicação:");

		textAnoPublicacao = new Text(compositeCadastroLivro, SWT.BORDER);
		textAnoPublicacao.setBounds(340, 103, 105, 29);

		Label lblSinopse = new Label(compositeCadastroLivro, SWT.NONE);
		lblSinopse.setBounds(10, 151, 58, 17);
		lblSinopse.setText("Sinopse");

		textSinopse = new Text(compositeCadastroLivro, SWT.BORDER);
		textSinopse.setBounds(10, 174, 546, 104);

		Button btnCadastrarLivro = new Button(compositeCadastroLivro, SWT.NONE);
		btnCadastrarLivro.setBounds(94, 311, 83, 34);
		btnCadastrarLivro.setText("Cadastrar");

		Button btnLimparLivro = new Button(compositeCadastroLivro, SWT.NONE);
		btnLimparLivro.setBounds(217, 311, 83, 34);
		btnLimparLivro.setText("Limpar");

		textCategoria = new Text(compositeCadastroLivro, SWT.BORDER);
		textCategoria.setBounds(488, 33, 68, 29);

		Label lblCategoria = new Label(compositeCadastroLivro, SWT.NONE);
		lblCategoria.setBounds(487, 10, 58, 17);
		lblCategoria.setText("Categoria");

		SelectionAdapter sa1 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent se) {
				if (((Button) se.getSource()).getText().equals("Cadastrar")) {
					bibliotecarioController.setEventCadastroLivro(se);
				} else {
					limparTelaCadastroLivro();
				}
			}
		};

		btnCadastrarLivro.addSelectionListener(sa1);
		btnLimparLivro.addSelectionListener(sa1);

		TabItem tbtmCadastroExemplar = new TabItem(tabFolderCompositeCadastro, SWT.NONE);
		tbtmCadastroExemplar.setText("Exemplar");

		Composite compositeCadastroExemplar = new Composite(tabFolderCompositeCadastro, SWT.NONE);
		tbtmCadastroExemplar.setControl(compositeCadastroExemplar);

		Label lblCodLivro = new Label(compositeCadastroExemplar, SWT.NONE);
		lblCodLivro.setBounds(10, 10, 58, 17);
		lblCodLivro.setText("Cod. Livro:");

		textCodLivro = new Text(compositeCadastroExemplar, SWT.BORDER);
		textCodLivro.setBounds(10, 33, 83, 29);

		Label lblEdicao = new Label(compositeCadastroExemplar, SWT.NONE);
		lblEdicao.setBounds(118, 10, 58, 17);
		lblEdicao.setText("Edição:");

		textEdicao = new Text(compositeCadastroExemplar, SWT.BORDER);
		textEdicao.setBounds(118, 33, 83, 29);

		textAno = new Text(compositeCadastroExemplar, SWT.BORDER);
		textAno.setBounds(230, 33, 83, 29);

		Label lblAno = new Label(compositeCadastroExemplar, SWT.NONE);
		lblAno.setBounds(230, 10, 58, 17);
		lblAno.setText("Ano:");

		textEstado = new Text(compositeCadastroExemplar, SWT.BORDER);
		textEstado.setBounds(340, 33, 83, 29);

		Label lblEstado = new Label(compositeCadastroExemplar, SWT.NONE);
		lblEstado.setBounds(340, 10, 58, 17);
		lblEstado.setText("Estado:");

		textDisponibilidade = new Text(compositeCadastroExemplar, SWT.BORDER);
		textDisponibilidade.setBounds(452, 33, 83, 29);

		Label lblDisponibilidade = new Label(compositeCadastroExemplar, SWT.NONE);
		lblDisponibilidade.setBounds(452, 10, 96, 17);
		lblDisponibilidade.setText("Disponibilidade");

		Button btnCadastrarExemplar = new Button(compositeCadastroExemplar, SWT.NONE);
		btnCadastrarExemplar.setBounds(10, 90, 83, 34);
		btnCadastrarExemplar.setText("Cadastrar");

		Button btnLimparExemplar = new Button(compositeCadastroExemplar, SWT.NONE);
		btnLimparExemplar.setBounds(118, 90, 83, 34);
		btnLimparExemplar.setText("Limpar");

		SelectionAdapter sa2 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent se) {
				if (((Button) se.getSource()).getText().equals("Cadastrar")) {
					bibliotecarioController.setEventCadastroExemplar(se);
				} else {
					limparTelaCadastroExemplar();
				}
			}
		};

		btnCadastrarExemplar.addSelectionListener(sa2);
		btnLimparExemplar.addSelectionListener(sa2);

		TabItem tbtmCadastroContato = new TabItem(tabFolderCompositeCadastro, SWT.NONE);
		tbtmCadastroContato.setText("Contato");

		Composite compositeCadastroContato = new Composite(tabFolderCompositeCadastro, SWT.NONE);
		tbtmCadastroContato.setControl(compositeCadastroContato);

		Label lblEmail = new Label(compositeCadastroContato, SWT.NONE);
		lblEmail.setBounds(10, 10, 58, 17);
		lblEmail.setText("Email:");

		textEmail = new Text(compositeCadastroContato, SWT.BORDER);
		textEmail.setBounds(10, 34, 345, 29);

		Label lblTelefone = new Label(compositeCadastroContato, SWT.NONE);
		lblTelefone.setBounds(10, 69, 58, 17);
		lblTelefone.setText("Telefone:");

		textTelefone = new Text(compositeCadastroContato, SWT.BORDER);
		textTelefone.setBounds(10, 92, 345, 29);

		Button btnCadastrarContato = new Button(compositeCadastroContato, SWT.NONE);
		btnCadastrarContato.setBounds(51, 133, 83, 34);
		btnCadastrarContato.setText("Cadastrar");

		Button btnLimparContato = new Button(compositeCadastroContato, SWT.NONE);
		btnLimparContato.setBounds(171, 133, 83, 34);
		btnLimparContato.setText("Limpar");

		SelectionAdapter sa3 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent se) {
				if (((Button) se.getSource()).getText().equals("Cadastrar")) {
					bibliotecarioController.setEventCadastroContato(se);
				} else {
					limparTelaCadastroContato();
				}
			}
		};

		btnCadastrarContato.addSelectionListener(sa3);
		btnLimparContato.addSelectionListener(sa3);

		TabItem tbtmCadastroUsuario = new TabItem(tabFolderCompositeCadastro, SWT.NONE);
		tbtmCadastroUsuario.setText("Usuário");

		Composite compositeCadastroUsuario = new Composite(tabFolderCompositeCadastro, SWT.NONE);
		tbtmCadastroUsuario.setControl(compositeCadastroUsuario);

		Label lblNomeUsuario = new Label(compositeCadastroUsuario, SWT.NONE);
		lblNomeUsuario.setBounds(10, 10, 58, 17);
		lblNomeUsuario.setText("Nome:");

		textNome = new Text(compositeCadastroUsuario, SWT.BORDER);
		textNome.setBounds(10, 33, 219, 29);

		Label lblCodContatoUsuario = new Label(compositeCadastroUsuario, SWT.NONE);
		lblCodContatoUsuario.setBounds(417, 10, 58, 17);
		lblCodContatoUsuario.setText("Contato:");

		textContato = new Text(compositeCadastroUsuario, SWT.BORDER);
		textContato.setBounds(417, 33, 83, 29);

		Label lblSenha = new Label(compositeCadastroUsuario, SWT.NONE);
		lblSenha.setBounds(235, 10, 58, 17);
		lblSenha.setText("Senha:");

		textSenha = new Text(compositeCadastroUsuario, SWT.BORDER);
		textSenha.setBounds(235, 33, 174, 29);

		Label lblLimiteLivros = new Label(compositeCadastroUsuario, SWT.NONE);
		lblLimiteLivros.setBounds(506, 10, 58, 17);
		lblLimiteLivros.setText("Limite:");

		textLimiteLivros = new Text(compositeCadastroUsuario, SWT.BORDER);
		textLimiteLivros.setBounds(506, 33, 83, 29);

		Button btnCadastrarUsuario = new Button(compositeCadastroUsuario, SWT.NONE);
		btnCadastrarUsuario.setBounds(34, 128, 83, 34);
		btnCadastrarUsuario.setText("Cadastrar");

		Button btnLimparUsuario = new Button(compositeCadastroUsuario, SWT.NONE);
		btnLimparUsuario.setBounds(146, 128, 83, 34);
		btnLimparUsuario.setText("Limpar");

		SelectionAdapter sa4 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent se) {
				if (((Button) se.getSource()).getText().equals("Cadastrar")) {
					bibliotecarioController.setEventCadastroUsuario(se);
				} else {
					limparTelaCadastroUsuario();
				}
			}
		};

		btnCadastrarUsuario.addSelectionListener(sa4);
		btnLimparUsuario.addSelectionListener(sa4);

		TabItem tbtmCadastroAutor = new TabItem(tabFolderCompositeCadastro, SWT.NONE);
		tbtmCadastroAutor.setText("Autor");

		Composite compositeCadastroAutor = new Composite(tabFolderCompositeCadastro, SWT.NONE);
		tbtmCadastroAutor.setControl(compositeCadastroAutor);

		Label lblNomeAutor = new Label(compositeCadastroAutor, SWT.NONE);
		lblNomeAutor.setBounds(10, 10, 58, 17);
		lblNomeAutor.setText("Nome:");

		textNomeAutor = new Text(compositeCadastroAutor, SWT.BORDER);
		textNomeAutor.setBounds(10, 33, 319, 29);

		Label lblBibliografia = new Label(compositeCadastroAutor, SWT.NONE);
		lblBibliografia.setBounds(10, 84, 80, 17);
		lblBibliografia.setText("Bibliografia:");

		textBibliografia = new Text(compositeCadastroAutor, SWT.BORDER);
		textBibliografia.setBounds(10, 107, 589, 117);

		Button btnCadastrarAutor = new Button(compositeCadastroAutor, SWT.NONE);
		btnCadastrarAutor.setBounds(51, 248, 83, 34);
		btnCadastrarAutor.setText("Cadastrar");

		Button btnLimparAutor = new Button(compositeCadastroAutor, SWT.NONE);
		btnLimparAutor.setBounds(155, 248, 83, 34);
		btnLimparAutor.setText("Limpar");

		SelectionAdapter sa5 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent se) {
				if (((Button) se.getSource()).getText().equals("Cadastrar")) {
					bibliotecarioController.setEventCadastroAutor(se);
				} else {
					limparTelaCadastroAutor();
				}
			}
		};

		btnCadastrarAutor.addSelectionListener(sa5);
		btnLimparAutor.addSelectionListener(sa5);

		TabItem tbtmEditora = new TabItem(tabFolderCompositeCadastro, SWT.NONE);
		tbtmEditora.setText("Editora");

		Composite compositeCadastroEditora = new Composite(tabFolderCompositeCadastro, SWT.NONE);
		tbtmEditora.setControl(compositeCadastroEditora);

		Label lblNomeEditora = new Label(compositeCadastroEditora, SWT.NONE);
		lblNomeEditora.setBounds(10, 10, 58, 17);
		lblNomeEditora.setText("Nome:");

		textNomeEditora = new Text(compositeCadastroEditora, SWT.BORDER);
		textNomeEditora.setBounds(10, 33, 312, 29);

		Label lblCodContatoEditora = new Label(compositeCadastroEditora, SWT.NONE);
		lblCodContatoEditora.setBounds(10, 68, 58, 17);
		lblCodContatoEditora.setText("Contato:");

		textContatoEditora = new Text(compositeCadastroEditora, SWT.BORDER);
		textContatoEditora.setBounds(10, 91, 83, 29);

		Label lblCnpjEditora = new Label(compositeCadastroEditora, SWT.NONE);
		lblCnpjEditora.setBounds(113, 68, 58, 17);
		lblCnpjEditora.setText("CNPJ:");

		textCnpjEditora = new Text(compositeCadastroEditora, SWT.BORDER);
		textCnpjEditora.setBounds(113, 91, 83, 29);

		Button btnCadastrarEditora = new Button(compositeCadastroEditora, SWT.NONE);
		btnCadastrarEditora.setBounds(10, 143, 83, 34);
		btnCadastrarEditora.setText("Cadastrar");

		Button btnLimparEditora = new Button(compositeCadastroEditora, SWT.NONE);
		btnLimparEditora.setBounds(113, 143, 83, 34);
		btnLimparEditora.setText("Limpar");

		SelectionAdapter sa6 = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent se) {
				if (((Button) se.getSource()).getText().equals("Cadastrar")) {
					bibliotecarioController.setEventCadastroEditora(se);
				} else {
					limparTelaCadastroEditora();
				}
			}
		};

		btnCadastrarEditora.addSelectionListener(sa6);
		btnLimparEditora.addSelectionListener(sa6);

		TabItem tbtmEmprestimo = new TabItem(tabFolderBusca, SWT.NONE);
		tbtmEmprestimo.setText("Emprestimo");

		Composite compositeEmprestimo = new Composite(tabFolderBusca, SWT.NONE);
		tbtmEmprestimo.setControl(compositeEmprestimo);

		TabItem tbtmReserva = new TabItem(tabFolderBusca, SWT.NONE);
		tbtmReserva.setText("Reserva");

		Composite composite_3 = new Composite(tabFolderBusca, SWT.NONE);
		tbtmReserva.setControl(composite_3);

		shlTelaBibliotecario.open();
		while (!shlTelaBibliotecario.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

	public void resultBusca(ArrayList<Object> rsBusca, int radio) {
		switch (radio) {
		// Livro
		case 1:
			tblclmnNewColumn_1.setText("Identificador");
			tblclmnNewColumn_2.setText("Livro");
			tblclmnNewColumn_3.setText("Autor");
			tblclmnNewColumn_4.setText("Editora");
			for (int i = 0; i < rsBusca.size(); i += 4) {
				tableItem = new TableItem(tableExibir, SWT.NONE);
				tableItem.setText(0, rsBusca.get(0 + i).toString());
				tableItem.setText(1, rsBusca.get(1 + i).toString());
				tableItem.setText(2, rsBusca.get(2 + i).toString());
				tableItem.setText(3, rsBusca.get(3 + i).toString());
			}
			break;
		// Usuário
		case 2:
			tblclmnNewColumn_1.setText("Identificador");
			tblclmnNewColumn_2.setText("Nome");
			tblclmnNewColumn_3.setText("Contato");
			tblclmnNewColumn_4.setText("Limite Livros");
			for (int i = 0; i < rsBusca.size(); i += 4) {
				tableItem = new TableItem(tableExibir, SWT.NONE);
				tableItem.setText(0, rsBusca.get(0 + i).toString());
				tableItem.setText(1, rsBusca.get(1 + i).toString());
				tableItem.setText(2, rsBusca.get(2 + i).toString());
				tableItem.setText(3, rsBusca.get(3 + i).toString());
			}
			break;
		// Emprestimo
		case 3:
			tblclmnNewColumn_1.setText("Identificador");
			tblclmnNewColumn_2.setText("Exemplar");
			tblclmnNewColumn_3.setText("prazo");
			tblclmnNewColumn_4.setText("Usuário");
			for (int i = 0; i < rsBusca.size(); i += 4) {
				tableItem = new TableItem(tableExibir, SWT.NONE);
				tableItem.setText(0, rsBusca.get(0 + i).toString());
				tableItem.setText(1, rsBusca.get(1 + i).toString());
				tableItem.setText(2, rsBusca.get(2 + i).toString());
				tableItem.setText(3, rsBusca.get(3 + i).toString());
			}
			break;
		// Reserva
		case 4:
			tblclmnNewColumn_1.setText("Identificador");
			tblclmnNewColumn_2.setText("Livro");
			tblclmnNewColumn_3.setText("Data");
			tblclmnNewColumn_4.setText("Previsão");
			for (int i = 0; i < rsBusca.size(); i += 4) {
				tableItem = new TableItem(tableExibir, SWT.NONE);
				tableItem.setText(0, rsBusca.get(0 + i).toString());
				tableItem.setText(1, rsBusca.get(1 + i).toString());
				tableItem.setText(2, rsBusca.get(2 + i).toString());
				tableItem.setText(3, rsBusca.get(3 + i).toString());
			}
			break;
		// Devolução
		case 5:
			tblclmnNewColumn_1.setText("Cod. Emprestimo");
			tblclmnNewColumn_2.setText("Cod. Exemplar");
			tblclmnNewColumn_3.setText("Data devolução");
			tblclmnNewColumn_4.setText("Multa");
			for (int i = 0; i < rsBusca.size(); i += 4) {
				tableItem = new TableItem(tableExibir, SWT.NONE);
				tableItem.setText(0, rsBusca.get(0 + i).toString());
				tableItem.setText(1, rsBusca.get(1 + i).toString());
				tableItem.setText(2, rsBusca.get(2 + i).toString());
				tableItem.setText(3, rsBusca.get(3 + i).toString());
			}
			break;
		}
	}

	public void getValuesCadastroLivro(ArrayList<Object> vec) {
		vec.add(textTitulo.getText());
		vec.add(textAutor.getText());
		vec.add(textEditora.getText());
		vec.add(textCategoria.getText());
		vec.add(textCapa.getText());
		vec.add(textAnoPublicacao.getText());
		vec.add(textSinopse.getText());

	}

	public void getValuesCadastroExemplar(ArrayList<Object> vec1) {
		vec1.add(textCodLivro.getText());
		vec1.add(textEdicao.getText());
		vec1.add(textAno.getText());
		vec1.add(textEstado.getText());
		vec1.add(textDisponibilidade.getText());

	}

	public void getValuesCadastroContato(ArrayList<Object> vec2) {
		vec2.add(textEmail.getText());
		vec2.add(textTelefone.getText());
	}

	public void getValuesCadastroUsuario(ArrayList<Object> vec3) {
		vec3.add(textNome.getText());
		vec3.add(textContato.getText());
		vec3.add(textSenha.getText());
		vec3.add(textLimiteLivros.getText());
	}

	public void getValuesCadastroAutor(ArrayList<Object> vec4) {
		vec4.add(textNomeAutor.getText());
		vec4.add(textBibliografia.getText());
	}

	public void getValuesCadastroEditora(ArrayList<Object> vec5) {
		vec5.add(textNomeEditora.getText());
		vec5.add(textContatoEditora.getText());
		vec5.add(textCnpjEditora.getText());
	}

	public String getBusca() {
		return textBusca.getText();
	}

	public String getBuscaEmprestimo() {
		return textIdAlunoEmprestimo.getText();
	}

	public void setVisible(boolean b) {
		shlTelaBibliotecario.setVisible(b);
		display.close();
	}

	public void limparTelaCadastroLivro() {
		textTitulo.setText("");
		textAutor.setText("");
		textEditora.setText("");
		textCategoria.setText("");
		textCapa.setText("");
		textAnoPublicacao.setText("");
		textSinopse.setText("");
	}

	public void limparTelaCadastroExemplar() {
		textCodLivro.setText("");
		textEdicao.setText("");
		textAno.setText("");
		textEstado.setText("");
		textDisponibilidade.setText("");
	}

	public void limparTelaCadastroContato() {
		textTelefone.setText("");
		textEmail.setText("");
	}

	public void limparTelaCadastroUsuario() {
		textNome.setText("");
		textContato.setText("");
		textSenha.setText("");
		textLimiteLivros.setText("");
	}

	public void limparTelaCadastroAutor() {
		textNomeAutor.setText("");
		textBibliografia.setText("");
	}

	public void limparTelaCadastroEditora() {
		textNomeEditora.setText("");
		textContatoEditora.setText("");
		textCnpjEditora.setText("");
	}
	
	public void mensagemCadastro() {
		MessageBox box = new MessageBox(shlTelaBibliotecario, SWT.ICON_INFORMATION);
		box.setText("Aviso");
		box.setMessage("Cadastro realizado com sucesso!");
		box.open();
	}
}
