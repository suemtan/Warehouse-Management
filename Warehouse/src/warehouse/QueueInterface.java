
package warehouse;

/**
 *
 * @author Owner
 */
public interface QueueInterface <T>{


	/* add a new entry to the back of the quet
	 * @param newEntry an object to be added
	 */
	public void enqueue(T newEntry);
	/* remove and return the entry at the front of the queue.
	 * @return the object at the front of the queue
	 */
	public T dequeue();
	/*retrive the entry at the front of this queue
	 * @return the object at the front of the queue or 
	 *                        null if the queue is empty 
	 */
	public T getFront();
	/* detect whether this queue is empty.
	 * @return True if the queue is empty or false otherwise
	 */
	public boolean isEmpty();
	/* removes all entries from the queue
	 */
	public void clear();
	public int TotalEntry();
	
}
