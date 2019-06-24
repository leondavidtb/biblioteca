package view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import controller.LoginController;

public class LoginView {

	protected Display display;
	protected Shell shell;
	private Text txtLogin;
	private Text txtSenha;
	private LoginController loginController = new LoginController(this);

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginView window = new LoginView();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	
	public void mensagemErro() {
		MessageBox box = new MessageBox(shell, SWT.ICON_WARNING);
		box.setText("Aviso");
		box.setMessage("Dados inválidos!");
		box.open();
	}
	
	public void limparTela() {
		txtLogin.setText("");
		txtSenha.setText("");
	}
	
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Tela de Login");
		
		Label lblLogin = new Label(shell, SWT.NONE);
		lblLogin.setBounds(10, 60, 58, 17);
		lblLogin.setText("Login");
		
		txtLogin = new Text(shell, SWT.BORDER);
		txtLogin.setBounds(10, 85, 424, 29);
		
		Label lblSenha = new Label(shell, SWT.NONE);
		lblSenha.setBounds(10, 131, 58, 17);
		lblSenha.setText("Senha");
		
		txtSenha = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		txtSenha.setBounds(10, 154, 424, 29);
		
		Button btnEntrar = new Button(shell, SWT.NONE);
		btnEntrar.setBounds(101, 202, 83, 34);
		btnEntrar.setText("Entrar");
		
		Button btnSenha = new Button(shell, SWT.NONE);
		btnSenha.setBounds(249, 202, 83, 34);
		btnSenha.setText("Limpar");

		//limparTela();
		SelectionAdapter sa = new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent se) {
				if(((Button) se.getSource()).getText().equals("Entrar")) {
					if(txtLogin.getText().equals("") || txtSenha.getText().equals("")) {
						mensagemErro();
					} else {
						loginController.setEvent(se);
					}
				} else {
					limparTela();
				}
			}
		};
		
		btnEntrar.addSelectionListener(sa);
		btnSenha.addSelectionListener(sa);
	}
	
	public String getUser() {
		return txtLogin.getText();
	}
	
	public String getSenha() {
		return txtSenha.getText();
	}

	public void setVisible(boolean b) {
		shell.setVisible(b);
		display.close();
		
	}
}
