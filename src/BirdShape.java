import java.awt.*;
import java.util.Random;

public class BirdShape extends Shape{

    /**
     * Constructor
     * @param x
     * @param y
     * @param width
     * @param path
     */
    public BirdShape(int x, int y, int width, String path) {
        super(path);
        this.x = x;
        this.y = y;
        this.width = width;

        Random rand = new Random();
        this.xDir = rand.nextInt(-6, 6);
        this.xDir = (this.xDir != 0) ? xDir : xDir + 1;
        this.yDir = rand.nextInt(-6, 6);
        this.yDir = (this.yDir != 0) ? yDir : yDir + 1;
    }

    /**
     * Method to draw this object
     * @param g2 the graphics context
     */
    @Override
    public void draw(Graphics2D g2) {
        super.paintComponent(g2);
        g2.drawImage(this.image, x, y, 100, 100, null);
    }
}
