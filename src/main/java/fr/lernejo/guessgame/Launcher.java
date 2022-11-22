package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.security.SecureRandom;

public class Launcher {
    public static void main(String[] args) {


        if (args.length == 1 && args[0].equals("-interactive")) {
            startInteractiveGame();

        } else if (args.length == 2 && args[0].equals("-auto") && isNumeric(args[1])) {
            long d = Long.parseLong(args[1]);
            startAutoGame(d);


        } else {
            printHelp();

        }
    }

    private static void printHelp() {
        Logger logger = LoggerFactory.getLogger("launcher");
        logger.log("Utiliser '-auto <age du capitaine>' pour le bot, '-interactive' pour jouer");
    }

    private static void startInteractiveGame() {
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextInt(100);
        Player humanPlayer = new HumanPlayer();
        Simulation simulation = new Simulation(humanPlayer);
        simulation.initialize(randomNumber);
        simulation.loopUntilPlayerSucceed(Long.MAX_VALUE);

    }

    private static void startAutoGame(long numberToGuess) {
        Player bot = new ComputerPlayer();
        Simulation simulation = new Simulation(bot);
        simulation.initialize(numberToGuess);
        simulation.loopUntilPlayerSucceed(10);

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            long d = Long.parseLong(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
