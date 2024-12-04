import java.util.Random;

public class SortTest {

    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        
        System.out.println("Size, Bubble Sort Time, Selection Sort Time, Insertion Sort Time, Merge Sort Time, Shell Sort Time, Quick Sort Time, Heap Sort Time"); 

        // Test on arrays of size 10k to 200k
        testSortingAlgorithms(sorter, 10000);
        testSortingAlgorithms(sorter, 20000);
        testSortingAlgorithms(sorter, 30000);
        testSortingAlgorithms(sorter, 40000);
        testSortingAlgorithms(sorter, 50000);
        testSortingAlgorithms(sorter, 60000);
        testSortingAlgorithms(sorter, 70000);
        testSortingAlgorithms(sorter, 80000);
        testSortingAlgorithms(sorter, 90000);
        testSortingAlgorithms(sorter, 100000);
        testSortingAlgorithms(sorter, 110000);
        testSortingAlgorithms(sorter, 120000);
        testSortingAlgorithms(sorter, 130000);
        testSortingAlgorithms(sorter, 140000);
        testSortingAlgorithms(sorter, 150000);
        testSortingAlgorithms(sorter, 160000);
        testSortingAlgorithms(sorter, 170000);
        testSortingAlgorithms(sorter, 180000);
        testSortingAlgorithms(sorter, 190000);
        testSortingAlgorithms(sorter, 200000);
    }

    /**
     * Helper method to test sorting algorithms with a given array size.
     */
    public static void testSortingAlgorithms(Sorter sorter, int size) {
        // Create and fill array with random integers
        int[] array = generateRandomArray(size);
        
        // Timings for each sorting algorithm
        long bubbleTime = 0, selectionTime = 0, insertionTime = 0;
        long mergeTime = 0, shellTime = 0, quickTime = 0, heapTime = 0;

        // Bubble Sort
        int[] bubbleArray = array.clone();
        long startTime = System.currentTimeMillis();  // Start time
        bubbleArray = sorter.bubbleSort(bubbleArray);
        long endTime = System.currentTimeMillis();    // End time
        bubbleTime = endTime - startTime;  // Time in milliseconds

        // Selection Sort
        int[] selectionArray = array.clone();
        startTime = System.currentTimeMillis();
        selectionArray = sorter.selectionSort(selectionArray);
        endTime = System.currentTimeMillis();
        selectionTime = endTime - startTime;

        // Insertion Sort
        int[] insertionArray = array.clone();
        startTime = System.currentTimeMillis();
        insertionArray = sorter.insertionSort(insertionArray);
        endTime = System.currentTimeMillis();
        insertionTime = endTime - startTime;

        // Merge Sort
        int[] mergeArray = array.clone();
        startTime = System.currentTimeMillis();
        mergeArray = sorter.mergeSort(mergeArray);
        endTime = System.currentTimeMillis();
        mergeTime = endTime - startTime;

        // Shell Sort
        int[] shellArray = array.clone();
        startTime = System.currentTimeMillis();
        shellArray = sorter.shellSort(shellArray);
        endTime = System.currentTimeMillis();
        shellTime = endTime - startTime;

        // Quick Sort
        int[] quickArray = array.clone();
        startTime = System.currentTimeMillis();
        quickArray = sorter.quickSort(quickArray);
        endTime = System.currentTimeMillis();
        quickTime = endTime - startTime;

        // Heap Sort
        int[] heapArray = array.clone();
        startTime = System.currentTimeMillis();
        heapArray = sorter.heapSort(heapArray);
        endTime = System.currentTimeMillis();
        heapTime = endTime - startTime;

        // Print results in CSV-like format
        System.out.printf("%d, %d, %d, %d, %d, %d, %d, %d%n", 
                          size, bubbleTime, selectionTime, insertionTime, 
                          mergeTime, shellTime, quickTime, heapTime);
    }

    /**
     * Validates if the array is sorted in ascending order.
     * 
     * @param array The array to validate
     * @return True if the array is sorted, false otherwise
     */
    public static boolean validate(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i]) {
                return false;  // Found a pair out of order
            }
        }
        return true;  // Array is sorted
    }

    /**
     * Generates an array of random integers of a given size.
     */
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200000);  // Random numbers between 0 and 200000
        }
        return array;
    }
}
