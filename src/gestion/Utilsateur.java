package gestion;

public class Utilsateur {
    private int idUtilisateur;
    private String nom;
    private String prenom;
    private String login;
    private String motDePasse; 
    private String profil; 

    public Utilsateur(int idUtilisateur,String nom, String prenom, String login, String motDePasse, String profil) {
        this.idUtilisateur = idUtilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motDePasse = motDePasse;
        this.profil = profil;
    }

    public Utilsateur(String nom, String prenom, String login, String motDePasse, String profil) {
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motDePasse = motDePasse;
        this.profil = profil;
    }
    

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getProfil() {
        return profil;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public String afficherUtilisateur() {
        return "ID: " + idUtilisateur + ", Nom: " + nom + ", Prénom: " + prenom + ", Login: " + login + ", Profil: " + profil;
    }
}