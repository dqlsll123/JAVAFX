/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdwt2supervisual;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 *
 * @author Leo2
 */
public class MyPlayerController implements Initializable {
   private int numBands = 25;
     @FXML
    private AnchorPane vizPane;
     @FXML
    private Canvas canvas;
    private ArrayList<Visualizer> visualizers;
    private Media media;
    private MediaPlayer mediaPlayer;
    private Visualizer currentVisualizer;
    @FXML
    private Menu visualizersMenu;
    @FXML
    private ImageView iv;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      // iv.setImage(new Image(this.getClass().getResourceAsStream("star.png")));
        visualizers = new ArrayList<>();
        visualizers.add(new Hdwt2Visual());
         visualizers.add(new Hdwt2VisualImage());
      
        currentVisualizer = visualizers.get(0);
    }   
    
    public void handleOpen(Event event) {
        Stage primaryStage = (Stage)vizPane.getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            openMedia(file);
        }
    }
    public void ChangeToImage(Event event){
        if(media==null){
        return;
        }
        changeVisualizer(visualizers.get(1));
    }
    public void ChangeToVisual(Event event){
        if(media==null){
        return;
        }
        changeVisualizer(visualizers.get(0));
    }
     public void ChangeToBands1(Event event){
        if(media==null){
        return;
        }
        numBands=25;
        changeBands(visualizers.get(0));
    }
     public void ChangeToBands2(Event event){
        if(media==null){
        return;
        }
        numBands=50;
       
        changeBands(visualizers.get(0));
    }
     private void changeVisualizer(Visualizer visualizer) {
        if (currentVisualizer != null) {
            currentVisualizer.end();
        }
        currentVisualizer = visualizer;
         currentVisualizer.start(numBands,vizPane,canvas,iv);
      
    }
     
     private void changeBands(Visualizer visualizer) {
         //System.out.println(numBands);
        if (currentVisualizer != null) {
            currentVisualizer.end();
        }
       if(!currentVisualizer.getName().equals("Hdwt2 Super Visual")){
        System.out.println(currentVisualizer.getName());
        return;
        }
        currentVisualizer = visualizer;
         currentVisualizer.start(numBands,vizPane,canvas,iv);
      
    }
     
     private void openMedia(File file) {
   
        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }
        
        try {
            media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);
            mediaPlayer.setAudioSpectrumListener((double timestamp, double duration, float[] magnitudes, float[] phases) -> {
                handleUpdate(timestamp, duration, magnitudes, phases);
            });
            mediaPlayer.setOnReady(() -> {
                handleReady();
            });
          //  filePathText.setText(file.getPath());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    private void handleUpdate(double timestamp, double duration, float[] magnitudes, float[] phases) {
       currentVisualizer.update(timestamp, duration, magnitudes, phases);
      // System.out.println(magnitudes);
      // System.out.println(phases);
    }

    private void handleReady() {
        currentVisualizer.start(numBands,vizPane,canvas,iv);
    }
    
}
