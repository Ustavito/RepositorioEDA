package bingo;

import utils.NumberGetter;

public class Game {


	    private final Hype hype;
	    private Player[] players;

	    public Game() {
	        hype = new Hype();
	        createPlayers();
	    }

	    void play() {
	        boolean lineDetected = false;
	        while (hype.hasNumbers()) {
	            int number = hype.getNumber();
	            for (int i = 0; i < players.length; i++) {
	                players[i].removeNumber(number);
	                if (!lineDetected) {
	                    if (players[i].hasLine()) {
	                        System.out.println("Line detected");
	                        lineDetected = true;
	                    }
	                }
	                if (players[i].hasBingo()) {
	                    System.out.println("Bingo detected");
	                    break;
	                }

	            }
	        }
	        
	    }

	    private void createPlayers() {
	        NumberGetter n = new NumberGetter();
	        final int numPlayers = n.getNumber("Number of players:");
	        players = new Player[numPlayers];
	        for (int i = 0; i < numPlayers; i++) {
	            players[i] = new Player();
	        }
	        
	    }

}
