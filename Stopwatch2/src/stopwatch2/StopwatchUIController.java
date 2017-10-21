/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stopwatch2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author dalemusser
 */
public class StopwatchUIController implements Initializable {

    @FXML
    private ImageView clockFace;
    
    @FXML
    private ImageView hand;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        clockFace.setImage(new Image(this.getClass().getResourceAsStream("clockface.png")));
        hand.setImage(new Image(this.getClass().getResourceAsStream("hand.png")));
    }    
    
}
