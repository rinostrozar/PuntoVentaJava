package general;

import java.awt.List;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSet;

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
			cn.insertar(consulta);//falta corroborar el ingreso de datos + mensaje	
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} 
		
	}
	
	public String ConsultarComuna(int codigo){
		String consulta ="select nombre from Comuna where codigo=" + codigo + ";" ;
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
	
	//public void ListarComuna(){
		//:P
	
//	}
	
	public String ConsultarRegion(int codigo){
		String consulta ="select reg.nombre from Comuna com join Region reg on com.codigoRegion=reg.codigo where com.codigoRegion=" + codigo + ";" ;
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
