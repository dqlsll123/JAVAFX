/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdwtpiano3.pkg0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Leo2
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private AnchorPane aP;
    @FXML
    private VBox vB;
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         vB.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            if (null != event.getCode().toString()) switch (event.getCode().toString()) {
                case "DOWN":
                    System.out.println(1);
                    break;
                case "RIGHT":
                    System.out.println(2);
                    break;
                case "UP":
                    System.out.println(3);
                    break;
                case "LEFT":
                    System.out.println(4);
                    break;
            }
        });
    
    }    
    
}
