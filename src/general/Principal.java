package general;

import java.sql.ResultSet;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Conectadb db = new Conectadb();
			db.conectar();
			 ResultSet rs =db.consulta("select * from ejemplo ");
			 while (rs.next())
			 {
				 System.out.println (rs.getInt ("id") + " " + rs.getString ("nombre"));
			 }
		}
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
	}

}
