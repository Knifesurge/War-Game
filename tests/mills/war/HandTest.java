package mills.war;

import org.junit.Test;

import static org.junit.Assert.*;

public class HandTest {

	@Test
	public void testAddCard()
	{
		System.out.println("addCard()");	// Output which method we are testing
		Hand hand = new Hand("name", 1);	//Create a new hand to test
		Card toAdd = new Card(Suit.SPADES, Face.ACE);	//Create a new card
		hand.addCard(toAdd);	//Add this new card to the hand
		Card expected = toAdd;	//Expected card
		Card result = hand.playCard();	//Actual card
		assertEquals(expected, result);	//Make sure they are the same card
		
		// Create a new hand and 3 new Cards
		Hand hand2 = new Hand("deck", 3);
		Card card1 = new Card(Suit.DIAMONDS, Face.KING);
		Card card2 = new Card(Suit.CLUBS, Face.FIVE);
		Card card3 = new Card(Suit.HEARTS, Face.SEVEN);
		
		/* Fill the new hand with Cards */
		hand2.addCard(card1);
		hand2.addCard(card2);
		hand2.addCard(card3);
		hand2.playCard();	//Takes the top off so we can access the second card
		
		/*Should be this card (Can't make a new card since it will fail).
		 * However in the War game this will never be a problem because there is only 
		 * one of each card*/
		expected = card2;
		result = hand2.playCard();	//It is actually this card
		assertEquals(expected, result);	//Make sure they are the same card
	}
	
	@Test
	public void testPlayCard()
	{
		System.out.println("playCard()");
		Hand hand = new Hand("name", 1);	//Create Hand to test
		hand.addCard(new Card(Suit.CLUBS, Face.QUEEN));	//Create a new card and add it to the deck
		Card expected = new Card(Suit.CLUBS, Face.QUEEN);	//Expected card when removeCard() is called
		Card result = hand.playCard();	//Actual card when removeCard() is called
		assertEquals(expected, result);	//Make sure these are equal (they should be!)
		
		Hand hand2 = new Hand("name", 5);
		Card card = new Card(Suit.SPADES, Face.FIVE);
		hand2.addCard(new Card(Suit.CLUBS, Face.FOUR));
		hand2.addCard(new Card(Suit.DIAMONDS, Face.EIGHT));
		hand2.addCard(card);
		
		expected = new Card(Suit.DIAMONDS, Face.EIGHT);
		result = hand2.playCard();
		assertNotEquals(expected, result);
	}
	
	@Test
	public void testSize()
	{
		System.out.println("size()");	//Size refers to not its capacity but to how many Cards are in the Hand
		Hand hand = new Hand("hand", 17);	//Create a new hand to test
		hand.addCard(new Card(Suit.CLUBS, Face.SEVEN));	//Add a card to the hand
		hand.addCard(new Card(Suit.DIAMONDS, Face.EIGHT));	//Add another card to the hand
		int expected = 2;	//Expected size of the hand
		int result = hand.size();	//Actual size of the hand
		assertEquals(expected, result);	//Make sure these are the same
		
		Hand hand2 = new Hand("new Hand", 5);	//Create a new hand
		expected = 3;	//should NOT be this number
		for(int i=1;i<5;i++)	//Add 4 new cards to the hand
			hand2.addCard(new Card(Suit.HEARTS, Face.getFace(i)));
		result = hand2.size();
		assertNotEquals(expected, result);	//Make sure they are NOT the same
	}	
}
