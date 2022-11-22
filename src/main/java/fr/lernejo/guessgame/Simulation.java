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
        if (guess == numberToGuess) {
            logger.log("Bien joué");
            return true;
        } else {
            player.respond(guess > numberToGuess);
            return false;

        }

    }

    public void loopUntilPlayerSucceed(long numberOfTry) {
        long time = System.currentTimeMillis();
        boolean isGameOver = false;
        while (isGameOver == false && numberOfTry > 0) {
            isGameOver = nextRound();
            numberOfTry = numberOfTry - 1;
        }
        if (isGameOver == false) {
            logger.log("Perdu");
        }
        time = System.currentTimeMillis() - time;
        logger.log(transformTimeFormat(time));


    }

    public String transformTimeFormat(long time) {


        long millis = time;  // obtained from StopWatch
        while (millis > 1000) {
            millis = millis % 10;
        }
        String millisStr = String.format("%03d", millis);

        long minutes = (time / 1000) / 60;
        String minutesStr = String.format("%02d", minutes);
        int seconds = (int) ((time / 1000) % 60);
        String secondsStr = String.format("%02d", seconds);
        return ("time: " + minutesStr + ":" + secondsStr + ":" + millisStr);
    }
}
