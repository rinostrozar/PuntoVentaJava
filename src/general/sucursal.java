package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sucursal {
	
	private int codigociudad;
	private String nombre;
	private int direccion;
	private int codigosucursal;
	private int codigocomuna;
	Conectadb cn = new Conectadb();
	
	public sucursal(){	
	}

	
	public int getcodigociudad(){
		return codigociudad;
	}
	
	public void setcodigociudad(int codciud){
		codigociudad=codciud;
	}
	
	public String getnombre(){
		return nombre;
	}
	
	public void setnombre(String nom){
		nombre=nom;
	}
	
	public int getdireccion(){
		return direccion;
	}
	
	public void setdireccion(int dir){
		direccion=dir;
	}
	
	public int getcodigosucursal(){
		return codigosucursal;
	}
	
	public void setcodigosucursal(int codsuc){
		codigosucursal=codsuc;
	}
	

	public boolean insertarsucursal(String nombre, int codigociudad, String direccion){
		String ingresar ="insert into sucursal values ('"+ nombre + "', '" + direccion + "', "+codigociudad+")";
			try{
				cn.conectar();
				cn.insertar(ingresar);	
				System.out.println(ingresar);
				return true;
				} 
			catch (Exception e) {
				return false;
				}			
		}
	
	
	public boolean ConsultarSucursal(int codigosucursal){
		String consulta="select nombre from sucursal where codigo="+codigosucursal;
			try {
				cn.conectar();
				cn.consulta(consulta);
				return true;
				}
			catch (SQLException e) {
				e.printStackTrace();
				return false;
				}	
		
	}
	 public boolean BorrarSucursal(int codigosucursal){
		 	try {
		 		String eliminar="delete from sucursal where codigo="+ codigosucursal +"";
		 		cn.conectar();
				cn.borrar(eliminar);
				return true;
				}
			catch (SQLException e) {
				e.printStackTrace();
				return false;
				}	
		}
	 
	 
	 public boolean ListarSucursal(){//por ahora, solo boolean, no resultset u otra cosa rara 
			String consulta ="select codigociudad, nombre, direccion, codigosucursal, codigocomuna from sucursal";
			ResultSet rs = null;	
			int codigociudad;
			String nombre = "";
			String direccion="";
			int codigosucursal;
			int codigocomuna;

			try {
				cn.conectar();
				rs = (ResultSet) cn.consulta(consulta);
				while (rs.next()){
					codigociudad = rs.getInt(1);
					nombre = rs.getString(2);
					direccion = rs.getString(3);
					codigosucursal = rs.getInt(4);
					codigocomuna = rs.getInt(5);
					
					System.out.println(codigociudad);
					System.out.println(nombre);
					System.out.println(direccion);
					System.out.println(codigosucursal);
					System.out.println(codigocomuna);
				}
				
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		
}