package general;

import java.sql.SQLException;
import java.sql.ResultSet;

public class Comuna {
	private int codigo;
	private String nombre;
	private String codigoRegion;
	Conectadb cn = new Conectadb();

	public Comuna() {
		// TODO Auto-generated constructor stub
	}
	
	public Comuna(int codigo, String nombre, String codigoComuna) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.codigoRegion = codigoComuna;
	}
	
	public boolean IngresarComuna(String nombre, String codigoRegion){
		String consulta = "insert into Comuna (nombre, codigoRegion) values ('"+ nombre + "', '" + codigoRegion + "');";
		try {
			cn.conectar();
			cn.insertar(consulta);
			return true;
		} catch (SQLException e) {
			return false;
		} 
		
	}
	
	public ResultSet ConsultarComuna(int codigo){
		String consulta ="select nombre from Comuna where codigo=" + codigo + ";" ;
		ResultSet rs = null;
		String nombre = "";

		try {
			cn.conectar();
			rs = cn.consulta(consulta);
			while (rs.next()){
				nombre = rs.getString(1);
			}
			return rs;
		} catch (SQLException e) {
			return rs;
		}

		
	}
	
	public ResultSet ListarComuna(){
		String consulta ="select codigo, nombre, codigoRegion from Comuna";
		ResultSet rs = null;
		String nombre = "";
		int codigo;
		int codigoRegion;

		try {
			cn.conectar();
			rs = cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				nombre = rs.getString(2);
				codigoRegion = rs.getInt(3);
			}
			return rs;
		} catch (SQLException e) {
			return rs;
		}
		
		
		}
	
	public ResultSet ConsultarRegion(int codigo){
		String consulta ="select reg.nombre from Comuna com join Region reg on com.codigoRegion=reg.codigo where com.codigoRegion=" + codigo + ";" ;
		ResultSet rs = null;
		String nombre = "";

		try {
			cn.conectar();
			rs = cn.consulta(consulta);
			while (rs.next()){
				nombre = rs.getString(1);
			}
			return rs;
		} catch (SQLException e) {
			return rs;
		}

		
	}


}
