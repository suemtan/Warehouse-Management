
package warehouse;

/**
 *
 * @author Owner
 */
public class ArrayQueueBag<T> implements QueueInterface<T> {


	private T[] queue;
	private int frontIndex;
	private int backIndex;
	private int count;
	private static final int CAPACITY = 50;
	
	public ArrayQueueBag()
	{
		this(CAPACITY);
	}
	public ArrayQueueBag(int cap)
	{
		
		queue = (T[]) new Object[cap + 1]; //1 for unused location
		count =0;
		frontIndex =0;
		backIndex = cap;
	}
        @Override
	public int TotalEntry()
	{
		//how many items/index in the queue
		return count; // for unused location
	}
	
        @Override
	public void enqueue(T newEntry)
	{
		if(isArrayFull())
			expandArray();
		
		
		backIndex = (backIndex +1) % queue.length;
		queue[backIndex] = newEntry;
		//System.out.println("count is "+ count);
		count++;
		
		
	}
        @Override
	public T dequeue()
	{
		T temp = null;
		if(!isEmpty())
		{
			temp = queue[frontIndex];
			queue[frontIndex] = null;
			
			frontIndex = (frontIndex +1) % queue.length;
		}
		return temp;
	}
        @Override
	public T getFront()
	{
		T temp = null;
		
		if(!isEmpty())
		{
			temp = queue[frontIndex];
		}
		return temp;
	}
        @Override
	public void clear()
	{
		if(!isEmpty())
		{
			for(int i = frontIndex; i != backIndex; i = (i+1) % queue.length)
			{
				queue[i] = null;
			}
			queue[backIndex] = null;
		}
		frontIndex =0;
		backIndex = queue.length -1;
		
		
	}
	private boolean isArrayFull()
	{
		return frontIndex == (backIndex + 2) % (queue.length-1);
	}
        @Override
	public boolean isEmpty()
	{
		return (count ==0);
	}
	
	private void expandArray(){
		T[] oldQueue = queue;
		int osize = oldQueue.length;
		
		queue = (T[]) new Object[2 * osize];
		
		for(int i=0; i < osize -1; i++)
		{
			queue[i]= oldQueue[frontIndex];
			frontIndex = (frontIndex + 1) % osize;
		}
		frontIndex =0;
		backIndex =(frontIndex + 1) % osize;
		
		
	}
}
