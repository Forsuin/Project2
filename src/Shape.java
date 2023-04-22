import java.awt.*;

/**
 * A shape that manages its selection state.
 */
public abstract class Shape extends Image{
    protected int xDir;
    protected int yDir;

    protected int x;
    protected int y;

    protected int width;

    Shape(String path) {
        super(path);
    }


    /**
     * Getter for X
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Setter for X location
     * @param x int
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *  Getter for Y
     * @return int
     */
    public int getY() {
        return y;
    }

    /**
     * Setter for Y location
     * @param y int
     */
    public void setY(int y) {
        this.y = y;
    }



    /**
     * Draws this item.
     *
     * @param g2 the graphics context
     */
    public abstract void draw(Graphics2D g2);

    /**
     * Translates this item by a given amount.
    **/
    public void translate() {
        x += xDir;
        y += yDir;
    }

}
