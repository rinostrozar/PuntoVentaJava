package general;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class DocumentoTest {
	
	//CONVERTIMOS EL FORMATO OBTENIDO DE LA LIBRERIA IMPORTADA
	//Y LE ASIGNAMOS UN NUEVO FORMATO PARA EL INGRESO DE FECHAS
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
	Calendar cal = Calendar.getInstance();  
	
	@Test
	public void test() {
	
		Documento d = new Documento();
		
		/*LLAMADA A LOS METODOS CREADOS PARA INSERTAR DATOS*/
		
		
		//assertNotNull(d.IngresarBoleta(2, "2015-3-22" , 1000));
		
		//assertNotNull(d.IngresarFactura(1, 2, "2015-2-23", 1));
		
		//assertNotNull(d.IngresarDetalleBoleta(2, 1, 1));
		
		//assertNotNull(d.IngresarDetalleFactura(2, 1, 1));
	
		//assertNotNull(d.IngresarEstadoDocumento(2, "deuda", "1"));
		
		
		
		
		/*LLAMADA A LOS METODOS CREADOS PARA LISTAR DATOS DE LA TABLAS*/
		
		
		//assertNotNull(d.ListarBoleta());
		
		//assertNotNull(d.ListarFactura());
		
		//assertNotNull(d.ListarDetalleBoleta());
		
		//assertNotNull(d.ListarDetalleFactura());
		
		//assertNotNull(d.ListarEstadoDocumento());
		
		
		
		
		/*LLAMADA A LOS METODOS CREADOS PARA CONSULTAR DATOS DE ACUERDO A UN PARAMETRO INGRESADO EN ESPECIFICO*/ 
		
		
		//assertNotNull(d.ConsultarBoleta(1));
		
		//assertNotNull(d.ConsultarFactura(1));
		
		//assertNotNull(d.ConsultarDetalleBoleta(1));
		
		//assertNotNull(d.ConsultarDetalleFactura(1));
		
		//assertNotNull(d.ConsultarEstadoDocumento(1));
		
		
		
		
		/*LLAMADA A LOS METODOS CREADOS PARA BORRAR DATOS DE LA TABLAS DE ACUERDO A UN PARAMETRO INGRESADO EN ESPECIFICO*/
		
		
		//assertNotNull(d.BorrarBoleta(2));
		
		//assertNotNull(d.BorrarFactura(2));

		//assertNotNull(d.BorrarDetalleBoleta(2));
		
		//assertNotNull(d.BorrarDetalleFactura(2));
	
		//assertNotNull(d.BorrarEstadoDocumento(2));
		
	}

}

