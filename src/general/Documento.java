package general;

import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.ResultSet;

public class Documento {
   
   //ATRIBUTOS
   private int neto;
   private int rutsucursal;
   private String direccionsucursal;
   private int iva; 
   private int codigo;  
   private String estado; 
   private int rutcliente; 
   private String nombrecliente; 
   private String detallearticulo; 
   private int total; 
   private int tipo;
   
   
   //CONEXION CON BdD
   Conectadb cn = new Conectadb();
   
   
   //CONSTRUCTOR SIN PARAMETROS
   public Documento(){
	   
   }
   
   
   //CONSTRUCTOR CON PARAMETROS
   public Documento(int neto, int rutsucursal, String direccionsucursal, int iva, int codigo, String estado, int rutcliente, String nombrecliente, String detallearticulo, int total, int tipo){
		this.rutsucursal = rutsucursal;
		this.direccionsucursal = direccionsucursal;
		this.codigo = codigo;
		this.estado = estado;
		this.rutcliente = rutcliente;
		this.nombrecliente = nombrecliente;
		this.detallearticulo = detallearticulo;
		this.neto = neto;
		this.iva = iva;
		this.total = total;
		this.tipo = tipo;
	}
   
   
   //METODO PARA INGRESAR UNA BOLETA
   public boolean IngresarBoleta(int rutsucursal, String direccionsucursal, int codigo, int estado, int total, int tipo){
		String insert = "insert into documento (rutsucursal, direccionsucursal, codigo, estado, total, tipo) values (" + rutsucursal + ", '" + direccionsucursal + "', "+ codigo + ", " + estado + ", " + total + ", " + tipo + ");";
		try {
			cn.conectar();
			cn.insertar(insert);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} 
   }
	
   
   //METODO PARA INGRESAR UNA FACTURA
   public boolean IngresarFactura(int neto, int rutsucursal, String direccionsucursal, int iva, int codigo, int estado, int rutcliente, String nombrecliente, String detallearticulo, int total, int tipo){
 		String insert2 = "insert into documento (nombre, codigoComuna) values (" + rutsucursal + ", '" + direccionsucursal + "', " + codigo + ", " + estado + ", " + rutcliente + ", '" + nombrecliente + "', '" + detallearticulo + "', " + neto + ", " + iva + ", " + total + ", " + tipo + ");";
 		try {
 			cn.conectar();
 			cn.insertar(insert2);
 			return true;
 		} catch (SQLException e) {
 			e.printStackTrace();
 			return false;
 		} 
    }
   
   
   //METODO PARA LISTAR LOS DOCUMENTOS
   public boolean ListarDocumento(){
		String consulta ="select codigo, estado, total, tipo from documento";
		ResultSet rs = null;
		int codigo;
		String estado = "";
		int total;
		int tipo;

		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(3);
				estado = rs.getString(4);
				total = rs.getInt(10);
				tipo = rs.getInt(11);
			}
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		}
	
   
   //METODO PARA CONSULTAR UN DOCUMENTO
   public String ConsultarDocumento(int codigo){
		String consulta ="select rutcliente, nombrecliente, detallearticulo, neto, iva, total, tipo from documento where codigo=" + codigo + ";" ;
		ResultSet rs = null;
		int rutcliente=0;
		String nombrecliente = " ";
		String detallearticulo = " ";
		int neto=0;
		int iva=0;
		int total=0;

		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				rutcliente = rs.getInt(5);
				nombrecliente = rs.getString(6);
				detallearticulo = rs.getString(7);
				neto = rs.getInt(8);
				iva = rs.getInt(9);
				total = rs.getInt(10);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rutcliente + nombrecliente + detallearticulo + neto + iva + total;
		
	}
		 
   
   //METODO PARA BORRAR UN DOCUMENTO
   public boolean BorrarDocumento (int codigo) {
	   String borrar = "delete from documento where codigo=" + codigo + ";";
	   try {
		   cn.conectar();
		   cn.borrar(borrar);
		   return true;
	   } catch (SQLException e){
		   e.printStackTrace();
		   return false;
	   }
   }
}