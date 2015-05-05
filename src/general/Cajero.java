import java.sql.ResultSet;
import java.sql.SQLException;


public class Cajero {
	
	private String rut, nombre;
	private int codSucursal;
	Conectadb c=new Conectadb();
	
	public void setRut(String s_rut){
		rut=s_rut;
	}
	public String getRutd(){
		return rut;
	}
	
	public void setcodSucursal(int s_codCiudad){
		codSucursal=s_codCiudad;
	}
	public int getcodSucursal(){
		return codSucursal;
	}
	
	public void setNombre(String s_name){
		nombre=s_name;
	}
	public String getNombre(){
		return nombre;
	}
	
	public boolean Ingreso_Cajero(String rut, String nom, int codSu){
		try {
			c.conectar();
			String Insert_caj= "insert into cajero (rut, nombre, codSucursal) values ('" + rut + "','" + nom + "',"+ codSu+");";
			c.insertar(Insert_caj);
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}
	
	public ResultSet Consulta_Cajero(String rut){
		String consulta= "select * from cajero where rut="+ rut+ "";
		ResultSet rs=null;
		try {
			c.conectar();			
			rs=c.consulta(consulta);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return rs;
		}
		
	}
	
	public ResultSet ListarCajero(){
		String consulta ="select * from Cajero";
		ResultSet rs = null;
		String rut="", nombre="";
		int codSucursal;
		try {
			c.conectar();
			rs =c.consulta(consulta);
			while (rs.next()){
				rut = rs.getString(1);
				nombre = rs.getString(2);
				codSucursal = rs.getInt(3);
			}
			return rs;
		}
		catch (SQLException e) {
			e.printStackTrace();
			return rs;
		}
		
	}
	
	
}
