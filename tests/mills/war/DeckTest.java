package mills.war;

import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

	@Test
	public void testDrawCard()
	{
		System.out.println("drawCard()");
		Deck deck = new Deck();	//Create a new Deck to test
		Card expected = new Card(Suit.SPADES, Face.TWO);	//Create a new Card that is expected to be drawn
		Card result = deck.drawCard();	//Result of drawCard method
		assertEquals(expected, result);	//Should be the same
		
		for(int i=0;i<5;i++)	//Draw 5 cards from the deck
			deck.drawCard();	//Essentially discarding the top 5 Cards from the Deck
		expected = new Card(Suit.CLUBS, Face.ACE);	//Should NOT equal this
		result = deck.drawCard();	//What the card is
		assertNotEquals(expected, result);	//Make sure these two things are not equal
		
		System.out.println("Test what happens when you try to draw a Card from an empty Deck");
		Deck deck2 = new Deck();	//Create a new Deck to test
		System.out.println(deck2.size());	//(52)
		while(!deck2.isEmpty())
			deck2.drawCard();
		System.out.println(deck2.size());	//Check the size of the deck (0)
		deck2.drawCard();
		deck2.drawCard();	//These should not fail
	}
	
	@Test
	public void testSize()
	{
		System.out.println("size()");
		/* When the constructor is called it creates a new Deck of 52
		 * Cards by default, so the size should be 52
		 */
		Deck deck = new Deck();
		int expected = 52;
		int result = deck.size();
		assertEquals(expected, result);
		
		Deck deck2 = new Deck();
		for(int i=0;i<50;i++)
			deck2.drawCard();	//Discard top 50 cards
		expected = 3;	//Should actually be 2
		result = deck2.size();
		assertNotEquals(expected, result);
	}
	
}
