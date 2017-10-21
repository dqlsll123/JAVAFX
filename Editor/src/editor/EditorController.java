/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.HTMLEditor;

/**
 * FXML Controller class
 *
 * @author dalemusser
 */
public class EditorController implements Initializable {

    @FXML
    private HTMLEditor htmlEditor;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    private void handleOpen(ActionEvent event) {
        System.out.println("Open was selected!");
        
        // here I would let the user select the file to open
        // then open the file and read its contents
        // then put the contents in the editor
        
        // here is an example of putting contents in the editor
        htmlEditor.setHtmlText("<b>Hello World!</b>");
        
    }
    
}
