package part1;

import java.awt.Color;
import java.awt.Graphics;

/**
 * DO NOT CHANGE THIS CLASS
 * <p>
 * This class represents the frogger character
 * in the game.
 */
public class FroggerPlayer extends FroggerSceneObject {
    /**
     * This constructor initializes all instance
     * variables.
     */
    public FroggerPlayer(int initX, int initY, int initVelocityX,
                         int initVelocityY, int initWidth, int initHeight, Color initColor) {
        // LET'S USE THE FroggerSceneObject constructor
        super(initX, initY, initVelocityX, initVelocityY, initWidth, initHeight,
                initColor);
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * <p>
     * We don't need to update frogger's movement
     * here, since it is not controlled by AI,
     * but rather, by the user controls, so this
     * does nothing.
     */
    public void move() {
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * <p>
     * We're going to render our frogger as a little
     * green dot that gradually gets paler as he
     * loses health. We'll add some eyes as well,
     * which turn to X's when he dies.
     */
    public void render(Graphics g) {
        // AS HE LOSES LIFE, RED AND BLUE INCREASE,
        // MAKING HIM PALER
        int rb = 255 - (int) (255 * (getLife() / (double) FroggerSceneObject.MAX_LIFE));

        // DRAW HIM ONE WAY IF HE'S LIVING
        if (isAlive()) {
            // A SHADE OF GREEN
            g.setColor(new Color(rb, 255, rb));
            g.fillOval(getX(), getY(), getWidth(), getHeight());

            // AND NOW THE EYES
            g.setColor(Color.white);
            g.fillOval(getX() + (getWidth() / 6), getY() + (getHeight() / 6), getWidth() / 3, getHeight() / 3);
            g.fillOval(getX() + (getWidth() * 3 / 6), getY() + (getHeight() / 6), getWidth() / 3, getHeight() / 3);

            // AND THE PUPILS
            g.setColor(Color.black);
            g.fillOval(getX() + (getWidth() * 3 / 12), getY() + (getHeight() * 3 / 12), getWidth() / 12, getHeight() / 12);
            g.fillOval(getX() + (getWidth() * 7 / 12), getY() + (getHeight() * 3 / 12), getWidth() / 12, getHeight() / 12);
        }
        // AND ANOTHER IF HE'S DEAD
        else {
            // DRAW HIS BODY A GHASTLY WHITE
            g.setColor(Color.white);
            g.fillOval(getX(), getY(), getWidth(), getHeight());

            // AND OUTLINE HIM IN BLACK
            g.setColor(Color.black);
            g.drawOval(getX(), getY(), getWidth(), getHeight());

            // AND DRAW Xs FOR EYES, THAT
            // TAKES 4 LINES

            // LINE 1 - LEFT EYE
            int eyeX1 = getX() + (getWidth() / 6);
            int eyeY1 = getY() + (getHeight() / 6);
            int eyeX2 = eyeX1 + getWidth() / 3;
            int eyeY2 = eyeY1 + getHeight() / 3;
            g.drawLine(eyeX1, eyeY1, eyeX2, eyeY2);

            // LINE 2 - LEFT EYE
            eyeY1 = eyeY1 + getHeight() / 3;
            eyeY2 = getY() + (getHeight() / 6);
            g.drawLine(eyeX1, eyeY1, eyeX2, eyeY2);

            // LINE 3 - RIGHT EYE
            eyeX1 = getX() + (getWidth() * 3 / 6);
            eyeY1 = getY() + (getHeight() / 6);
            eyeX2 = eyeX1 + getWidth() / 3;
            eyeY2 = eyeY1 + getHeight() / 3;
            g.drawLine(eyeX1, eyeY1, eyeX2, eyeY2);

            // LINE 4 - RIGHT EYE
            eyeY1 = eyeY1 + getHeight() / 3;
            eyeY2 = getY() + (getHeight() / 6);
            g.drawLine(eyeX1, eyeY1, eyeX2, eyeY2);
        }
    }

    /**
     * DO NOT CHANGE THIS METHOD
     * <p>
     * We don't need to respond to collisions
     * because frogger can't collide with frogger.
     */
    public void respondToCollision(FroggerSceneObject frogger) {
    }
}