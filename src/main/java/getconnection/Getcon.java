package getconnection;

import android.os.StrictMode;
import android.util.Log;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;


public class Getcon {
    public static Connection getconnection(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rts","root","");

        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
}
