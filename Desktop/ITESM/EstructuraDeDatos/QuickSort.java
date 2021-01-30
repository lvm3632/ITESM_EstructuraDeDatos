import java.util.Arrays;

public class QuickSort {

    /**
     * Quick sort the given array in ascending order 
     * 
     * @param array
     */
    public void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }
    
    /**
     * Quick sort the given array starting from index 
     * {@code l} to {@code r} 
     * 
     * Uses the first element in the array as the pivot 
     * 
     * @param array
     * @param l
     * @param r
     */
    private void sort(int[] array, int l, int r) {
        if (l < r) {
            // select pivot element (left-most)  
            int pivot = array[l];
            // partition and shuffle around pivot 
            int i = l;
            int j = r;
            while (i < j) {
                // move right to avoid pivot element 
                i += 1;
                // scan right: find elements greater than pivot 
                while (i <= r && array[i] < pivot) {
                    i += 1;
                }
                // scan left: find elements smaller than pivot
                while (j >= l && array[j] > pivot) {
                    j -= 1;
                }
                if (i <= r && i < j) {
                    // swap around pivot  
                    swap(array, i, j);
                }
            }
            // put pivot in correct place
            swap(array, l, j);
            // sort partitions 
            System.out.println("Sorted: " + Arrays.toString(array));
            System.out.println("Valor de i: " + (i-1));
            sort(array, l, j - 1);
            sort(array, j + 1, r);
        }
    }
    
    /**
     * Swap elements at indexes {@code i} and {@code j}
     * in the give array 
     * 
     * @param array
     * @param i
     * @param j
     */
    private void swap(int[] array, int i, int j) {
        if (i >= 0 && j >= 0 && i < array.length && j < array.length) {
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }

    /**
     * Main method 
     * 
     * @param args
     */
    public static void main(String[] args) {
        int[] array = new int[] {
            3,8,2,5,1,4,7,6
        };
        
        new QuickSort().sort(array);
        System.out.println("Sorted: " + Arrays.toString(array));
    }

}