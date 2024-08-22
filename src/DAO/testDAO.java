package DAO;

import gestion.Patient;
import gestion.Med;
import gestion.Utilsateur;
import java.util.ArrayList;
import java.util.Date;

public class testDAO {
    public static void main(String [] args){
        ArrayList<Patient> lesPatient = DaoPatient.lister();
        System.out.println("afficher : "+lesPatient.toString());
        ArrayList<Med> lesMeds = DaoMeds.lister();
        System.out.println("afficher : "+lesMeds.toString());
        ArrayList<Utilsateur> lesUsers = DaoUser.lister();
        System.out.println("afficher users: "+lesUsers.toString());
        
    }
}
