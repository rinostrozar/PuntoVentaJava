package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Region {

	private int codigo;
	private String nombre;
	private String numero;
	Conectadb cn = new Conectadb();
	
	public Region(){
	}
	
	public int getcodigo(){
		return codigo;	
	}
	
	public void setcodigo(int cod){
		codigo=cod;
	}
	
	public String getnombre(){
		return nombre;
	}
	
	public void setnombre(String nom){
		nombre=nom;
	}
	
	public String getnumero(){
		return numero;
	}
	
	public void setnumero(String num){
		numero=num;
	}
	
		
		public boolean insertarregion(int codigo,String nombre, int numero){
			String ingreso= "insert into Region values ("+codigo+",'"+ nombre + "', "+ numero +")"; 
			try{
				cn.conectar();
				cn.insertar(ingreso);	
				System.out.println(ingreso);
				return true;
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				return false;
				}			
		
		}
	
	
		public boolean ConsultarRegion(int codigo){
			String consulta="select nombre from region where codigo="+ codigo + "";
			try {
				cn.conectar();
				cn.consulta(consulta);
				return true;
				}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
				}	
		}
		
		
		 public boolean BorrarRegion(int codigo){
			 String eliminar="delete from Region where codigo="+ codigo +"";
			 try {
				cn.conectar();
				cn.borrar(eliminar);
				return true;
				}
			 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				return false;
				}	
		}
	
	
		 public boolean ListarRegion(){//por ahora, solo boolean, no resultset u otra cosa rara 
				String consulta ="select codigo, nombre, numero from Region";
				ResultSet rs = null;
				String nombre = "";
				int codigo;
				String numero;

				try {
					cn.conectar();
					rs = (ResultSet) cn.consulta(consulta);
					while (rs.next()){
						codigo = rs.getInt(1);
						nombre = rs.getString(2);
						numero = rs.getString(3);
						System.out.println(codigo);
						System.out.println(nombre);
						System.out.println(numero);
					}
					
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
				
				}
}
