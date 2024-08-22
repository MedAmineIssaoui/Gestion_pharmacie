/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import gestion.Ordennace;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
public class DaoOrd {
    public static Ordennace fetchById(int idOrdonnance) {
        Connection cn = Conn.seConnecter();
        Ordennace ordonnance = null;
        String req = "select * from ordonnance where id_ordonnance = ?";
        int idPatient;
        String meds;
        Date dateCreation;
        try {
            PreparedStatement ps = cn.prepareStatement(req);
            ps.setInt(1, idOrdonnance);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                idPatient = rs.getInt("id_patient");
                meds = rs.getString("meds");
                dateCreation = rs.getDate("date_creation");
                ordonnance = new Ordennace(idPatient, meds, dateCreation);
                ordonnance.setIdOrdonnance(idOrdonnance);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ordonnance;
    }

    public static int addOrdonnance(Ordennace ordonnance) {
        Connection cn = Conn.seConnecter();
        String req = "insert into ordonnance (id_patient, meds, date_creation) values (?, ?, ?)";
        try {
            PreparedStatement ps = cn.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ordonnance.getIdPatient());
            ps.setString(2, ordonnance.getMeds());
            ps.setDate(3, new java.sql.Date(ordonnance.getDateCreation().getTime()));
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idOrdonnance = rs.getInt(1);
                ordonnance.setIdOrdonnance(idOrdonnance);
                return idOrdonnance;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return -1;
    }

}
