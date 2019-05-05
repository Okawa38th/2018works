package part1;

import java.awt.Color;
import java.awt.Graphics;

public class ChargingEvilRect extends FroggerSceneObject  {

    private int counter;
    private  double Maxvelocity;
    public ChargingEvilRect(
            int initX, int initY,
            int initVelocityX,
            int initVelocityY,
            int initWidth, int initHeight,
            Color initColor) {
        super(initX, initY, initVelocityX, initVelocityY, initWidth, initHeight,
                initColor);
        counter = 0;
        Maxvelocity = -(Math.random()*50+50);
    }
    public void move() {
        if (counter <= Maxvelocity)
            counter = -1;
        else
            setVelocityX(counter--);

    }
    public void render(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }

    public void respondToCollision(FroggerSceneObject frogger) {
        frogger.decLife(5);
    }

}
