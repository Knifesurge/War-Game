package mills.war;

/**
 * Queue data structure
 * @author Nick Mills
 *
 */
public class Queue {

	private Card[] data;
	private int front, rear;
	private int maxSize;
	
	/**
	 * Constructor
	 */
	public Queue(int maxItems)
	{
		data = new Card[maxItems];
		front = -1;
		rear = -1;
		maxSize = maxItems;
	}
	
	/**
	 * Returns the front item without removing it from the queue.
	 * @return Card at the front of the queue
	 */
	public Card front()
	{
		return data[front];
	}
	
	/**
	 * Returns the item at the specified index without removing it from the queue.
	 * @return Card at the specified index
	 */
	public Card getAt(int index)
	{
		return data[index];
	}
	
	public void add(int index, Card obj)
	{
		data[index] = obj;
	}
	
	/**
	 * Removes the front item from the queue and returns it
	 * @return Card at the front of the queue
	 */
	public Card dequeue()
	{
		Card num;
		
		num = data[front];	//Get front item
		//if dequeuing last item make the queue empty
		if(front == rear)
			makeEmpty();
		else	//Move pointer to next item
			front = (front + 1) % maxSize;
		
		return num;
	}
	
	/**
	 * Adds an item to the queue if there is room
	 */
	public void enqueue(Card card)
	{
		if(isEmpty())	//First item queued
		{
			rear = 0;
			front = 0;
			data[rear] = card;
		} else
		{
			rear = (rear + 1) % maxSize;
			data[rear] = card;
		}
	}
	
	/**
	 * Determines if there are items on the queue
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty()
	{
		if(front == -1 && rear == -1)
			return true;
		else
			return false;
	}
	
	/**
	 * Returns the number of items in the queue
	 * @return int representation of how many items are in the queue
	 */
	public int size()
	{
		if(isEmpty())
			return 0;
		else	
			if(rear > front)			//Front item is "in front" of rear item
				return rear - front + 1;
			else if(front == rear + 1)	//Queue is full
				return maxSize;
			else						//front item is "behind" rear item
				return front - rear + 1;
	}
	
	/**
	 * Empties the queue
	 */
	public void makeEmpty()
	{
		front = -1;
		rear = -1;
	}
}
