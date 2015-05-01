package general;

import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

public class Ciudad {
	private int codigo;
	private String nombre;
	private String codigoComuna;
	Conectadb cn = new Conectadb();

	public Ciudad() {
		// TODO Auto-generated constructor stub
	}
	
	public Ciudad(int codigo, String nombre, String codigoComuna) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.codigoComuna = codigoComuna;
	}
	
	public boolean IngresarCiudad(String nombre, String codigoComuna){
		String consulta = "insert into Ciudad (nombre, codigoComuna) values ('"+ nombre + "', '" + codigoComuna + "');";
		try {
			cn.conectar();
			cn.insertar(consulta);//falta corroborar el ingreso de datos + mensaje	
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}
	
	public String ConsultarCiudad(int codigo){
		String consulta ="select nombre from Ciudad where codigo=" + codigo + ";" ;
		ResultSet rs = null;
		String nombre = "";

		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombre;
		
	}
	
	//public boolean ListarCiudad(){
		// 
		 //		 
		 //		
	//}
	
	public String ConsultarComuna(int codigo){
		String consulta ="select com.nombre from Ciudad ciu join Comuna com on ciu.codigoComuna=com.codigo where ciu.codigoComuna=" + codigo + ";" ;
		ResultSet rs = null;
		String nombre = "";

		try {
			cn.conectar();
			rs = (ResultSet) cn.consulta(consulta);
			while (rs.next()){
				nombre = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nombre;
		
	}


}
