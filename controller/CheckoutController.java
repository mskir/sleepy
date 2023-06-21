package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckoutController implements Initializable {

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6;

    @FXML
    VBox myvbox;

    @FXML
    Button homebutton;

    @FXML
    Label name1, name2, name3, name4, name5, name6, price1, price2, price3, price4, price5, price6, total;

    @FXML
    ImageView img1, img2, img3, img4, img5, img6;

    @FXML
    private ChoiceBox<String> choicebox1, choicebox2, choicebox3, choicebox4, choicebox5, choicebox6;

    private String[] quantity = { "1", "2", "3" };

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        name1.setText(LoginController.eguitar1.getProductName());
        price1.setText(Double.toString(LoginController.eguitar1.getProductPrice()));
        Image bedroomLamp = new Image(LoginController.eguitar1.getProductImage());
        img1.setImage(bedroomLamp);

        name2.setText(LoginController.eguitar2.getProductName());
        price2.setText(Double.toString(LoginController.eguitar2.getProductPrice()));
        Image ceilinglamp = new Image(LoginController.eguitar2.getProductImage());
        img2.setImage(ceilinglamp);

        name3.setText(LoginController.eguitar3.getProductName());
        price3.setText(Double.toString(LoginController.eguitar3.getProductPrice()));
        Image walllamp = new Image(LoginController.eguitar3.getProductImage());
        img3.setImage(walllamp);

        name4.setText(LoginController.cguitar1.getProductName());
        price4.setText(Double.toString(LoginController.cguitar1.getProductPrice()));
        Image bedroomPlant = new Image(LoginController.cguitar1.getProductImage());
        img4.setImage(bedroomPlant);

        name5.setText(LoginController.cguitar2.getProductName());
        price5.setText(Double.toString(LoginController.cguitar2.getProductPrice()));
        Image bedroomPlant1 = new Image(LoginController.cguitar2.getProductImage());
        img5.setImage(bedroomPlant1);

        name6.setText(LoginController.cguitar3.getProductName());
        price6.setText(Double.toString(LoginController.cguitar3.getProductPrice()));
        Image bedroomPlant2 = new Image(LoginController.cguitar3.getProductImage());
        img6.setImage(bedroomPlant2);

        // Set default quantities in choicebox to 1
        choicebox1.setValue("1");
        choicebox2.setValue("1");
        choicebox3.setValue("1");
        choicebox4.setValue("1");
        choicebox5.setValue("1");
        choicebox6.setValue("1");

        // Insert quantity array to choicebox
        choicebox1.getItems().addAll(quantity);
        choicebox2.getItems().addAll(quantity);
        choicebox3.getItems().addAll(quantity);
        choicebox4.getItems().addAll(quantity);
        choicebox5.getItems().addAll(quantity);
        choicebox6.getItems().addAll(quantity);

        // Add event handler on all choiceboxes
        choicebox1.setOnAction(this::computeTotal);
        choicebox2.setOnAction(this::computeTotal);
        choicebox3.setOnAction(this::computeTotal);
        choicebox4.setOnAction(this::computeTotal);
        choicebox5.setOnAction(this::computeTotal);
        choicebox6.setOnAction(this::computeTotal);
    }

    public void computeTotal(ActionEvent event) {

        double totalAmount = 0;
        double item1Amount = 0;
        double item2Amount = 0;
        double item3Amount = 0;
        double item4Amount = 0;
        double item5Amount = 0;
        double item6Amount = 0;

        ChoiceBox source = (ChoiceBox) event.getSource();

        // If product is chosen, compute item amount
        if (LoginController.eguitar1.getProductStatus()) {

            double qty = Double.parseDouble(choicebox1.getValue());
            LoginController.eguitar1.setProductQuantity(qty);
            item1Amount = LoginController.eguitar1.getProductPrice() * qty;

            if (source == choicebox1) {
                item1Amount = LoginController.eguitar1.getProductPrice() * qty;
            }
        }

        if (LoginController.eguitar2.getProductStatus()) {

            double qty = Double.parseDouble(choicebox2.getValue());
            LoginController.eguitar2.setProductQuantity(qty);
            item2Amount = LoginController.eguitar2.getProductPrice() * qty;

            if (source == choicebox2) {
                item2Amount = LoginController.eguitar2.getProductPrice() * qty;
            }
        }

        if (LoginController.eguitar3.getProductStatus()) {

            double qty = Double.parseDouble(choicebox3.getValue());
            LoginController.eguitar3.setProductQuantity(qty);
            item3Amount = LoginController.eguitar3.getProductPrice() * qty;

            if (source == choicebox3) {
                item3Amount = LoginController.eguitar3.getProductPrice() * qty;
            }
        }

        if (LoginController.cguitar1.getProductStatus()) {

            double qty = Double.parseDouble(choicebox4.getValue());
            LoginController.cguitar1.setProductQuantity(qty);
            item4Amount = LoginController.cguitar1.getProductPrice() * qty;

            if (source == choicebox4) {
                item4Amount = LoginController.cguitar1.getProductPrice() * qty;
            }
        }

        if (LoginController.cguitar2.getProductStatus()) {

            double qty = Double.parseDouble(choicebox5.getValue());
            LoginController.cguitar2.setProductQuantity(qty);
            item5Amount = LoginController.cguitar2.getProductPrice() * qty;

            if (source == choicebox5) {
                item5Amount = LoginController.cguitar2.getProductPrice() * qty;
            }
        }

        if (LoginController.cguitar3.getProductStatus()) {

            double qty = Double.parseDouble(choicebox6.getValue());
            LoginController.cguitar3.setProductQuantity(qty);
            item6Amount = LoginController.cguitar3.getProductPrice() * qty;

            if (source == choicebox6) {
                item6Amount = LoginController.cguitar3.getProductPrice() * qty;
            }
        }


        // Compute total amount for all items chosen
        totalAmount = item1Amount + item2Amount + item3Amount + item4Amount + item5Amount + item6Amount;

        // Display total amount in total label
        total.setText(Double.toString(totalAmount));
    }

    // Computes initial Amount before modifying item quantity
    public void getInitialAmount() {

        double totalAmount = 0.00;

        if (LoginController.eguitar1.getProductStatus()) {
            totalAmount += LoginController.eguitar1.getProductPrice();
        }

        if (LoginController.eguitar2.getProductStatus()) {
            totalAmount += LoginController.eguitar2.getProductPrice();
        }

        if (LoginController.eguitar3.getProductStatus()) {
            totalAmount += LoginController.eguitar3.getProductPrice();
        }

        if (LoginController.cguitar1.getProductStatus()) {
            totalAmount += LoginController.cguitar1.getProductPrice();
        }

        if (LoginController.cguitar2.getProductStatus()) {
            totalAmount += LoginController.cguitar2.getProductPrice();
        }

        if (LoginController.cguitar3.getProductStatus()) {
            totalAmount += LoginController.cguitar3.getProductPrice();
        }

        total.setText(Double.toString(totalAmount));
    }

    public void gotohome(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/view/Home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    // Go to Receipt Page
    public void checkout(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Receipt.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    // Show all items in ArrayList
    public void showItems(ArrayList<Pane> itemList) {
        myvbox.getChildren().clear();
        for (Pane p : itemList) {
            myvbox.getChildren().add(p);
        }
    }

}

