package fr.lernejo.guessgame;

import java.security.SecureRandom;

public class Launcher {
     public static void main(String[] args) {

         SecureRandom random = new SecureRandom();
         long randomNumber = random.nextInt(100);
         Player humanPlayer = new HumanPlayer();
         Simulation simulation = new Simulation(humanPlayer);
         simulation.initialize(randomNumber);
         simulation.loopUntilPlayerSucceed();

     }
}
