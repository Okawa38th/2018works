package lab5;

import javafx.beans.binding.BooleanBinding;

enum BotState {
    ATTACKING,
    RETREATING,
    PATROLING,
    DEAD
}

public class BotStateSelector {
    public static void main(String[] args) {
        BotState state = BotState.PATROLING;
        double health = 0.6;
        double distanceToEnemy = 50.0;
        System.out.println("Starting State: " + state);
        state = getstate(health,distanceToEnemy);
        System.out.println("Ending State: " + state);
        health = 0.2;
        distanceToEnemy = 500.0;
        System.out.println("Starting State: " + state);
        state = getstate(health,distanceToEnemy);
        System.out.println("Ending State: " + state);

    }
    public static BotState getstate( double health, double distanceToEnemy) {
        BotState state;
        if (health > 0.5) {
            if (distanceToEnemy < 100.0) {
                state = BotState.ATTACKING;
            } else {
                state = BotState.PATROLING;
            }
        } else if (health > 0.0) {
            state = BotState.RETREATING;
        } else {
            state = BotState.DEAD;
        }return state;
    }
}