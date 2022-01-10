package warehouse;

/**
 *
 * @author Owner
 */
public class Warehouse<T> implements BagInterface<T>{
    T[] array1;
    T[] array2;
    T[] array3;
    int numberOfEntries;
    int days = 0;
    
    
    public Warehouse(T[] aisle) // default for 1 array
    {
       this.array1 = aisle;
       days = 0;
       
    }
    
    public Warehouse(T[] aisle1, T[] aisle2, T[] aisle3) // default for 3 arrays
    {
        this.array1 = aisle1;
        this.array2 = aisle2;
        this.array3 = aisle3;
        days = 0;
    }
    
    @Override
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        //int len = array1.length;
        return (numberOfEntries == 0);
            
    }

    @Override
    public boolean add(T newEntry) {
        boolean result = true;
            if (isFull())
            {
                    result = false;
            }
            else
            {  // assertion: result is true here
                    array1[numberOfEntries] = newEntry;
                    numberOfEntries++;
            } // end if

            return result;
    }

    @Override
    public T remove() {
        T result = removeEntry(numberOfEntries - 1);
		
        return result;
    }

    @Override
    public boolean remove(T anEntry) {
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
		
	return anEntry.equals(result);
    }

    @Override
    public void clear() {
        while (!isEmpty()) 
        remove();
    }

    @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;

              for (int index = 0; index < numberOfEntries; index++) 
              {
                      if (anEntry.equals(array1[index]))
                      {
                              counter++;
                      } // end if
              } // end for

              return counter;
    }

    @Override
    public boolean contains(T anEntry) {
        return getIndexOf(anEntry) > -1; // or >= 0
    }

    @Override
    public T[] toArray() {
    T[] result = (T[])new Object[numberOfEntries]; // unchecked cast

        for (int index = 0; index < numberOfEntries; index++) 
        {
                result[index] = array1[index];
        } // end for

        return result;
    }
    
    public boolean isFull() 
    {
            return numberOfEntries == array1.length;
    } // end isFull
    
    private T removeEntry(int givenIndex)
	{
		T result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = array1[givenIndex];               // entry to remove
         numberOfEntries--;
         array1[givenIndex] = array1[numberOfEntries]; // replace entry to remove with last entry
         array1[numberOfEntries] = null;            // remove reference to last entry
		} // end if
      
      return result;
	} // end removeEntry  

    private int getIndexOf(T anEntry) 
      {
              int where = -1;
              boolean found = false;

              for (int index = 0; !found && (index < numberOfEntries); index++) 
              {
                      if (anEntry.equals(array1[index]))
                      {
                              found = true;
                              where = index;
                      } // end if
              } // end for
        return where;
    }
    public int setThreshold()
    {
        int value = 0;
        return value;
    }
    public void restock()
    {
        
    }
    public static <T extends Comparable<? super T>> void mergeSort(T[] a, int first, int last)
    {
        T[] tempArray = (T[]) new Comparable<?>[a.length];
        mergeSort(a, tempArray, first, last);
    }
    
    private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tempArray, int first, int last)
    {
        if(first < last)
        {
            int mid = (first + last)/2;
            mergeSort(a, tempArray, first, mid);
            mergeSort(a, tempArray, mid+1, last);
            merge(a, tempArray, first, mid, last);
        }
        
    }
    
    private static <T extends Comparable<? super T>> void merge(T[] a, T[] tempArray, int first, int mid, int last)
    {
        int beginHalf = first;
        int endHalf = mid;
        int beginHalf2 = mid + 1;
        int endHalf2 = last;
        
        int index = 0;
        while((beginHalf <= endHalf) && (beginHalf2 <= endHalf2))
        {
            if (a[beginHalf].compareTo(a[beginHalf2]) <= 0)
            {
                tempArray[first+index] = a[beginHalf];
                beginHalf++;
            }
            else
            {
                tempArray[first+index] = a[beginHalf2];
                beginHalf2++;
            }
            index++;
        }
        
        while((beginHalf <= endHalf))
        {
            tempArray[first+index] = a[beginHalf];
            beginHalf++;
            index++;
        }
        
        while((beginHalf2 <= endHalf2))
        {
            tempArray[first+index] = a[beginHalf2];
            beginHalf2++;
            index++;
        }
        
        for(int i = first; i <= last; i++)
        {
            a[i] = tempArray[i];
        }
    }
}
   
