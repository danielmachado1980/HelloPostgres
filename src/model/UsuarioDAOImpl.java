package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import interfaces.UsuarioDAO;

public class UsuarioDAOImpl extends BaseDAO implements UsuarioDAO {
	
	
	
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
		List<Usuario> lstUsuarios = new ArrayList<>();
		try {
			String sql = "SELECT * FROM usuario ORDER BY pontos DESC";
			PreparedStatement stm = connection.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.set_login(rs.getString("login"));
				usuario.set_nome(rs.getString("nome"));
				usuario.set_email(rs.getString("email"));
				usuario.set_senha(rs.getString("senha"));
				usuario.set_pontos(rs.getInt("pontos"));
				lstUsuarios.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstUsuarios;
	}
	
}
