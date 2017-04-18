package mills.war;

import java.util.Scanner;

public class WarGame {

	private static final int MAX_HAND_SIZE = 52;	//Max hand size for a Hand
	
	static Deck deck;	//The initial Deck that holds all the cards that will be used in the game
	
	static int numRounds = 0;	//How long the game was, in rounds
	static int numWar = 0;		//How many wars happened during the game
	static int numGames = 1;	//Always plays at least 1 game
	
	static boolean bailed = false;	//Whether or not we had to bail out of the game because there were too many rounds passed (stop infinite games)
	static boolean playing = true;	//Whether or not we are playing the game
	
	static Hand player;	//Player's hand
	static Hand computer;	//Computer's hand
	static Hand pot = new Hand("war",MAX_HAND_SIZE);	//Holds all the Cards that are played during a War
	
	private static String playerChoice;	//Used for checking whether or not we are playing another game
	private static String name = "";
	
	private static Scanner input;
	
	/**
	 * Creates a new Deck, shuffles the Deck, then creates a Player hand and a Computer hand, filling both with half the Deck size (26)
	 */
	private static void initializeGame()
	{
		deck = new Deck();
		deck.shuffle();
		
		/* Reinitialize variables that could have changed during the game */
		bailed = false;
		numRounds = 0;
		numWar = 0;
		playerChoice = "";
		
		if(numGames == 1)
		{
			System.out.print("What is your name? ");
			name = input.next();
			player = new Hand(name, MAX_HAND_SIZE);
		} else
		{
			player = new Hand(name, MAX_HAND_SIZE);
		}
		
		for(int i=0;i<26;i++)
			player.addCard(deck.drawCard());
		
		computer = new Hand("Hal", MAX_HAND_SIZE);
		for(int i=0;i<26;i++)
			computer.addCard(deck.drawCard());
		
	}
	
	/**
	 * Plays a round of War. Both players play a card. Cards are compared and whoever has the higher card takes the other's played card
	 */
	private static void playRound()
	{
		
		Card a = player.playCard();	//Player's played card
		Card b = computer.playCard();	//Computer's played card
		
		switch(a.compareTo(b))
		{
			case -1:	//Player's card is less than Computer's card
				computer.addCard(a);
				computer.addCard(b);
				break;
			case 0:		//Cards are equal
				playWar();
				break;
			case 1:		//Player's card is greater than Computer's card
				player.addCard(a);
				player.addCard(b);
				break;
		}
		numRounds++;
	}
	
	/**
	 * Plays a war, where each player plays 3 cards, showing the last one. Whoever has the higher card value wins all of the cards
	 */
	private static void playWar()
	{
		
		/* Since both players need to play 3 cards, if they do not have enough, they automatically lose */
		if(player.size() < 3)
		{
			player.makeEmpty();	//Triggers a game over
		} else if(computer.size() < 3)
		{
			computer.makeEmpty();	//Triggers a game over
		} else	//Both players have enough cards
		{
			for(int i=0;i<2;i++)	//Add two Cards
				pot.addCard(player.playCard());
			
			for(int i=0;i<2;i++)	//Add two Cards
				pot.addCard(computer.playCard());
			
			//Add the other Cards that will be compared to determine the winner for the War
			pot.addCard(computer.playCard());
			pot.addCard(player.playCard());
			
			switch(pot.peekCard().compareTo(pot.getAt(1)))
			{
				case -1:	//Player's card is less than the Computer's
					while(!pot.isEmpty())	//Add all cards in the pot to the computer's winnings
						computer.addCard(pot.playCard());
					break;
				case 0:		//Player's card and Computer's card are the same, another war ensues
					playWar();
					break;
				case 1:		//Player's card is greater than the Computer's
					while(!pot.isEmpty())	//Add all cards in the pot to the computer's winnings
						player.addCard(pot.playCard());
					break;
			}
			numWar++;
		}
	}
	
	/**
	 * Checks whether or not the game is over
	 * @return	true if either the Player or the Computer's hand is empty, false otherwise
	 */
	private static boolean isGameOver()
	{
		return player.isEmpty() || computer.isEmpty();
	}
	
	/**
	 * Prints out who won the game (based on who's hand is empty
	 */
	private static void getWinner()
	{
		if(bailed)
			System.out.println("Game went on for too long, so the player's decided to call it a tie");
		else if(player.isEmpty())	//Computer won
			System.out.println(computer.getName() + " won in " + numRounds + " rounds, with " + numWar + " wars!");
		else
			System.out.println(name + " won in " + numRounds + " rounds, with " + numWar + " wars!");
	}
	
	/**
	 * Determine whether or not another simulation should be run
	 */
	private static void playAgain()
	{
		System.out.println("Would you like to play again? (Y/N)");
		playerChoice = input.next();
		if(playerChoice.equalsIgnoreCase("y"))
		{
			System.out.println("Starting game "+numGames+" ...");
			run();
		} else
		{
			System.out.println("Thanks for playing!");
			playing = false;
		}
	}
	
	/**
	 * Play the game
	 */
	private static void run()
	{
		if(numGames > 1)	//Every game past the first
			initializeGame();
		while(!isGameOver() && !bailed)
		{
			if(numRounds >= 3500)
				bailed = true;
			playRound();
		}
		numGames++;
	}
	
	/**
	 * Run the program
	 * @param args
	 */
	public static void main(String[] args)
	{
		input = new Scanner(System.in);
		initializeGame();
		
		System.out.println("Starting game 1 ...");
		
		run();
		
		while(playing)
		{
			getWinner();
			playAgain();
		}
	}
}