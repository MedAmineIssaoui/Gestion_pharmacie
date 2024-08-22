package pharmacie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import gestion.Utilsateur;
import gestion.Patient;
import DAO.DaoPatient;
import gestion.Med;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javafx.scene.control.ChoiceBox;

public class main {

    enum Sexe {

        M, F
    }
  
  

    @FXML
    private Button addMed;

    @FXML
    private Button addPatient;

    @FXML
    private Button addUser;

    @FXML
    private TextField adresseField;

    @FXML
    private TableColumn<Patient, String> adresseP;

    @FXML
    private Button clear;

    @FXML
    private Button clear1;

    @FXML
    private Button clearMed;

    @FXML
    private TableColumn<Med, String> compoMed;

    @FXML
    private TextField compsition;

    @FXML
    private TableColumn<Patient, String> dateP;

    @FXML
    private DatePicker datedenaissance;

    @FXML
    private Button deleteMed;

    @FXML
    private Button deletePatient;

    @FXML
    private Button deleteUser;

    @FXML
    private TableColumn<Med, String> denoMed;

    @FXML
    private TextField denomination;

    @FXML
    private TextField dosage;

    @FXML
    private TableColumn<Med, String> dosageMed;

    @FXML
    private TextField forme;

    @FXML
    private TableColumn<Med, String> formeMed;

    @FXML
    private TextField idUsers;

    @FXML
    private TextField idUsers1;

    @FXML
    private TextField loginField;

    @FXML
    private TableColumn<Utilsateur, String> nom;

    @FXML
    private TextField nomField;

    @FXML
    private TableColumn<Patient, String> nomP;

    @FXML
    private TextField nompField;

    @FXML
    private TextField passwordField;

    @FXML
    private AnchorPane patientPanel;

    @FXML
    private AnchorPane medPanel;

    @FXML
    private TableView<Patient> patientTable;

    @FXML
    private TextField phoneField;

    @FXML
    private TableColumn<Utilsateur, String> prenom;

    @FXML
    private TextField prenomField;

    @FXML
    private TableColumn<Patient, String> prenomP;

    @FXML
    private TextField prenompField;

    @FXML
    private TableColumn<Utilsateur, String> profil;

    @FXML
    private TextField profilField;

    @FXML
    private ChoiceBox<Sexe> sexeField;

    @FXML
    private TableColumn<Patient, String> sexeP;

    @FXML
    private Button showPatient;
    @FXML
    private TableColumn<Patient, String> telephoneP;



    @FXML
    private Button updatePatient;
    @FXML
    private AnchorPane userPanel;

    @FXML
    void showP(ActionEvent event) {
        patientPanel.setVisible(true);
        userPanel.setVisible(false);
        medPanel.setVisible(false);
    }

    @FXML
    void addP(ActionEvent event) {
        String nom = nompField.getText();
        String prenom = prenompField.getText();
        String sexe = sexeField.getValue().toString();
        String adresse = adresseField.getText();
        int telephone = Integer.parseInt(phoneField.getText());
        Date dateDeNaissance = java.sql.Date.valueOf(datedenaissance.getValue());

        Patient p = new Patient(nom, prenom, dateDeNaissance, sexe, adresse, telephone);

        DaoPatient.ajouter(p);
        this.clearFieldsP(event);
        ObservableList<Patient> patients = FXCollections.observableArrayList(DaoPatient.lister());
        patientTable.setItems(patients);

    }

    @FXML
    void clearFieldsP(ActionEvent event) {
        nompField.clear();
        prenompField.clear();
        sexeField.setValue(null);
        adresseField.clear();
        phoneField.clear();
        idUsers1.clear();
        datedenaissance.setValue(null);
    }

    @FXML
    void recherce(ActionEvent event) {
        idUsers.getText();
    }

    @FXML
    void updateP(ActionEvent event) {
        LocalDate localDate = datedenaissance.getValue();
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Patient p = new Patient(
                Integer.parseInt(idUsers1.getText()),
                nompField.getText(),
                prenomP.getText(),
                date,
                sexeField.getValue().toString(),
                adresseField.getText(),
                Integer.parseInt(phoneField.getText()));
        DaoPatient.modifier(p);
        this.clearFieldsP(event);
        ObservableList<Patient> patients = FXCollections.observableArrayList(DaoPatient.lister());
        patientTable.setItems(patients);
    }

    @FXML
    void deleteP(ActionEvent event) {
        DaoPatient.supprimer(Integer.parseInt(idUsers1.getText()));
        this.clearFieldsP(event);
        ObservableList<Patient> patients = FXCollections.observableArrayList(DaoPatient.lister());
        patientTable.setItems(patients);
    }

    @FXML
    void clearFields(ActionEvent event) {
        loginField.clear();
        nomField.clear();
        passwordField.clear();
        prenomField.clear();
        profilField.clear();
    }

    @FXML
    private void initialize() {

        ObservableList<Patient> patients = FXCollections.observableArrayList(DaoPatient.lister());
        patientTable.setItems(patients);
        nomP.setCellValueFactory(new PropertyValueFactory<>("nom"));
        prenomP.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        dateP.setCellValueFactory(new PropertyValueFactory<>("dateDeNaissance"));
        sexeP.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        adresseP.setCellValueFactory(new PropertyValueFactory<>("adresse"));
        telephoneP.setCellValueFactory(new PropertyValueFactory<>("telephone"));
        sexeField.setItems(FXCollections.observableArrayList(Sexe.M, Sexe.F));

    }

    private void handlePatientSelection(ObservableValue<? extends Patient> observable, Patient oldValue, Patient newValue) {
        if (newValue != null) {
            nompField.setText(newValue.getNom());
            prenompField.setText(newValue.getPrenom());
            int year = newValue.getDateDeNaissance().getYear();
            int month = newValue.getDateDeNaissance().getMonth() + 1;
            int day = newValue.getDateDeNaissance().getDate();
            if (year < 1900) {
                year += 1900;
            }
            datedenaissance.setValue(LocalDate.of(year, month, day));
            sexeField.setValue(Sexe.valueOf(newValue.getSexe()));
            adresseField.setText(newValue.getAdresse());
            phoneField.setText(String.valueOf(newValue.getTelephone()));
            idUsers1.setText(String.valueOf(newValue.getId_Patient()));
        }
    }

}
