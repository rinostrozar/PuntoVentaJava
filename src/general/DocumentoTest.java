package general;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class DocumentoTest {
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	Calendar cal = Calendar.getInstance();  
	
	@Test
	public void test() {
	
		Documento d = new Documento();
		
		/*boolean resp = d.IngresarBoleta(2, "2015-3-22" , 1000);
		assertTrue(resp);*/
		
		/*boolean resp = d.IngresarFactura(2, 2, "2015-2-23", 1);
		assertTrue(resp);*/
		
		/*boolean resp = d.IngresarDetalleBoleta(2, 1, 1);
		assertTrue(resp);*/
		
		/*boolean resp = d.IngresarDetalleFactura(2, 1, 1);
		assertTrue(resp);*/
		
		/*boolean resp = d.IngresarEstadoDocumento(2, "deuda", "1");
		assertTrue(resp);*/
		
		//assertNotNull(d.ListarBoleta());
		
		//assertNotNull(d.ListarFactura());
		
		//assertNotNull(d.ListarDetalleBoleta());
		
		//assertNotNull(d.ListarDetalleFactura());
		
		//assertNotNull(d.ListarEstadoDocumento());
		
		//assertNotNull(d.ConsultarBoleta(1));
		
		//assertNotNull(d.ConsultarFactura(1));
		
		//assertNotNull(d.ConsultarDetalleBoleta(1));
		
		//assertNotNull(d.ConsultarDetalleFactura(1));
		
		//assertNotNull(d.ConsultarEstadoDocumento(1));
		
		/*boolean resp = d.BorrarBoleta(2);
		assertTrue(resp);*/
		
		/*boolean resp = d.BorrarFactura(2);
		assertTrue(resp);*/
		
		/*boolean resp = d.BorrarDetalleBoleta(2);
		assertTrue(resp);*/
		
		/*boolean resp = d.BorrarDetalleFactura(2);
		assertTrue(resp);*/
		
		/*boolean resp = d.BorrarEstadoDocumento(2);
		assertTrue(resp);*/
	}

}

