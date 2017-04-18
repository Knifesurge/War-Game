package mills.war;

public class Card implements Comparable<Card>{

	Suit suit;
	Face face;
	
	/**
	 * Constructor to create a new Card.
	 * @param s	Suit of the Card
	 * @param f Face of the Card
	 */
	public Card(Suit s, Face f)
	{
		suit = s;
		face = f;
	}
	
	/**
	 * Returns this Card's Suit
	 * @return The Suit of this Card
	 */
	public Suit getSuit()
	{
		return suit;
	}
	
	/**
	 * Returns this card's Face
	 * @return The Face of this Card
	 */
	public Face getFace()
	{
		return face;
	}
	
	/**
	 * Returns this object represented as a String.
	 */
	@Override
	public String toString()
	{
		return getSuit() + ": " + getFace(); 
	}

	/**
	 *	Compares this object with another object to see if they are equal.
	 *	@return True if they have same face and suit, false otherwise
	 */
	@Override
	public boolean equals(Object obj)
	{
		Card card = (Card) obj;
		if(getSuit() == card.getSuit())
			if(getFace() == card.getFace())
				return true;
		return false;
	}

	/**
	 * UNUSED
	 */
	@Override
	public int compareTo(Card card) {
		if(getFace().getValue() > card.getFace().getValue())
			return 1;										//This Card is greater than the specified Card
		if(getFace().getValue() < card.getFace().getValue())
			return -1;										//This Card is less than the specified Card
		else
			return 0;										//Cards are equal 

	}
}
