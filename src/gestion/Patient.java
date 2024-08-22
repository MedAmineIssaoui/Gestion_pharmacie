package gestion;

import java.util.Date;

public class Patient {
    private int id_Patient ;
    private String nom;
    private String prenom;
    private Date dateDeNaissance;
    private String sexe;
    private String adresse;
    private int telephone;

    public Patient(int id_Patient, String nom, String prenom, Date dateDeNaissance, String sexe, String adresse, int telephone) {
        this.id_Patient = id_Patient;
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    public Patient(String nom, String prenom, Date dateDeNaissance, String sexe, String adresse, int telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateDeNaissance = dateDeNaissance;
        this.sexe = sexe;
        this.adresse = adresse;
        this.telephone = telephone;
    }
    

    public int getId_Patient() {
        return id_Patient;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public String getSexe() {
        return sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }
    
    

    @Override
    public String toString() {
        return "Patient{" + "id_Patient=" + id_Patient + ", nom=" + nom + ", prenom=" + prenom + ", dateDeNaissance=" + dateDeNaissance + ", sexe=" + sexe + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }
}
