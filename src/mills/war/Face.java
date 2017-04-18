package mills.war;

public enum Face {

	/* ACES ARE HIGH */
	
	NULL(0), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13), ACE(14);
	
	private int value;
	
	/**
	 * Constructor
	 * @param val Value of the card
	 */
	Face(int val)
	{
		value = val;
	}
	
	/**
	 * Used to assign the correct Face when creating the cards
	 * @param value - integer representation of the face
	 * @return Face - that represents what face it should be. Defaults to null
	 */
	public static Face getFace(int value)
	{
		switch(value)
		{
			case 2:
				return TWO;
			case 3:
				return THREE;
			case 4:
				return FOUR;
			case 5:
				return FIVE;
			case 6:
				return SIX;
			case 7:
				return SEVEN;
			case 8:
				return EIGHT;
			case 9:
				return NINE;
			case 10:
				return TEN;
			case 11:
				return JACK;
			case 12:
				return QUEEN;
			case 13:
				return KING;
			case 14:
				return ACE;
			default:
				return NULL;
		}
	}
	
	/**
	 * Gets the value that the Face is worth (2 for TWO, 3 for THREE, etc)
	 * @return
	 */
	public int getValue()
	{
		return value;
	}
}
