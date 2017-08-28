package formulario;

import java.sql.*;
/**
 *
 * @author Dylan Josel Vaca Méndez
 * @version 1.0
 */

public class ConexionMySQL {
    /** Establece la conexion*/
    Connection con = null;
    
    /** Ejecuta las operaciones*/
    Statement sta = null;
    
    /** Argumentos de la conexion*/
    String driver, url, user, pass;
    
    /**
     *Constructor Asigna los argumentos de la conexión
     */
    public ConexionMySQL(){
    driver = "com.mysql.jdbc.Driver";
    url = "jdbc:mysql://localhost/formulario";
    user = "root";
    pass = "n0m3l0";
    }

    /**
     *
     * @throws Exception
     */
    public void Conexion() throws Exception{
        Class.forName(driver).newInstance();
        con = DriverManager.getConnection(url, user, pass);
    }
    
    /**
     *
     * @param nomb recibe el valor de Nombre desde el formulario
     * @param apep recibe el valor de Apellido Paterno desde el formulario
     * @param apem recibe el valor de Apellido Materno desde el formulario
     * @param escu recibe el valor de Escuela desde el formulario
     * @throws java.sql.SQLException
     */
    public void Agregar(String nomb, String apep, String apem, String escu) throws SQLException{
        sta = con.createStatement();
        sta.execute("insert into formulario values('"+nomb+"','"+apep+"','"+apem+"','"+escu+"',');");
    }
    
    /**
     *
     * @throws SQLException
     */
    public void Cerrar() throws SQLException{
        con.close();
    }
}