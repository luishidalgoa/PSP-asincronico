package dev.iesfranciscodelosrios.psp_async_navidad.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionData {
    //Es opcional porque podria interesarnos cerrar la conexion
    private static java.sql.Connection conn =null;
    private final static String uri="jdbc:mysql://localhost:3306/itv";
    private final static String user= "root";
    private final static String password="1234";

    public ConnectionData(){ }
    public static java.sql.Connection getConnection(){
        if(conn==null){
            try {
                conn = DriverManager.getConnection(uri,user,password);
            } catch (SQLException e) {
                e.printStackTrace();
                conn = null;
            }
        }
        return conn;
    }
}
