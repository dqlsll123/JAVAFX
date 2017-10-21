/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdwt2supervisual;

import java.util.Random;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;

/**
 *
 * @author Leo2
 */
public class Hdwt2Visual implements Visualizer{
    private String name = "Hdwt2 Super Visual";
    private AnchorPane vizPane;
    private Canvas canvas;
    private GraphicsContext c ;
    private ImageView iv;
    float temp = 60;
    Color w = Color.WHITE;
    Line l;
    int numBands;
    int temp1;
    public Hdwt2Visual(){
    }
    @Override
    public void start(Integer numBands,AnchorPane vizPane,Canvas canvas,ImageView iv) {
        this.vizPane = vizPane;
        this.canvas=canvas;
        this.numBands=numBands;
        this.iv=iv;
       iv.setImage(null);
    // GraphicsContext gc = canvas.getGraphicsContext2D();
     c  = canvas.getGraphicsContext2D();
     //   gc.setFill(Color.BLACK);
    //int m =40;
       // for(int i=0;i<25;i++){
      //  gc.fillRect(m,60,20,140);
     //   m=m+21;}
    }

    @Override
    public void end() {
       c.clearRect(0, 0, canvas.getWidth(),canvas.getHeight());
    }

    @Override
    public String getName() {
        return name;
   }

    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases) {
       // System.out.println(canvas.getWidth());
     
        c.clearRect(0, 0, canvas.getWidth(),canvas.getHeight());
        
        float m =40;
        
        
        if(magnitudes[2]>temp){
            w.brighter();
        }else{
            w.darker();
        }
       temp = magnitudes[2];
        c.setFill(w);
         for(int i=0;i<numBands;i++){
          //  System.out.println( magnitudes[i]);
        c.fillRect(m,0,20/(numBands/25),120);
        m=m+21/(numBands/25);
         }
          c.setStroke(Color.GOLD);
          for(int i=0;i<numBands;i++){ 
             c.setLineWidth(3);
             
             c.strokeLine(50+21/(numBands/25)*i, (150 + magnitudes[i])*2,
                     21/(numBands/25)+50+21/(numBands/25)*i, (150 + magnitudes[i+1])*2);}
      //  c.setStroke(Color.BLACK);
       //  c.strokeLine(10, 10, (100 + magnitudes[2])*2, 100);
      //   for(int i=0;i<24;i++){ 
        //     c.setLineWidth(5);
       //      c.strokeLine(50+21*i, (150 + magnitudes[i])*2, 71+21*i, (150 + magnitudes[i+1])*2);}
        
        float n =40;
       c.setFill(Color.RED);
        for(int i=0;i<numBands;i++){
          
          //  System.out.println( magnitudes[i]);
        c.fillRect(n,0,20/(numBands/25)-0.5,(60 + magnitudes[i])*2);
        
       
        n=n+21/(numBands/25);}
      
    }
    
//			int paramInt, Canvas paramCanvas) {
//		Random localRandom = new Random();
//		if (paramInt < localRandom.nextInt(7)) {
//			paramCanvas.drawLine(x1, y1, x2, y2, mLighnitngColorPaint);
//			paramCanvas.drawLine(x1, y1, x2, y2, mLighnitngColorPaint);
//			paramCanvas.drawLine(x1, y1, x2, y2, mLighnitngGlowPaintBold);
//                        
//			return;
//		}
//		float x3 = 0, y3 = 0;
//		if (localRandom.nextBoolean()) {
//			x3 = (float) ((x2 + x1) / 2.0F + ((localRandom.nextInt(8) - 0.5D) * paramInt));
//		} else {
//			x3 = (float) ((x2 + x1) / 2.0F - ((localRandom.nextInt(8) - 0.5D) * paramInt));
//		}
//		if (localRandom.nextBoolean()) {
//			y3 = (float) ((y2 + y1) / 2.0F + ((localRandom.nextInt(5) - 0.5D) * paramInt));
//		} else {
//			y3 = (float) ((y2 + y1) / 2.0F - ((localRandom.nextInt(5) - 0.5D) * paramInt));
//		}
//		drawLightning(x1, y1, x3, y3, paramInt / 2, paramCanvas);
//		drawLightning(x2, y2, x3, y3, paramInt / 2, paramCanvas);
//		return;
//
//	}
    
}
