package general;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Region {

	private int codigo;
	private String nombre;
	private int numero;
	
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
	
	public int getnumero(){
		return numero;
	}
	
	public void setnumero(int num){
		numero=num;
	}
	
		
	public void ingreso(){	
	}
	
	public String consulta(){
		String consultaregion="";
		return consultaregion;
	}
	
	public Object listar(){
		Object[] lista = new Object[4];
		return lista;
	}
	
	
}
