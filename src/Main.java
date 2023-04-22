import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.Random;

/**
 * A program that allows users to edit a scene composed
 * of items.
 */
public class Main {
    private static JFrame secondFrame;
    private static ScenePanel secondPanel;

    private static final int WIDTH = 600;
    private static final int HEIGHT = 600;

    /**
     * The entry point for the program, creates a single new window and handles UI input
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        final ScenePanel panel = new ScenePanel();


        JButton showButton = new JButton("Show");
        JButton addButton = new JButton("Add");
        JButton pauseButton = new JButton("Pause");
        JButton exitButton = new JButton("Exit");

        JPanel buttons = new JPanel();
        buttons.add(showButton);
        buttons.add(addButton);
        buttons.add(pauseButton);
        buttons.add(exitButton);


        JCheckBox birdCheck = new JCheckBox("Bird");
        JCheckBox rocketCheck = new JCheckBox("Rocket");
        JCheckBox ufoCheck = new JCheckBox("UFO");

        JPanel checkboxes = new JPanel();
        checkboxes.add(birdCheck);
        checkboxes.add(rocketCheck);
        checkboxes.add(ufoCheck);


        showButton.addActionListener(e -> createSubwindow());

        addButton.addActionListener(e -> addShapes(birdCheck.isSelected(), rocketCheck.isSelected(), ufoCheck.isSelected()));

        pauseButton.addActionListener(e -> {
            if(secondPanel != null)
                secondPanel.togglePause();
        });

        exitButton.addActionListener(e -> frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));


        JPanel columns = new JPanel();
        columns.setLayout(new BoxLayout(columns, BoxLayout.X_AXIS));
        columns.add(buttons);
        columns.add(checkboxes);


        contentPane.add(panel, BorderLayout.CENTER);
        contentPane.add(columns, BorderLayout.NORTH);


        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);

    }

    /**
     * Checks whether any parameters are checked then adds a new image of that type to the scene
     * @param birdChecked
     * @param rocketChecked
     * @param ufoChecked
     */
    private static void addShapes(boolean birdChecked, boolean rocketChecked, boolean ufoChecked) {
        if(secondPanel == null){
            createSubwindow();
        }

        Random rand = new Random();

        if (birdChecked){
            secondPanel.add(new BirdShape(rand.nextInt(-WIDTH + 200, WIDTH - 200), rand.nextInt(-HEIGHT + 200, HEIGHT - 200), 75, "src/bird.png"));
        }

        if (rocketChecked) {
            secondPanel.add(new RocketShape(rand.nextInt(-WIDTH + 200, WIDTH - 200), rand.nextInt(-HEIGHT + 200, HEIGHT - 200), 75, "src/rocket.png"));
        }

        if (ufoChecked) {
            secondPanel.add(new UFOShape(rand.nextInt(-WIDTH + 200, WIDTH - 200), rand.nextInt(-HEIGHT + 200, HEIGHT - 200), 75, "src/ufo.png"));
        }
    }

    /**
     * Creates a second window to display images moving around
     */
    private static void createSubwindow() {
        secondFrame = new JFrame();

        Container contentPane = secondFrame.getContentPane();

        secondPanel = new ScenePanel();

        JPanel buttons = new JPanel();

        JButton exitButton = new JButton("Exit");

        exitButton.addActionListener(e -> {
            secondFrame.dispatchEvent(new WindowEvent(secondFrame, WindowEvent.WINDOW_CLOSING));
            secondPanel = null;
        });

        buttons.add(exitButton);

        contentPane.add(secondPanel, BorderLayout.CENTER);
        contentPane.add(buttons, BorderLayout.NORTH);

        secondFrame.setSize(WIDTH, HEIGHT);
        secondFrame.setVisible(true);

        secondPanel.run();
    }


}