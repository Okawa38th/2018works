package part1;

import java.util.TimerTask;

/**
 * DO NOT CHANGE THIS CLASS
 * <p>
 * This class is for forcing the timed processing
 * and rendering of the frogger game.
 *
 * @author McKilla Gorilla
 */
public class AnimateFrogger extends TimerTask {
    // THIS IS THE GAME WE NEED TO REPAINT EACH TIME
    private FroggerRenderer panel;

    /**
     * This constructor only needs to register
     * the panel on which we will render the game.
     */
    public AnimateFrogger(FroggerRenderer initPanel) {
        panel = initPanel;
    }

    /**
     * This method will be called at fixed-time intervals,
     * each time rendering the panel.
     */
    public void run() {
        // TELL THE GAME TO UPDATE EVERYTHING,
        // WHICH INCLUDES GETTING USER INPUT,
        // MOVING THE OBJECTS, AND PERFORMING
        // COLLISION DETECTION
        panel.updateGame();

        // AND REDRAW THE GAME
        panel.repaint();
    }
}