package part1;

import java.awt.Color;
import java.awt.Graphics;

/**
 * DO NOT CHANGE THIS CLASS
 * <p>
 * This class represents one of the objects
 * moving around the board as an obstacle
 * to frogger. It is oval and periodically
 * changes direction. When collided with, it
 * does the most damage to frogger.
 */
public class CrazyRandomOval extends FroggerSceneObject {
        // THIS IS USED FOR AI
        private int counter;

    /**
     * This constructor initializes all instance
     * variables.
     */
    public CrazyRandomOval(
            int initX, int initY,
            int initVelocityX,
            int initVelocityY,
            int initWidth, int initHeight,
            Color initColor) {
        // USE THE FroggerSceneObject CONSTRUCTOR
        super(initX, initY, initVelocityX, initVelocityY, initWidth, initHeight,
                initColor);

        // RESET THE COUNTER
        counter = 0;
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * <p>
     * This method updates the velocity once every
     * 50 frames. In so doing, it picks a new x
     * velocity, which may be positive (to the right)
     * or negative (to the left).
     */
    public void move() {
        // ONLY DO THIS ONCE PER 50 FRAMES
        if (counter == 50) {
            // PICK A NEW X VELOCITY
            setVelocityX((int) (Math.random() * 20) - 10);

            // RESET THE COUNTER
            counter = 0;
        }
        // OTHERWISE INC THE COUNTER
        else
            counter++;
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * <p>
     * This method simply renders this object as
     * a filled in oval using the methods from
     * the Graphics class to render the oval
     * in its proper location with its own color.
     */
    public void render(Graphics g) {
        g.setColor(getColor());
        g.fillOval(getX(), getY(), getWidth(), getHeight());
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * <p>
     * For every frame this object collides with
     * frogger, 10 units of life are taken
     * from him.
     */
    public void respondToCollision(FroggerSceneObject frogger) {
        frogger.decLife(10);
    }
}