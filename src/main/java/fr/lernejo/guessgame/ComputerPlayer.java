package fr.lernejo.guessgame;


import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    public long lastGuess;
    public long x = 0;
    public long y = 100;

    public long askNextGuess() {

        logger.log("Quel est l'age du capitaine ?");
        long answer = x + (y - x) / 2;
        logger.log(String.valueOf(answer));
        lastGuess = answer;
        return answer;

    }

    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater) {
            logger.log("Plus jeune");
            y = lastGuess;
        } else {
            logger.log("Plus vieux");
            x = lastGuess;
        }

    }
}
