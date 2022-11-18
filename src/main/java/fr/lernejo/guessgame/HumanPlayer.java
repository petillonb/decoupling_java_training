package fr.lernejo.guessgame;


import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private final Logger logger = LoggerFactory.getLogger("player");
    public long askNextGuess(){
        logger.log("Quel est l'age du capitaine ?");
        Scanner scanner = new Scanner(System.in);
        String rawAnswer = scanner.nextLine();
        long answer=Long.parseLong(rawAnswer);
        
        return answer;

    }
    public void respond(boolean lowerOrGreater){
        if(lowerOrGreater){
            logger.log("Plus jeune");
        }
        else{
            logger.log("Plus vieux");
        }

    }


}
