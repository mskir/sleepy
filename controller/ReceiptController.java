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
import javafx.stage.Stage;

public class ReceiptController implements Initializable {

    @FXML
    double item1Amount, item2Amount, item3Amount, item4Amount, item5Amount, item6Amount;

    @FXML
    Label qty1, qty2, qty3, qty4, qty5, qty6, product1, product2, product3, product4, product5, product6,
          amount1, amount2, amount3, amount4, amount5, amount6, total;

    @FXML
    Button homebutton;

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

        if (LoginController.eguitar1.getProductStatus()) {
            product1.setText(LoginController.eguitar1.getProductName());
            qty1.setText(Double.toString(LoginController.eguitar1.getProductQuantity()));
            amount1.setText(Double
                    .toString(LoginController.eguitar1.getProductPrice() * LoginController.eguitar1.getProductQuantity()));

            product1.setVisible(true);
            qty1.setVisible(true);
            amount1.setVisible(true);

            item1Amount = LoginController.eguitar1.getProductPrice() * LoginController.eguitar1.getProductQuantity();

        }

        if (LoginController.eguitar3.getProductStatus()) {
            product2.setText(LoginController.eguitar3.getProductName());
            qty2.setText(Double.toString(LoginController.eguitar3.getProductQuantity()));
            amount2.setText(Double
                    .toString(LoginController.eguitar3.getProductPrice() * LoginController.eguitar3.getProductQuantity()));

            product2.setVisible(true);
            qty2.setVisible(true);
            amount2.setVisible(true);

            item2Amount = LoginController.eguitar3.getProductPrice() * LoginController.eguitar3.getProductQuantity();
        }

        if (LoginController.eguitar2.getProductStatus()) {
            product3.setText(LoginController.eguitar2.getProductName());
            qty3.setText(Double.toString(LoginController.eguitar2.getProductQuantity()));
            amount3.setText(Double
                    .toString(LoginController.eguitar2.getProductPrice() * LoginController.eguitar2.getProductQuantity()));

            product3.setVisible(true);
            qty3.setVisible(true);
            amount3.setVisible(true);

            item3Amount = LoginController.eguitar2.getProductPrice() * LoginController.eguitar2.getProductQuantity();

        }

        if (LoginController.cguitar1.getProductStatus()) {
            product4.setText(LoginController.cguitar1.getProductName());
            qty4.setText(Double.toString(LoginController.cguitar1.getProductQuantity()));
            amount4.setText(Double
                    .toString(LoginController.cguitar1.getProductPrice() * LoginController.cguitar1.getProductQuantity()));

            product4.setVisible(true);
            qty4.setVisible(true);
            amount4.setVisible(true);

            item4Amount = LoginController.cguitar1.getProductPrice() * LoginController.cguitar1.getProductQuantity();

        }

        if (LoginController.cguitar2.getProductStatus()) {
            product5.setText(LoginController.cguitar2.getProductName());
            qty5.setText(Double.toString(LoginController.cguitar2.getProductQuantity()));
            amount5.setText(Double
                    .toString(LoginController.cguitar2.getProductPrice() * LoginController.cguitar2.getProductQuantity()));

            product5.setVisible(true);
            qty5.setVisible(true);
            amount5.setVisible(true);

            item5Amount = LoginController.cguitar2.getProductPrice() * LoginController.cguitar2.getProductQuantity();

        }

        if (LoginController.cguitar3.getProductStatus()) {
            product6.setText(LoginController.cguitar3.getProductName());
            qty6.setText(Double.toString(LoginController.cguitar3.getProductQuantity()));
            amount6.setText(Double
                    .toString(LoginController.cguitar3.getProductPrice() * LoginController.cguitar3.getProductQuantity()));

            product6.setVisible(true);
            qty6.setVisible(true);
            amount6.setVisible(true);

            item6Amount = LoginController.cguitar3.getProductPrice() * LoginController.cguitar3.getProductQuantity();

        }
        double final_amount = item1Amount + item2Amount + item3Amount + item4Amount + item5Amount + item6Amount;
        total.setText(Double.toString(final_amount));

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

