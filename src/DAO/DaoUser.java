package DAO;

import gestion.Utilsateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoUser {

    public static ArrayList<Utilsateur> lister() {
        Connection cn = Conn.seConnecter();
        ArrayList<Utilsateur> lesUtilisateurs = new ArrayList<>();
        String req = "select * from utilisateur";
        String nom, prenom, login, motDePasse, profil;
        int idUtilisateur;
        Utilsateur u;
        try {
            Statement s = cn.createStatement();
            ResultSet rs = s.executeQuery(req);
            while (rs.next()) {
                idUtilisateur = rs.getInt(1);
                nom = rs.getString(2);
                prenom = rs.getString(3);
                login = rs.getString(4);
                motDePasse = rs.getString(5);
                profil = rs.getString(6);
                u = new Utilsateur(idUtilisateur, nom, prenom, login, motDePasse, profil);
                lesUtilisateurs.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lesUtilisateurs;
    }

    public static int ajouter(Utilsateur u) {
        Connection cn = Conn.seConnecter();
        String req = "insert into utilisateur (`nom`, `prenom`, `login`, `motDePasse`, `profil`) values (?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getLogin());
            ps.setString(4, u.getMotDePasse());
            ps.setString(5, u.getProfil());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }

    public static int modifier(Utilsateur u) {
        Connection cn = Conn.seConnecter();
        String req = "update utilisateur set nom =?, prenom =?, login =?, `motDePasse` =?, profil =? where idUtilisateur =?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, u.getNom());
            ps.setString(2, u.getPrenom());
            ps.setString(3, u.getLogin());
            ps.setString(4, u.getMotDePasse());
            ps.setString(5, u.getProfil());
            ps.setInt(6, u.getIdUtilisateur());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }

    public static int supprimer(int idUtilisateur) {
        Connection cn = Conn.seConnecter();
        String req = "delete from utilisateur where idUtilisateur =?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, idUtilisateur);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }

    public static Utilsateur seConnecter(String login, String motDePasse) {
        Connection cn = Conn.seConnecter();
        Utilsateur u = null;
        String req = "select * from utilisateur where login =? and motDePasse =?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, login);
            ps.setString(2, motDePasse);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new Utilsateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return u;
    }

    public static int changerMotDePasse(String idUtilisateur, String nouveauMotDePasse) {
        Connection cn = Conn.seConnecter();
        String req = "update utilisateur set motDePasse =? where idUtilisateur =?";
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, nouveauMotDePasse);
            ps.setString(2, idUtilisateur);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return 1;
    }

    public static ArrayList<Utilsateur> listerParProfil(String profil) {
        Connection cn = Conn.seConnecter();
        ArrayList<Utilsateur> lesUtilisateurs = new ArrayList<>();
        String req = "select * from utilisateur where profil =?";
        String  nom, prenom, login, motDePasse, profil_utilisateur;
        int idUtilisateur;
        Utilsateur u;
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setString(1, profil);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idUtilisateur = rs.getInt(1);
                nom = rs.getString(2);
                prenom = rs.getString(3);
                login = rs.getString(4);
                motDePasse = rs.getString(5);
                profil_utilisateur = rs.getString(7);
                u = new Utilsateur(idUtilisateur, nom, prenom, login, motDePasse, profil_utilisateur);
                lesUtilisateurs.add(u);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lesUtilisateurs;
    }
}

