package part1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.Timer;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * DO NOT CHANGE THIS CLASS
 * <p>
 * This class represents the surface
 * on which we will render our game inside
 * our GUI. It also provides the game
 * architecture, connecting the various
 * game components that make up all the
 * rules.
 */
public class FroggerRenderer extends JPanel {
    // THIS IS THE PLAYER OBJECT
    private FroggerSceneObject frogger;

    // HERE ARE THE OBSTACLES
    private FroggerSceneObject fso1;
    private FroggerSceneObject fso2;
    private FroggerSceneObject fso3;
    private FroggerSceneObject fso4;
    private FroggerSceneObject fso5;
    private FroggerSceneObject fso6;

    // THIS IS FOR MAKING SURE THE PANEL IS
    // VISIBLE BEFORE WE TRY TO CONSTRUCT
    // AND USE THE OBSTACLES
    private boolean fsosConstructed = false;

    // THIS KEEPS TRACK OF PLAYER POINTS
    // TEN POINTS WINS THE GAME
    private int points = 0;

    // THIS HANDLES PLAYER KEYBOARD INPUT
    // FOR CONTROLLING FROGGER
    private PlayerControlsHandler pch;

    /**
     * This constructor initializes most of the
     * game architecture, but not the game objects.
     */
    public FroggerRenderer() {
        // THE TIMER WILL PROVIDE THE LOOP
        // FOR CONSTANT RENDERING
        Timer timer = new Timer();

        // WE PROVIDE THE TASK EACH TIME IN THE LOOP
        // THIS TASK ALSO DECIDES WHEN TO END THE TIMED
        // Timer LOOP AND KILLS IT
        AnimateFrogger task = new AnimateFrogger(this);

        // WE'LL START THIS ANIMATION IMMEDIATELY (0)
        // AND WILL HAVE delay AMOUNT OF TIME BETWEEN
        // EACH FRAME, MEANING EACH TIME THE Timer CALLS run
        // INSIDE OUR TASK.
        timer.scheduleAtFixedRate(task, 0, 30);

        // SETUP THE FROGGER CONTROLLER
        this.setFocusable(true);
        pch = new PlayerControlsHandler();
        addKeyListener(pch);
    }

    /**
     * This method gets called once per frame by
     * the timer, it updates all the game objects,
     * including their positions, velocities, and
     * responses to collisions, which may affect
     * other game state variables.
     */
    public void updateGame() {
        // GAME CANVAS WIDTH AND HEIGHT
        // IS THE SAME AS THIS PANEL, WE'LL
        // NEED TO USE IT HERE AND THERE
        int w = getWidth();
        int h = getHeight();

        // WHEN THE PLAYER GETS 10 POINTS
        // THE PLAYER WINS AND THE GAME ENDS
        if (points == 10) {
            JOptionPane.showMessageDialog(this, "YOU WIN!");
            System.exit(0);
        }

        // MAKE SURE THE GAME OBJECTS HAVE
        // BEEN CONSTRUCTED BEFORE UPDATING
        // THEIR STATES
        if (fso1 != null) {
            // GET AND PROCESS USER INPUT
            checkPlayerInput(w, h);

            // UPDATE ALL THE AI OBJECTS
            moveAndUpdate(fso1, w, h);
            moveAndUpdate(fso2, w, h);
            moveAndUpdate(fso3, w, h);
            moveAndUpdate(fso4, w, h);
            moveAndUpdate(fso5, w, h);
            moveAndUpdate(fso6, w, h);

            // UPDATE THE FROGGER IF STILL ALIVE
            if (frogger.isAlive()) {
                // UPDATE POSITION
                moveAndUpdate(frogger, w, h);

                // AND CHECK TO SEE IF frogger
                // IS COLLIDING WITH ANYTHING
                checkForCollisions();

                // AWARD A POINT FOR FROGGER
                // REACHING THE OTHER SIDE
                if (frogger.getY() < 0) {
                    int y = h * 10 / 11;
                    frogger.setY(y);
                    points++;
                }
            }
        }
    }

    /**
     * This method checks to see if frogger is
     * colliding with any of the other game
     * obstacles. If there is a collision, we
     * call the proper response method.
     */
    public void checkForCollisions() {
        if (isColliding(fso1, frogger))
            fso1.respondToCollision(frogger);
        if (isColliding(fso2, frogger))
            fso2.respondToCollision(frogger);
        if (isColliding(fso3, frogger))
            fso3.respondToCollision(frogger);
        if (isColliding(fso4, frogger))
            fso4.respondToCollision(frogger);
        if (isColliding(fso5, frogger))
            fso5.respondToCollision(frogger);
        if (isColliding(fso6, frogger))
            fso6.respondToCollision(frogger);
    }

    /**
     * This method performs some cheap collision
     * detection to see if the fsoA game object
     * is colliding with fsoB. True is returned
     * if they are overlapping, false otherwise.
     */
    public boolean isColliding(FroggerSceneObject fsoA,
                               FroggerSceneObject fsoB) {
        int x1 = fsoA.getX();
        int y1 = fsoA.getY();
        int w1 = fsoA.getWidth();
        int h1 = fsoA.getHeight();
        int x2 = fsoB.getX();
        int y2 = fsoB.getY();
        int w2 = fsoB.getWidth();
        int h2 = fsoB.getHeight();
        if (x1 < x2) {
            if (x2 > (x1 + w1))
                return false;
        } else {
            if (x1 > (x2 + w2))
                return false;
        }
        if (y1 < y2) {
            if (y2 > (y1 + h1))
                return false;
        } else {
            if (y1 > (y2 + h2))
                return false;
        }
        return true;
    }

    /**
     * This method examines the player input
     * to see what direction keys are pressed
     * and updates the frogger velocities
     * accordingly.
     */
    public void checkPlayerInput(int w, int h) {
        if (pch.isUpPressed())
            frogger.setVelocityY(-10);
        if (pch.isDownPressed())
            frogger.setVelocityY(10);
        if (pch.isLeftPressed())
            frogger.setVelocityX(-10);
        if (pch.isRightPressed())
            frogger.setVelocityX(10);

        if ((!pch.isUpPressed())
                &&
                (!pch.isDownPressed()))
            frogger.setVelocityY(0);
        if ((!pch.isLeftPressed())
                &&
                (!pch.isRightPressed()))
            frogger.setVelocityX(0);
    }

    /**
     * This helper method is for updating
     * an FSO each frame.
     */
    public void moveAndUpdate(FroggerSceneObject fso, int w, int h) {
        fso.move();
        fso.update(w, h);
    }

    /**
     * This is for constructing a Frogger game
     * world of obstacles and Frogger himself.
     */
    public void initFSOs() {
        int height = getHeight();
        fso1 = makeRandomFSO(0, height * 2 / 11);
        fso2 = makeRandomFSO(0, height * 3 / 11);
        fso3 = makeRandomFSO(0, height * 4 / 11);
        fso4 = makeRandomFSO(0, height * 6 / 11);
        fso5 = makeRandomFSO(0, height * 7 / 11);
        fso6 = makeRandomFSO(0, height * 8 / 11);
        fsosConstructed = true;
        int width = getWidth();
        frogger = new FroggerPlayer((width / 2) - (height / 22),
                height * 10 / 11,
                0, 0,
                height / 11,
                height / 11,
                Color.green);
    }

    /**
     * This method builds and returns a random FSO.
     */
    public FroggerSceneObject makeRandomFSO(int x, int y) {
        // GENERATE A RANDOM COLOR
        float red = (float) Math.random();
        float green = (float) Math.random();
        float blue = (float) Math.random();
        Color randColor = new Color(red, green, blue);
        int height = getHeight();
        height = height / 11;

        // AND PICK A RANDOM OF THE 3 TYPES
        double num = Math.random();
//		if (num < (1.0/3.0))
        return new CrazyRandomOval(x, y, 0, 0, height, height, randColor);
//		else if (num < (2.0/3.0))
//			return new SlowLifeGivingRoundRect(x, y, 0, 0, height*4, height, randColor);
//		else
//			return new ChargingEvilRect(x, y, 0, 0, height, height, randColor);
    }

    /**
     * This method renders the entire world inside
     * this window. Note that we render the grass and
     * street here, but ask the game objects to
     * render themselves.
     */
    public void paintComponent(Graphics g) {
        int width = getWidth();
        int height = getHeight();

        if (width >= 0) {
            // MAKE SURE OUR ENEMIES ARE CONSTRUCTED
            if (!fsosConstructed) {
                initFSOs();
            }

            // FIRST RENDER THE STREET
            // THIS MEANS THE GRASS ON EITHER SIDE
            g.setColor(Color.green);
            g.fillRect(0, 0, width, height / 11);
            g.fillRect(0, (10 * height / 11), width, height / 11);

            // THE STREET ITSELF
            g.setColor(Color.gray);
            g.fillRect(0, (2 * height / 11), width, height * 7 / 11);

            // THE SIDEWALK ON EITHER SIDE
            g.setColor(Color.darkGray);
            g.fill3DRect(0, (height / 11), width, height / 11, true);
            g.fill3DRect(0, 9 * height / 11, width, height / 11, true);

            // INCLUDING THE DOUBLE YELLOW LINES
            Graphics2D g2 = (Graphics2D) g;
            Rectangle2D.Double yellowLine1 = new Rectangle2D.Double(
                    0, (height * 5 / 11) + (height / (5 * 11)),
                    width,
                    height / (5 * 11));
            Rectangle2D.Double yellowLine2 = new Rectangle2D.Double(
                    0, (height * 5 / 11) + (height * 3 / (5 * 11)),
                    width,
                    height / (5 * 11));
            g2.setColor(Color.yellow);
            g2.fill(yellowLine1);
            g2.fill(yellowLine2);

            // THEN RENDER THE THINGS ON THE STREET
            fso1.render(g);
            fso2.render(g);
            fso3.render(g);
            fso4.render(g);
            fso5.render(g);
            fso6.render(g);
            frogger.render(g);

            // FINALLY, DISPLAY THE FROGGER'S HEALTH
            g.setColor(Color.white);
            g.setFont(new Font("Serif", Font.PLAIN, 50));
            g.drawString("Life: " + frogger.getLife(), 50, 50);

            // AND THE PLAYER'S SCORE
            g.drawString("Points: " + points, width - 250, 50);
        }
    }
}