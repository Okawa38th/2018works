package part1;

import java.awt.Color;
import java.awt.Graphics;

public class SlowLifeGivingRoundRect extends FroggerSceneObject  {

    private int counter;
    public SlowLifeGivingRoundRect(
            int initX, int initY,
            int initVelocityX,
            int initVelocityY,
            int initWidth, int initHeight,
            Color initColor) {
        super(initX, initY, initVelocityX, initVelocityY, initWidth, initHeight,
                initColor);
        counter = -1;
    }
    public void move() {
        if (counter <=-50)
            counter = -1;
        else
            setVelocityX(counter);

    }
    public void render(Graphics g) {
        g.setColor(getColor());
        g.fillRoundRect(getX(), getY(), getWidth(), getHeight(),getWidth(),getHeight());
    }

    public void respondToCollision(FroggerSceneObject frogger) {
        frogger.decLife(-5);
        counter--;
    }

}
