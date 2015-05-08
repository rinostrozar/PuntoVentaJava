package general;

import java.sql.SQLException;
import java.sql.ResultSet;

public class Documento {
   
   //ATRIBUTOS
   private int valor;
   private int codigo;  
   private String estado;
   private String descripcion;
   private String fecha;
   
   
   //CONEXION CON BdD
   Conectadb cn = new Conectadb();
   
   
   //CONSTRUCTOR SIN PARAMETROS
   public Documento(){
	   
   }
   
   
   //CONSTRUCTOR CON PARAMETROS
   public Documento(int valor, int codigo, String estado, String descripcion, String fecha){
	   this.valor = valor;
	   this.codigo = codigo;
	   this.estado = estado;
	   this.descripcion = descripcion;
	   this.fecha = fecha;
	}
   
   
   //METODO PARA INGRESAR UNA BOLETA
   public boolean IngresarBoleta(int CodigoBoleta, String fecha, int total){
		String insert = "insert into boleta (codigo, fecha, total) values ("+ CodigoBoleta + ", '" + fecha + "', " + total + ");";
		try {
			cn.conectar();
			cn.insertar(insert);
			System.out.println(">> Datos ingresados a la tabla ''Boleta'' <<");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
   }
	
   
   //METODO PARA INGRESAR UNA FACTURA
   public boolean IngresarFactura(int CodigoEstadoFactura, int codigo, String fecha, int rutcliente){
 		String insert2 = "insert into factura (codEstado, codigo, fecha, rutcliente) values ("+ CodigoEstadoFactura + ", " + codigo + ", '" + fecha + "', " + rutcliente + ");";
 		try {
 			cn.conectar();
 			cn.insertar(insert2);
 			System.out.println(">> Datos ingresados a la tabla ''Factura'' <<");
 			return true;
 		} catch (SQLException e) {
 			e.printStackTrace();
 			return false;
 		} 
    }
   
   
   //METODO PARA INGRESAR UN DETALLE DE LA BOLETA
   public boolean IngresarDetalleBoleta(int CodigoDetalleBoleta, int CodigoArticulo, int CodigoBoleta){
		String insert = "insert into detalleBoleta (codigo, codArticulo, codBoleta) values ("+ CodigoDetalleBoleta + ", '" + CodigoArticulo + "', " + CodigoBoleta + ");";
		try {
			cn.conectar();
			cn.insertar(insert);
			System.out.println(">> Datos ingresados a la tabla ''Detalle Boleta'' <<");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
   }
   
   
   //METODO PARA INGRESAR UN DETALLE DE LA FACTURA
   public boolean IngresarDetalleFactura(int CodigoDetalleFactura, int CodigoFactura, int CodigoArticulo){
		String insert = "insert into detalleFactura (codigo, codFactura, codArticulo) values ("+ CodigoDetalleFactura + ", '" + CodigoFactura + "', " + CodigoArticulo + ");";
		try {
			cn.conectar();
			cn.insertar(insert);
			System.out.println(">> Datos ingresados a la tabla ''Detalle Factura'' <<");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
   }
   
   
   //METODO PARA INGRESAR UN ESTADO DE DOCUMENTO
   public boolean IngresarEstadoDocumento(int CodigoEstadoDocumento, String NombreEstado , String Descripcion){
		String insert = "insert into estadodocumento (codigo, nombre, descripcion) values ("+ CodigoEstadoDocumento + ", '" + NombreEstado + "', '" + Descripcion + "');";
		try {
			cn.conectar();
			cn.insertar(insert);
			System.out.println(">> Datos ingresados a la tabla ''Estado de Documento'' <<");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
   }
   
   
   //METODO PARA LISTAR LAS BOLETAS
   public boolean ListarBoleta(){
		String consulta ="select * from boleta";
		ResultSet rs = null;
		int codigo;
		String fecha = " ";
		int total;
		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				fecha = rs.getString(2);
				total = rs.getInt(3);
				System.out.println(">> Código boleta: [" + codigo + "]\n>> Fecha: [" + fecha + "]\n>> Total boleta: [$" + total + "]\n");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
   
   
   //METODO PARA LISTAR LAS FACTURAS
   public boolean ListarFactura(){
		String consulta ="select f.codigo, f.rutcliente, f.fecha, es.nombre from factura f join estadodocumento es on f.codEstado=es.codigo";
		ResultSet rs = null;
		int codigo;
		int rutcliente;
		String fecha = " ";
		String estado = " ";
		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				rutcliente = rs.getInt(2);
				fecha = rs.getString(3);
				estado = rs.getString(4);
				System.out.println(">> Código factura: [" + codigo + "]\n>> Rut del cliente: [" + rutcliente + "]\n>> Fecha: [" + fecha + "]\n>> Estado del documento: [" + estado + "]\n");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
   
   
   //METODO PARA LISTAR LOS DETALLES DE LAS BOLETAS
   public boolean ListarDetalleBoleta(){
		String consulta ="select db.codigo, a.codigo, a.nombre, db.codboleta from detalleboleta db join articulo a on db.codarticulo=a.codigo";
		ResultSet rs = null;
		int codigo;
		int codigoarticulo;
		String nombre = " ";
		int codigoboleta;
		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				codigoarticulo = rs.getInt(2);
				nombre = rs.getString(3);
				codigoboleta = rs.getInt(4);
				System.out.println(">> Código del Detalle de Boleta: [" + codigo + "]\n>> Código de Artículo: [" + codigoarticulo + "]\n>> Nombre de Artículo: [" + nombre + "]\n>> Código de Boleta: [" + codigoboleta + "]\n");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
   
   
   //METODO PARA LISTAR LOS DETALLES DE LAS FACTURAS
   public boolean ListarDetalleFactura(){
		String consulta ="select df.codigo, a.codigo, a.nombre, df.codfactura from detallefactura df join articulo a on df.codarticulo=a.codigo";
		ResultSet rs = null;
		int codigo;
		int codigoarticulo;
		String nombre = " ";
		int codigofactura;
		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				codigoarticulo = rs.getInt(2);
				nombre = rs.getString(3);
				codigofactura = rs.getInt(4);
				System.out.println(">> Código del Detalle de Factura: [" + codigo + "]\n>> Código de Artículo: [" + codigoarticulo + "]\n>> Nombre de Artículo: [" + nombre + "]\n>> Código de Factura: [" + codigofactura + "]\n");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
		
   
   //METODO PARA LISTAR LOS ESTADOS DE LOS DOCUMENTOS
   public boolean ListarEstadoDocumento(){
		String consulta ="select * from estadodocumento";
		ResultSet rs = null;
		int codigo;
		String nombre=" ";
		String descripcion=" ";
		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				nombre = rs.getString(2);
				descripcion = rs.getString(3);
				System.out.println(">> Código del Estado de Documento: [" + codigo + "]\n>> Nombre del estado: [" + nombre + "]\n>> Descripción del estado: [" + descripcion + "]\n");
			}
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
   
   
   //METODO PARA CONSULTAR UNA BOLETA
   public int ConsultarBoleta(int codigo){
		String consulta ="select codigo, fecha, total from boleta where codigo=" + codigo + ";" ;
		ResultSet rs = null;
		String fecha = " ";
		int total = 0;
		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				fecha = rs.getString(2);
				total = rs.getInt(3);
				System.out.println(">> Código de boleta: [" + codigo + "]\n>> Fecha: [" + fecha + "]\n>> Total: [$" + total + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codigo + total;
	}
   
   
   //METODO PARA CONSULTAR UNA FACTURA
   public String ConsultarFactura(int codigo){
		String consulta ="select f.codigo, f.rutcliente, f.fecha, es.nombre from factura f join estadodocumento es on es.codigo=f.codestado where f.codigo=" + codigo + ";" ;
		ResultSet rs = null;
		String rutcliente = " ";
		String fecha = " ";
		String estado = " ";
		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				rutcliente = rs.getString(2);
				fecha = rs.getString(3);
				estado = rs.getString(4);
				System.out.println(">> Código de factura: [" + codigo + "]\n>> Rut del cliente: [" + rutcliente + "]\n>> Fecha: [" + fecha + "]\n>> Estado de factura: [" + estado + "]\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return estado + codigo + rutcliente;
	}
   
   
   //METODO PARA CONSULTAR UN DETALLE DE BOLETA
   public String ConsultarDetalleBoleta(int codigo){
		String consulta ="select db.codigo, a.codigo, a.nombre, db.codboleta from detalleboleta db join articulo a on db.codarticulo=a.codigo where db.codigo=" + codigo + ";" ;
		ResultSet rs = null;
		int codigoarticulo = 0;
		String nombrearticulo = " ";
		int codigoboleta = 0;
		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				codigoarticulo = rs.getInt(2);
				nombrearticulo = rs.getString(3);
				codigoboleta = rs.getInt(4);
				System.out.println(">> Código de Detalle de boleta: [" + codigo + "]\n>> Código de artículo: [" + codigoarticulo + "]\n>> Nombre de artículo: [" + nombrearticulo + "]\n>> Código de boleta: [" + codigoboleta + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codigo + codigoarticulo + nombrearticulo + codigoboleta;
	}
   
   
   //METODO PARA CONSULTAR UN DETALLE DE FACTURA
   public String ConsultarDetalleFactura(int codigo){
		String consulta ="select df.codigo, a.codigo, a.nombre, df.codfactura from detallefactura df join articulo a on df.codarticulo=a.codigo where df.codigo=" + codigo + ";" ;
		ResultSet rs = null;
		int codigoarticulo = 0;
		String nombrearticulo = " ";
		int codigofactura = 0;
		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				codigoarticulo = rs.getInt(2);
				nombrearticulo = rs.getString(3);
				codigofactura = rs.getInt(4);
				System.out.println(">> Código de Detalle de factura: [" + codigo + "]\n>> Código de artículo: [" + codigoarticulo + "]\n>> Nombre de artículo: [" + nombrearticulo + "]\n>> Código de factura: [" + codigofactura + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codigo + codigoarticulo + nombrearticulo + codigofactura;
	}
   
   
   //METODO PARA CONSULTAR UN ESTADO DE DOCUMENTO
   public String ConsultarEstadoDocumento(int codigo){
		String consulta ="select * from estadodocumento where codigo=" + codigo + ";" ;
		ResultSet rs = null;
		String nombre = " ";
		String descripcion = " ";
		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				nombre = rs.getString(2);
				descripcion = rs.getString(3);
				System.out.println(">> Código de estado de documento: [" + codigo + "]\n>> Nombre de estado: [" + nombre + "]\n>> Descripción de estado: [" + descripcion + "]");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return codigo + nombre + descripcion;
	}
   
   
   //METODO PARA BORRAR UNA BOLETA
   public boolean BorrarBoleta (int codigo) {
	   String borrar = "delete from boleta where codigo=" + codigo + ";"; 
	   try {
		   cn.conectar();
		   cn.borrar(borrar);
		   System.out.println("Datos eliminados de la tabla ''Boleta'' en relación al Código de Boleta: " + codigo);
	   } catch (SQLException e){
		   e.printStackTrace();
	   }
	return true;
   }
   
   
   //METODO PARA BORRAR UNA BOLETA
   public boolean BorrarFactura (int codigo) {
	   String borrar = "delete from factura where codigo=" + codigo + ";"; 
	   try {
		   cn.conectar();
		   cn.borrar(borrar);
		   if(true){
		   System.out.println("Datos eliminados de la tabla ''Factura'' en relación al Código de Factura: " + codigo);
		   }
	   } catch (SQLException e){
		   e.printStackTrace();
	   }
	return true;
   }
   
   
   //METODO PARA BORRAR UN DETALLE DE BOLETA
   public boolean BorrarDetalleBoleta (int codigo) {
	   String borrar = "delete from detalleboleta where codigo=" + codigo + ";"; 
	   try {
		   cn.conectar();
		   cn.borrar(borrar);
		   System.out.println("Datos eliminados de la tabla ''Detalle Boleta'' en relación al Código de detalle: " + codigo);
	   } catch (SQLException e){
		   e.printStackTrace();
	   }
	return true;
   }
   
   
   //METODO PARA BORRAR UN DETALLE DE FACTURA
   public boolean BorrarDetalleFactura (int codigo) {
	   String borrar = "delete from detallefactura where codigo=" + codigo + ";"; 
	   try {
		   cn.conectar();
		   cn.borrar(borrar);
		   System.out.println("Datos eliminados de la tabla ''Detalle Factura'' en relación al Código de detalle: " + codigo);
	   } catch (SQLException e){
		   e.printStackTrace();
	   }
	return true;
   }
   
   
   //METODO PARA BORRAR UN ESTADO DE DOCUMENTO
   public boolean BorrarEstadoDocumento (int codigo) {
	   String borrar = "delete from estadodocumento where codigo=" + codigo + ";"; 
	   try {
		   cn.conectar();
		   cn.borrar(borrar);
		   System.out.println("Datos eliminados de la tabla ''Estado de Documento'' en relación al Código de estado: " + codigo);
	   } catch (SQLException e){
		   e.printStackTrace();
	   }
	return true;
   }
}