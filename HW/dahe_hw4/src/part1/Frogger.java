package part1;

import javax.swing.JFrame;

/**
 * DO NOT CHANGE THIS CLASS
 * <p>
 * This is our humble little Frogger application.
 * This class simply organizes the window and then
 * displays it. The rendering panel is really where
 * most of the game rules are implemented.
 *
 * @author McKillaGorilla
 */
public class Frogger extends JFrame {
    /**
     * This default constructor is for initializing
     * our frogger window.
     */
    public Frogger() {
        // INIT THE WINDOW WITH THE TITLE Frogger
        super("Frogger");

        // ADD THE RENDER PANEL TO OUR WINDOW
        this.add(new FroggerRenderer());

        // MAXIMIZE THE WINDOW
        this.setExtendedState(MAXIMIZED_BOTH);

        // KILL THE APP WHEN THE USER WANTS TO
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * Build our frogger window and display it.
     */
    public static void main(String[] args) {
        Frogger window = new Frogger();
        window.setVisible(true);
    }
}