import java.util.Arrays;
import java.util.Random;

/**
 * Test class for verifying the functionality of different search algorithms.
 * Tests linear search, binary search, and binary search tree operations.
 */
public class SearchTester {
    
    /**
     * Main method to run the functionality tests.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Search searcher = new Search();
        
        // Create test array
        // Create array of 100 random integers between 0 and 100
        int[] array = new int[100];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101); // nextInt(101) gives numbers 0 to 100 inclusive
        }
        System.out.println("Original array: " + searcher.toString(array));
        
        // Test Linear Search
        System.out.println("\nTesting Linear Search:");
        testLinearSearch(searcher, array, 7);  // Should find
        testLinearSearch(searcher, array, 4);  // Should not find
        
        // Create sorted array for binary search
        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);
        System.out.println("\nSorted array: " + searcher.toString(sortedArray));
        
        // Test Binary Search
        System.out.println("\nTesting Binary Search:");
        testBinarySearch(searcher, sortedArray, 7);  // Should find
        testBinarySearch(searcher, sortedArray, 4);  // Should not find
        
        // Test BST
        System.out.println("\nTesting Binary Search Tree:");
        testBST(array);
    }
    
    /**
     * Tests the linear search algorithm
     *
     * @param searcher Search object containing the implementation
     * @param array Array to search in
     * @param value Value to search for
     */
    private static void testLinearSearch(Search searcher, int[] array, int value) {
        boolean found = searcher.linearSearch(array, value);
        System.out.println("Searching for " + value + ": " + 
                          (found ? "Found" : "Not found"));
    }
    
    /**
     * Tests the binary search algorithm
     *
     * @param searcher Search object containing the implementation
     * @param array Sorted array to search in
     * @param value Value to search for
     */
    private static void testBinarySearch(Search searcher, int[] array, int value) {
        boolean found = searcher.binarySearch(array, value, 0, array.length - 1);
        System.out.println("Searching for " + value + ": " + 
                          (found ? "Found" : "Not found"));
    }
    
    /**
     * Tests the Binary Search Tree implementation
     *
     * @param array Array of values to add to the tree
     */
    private static void testBST(int[] array) {
        BalanceTree bst = new BalanceTree();
        
        // Add values to BST
        for (int value : array) {
            bst.addValue(value);
        }
        
        // Print BST in pre-order
        System.out.println("BST elements (in pre-order):");
        bst.printPreOrder();
    }
}
