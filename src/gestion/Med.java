package gestion;

public class Med {
    
    private int id_Medicament;	
    private String denomination;	
    private String composition;
    private String forme_Pharmaceutique;	
    private String dosage;	
    private float prix;
    private String type;

    public Med(int id_Medicament, String denomination, String composition, String forme_Pharmaceutique, String dosage, float prix, String type) {
        this.id_Medicament = id_Medicament;
        this.denomination = denomination;
        this.composition = composition;
        this.forme_Pharmaceutique = forme_Pharmaceutique;
        this.dosage = dosage;
        this.prix = prix;
        this.type = type;
    }

    public Med(String denomination, String composition, String forme_Pharmaceutique, String dosage, float prix, String type) {
        this.denomination = denomination;
        this.composition = composition;
        this.forme_Pharmaceutique = forme_Pharmaceutique;
        this.dosage = dosage;
        this.prix = prix;
        this.type = type;
    }
    

    public int getId_Medicament() {
        return id_Medicament;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getForme_Pharmaceutique() {
        return forme_Pharmaceutique;
    }

    public void setForme_Pharmaceutique(String forme_Pharmaceutique) {
        this.forme_Pharmaceutique = forme_Pharmaceutique;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Med{" + "id_Medicament=" + id_Medicament + ", denomination=" + denomination + ", composition=" + composition + ", forme_Pharmaceutique=" + forme_Pharmaceutique + ", dosage=" + dosage + ", prix=" + prix + ", type=" + type + '}';
    }
    
    
}
