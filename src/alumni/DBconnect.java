/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package alumni;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBconnect {
static Connection con=null;
static final String DB_URL="jdbc:mysql://localhost/alumni1";
static final String USER="root";
static final String PASS="";
public static Connection connect()
{
  try
   {
      Class.forName("com.mysql.jdbc.Driver");
      con=DriverManager.getConnection(DB_URL,USER,PASS);
   }
   catch(ClassNotFoundException | SQLException e){}
   return con;
}
}
