package general;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArticuloTest {

	@Test
	public void test() {
		Articulo a = new Articulo();
		boolean resp = a.consultarArticulo(1111);
		assertTrue(resp);
	}

}
