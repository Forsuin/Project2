import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * A panel that shows a scene composed of shapes.
 */
public class ScenePanel extends JPanel {
    private final ArrayList<Shape> shapes;

    private boolean isPaused = false;

    /**
     * Constructor
     */
    public ScenePanel() {
        shapes = new ArrayList<Shape>();
    }

    /**
     * Adds a shape to the scene.
     *
     * @param s the shape to add
     */
    public void add(Shape s) {
        shapes.add(s);
        repaint();
    }

    /**
     * Toggles whether this ScenePanel should update its contents
     */
    public void togglePause(){
        isPaused = !isPaused;
    }

    /**
     * Displays the contents of this panel
     * @param g the <code>Graphics</code> object to draw with
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (Shape shape : shapes) {
            shape.draw(g2);
        }
    }

    /**
     * If this panel is not paused, this method will update the contents of the panel
     */
    public void run() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if(!isPaused) {
                    update();
                }
            }
        }, 0, 33, TimeUnit.MILLISECONDS);
    }

    /**
     * Actually handles updating contents by translating them
     */
    private void update() {
        for(Shape shape : shapes){
            shape.translate();

            if(shape.getX() < 0){
                shape.setX(this.getWidth());
            }
            else if(this.getWidth() < shape.getX()){
                shape.setX(0);
            }

            if(shape.getY() < 0){
                shape.setY(this.getHeight());
            }
            else if(this.getHeight() < shape.getY()){
                shape.setY(0);
            }

        }
        repaint();
    }
}
