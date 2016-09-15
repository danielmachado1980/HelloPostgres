package model;

import java.util.List;

import interfaces.UsuarioDAO;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	static {
		try{
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	@Override
	public void inserir(Usuario u) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario recuperar(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Usuario> ranking() {
		// TODO Auto-generated method stub
		return null;
	}

}
