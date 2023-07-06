package LoginFile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpController {
    private Stage stage;
    private Scene scene;
    private  Parent root;

    private  String userName;
    private  String Password;

    @FXML
    private Button SubBt;

    @FXML
    private Label signuptxtlbl;
    @FXML
    private TextField SignUpPassField;
    @FXML
    private TextField signUpTxtField;

    public void makeAnEntry(ActionEvent actionEvent) {
        Password = SignUpPassField.getText();
        userName = signUpTxtField.getText();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Login.txt",true));
            writer.write(userName+"\t"+Password+"\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        signuptxtlbl.setText("Hello " + userName);

    }
    @FXML
    void gotoLoginWindow(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }
}
