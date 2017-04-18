package mills.war;

public class Deck
{
	
	private static Queue deck = new Queue(52);
	
	/**
	 * Constructor. Initializes the deck when called
	 */
	public Deck()
	{	
		initialize();	//Fill the Deck with the default Cards (ACE-KING in all Suits (SPADES, HEARTS, DIAMONDS, CLUBS))
	}
	
	/**
	 * Fills the Queue object that represents the deck of cards with Card objects
	 */
	private void initialize()
	{
		for(int i=0;i<4;i++)		//Suits
			for(int j=2;j<15;j++)	//Faces
			{
				switch(i)
				{
					case 0:	//Spades
						deck.enqueue(new Card(Suit.SPADES, Face.getFace(j)));
						break;
					case 1:	//Hearts
						deck.enqueue(new Card(Suit.HEARTS, Face.getFace(j)));
						break;
					case 2:	//Clubs
						deck.enqueue(new Card(Suit.CLUBS, Face.getFace(j)));
						break;
					case 3:	//Diamonds
						deck.enqueue(new Card(Suit.DIAMONDS, Face.getFace(j)));
						break;
				}
			}
	}
	
	/**
	 * Shuffle the deck so the Cards are in random spots
	 */
	public void shuffle()
	{
		Card temp;
		int a;
		for(int i=0;i<10_000;i++)	//Shuffle 10 000 times to really shuffle the deck
			for(int j=0;j<size();j++)
			{
				a = (int)(Math.random() * size());	//Get a random number within the size
				temp = deck.getAt(j);				//Get the card at the current index
				deck.add(j, deck.getAt(a));			//Set the card at the current index to the Card at the random index
				deck.add(a, temp);					//Set the card at the random index to the Card at the current index
			}
		
	}
	
	/**
	 * Returns the Card at the 'top' of the deck and removes it from the deck
	 * @return Card at the 'top' of the deck
	 */
	public Card drawCard()
	{
		if(!isEmpty())
			return deck.dequeue();
		else
			return new Card(Suit.NULL, Face.NULL);
	}
	
	/**
	 * Returns how many Cards are in the deck
	 * @return int representing how many Card objects are in the deck
	 */
	public int size()
	{
		return deck.size();
	}
	
	/**
	 * Returns a String of all of the Card objects that are left in the Deck.
	 */
	@Override
	public String toString()
	{
		String output = "Deck:\n\n";
		
		if(size() == 0)
			return output + "The deck is empty";
		
		for(int i=0;i<deck.size();i++)
			output += deck.getAt(i) + "\n";
		
		return output;
	}

	/**
	 * Check whether or not this Deck has Cards in it
	 * @return	true if Cards are present, false otherwise
	 */
	public boolean isEmpty()
	{
		return deck.isEmpty();
	}
	
	/**
	 * Checks to see if this Deck is the same as deck. The Decks are only equal if they are the same size, and every card is in the same order.
	 * @param deck - Deck to compare to
	 */
	@Override
	public boolean equals(Object obj)
	{
		Deck deck = (Deck) obj;
		boolean result = false;	//Whether or not these two Decks are equal
		if(size() == deck.size())
		{
			for(int i=0;i<size();i++)
			{
				if(this.deck.getAt(i) == deck.deck.getAt(i))
					result = true;
				else
					return false;
			}
		}
		if(result)
			return true;
		else
			return false;
	}
	
}
