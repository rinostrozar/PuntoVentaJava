package general;

public class Documento {
   
   //ATRIBUTOS
   private int neto;
   private int rutsucursal;
   //private Date fecha;
   private String direccionsucursal;
   private int iva; 
   private int codigo;  
   private String estado; 
   private int rutcliente; 
   private String nombrecliente; 
   private String detallearticulo; 
   private int total; 
   private int tipo;
   
   
   //MUTADORES Y ACCESADORES
   public int getNeto(){
	   return neto;
   }
   
   public void setNeto(int n){
	   neto=n;
   }
   
   public int getRutSucursal(){
	   return rutsucursal;
   }
   
   public void setRutSucursal(int rs){
	   rutsucursal=rs;
   }
   
   //public Date getFecha(){
   //   return fecha;
   //}
   
   //public void setFecha(Date f){
   //   fecha=f;
   //}
   
   public String getDireccionSucursal(){
	   return direccionsucursal;
   }
   
   public void setDireccionSucursal(String ds){
	   direccionsucursal=ds;
   }
   
   public int getIva(){
	   return iva;
   }
   
   public void setIva(int i){
	   iva=i;
   }
   
   public int getCodigo(){
	   return codigo;
   }
   
   public void setCodigo(int c){
	   codigo=c;
   }
   
   public String getEstado(){
	   return estado;
   }
   
   public void setEstado(String e){
	   estado=e;
   }
   
   public int getRutCliente(){
	   return rutcliente;
   }
   
   public void setRutCliente(int rc){
	   rutcliente=rc;
   }
   
   public String getNombreCliente(){
	   return nombrecliente;
   }
   
   public void setNombreCliente(String nc){
	   nombrecliente=nc;
   }
   
   public String getDetalleArticulo(){
	   return detallearticulo;
   }
   
   public void setDetalleArticulo(String da){
	   detallearticulo=da;
   }
   
   public int getTotal(){
	   return total;
   }
   
   public void setTotal(int t){
	   total=t;
   }
   
   public int getTipo(){
	   return tipo;
   }
   
   public void setTipo(int ti){
	   tipo=ti;
   }
   
   
   //CONSTRUCTOR
   public Documento(){
	   
   }
   
   
   //METODOS
   public void ingresar() {
      
   }
   
   
   public java.lang.Object listar() {
	  String msn="";
      return msn;
   }
   
  
   public String consultar() {
	  String msn="";
      return msn;
   }
   
 
   public void eliminar() {
      
   }
   
   
   public void ingresarboleta() {
      
   }
   
   
   public void ingresarfactura() {
    
   }

}