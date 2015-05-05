package general;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Articulo {
	
	   private int codigo;
	   
	   private String nombre;
	   
	   private String categoria;
	   
	   private int valor;
	    
	   private int proveedor;
	   
	   Conectadb cn = new Conectadb();
	   
	   public Articulo(){}
	   
	   
	   
		public int getCodigo(){
			return codigo;
		}
		public void setCodigo(int cod){
			codigo = cod;
		}
	   
		public String getCategoria(){
			return categoria;
		}
		public void setCategoria(String cat){
			categoria = cat;
		}
		
		public String getNombre(){
			return nombre;
		}
		public void setNombre(String nom){
			nombre = nom;
		}
		
		public int getValor(){
			return valor;
		}
		public void setValor(int val){
			valor = val;
		}
		
		public int getProveedor(){
			return proveedor;
		}
		public void setProveedor(int prov){
			proveedor = prov;
		}
		
	   public boolean ingresarArticulo(String nom, int val,int canti,int codca) {
		   
		   try{
		   
		   cn.conectar();
		   String consultaSql="insert into articulo (nombre, valor, cantidad, codCategoria) values('"+nom+"',"+val+","+canti+","+codca+")";
		   cn.insertar(consultaSql);
		   return true;
		   }
		   catch(Exception ex){
			return false;
		   }

	   }
	   
	   
	   public ResultSet listarArticulo(){
			String consulta ="select * from Articulo";
			ResultSet rs = null;
			String nombre = "";
			int codigo, codigoCategoria, valor, cantidad;

			try {
				cn.conectar();
				rs = cn.consulta(consulta);
				while (rs.next()){
					codigo = rs.getInt(1);
					nombre = rs.getString(2);
					valor = rs.getInt(3);
					cantidad = rs.getInt(4);
					codigoCategoria = rs.getInt(5);
				}
				return rs;
			} catch (SQLException e) {
				return rs;
			}
			
			}
	   
	   
	   public ResultSet consultarArticulo(int codigo){
			String consulta ="select nombre, cantidad from Articulo where codigo=" + codigo + ";" ;
			ResultSet rs = null;

			try {
				cn.conectar();
				rs =  cn.consulta(consulta);
				return rs;
				
			} catch (SQLException e) {
				return rs;
			}
			 
			
		}
}
