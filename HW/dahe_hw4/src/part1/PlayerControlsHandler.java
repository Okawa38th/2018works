package part1;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * DO NOT CHANGE THIS CLASS
 * <p>
 * This class simply keeps track of user key
 * presses on the keyboard so that we always
 * know what keys are pressed at any time. This
 * allows us to control frogger.
 */
public class PlayerControlsHandler implements KeyListener {
    // FROGGER NEEDS TO KNOW IF THE
    // DIRECTION KEYS (OR WASD) ARE PRESSED
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean leftPressed = false;
    private boolean rightPressed = false;

    // ACCESSOR METHODS
    public boolean isUpPressed() {
        return upPressed;
    }

    public boolean isDownPressed() {
        return downPressed;
    }

    public boolean isLeftPressed() {
        return leftPressed;
    }

    public boolean isRightPressed() {
        return rightPressed;
    }

    /**
     * This method updates the state of our
     * variables for knowing when a key is pressed.
     */
    public void keyPressed(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_UP)
                ||
                (e.getKeyCode() == KeyEvent.VK_W)) {
            upPressed = true;
        } else if ((e.getKeyCode() == KeyEvent.VK_DOWN)
                ||
                (e.getKeyCode() == KeyEvent.VK_S)) {
            downPressed = true;
        } else if ((e.getKeyCode() == KeyEvent.VK_LEFT)
                ||
                (e.getKeyCode() == KeyEvent.VK_A)) {
            leftPressed = true;
        } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT)
                ||
                (e.getKeyCode() == KeyEvent.VK_D)) {
            rightPressed = true;
        }
    }

    /**
     * This method lets us know when a key is
     * no longer pressed.
     */
    public void keyReleased(KeyEvent e) {
        if ((e.getKeyCode() == KeyEvent.VK_UP)
                ||
                (e.getKeyCode() == KeyEvent.VK_W)) {
            upPressed = false;
        } else if ((e.getKeyCode() == KeyEvent.VK_DOWN)
                ||
                (e.getKeyCode() == KeyEvent.VK_S)) {
            downPressed = false;
        } else if ((e.getKeyCode() == KeyEvent.VK_LEFT)
                ||
                (e.getKeyCode() == KeyEvent.VK_A)) {
            leftPressed = false;
        } else if ((e.getKeyCode() == KeyEvent.VK_RIGHT)
                ||
                (e.getKeyCode() == KeyEvent.VK_D)) {
            rightPressed = false;
        }
    }

    // WE DON'T USE THIS ONE
    public void keyTyped(KeyEvent e) {
    }
}