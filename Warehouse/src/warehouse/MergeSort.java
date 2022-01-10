package warehouse;


public class MergeSort 
{
    public static Comparable[] mergeSort(Comparable[] list) 
    {
        if (list.length <= 1) 
        {
            return list;
        }
         
        Comparable[] first = new Comparable[list.length / 2];
        Comparable[] second = new Comparable[list.length - first.length];
        System.arraycopy(list, 0, first, 0, first.length);
        System.arraycopy(list, first.length, second, 0, second.length);
         
        mergeSort(first);
        mergeSort(second); 
        
        merge(first, second, list);
        return list;
    }
     
    
    private static void merge(Comparable[] first, Comparable[] second, Comparable[] result) 
    {
        int i1 = 0;       
        int i2 = 0;       
        int m = 0;
         
        while (i1 < first.length && i2 < second.length) 
        {
            if (first[i1].compareTo(second[i2]) < 0) 
            {
                result[m] = first[i1];
                i1++;
            } 
            else
            {
                result[m] = second[i2];
                i2++;
            }
            m++;
        }
        System.arraycopy(first, i1, result, m, first.length - i1);
        System.arraycopy(second, i2, result, m, second.length - i2);
    }
}