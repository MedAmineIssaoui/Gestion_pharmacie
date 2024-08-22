package DAO;

import gestion.Patient;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Date;

public class DaoPatient {
    public static ArrayList<Patient> lister(){
        Connection cn = Conn.seConnecter();
        ArrayList<Patient> lesPatient = new ArrayList<>();
        String req = "select * from patient";
        String nom,prenom,sexe,adresse; 
        Date dateDeNaissance;
        int telephone,id_Patient;
        Patient p;
        try{
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(req);
            while(rs.next()){
                id_Patient=rs.getInt(1);
                nom=rs.getString(2);
                prenom=rs.getString(3);
                dateDeNaissance=rs.getDate(4);
                sexe=rs.getString(5);
                adresse=rs.getString(6);
                telephone=rs.getInt(7);
                p = new Patient(id_Patient,nom,prenom,dateDeNaissance,sexe,adresse,telephone);
                lesPatient.add(p);
            }
        }catch(SQLException ex){
              System.out.println(ex.getMessage());
        }
        return lesPatient;
    }
    
    public static int ajouter(Patient p) {
        Connection cn = Conn.seConnecter();
        String req = "insert into patient (`nom`, `prenom`, `dateDeNaissance`, `sexe`, `adresse`, `telephone`)  values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setDate(3, new Date(p.getDateDeNaissance().getTime()));
            ps.setString(4, p.getSexe());
            ps.setString(5, p.getAdresse());
            ps.setInt(6, p.getTelephone());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }
    
    public static int modifier(Patient p) {
        Connection cn = Conn.seConnecter();
        String req = "update patient set nom =?, prenom =?, dateDeNaissance =?, sexe =?, adresse =?, telephone =? where id_Patient =?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getPrenom());
            ps.setDate(3, new java.sql.Date(p.getDateDeNaissance().getTime()));
            ps.setString(4, p.getSexe());
            ps.setString(5, p.getAdresse());
            ps.setInt(6, p.getTelephone());
            ps.setInt(7, p.getId_Patient());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }
    
    public static int supprimer(int id_Patient) {
        Connection cn = Conn.seConnecter();
        String req = "delete from patient where id_Patient =?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, id_Patient);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }
}
