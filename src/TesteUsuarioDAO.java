import static org.junit.Assert.*;

import org.dbunit.JdbcDatabaseTester;
import org.junit.Before;
import org.junit.Test;

public class TesteUsuarioDAO {
	
	JdbcDatabaseTester jdt;

	@Before
	public void setUp() throws Exception {
		jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/postgres", "postgres",
					"dan");
		
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
