package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;
    private long numberToGuess;

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;

    }
    private boolean nextRound() {
        long guess = player.askNextGuess();
        if (guess == numberToGuess){
            logger.log("Bien joué");
            return true;
        }
        else {
            player.respond(guess > numberToGuess);
            return false;

        }

    }

    public void loopUntilPlayerSucceed() {
        boolean isGameOver = false;
        while (isGameOver == false){
            isGameOver =  nextRound();
        }
        //TODO implement me
    }
}
