import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Represents an image to be drawn
 */
public class Image extends JPanel {
    protected BufferedImage image;

    /**
     * Constructor
     * @param path to file
     */
    Image(String path) {
        try {
            image = ImageIO.read(new File(path));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
