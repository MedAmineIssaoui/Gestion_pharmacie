package gestion;

import java.util.Date;

public class Ordennace {
    private int idOrdonnance;
    private int idPatient;
    private String meds;
    private Date dateCreation;


    public Ordennace(int idPatient, String meds, Date dateCreation) {
        this.idPatient = idPatient;
        this.meds = meds;
        this.dateCreation = dateCreation;
    }

    public int getIdOrdonnance() {
        return idOrdonnance;
    }

    public void setIdOrdonnance(int idOrdonnance) {
        this.idOrdonnance = idOrdonnance;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public String getMeds() {
        return meds;
}

    public void setMeds(String meds) {
        this.meds = meds;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
}
