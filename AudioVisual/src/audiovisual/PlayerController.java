/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package audiovisual;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author dale
 * Music: http://www.bensound.com/royalty-free-music
 */
public class PlayerController implements Initializable {
    
    @FXML
    private Text magText1;
    
    @FXML
    private Text magText2;
    
    @FXML
    private Text magText3;
    
    @FXML
    private Text magText4;
    
    @FXML
    private Text phaseText1;
    
    @FXML
    private Text phaseText2;
    
    @FXML
    private Text phaseText3;
    
    @FXML
    private Text phaseText4;
    
    @FXML
    private Ellipse ellipse1;
    
    @FXML
    private Ellipse ellipse2;
    
    @FXML
    private Ellipse ellipse3;
    
    @FXML
    private Ellipse ellipse4;
    
    private Double phaseMultiplier = 360.0;
    private Double phaseMultiplier2 = 50.3;
    private Double magnitudeOffset = 70.0;

    
    private Media media;
    private MediaPlayer mediaPlayer;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        media = new Media(this.getClass().getResource("bensound-scifi.mp3").toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        
        mediaPlayer.setAudioSpectrumNumBands(4);
        mediaPlayer.setAudioSpectrumInterval(0.01);
        mediaPlayer.setAudioSpectrumListener((double timestamp, double duration, float[] magnitudes, float[] phases) -> {
            if (magnitudes.length >= 4) {
                //System.out.println(magnitudes[0] + "," + magnitudes[1] + "," + magnitudes[2] + "," + magnitudes[3]);
                
                magText1.setText(Float.toString(magnitudes[0]));
                magText2.setText(Float.toString(magnitudes[1]));
                magText3.setText(Float.toString(magnitudes[2]));
                magText4.setText(Float.toString(magnitudes[3]));
                
                phaseText1.setText(Float.toString(phases[0]));
                phaseText2.setText(Float.toString(phases[1]));
                phaseText3.setText(Float.toString(phases[2]));
                phaseText4.setText(Float.toString(phases[3]));
                
                ellipse1.setRadiusX(magnitudeOffset + magnitudes[0]);
                ellipse2.setRadiusX(magnitudeOffset + magnitudes[1]);
                ellipse3.setRadiusX(magnitudeOffset + magnitudes[2]);
                ellipse4.setRadiusX(magnitudeOffset + magnitudes[3]);
                
                /*
                ellipse1.setRadiusY(phaseMultiplier2 * Math.abs(phases[0]));
                ellipse2.setRadiusY(phaseMultiplier2 * Math.abs(phases[1]));
                ellipse3.setRadiusY(phaseMultiplier2 * Math.abs(phases[2]));
                ellipse4.setRadiusY(phaseMultiplier2 * Math.abs(phases[3]));
                */
                
                ellipse1.setRotate(phases[0] * phaseMultiplier);
                ellipse2.setRotate(phases[1] * phaseMultiplier);
                ellipse3.setRotate(phases[2] * phaseMultiplier);
                ellipse4.setRotate(phases[3] * phaseMultiplier);
                
                ellipse1.setFill(Color.hsb(magnitudes[0] * -6.0, 1.0, 1.0, 1.0));
                ellipse2.setFill(Color.hsb(magnitudes[1] * -6.0, 1.0, 1.0, 1.0));
                ellipse3.setFill(Color.hsb(magnitudes[2] * -6.0, 1.0, 1.0, 1.0));
                ellipse4.setFill(Color.hsb(magnitudes[3] * -6.0, 1.0, 1.0, 1.0));
                
            }
        });
    }
    
    @FXML
    private void handlePlay() {
        mediaPlayer.play();
    }
    
    @FXML
    private void handlePause() {
        mediaPlayer.pause();
    }
    
    @FXML
    private void handleStop() {
        mediaPlayer.stop();
    }
    
}
