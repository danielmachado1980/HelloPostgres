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
		String sql = "INSERT INTO usuario(login, email, nome, senha, pontos) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, u.get_login());
			stm.setString(2, u.get_email());
			stm.setString(3, u.get_nome());
			stm.setString(4, u.get_senha());
			stm.setInt(5, u.get_pontos());
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Usuario recuperar(String login) {
		String sql = "SELECT * FROM usuario WHERE login = ?";
		Usuario usuario = new Usuario();
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, login);
			ResultSet rs = stm.executeQuery();
			rs.next();
			usuario.set_login(rs.getString("login"));
			usuario.set_nome(rs.getString("nome"));
			usuario.set_email(rs.getString("email"));
			usuario.set_senha(rs.getString("senha"));
			usuario.set_pontos(rs.getInt("pontos"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public void adicionarPontos(String login, int pontos) {
		String sql = "UPDATE usuario SET pontos = pontos + ? WHERE login = ?";
		try {
			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setInt(1, pontos);
			stm.setString(2, login);
			stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
