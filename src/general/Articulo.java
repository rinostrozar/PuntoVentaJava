package general;

import java.sql.SQLException;
import java.sql.Statement;

public class Articulo {
	
	   private int codigo;
	   
	   private String nombre;
	   
	   private String categoria;
	   
	   private int valor;
	    
	   private int proveedor;
	   
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
		
	   public boolean ingresar(int cod,String nom, int val,int canti,int codca) {
		   
		   try{
		   Conectadb cn = new Conectadb();
		   cn.conectar();
		   String consultaSql="insert into articulo values("+cod+",'"+nom+"',"+val+","+canti+","+codca+")";
		   cn.insertar(consultaSql);
		   return true;
		   }
		   catch(Exception ex){
			return false;
		   }
		 
		 
	   }
	   
	   
	   public java.lang.Object listar() {
	      
	      return null;
	   }
	   
	   
	   public boolean consultarArticulo(int cod) {
	      
		   try{
			   Conectadb cn = new Conectadb();
			   cn.conectar();
			   String consultaSql="Select nombre from articulo where codigo ="+cod ;
			   cn.consulta(consultaSql);
			   return true;
		   }
		   catch(Exception es){
			   return false;
		   }
	     
	   }
	}
