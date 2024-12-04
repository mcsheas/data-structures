/**
 * A class that implements various sorting algorithms and tracks the number of swaps performed.
 * Each sorting method takes an unsorted array and returns a sorted array in ascending order.
 */
public class Sorter {
    private int swaps; //global swap counter 
    
    /**
     * Sorts an array using bubble sort algorithm.
     * Repeatedly steps through the array, compares adjacent elements and swaps them if they're in the wrong order.
     * 
     * @param array The array to be sorted
     * @return The sorted array
     */
    public int[] bubbleSort(int[] array) {
        swaps = 0;  // reset swap count
        while (true) {
            boolean swapped = false;    // keep track if we made any swaps in this pass
            // look at each pair of numbers
            for (int i = 0; i < array.length - 1; i++) {
                // If the left number is bigger than right number
                if (array[i] > array[i + 1]) {
                    // Swap the numbers
                    int temp = array[i];               // store left number temporarily
                    array[i] = array[i + 1];           // move right number to left position
                    array[i + 1] = temp;               // put temporarily stored number in right position
                    swaps++;                           // increase swap counter 
                    swapped = true;                    // mark that a swap was made 
                }
            }
            // if no swaps, the array is sorted
            if (!swapped) {
                break;
            }
        }
        return array;
    }
    
    /**
     * Sorts an array using selection sort algorithm.
     * Finds the minimum element in unsorted portion and places it at the beginning.
     * 
     * @param array The array to be sorted
     * @return The sorted array
     */
    public int[] selectionSort(int[] array) {
        swaps = 0;  // reset swap count
        
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;  //holds the number at the position we are currently at 
            
            // looks through rest of array to find smallest number
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;  // holds where we found smaller number
                }
            }
            
            // if a smaller number was found, swap it 
            if (minIndex != i) {
                int temp = array[i];                // temporarily stores current number
                array[i] = array[minIndex];         // puts the smallest number that the current position
                array[minIndex] = temp;             // puts the temporarily stored number where smallest was
                swaps++;                           // marks that a swap was made 
            }
        }
        return array;
    }
    
    /**
     * Sorts an array using insertion sort algorithm.
     * Builds the final sorted array one item at a time.
     * 
     * @param array The array to be sorted
     * @return The sorted array
     */
    public int[] insertionSort(int[] array) {
        swaps = 0;  //reset swap counter 

        // starts at second element
        for (int i = 1; i < array.length; i++) {
            int curr = array[i];  // holds current number
            int j = i - 1;        // looks at the number before the current
            
            // shfts larger elements to the right
            while (j >= 0 && array[j] > curr) {
                array[j + 1] = array[j];  // shift number right
                    j--;                  // looks at next number to left
                swaps++;                  // mark that a swap was made 
            }

            array[j + 1] = curr;  // put current number in its right spot
        }
        return array;
    }
    
    /**
     * Sorts an array using merge sort algorithm.
     * Divides array into smaller subarrays, sorts them, and merges them back.
     * 
     * @param array The array to be sorted
     * @return The sorted array
     */
    public int[] mergeSort(int[] array) {
        swaps = 0;  //reset swap counter
        return mergeSortRecursive(array, 0, array.length - 1);
    }

    /**
     * Helper method that recursively divides and sorts array segments.
     */
    private int[] mergeSortRecursive(int[] array, int left, int right) {
        // if the segment is just one number, it's already sorted
        if (left >= right) {
            return new int[]{array[left]};
        }
        // find the middle point
        int mid = (left + right) / 2;

        // sort left and right halves
        int[] leftArray = mergeSortRecursive(array, left, mid);
        int[] rightArray = mergeSortRecursive(array, mid + 1, right);

        // combine sorted halves
        return merge(leftArray, rightArray);
    }

    /**
     * Merges two sorted arrays into one sorted array.
     */
    private int[] merge(int[] left, int[] right) {
        // create array with a size of the combined lengths
        int[] merged = new int[left.length + right.length];
        //position trackers in each array
        int i = 0;
        int j = 0;
        int k = 0;  
    
        // compare and merge the numbers from both arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];  // take from left array
            } else {
                merged[k++] = right[j++];  // take from right array
                swaps++;                   // mark that a swap was made
            }
        }
        
        // adds any remaining numbers from left array
        while (i < left.length) {
            merged[k++] = left[i++];
        }
        
        // adds any remaining numbers from right array
        while (j < right.length) {
            merged[k++] = right[j++];
        }
        
        return merged;
    }
    
    /**
     * Sorts an array using shell sort algorithm.
     * Improves on insertion sort by comparing elements far apart.
     * 
     * @param array The array to be sorted
     * @return The sorted array
     * 
     * Algorithm explained based on research from GeeksforGeeks:
     * https://www.geeksforgeeks.org/time-complexities-of-all-sorting-algorithms/
     */
    public int[] shellSort(int[] array) {
        swaps = 0;  //resets swap counter 
        int n = array.length;
        //starts with a large gap then reduces the gap size in each iteration
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // does an insertion sort on elements that are "gap" distance apart 
            for (int i = gap; i < n; i++) {
                int temp = array[i]; // temporarily store the current number 
                int j;
                
                //compares the numbers that are a "gap" apart and shifts elements that are greater than the temp
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];  // shifts larger number to the right  
                    swaps++;                    // mark that a swap was made
                }
                array[j] = temp;  // put the temporarily stored number in the correct position within the sorted part
            }
        }
        return array;
    }
    
    /**
     * Sorts an array using quick sort algorithm.
     * Picks a 'pivot' element and partitions array around it.
     * 
     * @param array The array to be sorted
     * @return The sorted array
     * 
     * Algorithm explained based on research from GeeksforGeeks:
     * https://www.geeksforgeeks.org/time-complexities-of-all-sorting-algorithms/
     */
    public int[] quickSort(int[] array){
        // create a stack to simulate recursion and track subarrays to sort
        int[] arr = new int[array.length];
        int top = 0;  //pointer to the top of the stack 
        int low = 0;  // starting index of the array
        int high = array.length-1;  // ending index of the array
        
        // push the initial bouds of the array onto the stack 
        arr[top] = low; // push the lower bound
        top++;
        arr[top] = high; // push the upper bound
        top++;
        
        // continue sorting while there are subarrays to sort
        while(top > 0){
            // Pop the upper and lower bounds of a subarray
            top--;
            high = arr[top]; //get the upper bound
            top--;
            low = arr[top]; //get the lower bound 
            
            //check whether the subarray has more than one element
            if(low < high){
                // Partition array and get pivot index
                int cvi = seperate(array, low, high);
                
                // if there are elements on left side of pivot
                if(cvi-1 > low){
                    // Push left subarray bounds onto the stack
                    arr[top] = low;
                    top++;
                    arr[top] = cvi-1;
                    top++;
                }
                
                // if there are elements on right side of pivot
                if(cvi+1 < high){
                    // Push right subarray bounds onto the stack
                    arr[top] = cvi+1;
                    top++;
                    arr[top] = high;
                    top++;
                }
            }
        }
        return array;
    }
    
    /**
     * Helper method for quickSort that partitions the array around a pivot element.
     * Elements smaller than the pivot are moved to the left, and elements greater are moved to the right.
     * 
     * @param array The array to be partitioned
     * @param low The starting index of the subarray
     * @param high The ending index of the subarray
     * @return The index of the pivot element after partitioning
     */
    private int seperate(int[] array, int low, int high) {
        int cv = array[high];  // select last element as the pivot
        int x = low - 1;       // partition index to one before the start 
    
        // loops through the subarray from low to high - 1
        for (int i = low; i < high; i++) {
            // if current element is smaller than pivot
            if (array[i] <= cv) {
                x++;  // Move the partition index forward
                
                // Swap current element with element at the element at partition index
                int temp = array[x];
                array[x] = array[i];
                array[i] = temp;
                swaps++; //mark that a swap was made
            }
        }
        
        // swaps the pivot element with the element at the partition index + 1
        int temp = array[x + 1];
        array[x + 1] = array[high];
        array[high] = temp;
        swaps++; //mark that a swap positiom was made
        return x + 1;  // return the index of the pivot
    }

    /**
     * Sorts an array using heap sort algorithm.
     * Creates a heap structure and repeatedly extracts the maximum.
     * 
     * @param array The array to be sorted
     * @return The sorted array
     * 
     * Algorithm explained based on research from GeeksforGeeks:
     * https://www.geeksforgeeks.org/time-complexities-of-all-sorting-algorithms/
     */
    public int[] heapSort(int[] array) {
        swaps = 0;  // resets swap counter 
        int n = array.length;

        // create max heap from array
        // starts from the last non-leaf node and heapify each node in reverse level order
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // extracts elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // move current root (largest element) to end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            swaps++; //mark that a swap was made

            // Reduce the size of the heap and heapify the root to restore the max heap property
            heapify(array, i, 0);
        }
        return array;
    }

    /**
     * Helper method to maintain the max heap property.
     * Ensures that the subtree rooted at index `i` is a valid max heap.
     *
     * @param array The array representing the heap
     * @param n The size of the heap
     * @param i The index of the root of the subtree to heapify
     */
    private void heapify(int[] array, int n, int i) {
        int largest = i;      // initializes the largest number as root
        int left = 2*i + 1;   // index of left child
        int right = 2*i + 2;  // index of right child
        
        // if left child is larger than root
        if (left < n && array[left] > array[largest]) {
            largest = left; //update the largest to the left child
        }
        // if right child is larger than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right; //update the largest to the right child
        }
        
        // if largest is not root
        if (largest != i) {
            // swap root with largest element 
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;
            swaps++; //mark that a swap was made
            // recursively heapify the affected subtree to maintain the max heap property
            heapify(array, n, largest);
        }
    }

    /**
     * Gets the total number of swaps performed in the last sort operation.
     * 
     * @return Number of swaps
     */
    public int getSwapCount(){
        return swaps;
    }
    
    /**
     * Converts an array to a readable string format.
     * 
     * @param array The array to convert
     * @return String representation of the array
     */
    public String toString(int[] array) {
        String a = "[ ";  // Start with opening bracket
        // Add each number with comma
        for (int i = 0; i < array.length; i++) {
            a += array[i];
            if (i < array.length - 1) {
                a += ", ";  // Add comma after all but last number
            }
        }
        a += " ]";  // End with closing bracket
        return a;
    }
}
