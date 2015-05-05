//CLASE DE IGNACIO - PROVEEDOR

package general;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Proveedor {

	
	private String nombre, fono, direccion, rut;
	Conectadb c=new Conectadb();
	
	public Proveedor(){
	}
	
	public void setRut(String s_rut){
		rut=s_rut;
	}
	public String getRut(){
		return rut;
	}
	
	public void setNombre(String s_name){
		nombre=s_name;
	}
	public String getNombre(){
		return nombre;
	}

	public void setFono(String s_fono){
		fono=s_fono;
	}
	public String getFono(){
		return fono;
	}

	public void setDireccion(String s_direc){
		direccion=s_direc;
	}
	public String getDireccion(){
		return direccion;
	}
	
	
	public boolean Ingreso_Proveedor(String rut, String nom, String fon, String direc){
		try {
			c.conectar();
			String Insert_prov= "insert into proveedor (rut, nombre, fono, direccion) values ('" + rut + "','" + nom + "','"+ fon + "','"+direc+"');";
			c.insertar(Insert_prov);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ResultSet Consulta_Proveedor(String rut){
		ResultSet rs = null;
		String nombre = "";
		String consulta= "select nombre from Proveedor where rut='" + rut +"';" ;
		try {
			c.conectar();
			rs = (ResultSet) c.consulta(consulta);
			while (rs.next()){
				nombre = rs.getString(2);
			}
			return rs;
			
		} catch (SQLException e) {
			return rs;
		}
	}
	
		
	public ResultSet ListarProveedor(){
		String consulta ="select * from Proveedor";
		ResultSet rs = null;
		String nombre="", fono="", direccion="", rut="";
		try {
			c.conectar();
			rs = c.consulta(consulta);
			while (rs.next()){
				rut = rs.getString(1);
				nombre = rs.getString(2);
				fono = rs.getString(3);
				direccion= rs.getString(4);
			}
			
			return rs;
		}
		catch (SQLException e) {
			return rs;
		}
		
	}
	
	
}
