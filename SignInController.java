package LoginFile;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.spi.InetAddressResolver;

public class SignInController {
    @FXML
    private Button SignInBt;

    @FXML
    private Button SignUpBt;

    @FXML
    private PasswordField signInPassword;

    @FXML
    private Label signInTxtLbl;

    @FXML
    private TextField signInUsername;


    private Stage stage;
    private Scene scene;
    private Parent root;
    private String username;
    private String userpwd;

    public void goToSignUp(ActionEvent actionEvent) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
       stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
       scene = new Scene(root);
       stage.setScene(scene);
    }

    public void makeSignIn(ActionEvent actionEvent) throws IOException {
        username = signInUsername.getText();
        userpwd = signInPassword.getText();
        BufferedReader reader = new BufferedReader(new FileReader("Login.txt"));
        String line;
        Boolean matched = false;

        while ((line=reader.readLine())!=null){
            if (line.equals(username+"\t"+userpwd)){
                matched = true;
                break;
            }
        }
        if (matched){
            signInTxtLbl.setText("hello "+username);
        }
        else {
            signInTxtLbl.setText("Wrong username or password");
        }
        reader.close();
    }
}
