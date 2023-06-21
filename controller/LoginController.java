package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Cart;
import model.Cguitar1;
import model.Cguitar2;
import model.Cguitar3;
import model.Eguitar1;
import model.Eguitar2;
import model.Eguitar3;

public class LoginController implements Initializable {

    @FXML
    TextField mytextfield;

    @FXML
    PasswordField mypasswordfield;

    @FXML
    Button mybutton;

    @FXML
    Label mywarninglabel;

    @FXML
    HomeController homeController = null;

    @FXML
    static CheckoutController checkoutController = null;

    @FXML
    static Parent homeRoot = null;

    FXMLLoader loader;

    static Eguitar1 eguitar1 = new Eguitar1();
    static Eguitar2 eguitar2 = new Eguitar2();
    static Eguitar3 eguitar3 = new Eguitar3();
    static Cguitar1 cguitar1 = new Cguitar1();
    static Cguitar2 cguitar2 = new Cguitar2();
    static Cguitar3 cguitar3 = new Cguitar3();
    static Cart cart = new Cart();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== 1 ==================//
        eguitar1.setProductName(" Surf Green");
        eguitar1.setProductPrice(12000);
        eguitar1.setProductImage("images/eguitar1.png");
        // ============== 2 ==================//

        eguitar2.setProductName("Unique Series");
        eguitar2.setProductPrice(17000);
        eguitar2.setProductImage("images/eguitar2.png");

        // ============== 3 ==================//
        eguitar3.setProductName("Electric BLK");
        eguitar3.setProductPrice(14000.00);
        eguitar3.setProductImage("images/eguitar3.png");

        // ============== 4 ==================/
        cguitar1.setProductName("HGHMNDS BLK");
        cguitar1.setProductPrice(11000.00);
        cguitar1.setProductImage("images/aguitar1.png");

        // ============== 5 ==================/
        cguitar2.setProductName("Junior Acoustic");
        cguitar2.setProductPrice(12000.00);
        cguitar2.setProductImage("images/aguitar2.png");

        // ============== 6 ==================/
        cguitar3.setProductName("DJANGO Spruce");
        cguitar3.setProductPrice(10000.00);
        cguitar3.setProductImage("images/aguitar3.png");


        try {
            loader = new FXMLLoader(getClass().getResource("/view/Checkout.fxml"));
            homeRoot = loader.load();

        } catch (Exception e) {
            e.printStackTrace();

        }

        // Clears all items in Checkout.fxml
        checkoutController = loader.getController();
        checkoutController.myvbox.getChildren().removeAll(checkoutController.myvbox.getChildren());
    }

    public void login(ActionEvent event) throws IOException {

        String username = mytextfield.getText();
        String password = mypasswordfield.getText();

        if (username.equals("ulala") && password.equals("ulala")) {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Home.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            mywarninglabel.setVisible(true);
        }
    }

}