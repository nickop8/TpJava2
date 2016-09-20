package data;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import utils.*;



public class MySqlConexion 
{
	
	private String driver="com.mysql.jdbc.Driver";
	private String host="localhost";
	private String port="3306";
	private String user="java2016";
	private String pass="java";
	private String db="java2016";
	private String dbType="mysql";
	
	private Connection conn;
	private int cantConn=0;
	
	private MySqlConexion() throws ApplicationException
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new ApplicationException("Error del Driver JDBC",e);
		}
	}
	
	private static MySqlConexion instancia;
	
	public static MySqlConexion getInstancia() throws ApplicationException
	{
		if (instancia==null){
			instancia = new MySqlConexion();
		}
		return instancia;
	}
	
	public Connection getConn(){
		try {
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection(
						"jdbc:"+dbType+"://"+host+":"+port+"/"+
						db+"?user="+user+"&password="+pass);
				cantConn++;
			}
		} catch (SQLException e) {
			new ApplicationException("Error al conectar a la DB",e);

		}
		return conn;
	}
	
	public void releaseConn() throws ApplicationException{
		try {
			cantConn--;
			if(cantConn==0){
				conn.close();
			}
		} catch (SQLException e) {
			throw new ApplicationException("Error al cerrar conexión",e);
		}
		
	}
}
    
		
	/* public void consultarDatos() throws SQLException
    {
        String instruccion = "SELECT * FROM tp_java.personajes";
        try {
            comando = conn.createStatement();           
            resultados = comando.executeQuery(instruccion);
        } catch (SQLException e) {            
            e.printStackTrace();            
            throw e;
        }        
    }
	
	 public void imprimirDatos() throws SQLException
	    {
	        int cod;
	        int vida;
	        String nombre;
	        
	        while(resultados.next())
	        {
	            try {            
	                cod = resultados.getInt("cod_personaje");
	                vida = resultados.getInt("vida");
	                nombre = resultados.getString("nombre");
	            } catch (SQLException e) {
	                e.printStackTrace();
	                throw e;
	            }
	            System.out.print(nombre + "\t\t\t");           
	            System.out.print(vida+ "\t\t\t");
	            System.out.print(nombre + "\n");     
	        }    
	    }
}*/

