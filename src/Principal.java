import java.util.ArrayList;
import java.util.List;

import model.Usuario;
import model.UsuarioDAOImpl;

public class Principal {

	public static void main(String[] args) {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		//List<Usuario> usuarios = new ArrayList<>();
		//Usuario usuario = new Usuario();
		dao.adicionarPontos("lidia", 10);
		//System.out.println(usuario);
		//for(Usuario usu : usuarios){
		//	System.out.println(usu);
		//}
	}

}
