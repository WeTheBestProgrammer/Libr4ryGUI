package login;
import java.sql.*;
/**
 *
 * @author Angga Maulana A
 */
public class koneksi1 {
    public Connection cc;
    public Statement ss;
    public ResultSet rr;
   
public void Class(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        cc = DriverManager.getConnection("jdbc:mysql://localhost/Login","root","");
        System.out.println("koneksi sukses");
    }
    catch (Exception e){
        System.out.println(e);
    }
}
}
