package controller;

import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;

import dao.UsuarioDao;
import view.BibliotecarioView;
import view.LoginView;

public class LoginController {

	private LoginView loginView;
	private UsuarioDao uDao = new UsuarioDao();
	
	public LoginController(LoginView view) {
		this.loginView = view;
	}
	
	public void setEvent(SelectionEvent se) {
		if(se.getSource() instanceof Button) {
			if(((Button) se.getSource()).getText().equals("Entrar")) {
				if(uDao.checkLogin(loginView.getUser(), loginView.getSenha())) {
					loginView.setVisible(false);
					new BibliotecarioView();
				} else {
					loginView.mensagemErro();
				}
			}
		}
	}
}
