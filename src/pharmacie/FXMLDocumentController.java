package pharmacie;

import DAO.DaoUser;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import gestion.Utilsateur;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Button loginBtn;

    @FXML
    private TextField password;

    @FXML
    private TextField username;

    @FXML
void authificated(ActionEvent event) {
    String login = username.getText();
    String motDePasse = password.getText();
    Utilsateur u = DaoUser.seConnecter(login, motDePasse);
    if (u != null) {
        // Load the new FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage stage = (Stage) loginBtn.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    } else {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Authentification échouée");
        alert.setHeaderText("La connexion a échoué");
        alert.setContentText("Le nom d'utilisateur ou le mot de passe que vous avez tapé est incorrect.");
        alert.showAndWait();
    }
}
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
