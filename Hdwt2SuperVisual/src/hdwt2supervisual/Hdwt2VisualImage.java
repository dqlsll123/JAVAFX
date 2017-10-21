/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdwt2supervisual;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

/**
 *
 * @author Leo2
 */
public class Hdwt2VisualImage implements Visualizer{
    private String name = "Hdwt2 Super Visual2";
     private Image image;  
     private WritableImage wImage; 
     private ImageView imageView;
      private AnchorPane vizPane;
    private Canvas canvas;
    
    float temp0=60;
    float temp1=60;
    float temp2=60;
    float temp3=60;
    float temp4=60;
    float temp5=60;
    int time=0;
    @Override
    public void start(Integer numBands,AnchorPane vizPane, Canvas canvas,ImageView iv) {
        this.vizPane = vizPane;
        this.canvas=canvas;
        this.imageView=iv;
        
        image = new Image(this.getClass().getResourceAsStream("Hdwt2Star.png"));  
        imageView.setImage(image);
        
        imageView.setSmooth(true);  
         System.out.println(1);
    }

    @Override
    public void end() {
       
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
// System.out.println("success");
            if(magnitudes[0]>temp0){
            pixWithImage(0);
            temp0=magnitudes[0];
            }
            else{
             pixWithImage(1);
             temp0=magnitudes[0];
            }
            if(magnitudes[1]>temp1){
            pixWithImage(2);
            temp1=magnitudes[1];
            }
            else{
             pixWithImage(3);
             temp1=magnitudes[1];
            }
            
            if(magnitudes[2]>temp2){
            pixWithImage(4);
            temp2=magnitudes[2];
            }
            else{
             pixWithImage(5);
             temp2=magnitudes[2];
            }
            
            if(magnitudes[3]>temp3){
                time++;
                if(time>3){
            pixWithImage(3);
            temp3=magnitudes[3];
                time=0;
                }
            }
            else{
              imageView.setImage(image);
             temp3=magnitudes[3];
            }
       
    }
    private void pixWithImage(int type){  
        PixelReader pixelReader = imageView.getImage().getPixelReader();  
        // Create WritableImage  
        wImage = new WritableImage(  
                (int)image.getWidth(),  
                (int)image.getHeight());  
        PixelWriter pixelWriter = wImage.getPixelWriter();  
          
        for(int y = 0; y < image.getHeight(); y++){  
            for(int x = 0; x < image.getWidth(); x++){  
                Color color = pixelReader.getColor(x, y);  
                switch (type) {  
                case 0:  
                    color = color.brighter();  
                    
                    break;  
                case 1:  
                    color = color.darker();  
                  
                    break;  
                case 2:  
                    color = color.grayscale();  
                    break;  
                case 3:  
                    color = color.invert();  
                    break;  
                case 4:  
                    color = color.saturate();  
                    break;  
                case 5:  
                    color = color.desaturate();  
                    break;  
                default:  
                    break;  
                }  
                pixelWriter.setColor(x, y, color);  
            }  
        }  
        imageView.setImage(wImage);  
    }  
    
}
