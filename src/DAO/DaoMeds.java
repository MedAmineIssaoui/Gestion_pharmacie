package DAO;

import gestion.Med;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoMeds {
    public static ArrayList<Med> lister(){
        Connection cn = Conn.seConnecter();
        ArrayList<Med> lesMeds = new ArrayList<>();
        String req = "select * from medicament";
        int id_Medicament;
        String denomination,composition,forme_Pharmaceutique,dosage,type;
        float prix;
        Med p;
        try{
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(req);
            while(rs.next()){
                id_Medicament = rs.getInt(1);
                denomination=rs.getString(2);
                composition=rs.getString(3);
                forme_Pharmaceutique=rs.getString(4);
                dosage=rs.getString(5);
                prix=rs.getFloat(6);
                type=rs.getString(7);
                p = new Med(id_Medicament,denomination,composition,forme_Pharmaceutique,dosage,prix,type);
                lesMeds.add(p);
            }
        }catch(SQLException ex){
              System.out.println(ex.getMessage());
        }
        return lesMeds;
    }
    
    public static int ajouter(Med p) {
        Connection cn = Conn.seConnecter();
        String req = "insert into médicament ( `denomination`, `composition`, `forme_Pharmaceutique`, `dosage`, `prix`, `type`)  values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, p.getDenomination());
            ps.setString(2, p.getComposition());
            ps.setString(3, p.getForme_Pharmaceutique());
            ps.setString(4, p.getDosage());
            ps.setFloat(5, p.getPrix());
            ps.setString(6, p.getType());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }
    
    public static int modifier(Med p) {
        Connection cn = Conn.seConnecter();
        String req = "update médicament set denomination =?, composition =?, forme_Pharmaceutique =?, 	dosage =?, prix =?, type =? where ID_médicament  =?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, p.getDenomination());
            ps.setString(2, p.getComposition());
            ps.setString(3,p.getForme_Pharmaceutique() );
            ps.setString(4, p.getDosage());
            ps.setFloat(5, p.getPrix());
            ps.setString(6, p.getType());
            ps.setInt(7,p.getId_Medicament());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }
    
    public static int supprimer(int Id_Medicament) {
        Connection cn = Conn.seConnecter();
        String req = "delete from médicament where id_Medicament   =?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, Id_Medicament);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }
}
