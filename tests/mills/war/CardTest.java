package mills.war;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardTest {

	@Test
	public void testGetSuit()
	{
		System.out.println("getSuit()");
		Card card1 = new Card(Suit.SPADES, Face.FIVE);
		Suit expected = Suit.SPADES;
		Suit result = card1.getSuit();
		assertEquals(expected, result);
		
		Card card2 = new Card(Suit.CLUBS, Face.KING);
		Suit expected2 = Suit.DIAMONDS;
		Suit result2 = card2.getSuit();
		assertNotEquals(expected2, result2);
	}
	
	@Test
	public void testGetFace()
	{
		System.out.println("getFace()");
		Card card = new Card(Suit.CLUBS, Face.JACK);
		Face expected = Face.NINE;
		Face result = card.getFace();
		assertNotEquals(expected, result);
		
		Card card2 = new Card(Suit.SPADES, Face.EIGHT);
		expected = Face.EIGHT;
		result = card2.getFace();
		assertEquals(expected, result);
	}
	
	@Test
	public void testEquals()
	{
		System.out.println("equals()");
		Card card = new Card(Suit.DIAMONDS, Face.ACE);
		Card testAgainst = new Card(Suit.DIAMONDS, Face.ACE);
		boolean expected = true; //What equals should return
		boolean result = card.equals(testAgainst);
		assertEquals(expected, result);
		
		Card newCard = new Card(Suit.SPADES, Face.KING);
		Card test = new Card(Suit.DIAMONDS, Face.KING);
		expected = false;
		result = newCard.equals(test);
		assertEquals(expected, result);
		
		Card finalCard = new Card(Suit.CLUBS, Face.QUEEN);
		Card finalTest = new Card(Suit.CLUBS, Face.THREE);
		expected = false;
		result = finalCard.equals(finalTest);
		assertEquals(expected, result);
	}
	
	@Test
	public void testToString()
	{
		System.out.println("toString()");
		Card card = new Card(Suit.HEARTS, Face.FOUR);	//Create a new card to test
		String expected = Suit.HEARTS+": "+Face.FOUR;	//What the toString method should return
		String result = card.toString();	//What the toString method actually returns
		assertEquals(expected, result);		//These should be equal
		
		Card card2 = new Card(Suit.SPADES, Face.JACK);	//Create a new card to test
		expected = "Card: "+Suit.SPADES+": "+Face.JACK;	//Should NOT be this
		result = card2.toString();	//Result from the toString method
		assertNotEquals(expected, result);	//These should NOT be equal!
	}
	
	@Test
	public void testCompareTo()
	{
		System.out.println("compareTo()");
		Card card = new Card(Suit.CLUBS, Face.NINE);
		Card card2 = new Card(Suit.DIAMONDS, Face.NINE);
		int expected = 0;
		int result = card.compareTo(card2);
		assertEquals(expected, result);
		
		Card card3 = new Card(Suit.DIAMONDS, Face.KING);
		Card card4 = new Card(Suit.DIAMONDS, Face.ACE);
		expected = -1;
		result = card3.compareTo(card4);
		assertEquals(expected, result);
		
		Card card5 = new Card(Suit.SPADES, Face.EIGHT);
		Card card6 = new Card(Suit.HEARTS, Face.FIVE);
		expected = 1;
		result = card5.compareTo(card6);
		assertEquals(expected, result);
	}
	
}
