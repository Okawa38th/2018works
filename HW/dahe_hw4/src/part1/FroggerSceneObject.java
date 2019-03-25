package part1;

import java.awt.Color;
import java.awt.Graphics;

/**
 * DO NOT CHANGE THIS CLASS
 * <p>
 * This abstract class represents a renderable
 * object in the frogger game. Note that game
 * objects should extend this class and then
 * provide all the customized behaviour by
 * overriding the abstract methods.
 */
public abstract class FroggerSceneObject {
    // 100 REPRESENTS FULL HEALTH
    public static final int MAX_LIFE = 100;

    // THIS IS THE CURRENT LIFE OF THIS OBJECT
    private int life;

    // POSITION OF THIS OBJECT
    private int x, y;

    // VELOCITY OF THIS OBJECT
    private int velocityX, velocityY;

    // DIMENSIONS OF THIS OBJECT
    private int width, height;

    // COLOR OF THIS OBJECT
    private Color color;

    /**
     * This constructor initializes all FSO data,
     * including starting this object at full health.
     */
    public FroggerSceneObject(int initX, int initY,
                              int initVelocityX,
                              int initVelocityY,
                              int initWidth,
                              int initHeight,
                              Color initColor) {
        life = MAX_LIFE;
        x = initX;
        y = initY;
        velocityX = initVelocityX;
        velocityY = initVelocityY;
        width = initWidth;
        height = initHeight;
        color = initColor;
    }

    // ACCESSOR METHODS
    public boolean isAlive() {
        return life > 0;
    }

    public int getLife() {
        return life;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    // MUTATOR METHODS
    public void decLife(int damage) {
        life -= damage;

        // MAKE SURE WE DON'T GET NEGATIVE
        // LIFE OR LIFE OVER THE MAX, 100
        if (life < 0)
            life = 0;
        if (life > MAX_LIFE)
            life = MAX_LIFE;
    }

    public void setX(int initX) {
        x = initX;
    }

    public void setY(int initY) {
        y = initY;
    }

    public void setVelocityX(int initVX) {
        velocityX = initVX;
    }

    public void setVelocityY(int initVY) {
        velocityY = initVY;
    }

    /**
     * This method should be called on each game
     * object once per frame, it updates the object's
     * position using the current velocity and makes
     * sure game objects don't disappear off the left
     * or right of the screen.
     */
    public void update(int viewportWidth, int viewportHeight) {
        x += velocityX;
        y += velocityY;

        if ((x > viewportWidth)
                && (velocityX > 0))
            x = -width;
        if ((x < 0)
                && (velocityX < 0))
            x = viewportWidth;
    }

    // CLASSES THAT CHOOSE TO EXTEND
    // FroggerSceneObject MUST OVERRIDE
    // THESE METHODS BECAUSE THEY ARE abstract.
    // CHILD CLASSES MUST DEFINE CUSTOM MOVEMENT,
    // RENDERING, AND COLLISION RESPONSE
    public abstract void move();

    public abstract void render(Graphics g);

    public abstract void respondToCollision(FroggerSceneObject frogger);
}