package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import alert.AlertMaker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ElectricController implements Initializable {

    @FXML
    Label name1, name2, name3, price1, price2, price3;

    @FXML
    ImageView img1, img2, img3;

    @FXML
    Button button1, button2, button3, cartbutton, homeButton;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    static Parent homeRoot = null;

    FXMLLoader loader;

    @FXML
    static CheckoutController checkoutController = null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== BEDROOM LAMP ==================//
        name1.setText(LoginController.eguitar1.getProductName());
        price1.setText(Double.toString(LoginController.eguitar1.getProductPrice()));
        Image bedroomLamp = new Image(LoginController.eguitar1.getProductImage());
        img1.setImage(bedroomLamp);

        // ============== CEILING LAMP ==================//

        name2.setText(LoginController.eguitar2.getProductName());
        price2.setText(Double.toString(LoginController.eguitar2.getProductPrice()));

        Image ceilingLamp = new Image(LoginController.eguitar2.getProductImage());
        img2.setImage(ceilingLamp);

        // ============== WALL LAMP ==================//

        name3.setText(LoginController.eguitar3.getProductName());
        price3.setText(Double.toString(LoginController.eguitar3.getProductPrice()));
        Image wallLamp = new Image(LoginController.eguitar3.getProductImage());
        img3.setImage(wallLamp);

    }

    public void buy(ActionEvent event) throws IOException {

        AlertMaker.showSimpleAlert("Seju", "The item is added");

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton.equals(button1)) {
            LoginController.eguitar1.setProductStatus(true);
            LoginController.eguitar1.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.checkoutController.pane1);
        }

        else if (sourceButton == button2) {
            LoginController.eguitar2.setProductStatus(true);
            LoginController.eguitar2.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.checkoutController.pane2);
        }

        else if (sourceButton == button3) {
            LoginController.eguitar3.setProductStatus(true);
            LoginController.eguitar3.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.checkoutController.pane3);
        }

        LoginController.cart.showItems();
    }

    // Goes to Checkout.fxml
    public void gotocart(ActionEvent event) throws IOException {

        // Load items to cart before switching to checkout page
        LoginController.checkoutController.showItems(LoginController.cart.getItemList());

        // Set initial total amount in checkout page
        LoginController.checkoutController.getInitialAmount();

        Scene scene = new Scene(LoginController.homeRoot);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Goes to Checkout.fxml
    public void gotohome(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}