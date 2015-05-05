package general;

import java.sql.SQLException;

import java.sql.ResultSet;

public class Ciudad {
	private int codigo;
	private String nombre;
	private String codigoComuna;
	Conectadb cn = new Conectadb();

	public Ciudad() {
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
			cn.insertar(consulta);
			return true;
		} catch (SQLException e) {
			return false;
		} 
		
	}
	
	public ResultSet ConsultarCiudad(int codigo){
		String consulta ="select nombre from Ciudad where codigo=" + codigo + ";" ;
		ResultSet rs = null;

		try {
			cn.conectar();
			rs =  cn.consulta(consulta);
			return rs;
			
		} catch (SQLException e) {
			return rs;
		}
		 
		
	}
	
	public ResultSet ListarCiudad(){
		String consulta ="select codigo, nombre, codigoComuna from Ciudad";
		ResultSet rs = null;
		String nombre = "";
		int codigo;
		int codigoComuna;

		try {
			cn.conectar();
			rs = cn.consulta(consulta);
			while (rs.next()){
				codigo = rs.getInt(1);
				nombre = rs.getString(2);
				codigoComuna = rs.getInt(3);
			}
			return rs;
		} catch (SQLException e) {
			return rs;
		}
		
		}
	
	public ResultSet ConsultarComuna(int codigo){
		String consulta ="select com.nombre from Ciudad ciu join Comuna com on ciu.codigoComuna=com.codigo where ciu.codigoComuna=" + codigo + ";" ;
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
