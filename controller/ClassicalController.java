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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import alert.AlertMaker;

public class ClassicalController implements Initializable {

    @FXML
    Label name1, name2, name3, price1, price2, price3;

    @FXML
    ImageView img1, img2, img3;

    @FXML
    Button button1, button2, button3, cartbutton, homebutton;

    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root = null;

    FXMLLoader loader;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // ============== BEDROOM LAMP ==================//

        name1.setText(LoginController.cguitar1.getProductName());
        price1.setText(Double.toString(LoginController.cguitar1.getProductPrice()));
        Image bedroomPlant = new Image(LoginController.cguitar1.getProductImage());
        img1.setImage(bedroomPlant);

        // ============== BEDROOM LAMP ==================//

        name2.setText(LoginController.cguitar2.getProductName());
        price2.setText(Double.toString(LoginController.cguitar2.getProductPrice()));
        Image bedroomPlant1 = new Image(LoginController.cguitar2.getProductImage());
        img2.setImage(bedroomPlant1);

        // ============== BEDROOM LAMP ==================//

        name3.setText(LoginController.cguitar3.getProductName());
        price3.setText(Double.toString(LoginController.cguitar3.getProductPrice()));
        Image bedroomPlant2 = new Image(LoginController.cguitar3.getProductImage());
        img3.setImage(bedroomPlant2);
    }

    public void buy(ActionEvent event) throws IOException {

        AlertMaker.showSimpleAlert("hello", "item added");

        Button sourceButton = (Button) event.getSource();

        // If addtocart button is pressed, set product status to true
        if (sourceButton.equals(button1)) {
            LoginController.cguitar1.setProductStatus(true);
            LoginController.cguitar1.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.checkoutController.pane4);
        }

        else if (sourceButton == button2) {
            LoginController.cguitar2.setProductStatus(true);
            LoginController.cguitar2.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.checkoutController.pane5);
        }

        else if (sourceButton == button3) {
            LoginController.cguitar3.setProductStatus(true);
            LoginController.cguitar3.setProductQuantity(1);
            LoginController.cart.addItem(LoginController.checkoutController.pane6);
        }

        LoginController.cart.showItems();
    }

    // Goes to Checkout.fxml
    public void gotocart(ActionEvent event) throws IOException {

        // Load items to cart before switching to checkout page
        LoginController.checkoutController.showItems(LoginController.cart.getItemList());

        // Set initial total amount in checkout page
        LoginController.checkoutController.getInitialAmount();

        final Scene scene = new Scene(LoginController.homeRoot);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public void gotohome(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}