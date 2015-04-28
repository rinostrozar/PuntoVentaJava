package general;

public class sucursal {

	private int codigociudad;
	private String nombre;
	private int direccion;
	private int codigosucursal;
	
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
	

	public String consultarsucursal(){
		String consulta="";
		return consulta;
	}
	
	public void ingresar(){
		
	}
	
	public Object listar(){
		Object[] lista = new Object[4];
		return lista;
	}
	
	public void eliminar(){
	
	}
}