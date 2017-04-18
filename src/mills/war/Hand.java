package mills.war;

public class Hand {

	private String name = "hand";
	private Queue hand;
	public int MAX_SIZE;
	
	public Hand(String n, int startSize)
	{
		name = n;
		hand = new Queue(startSize);
		MAX_SIZE = startSize;
	}
	
	/**
	 * Returns the Card at the 'front' of the hand, but doesn't remove it
	 * @return Card at the 'front' of the hand
	 */
	public Card peekCard()
	{
		return hand.front();
	}
	
	/**
	 * Adds a Card object to the bottom of the hand
	 * @param c	-	Card object to add to the bottom of the hand
	 */
	public void addCard(Card c)
	{
		hand.enqueue(c);
	}
	
	/**
	 * Returns the Card at the 'top' of the hand
	 * @return	Card object at the 'top' of the hand
	 */
	public Card playCard()
	{
		return hand.dequeue();
	}
	
	/**
	 * Returns how many Cards are in the hand
	 * @return int representing how many cards are in the hand
	 */
	public int size()
	{
		return hand.size();
	}
	
	public Card getAt(int i)
	{
		return hand.getAt(i);
	}
	
	/**
	 * Empties this hand
	 */
	public void makeEmpty()
	{
		hand.makeEmpty();
	}
	
	/**
	 * Checks if the hand is empty
	 * @return boolean true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		return hand.isEmpty();
	}
	
	public String getName()
	{
		return name;
	}
	
	@Override
	public String toString()
	{
		String output = "\n" + name + "'s hand:\n\n";
		
		for(int i=0;i<size();i++)
			output += hand.getAt(i) + "\n";
		
		return output;
	}
}
