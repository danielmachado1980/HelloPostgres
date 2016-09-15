package model;

public class Usuario {
	private String _login;
	private String _email;
	private String _nome;
	private String _senha;
	private int _pontos;
	
	public Usuario(String login, String email, String nome, String senha, int pontos) {
		super();
		this._login = _login;
		this._email = _email;
		this._nome = _nome;
		this._senha = _senha;
		this._pontos = _pontos;
	}

	public String get_login() {
		return _login;
	}

	public void set_login(String login) {
		this._login = _login;
	}

	public String get_email() {
		return _email;
	}

	public void set_email(String email) {
		this._email = _email;
	}

	public String get_nome() {
		return _nome;
	}

	public void set_nome(String nome) {
		this._nome = _nome;
	}

	public String get_senha() {
		return _senha;
	}

	public void set_senha(String senha) {
		this._senha = _senha;
	}

	public int get_pontos() {
		return _pontos;
	}

	public void set_pontos(int pontos) {
		this._pontos = _pontos;
	}
}
