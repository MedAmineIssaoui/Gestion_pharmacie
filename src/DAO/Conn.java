package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conn {
     private static Connection con;
    private static String user = "root";
    private static String passWord = "";

    public static Connection seConnecter() {
        if (con == null) {
            try {
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pharmacie",user,passWord);
                System.out.println("connexion établie");
            } catch (SQLException ex) {
                System.out.println("bd non trouvée: " + ex.getMessage());
            }
        }
        return con;
    }

    public static void setUser(String user) {
        Conn.user = user;
    }

    public static void setPassWord(String passWord) {
        Conn.passWord = passWord;
    }
}
