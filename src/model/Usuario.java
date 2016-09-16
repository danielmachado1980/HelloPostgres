package model;

public class Usuario {
	private String _login;
	private String _email;
	private String _nome;
	private String _senha;
	private int _pontos;
	
	public String get_login() {
		return _login;
	}

	public void set_login(String login) {
		this._login = login;
	}

	public String get_email() {
		return _email;
	}

	public void set_email(String email) {
		this._email = email;
	}

	public String get_nome() {
		return _nome;
	}

	public void set_nome(String nome) {
		this._nome = nome;
	}

	public String get_senha() {
		return _senha;
	}

	public void set_senha(String senha) {
		this._senha = senha;
	}

	public int get_pontos() {
		return _pontos;
	}

	public void set_pontos(int pontos) {
		this._pontos = pontos;
	}

	@Override
	public String toString() {
		return "Usuario [_login=" + _login + "]";
	}
	
}
