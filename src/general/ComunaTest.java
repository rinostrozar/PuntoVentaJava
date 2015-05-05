package general;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.Test;


public class ComunaTest {

	@Test
	public void test() {
		Comuna c = new Comuna();
		
		//1 - Ingresar Comuna
		//c.IngresarComuna("Comuna2", "1");
		//assertTrue(true);

		//2 - Consultar Comuna por código 
		//assertNotNull(c.ConsultarComuna(1));
		
		//3 - Consultar Region por codigo (foránea de Comuna) 
		//assertNotNull(c.ConsultarRegion(1));
		
		//4 - Listar Ciudades
		//ResultSet respuesta = c.ListarComuna();
		//assertNotNull(respuesta);
	}

}
