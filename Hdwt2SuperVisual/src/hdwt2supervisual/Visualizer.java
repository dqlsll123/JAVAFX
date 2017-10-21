/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hdwt2supervisual;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author dale
 */
public interface Visualizer {
    public void start( Integer numBands,AnchorPane vizPane,Canvas canvas,ImageView iv);
    public void end();
    public String getName();
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases);
}
