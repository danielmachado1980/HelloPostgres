import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Before;
import org.junit.Test;

import model.Usuario;
import model.UsuarioDAOImpl;

public class TesteUsuarioDAOImpl {
	JdbcDatabaseTester jdt;

	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/coursera", "postgres",
					"dan");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		jdt.setDataSet(loader.load("/inicio.xml"));
		jdt.onSetup();
	}

	@Test
	public void ranking() {
		List<Usuario> lstUsuarios = new ArrayList<>();
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		lstUsuarios = dao.ranking();
		assertEquals("lidia", lstUsuarios.get(0).get_login());
	}
	
	@Test
	public void recuperar() {
		Usuario usuario = new Usuario();
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		usuario = dao.recuperar("joao");
		assertEquals(20, usuario.get_pontos());
		assertEquals("joao@mail.com", usuario.get_email());
		assertEquals("jao", usuario.get_senha());
		assertEquals("joao", usuario.get_login());
		assertEquals("JOAO BATISTA MACHADO", usuario.get_nome());
	}
	
	@Test
	public void adicionaPontos() {
		Usuario usuario = new Usuario();
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		dao.adicionarPontos("lidia", 10);
		usuario = dao.recuperar("lidia");
		assertEquals(60, usuario.get_pontos());
		dao.adicionarPontos("joao", 5);
		usuario = dao.recuperar("joao");
		assertEquals(25, usuario.get_pontos());
	}
	
	@Test
	public void inserir() throws Exception {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		
		Usuario usuario = new Usuario();
		usuario.set_email("duda@mail.com");
		usuario.set_login("duda");
		usuario.set_nome("MARIA EDUARDA GUERRA");
		usuario.set_pontos(45);
		usuario.set_senha("duda123");
		dao.inserir(usuario);
		
		usuario = new Usuario();
		usuario.set_email("duda2@mail.com");
		usuario.set_login("duda2");
		usuario.set_nome("MARIA EDUARDA GUERRA2");
		usuario.set_pontos(45);
		usuario.set_senha("duda1234");
		dao.inserir(usuario);
		
		IDataSet currentDataset = jdt.getConnection().createDataSet();
		ITable currentTable = currentDataset.getTable("USUARIO");
		FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
		IDataSet expectedDataset = loader.load("/verifica.xml");
		ITable expectedTable = expectedDataset.getTable("USUARIO");
		Assertion.assertEquals(expectedTable, currentTable);
	}

}
