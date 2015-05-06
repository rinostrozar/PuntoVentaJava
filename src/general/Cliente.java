package general;

import java.sql.ResultSet;
import java.sql.SQLException;


public class Cliente {

	private int codigoCiudad;
	private String rut, nombre, apellidoMaterno, apellidoPaterno, direccion, fono, giro;
	Conectadb c=new Conectadb();
	
	public Cliente(){
	}
	
	public void setRut(String s_rut){
		rut=s_rut;
	}
	public String getRutd(){
		return rut;
	}
	
	public void setcodigoCiudadint(int s_codCiudad){
		codigoCiudad=s_codCiudad;
	}
	public int getcodigoCiudad(){
		return codigoCiudad;
	}
	
	public void setNombre(String s_name){
		nombre=s_name;
	}
	public String getNombre(){
		return nombre;
	}

	public void setapellidoMaterno(String s_apMaterno){
		apellidoMaterno=s_apMaterno;
	}
	public String getapellidoMaterno(){
		return apellidoMaterno;
	}

	public void setapellidoPaterno(String s_apPaterno){
		apellidoPaterno=s_apPaterno;
	}
	public String getapellidoPaterno(){
		return apellidoPaterno;
	}
	
	/*public void setFono(String s_fono){
		fono=s_fono;
	}
	public String getFono(){
		return fono;
	}*/

	public void setDireccion(String s_direccion){
		direccion=s_direccion;
	}
	public String getDireccion(){
		return direccion;
	}

	public void setGiro(String s_giro){
		giro=s_giro;
	}
	public String getGiro(){
		return giro;
	}

	public boolean Ingreso_Cliente(String rut, String nom, String apPaterno, String apMaterno, String direc, String gir, int codCi){
		try {
			c.conectar();
			String Insert_cli= "insert into cliente (rut, nombre,apellidoPaterno, apellidoMaterno,giro, direccion, codCiudad) values ('" + rut + "','" + nom + "','"+ apPaterno + "','"+ apMaterno+"','"+ gir +"','"+ direc+"',"+ codCi+");";
			c.insertar(Insert_cli);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ResultSet Consulta_cliente(String rut){
		ResultSet rs=null;
		String consulta= "select nombre from Cliente where rut="+ rut+ "";
		try {
			c.conectar();			
			rs=c.consulta(consulta);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return rs;
		}
		
	}
	
	public ResultSet ListarCliente(){
		String consulta ="select rut, nombre, apellidoPaterno, apellidoMaterno, direccion, fono, giro, codigoCiudad from Cliente";
		ResultSet rs = null;
		String nombre = "", rut="",apellidoPaterno="",apellidoMaterno="", giro="", direccion="" ;
		int codigoCiudad;
		try {
			c.conectar();
			rs =c.consulta(consulta);
			while (rs.next()){
				rut = rs.getString(1);
				nombre = rs.getString(2);
				apellidoPaterno = rs.getString(3);
				apellidoMaterno = rs.getString(4);
				giro = rs.getString(5);
				direccion = rs.getString(6);
				codigoCiudad = rs.getInt(7);
			}			
			return rs;
		}
		catch (SQLException e) {
			return rs;
		}
		
	}
	
	
}
