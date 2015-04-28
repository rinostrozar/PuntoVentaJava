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
	
	public void IngresarCiudad(){
		String consulta = "insert into Ciudad values (" + codigo + ", '"+ nombre + "', '" + codigoComuna + "');";
		try {
			cn.conectar();
			cn.insertar(consulta);//falta corroborar el ingreso de datos + mensaje		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public ResultSet ConsultarCiudad(int codigo){
		String consulta ="select nombre from Ciudad where codigo=" + codigo + ";" ;
		ResultSet rs = null;
		String nombre;

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
		return rs;
		
	}
	
	public Object[] ListarCiudad(){
		 Object[] lista = new Object[3]; //como obtener cantidad de filas y asignarlo al objeto
		 String consulta = "select * from ciudad";		 
		 return lista;		
	}
	
	public String ConsultaComuna(){
		String consulta ="";
		
		return consulta;
	}


}
