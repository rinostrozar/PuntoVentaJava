package principal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Coneccion {
 public static void main(String[] args) {
	// TODO Auto-generated method stub
	try
    {
        // Se registra el Driver de MySQL
        DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
        
        // Se obtiene una conexión con la base de datos. Hay que
        // cambiar el usuario "root" y la clave "la_clave" por las
        // adecuadas a la base de datos que estemos usando.
        Connection conexion = DriverManager.getConnection (
            "jdbc:mysql://localhost/parajava","root", "");
        
        // Se crea un Statement, para realizar la consulta
        Statement s = conexion.createStatement();
        
        // Se realiza la consulta. Los resultados se guardan en el 
        // ResultSet rs
        ResultSet rs = s.executeQuery ("select * from ejemplo ");
        
        // Se recorre el ResultSet, mostrando por pantalla los resultados.
        while (rs.next())
        {
        		//JOptionPane.showMessageDialog(null,rs.getInt ("id") + " " + rs.getString ("nombre"));
           System.out.println (rs.getInt ("id") + " " + rs.getString ("nombre"));
        }
        
        // Se cierra la conexión con la base de datos.
        conexion.close();
    }
    catch (Exception e1)
    {
        e1.printStackTrace();
    }
}
}
