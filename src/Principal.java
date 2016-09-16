import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import model.UsuarioDAOImpl;

public class Principal {

	public static void main(String[] args) {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		List<Usuario> usuarios = new ArrayList<>();
		usuarios = dao.ranking();
		for(Usuario usuario : usuarios){
			System.out.println(usuario);
		}
	}

}
