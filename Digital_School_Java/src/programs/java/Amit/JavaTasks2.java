package programs.java.Amit;


import java.util.*;

public class JavaTasks2 {

    // 6. Find Duplicate Elements in an Array using HashSet
    public static void findDuplicates(int[] array) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> duplicates = new HashSet<>();
        for (int num : array) {
            if (!seen.add(num)) {   //returns true if it add in "seen" variable.If its duplicate values,returns false.hence reverse to this condition applied !
                duplicates.add(num);
                
            }
        }
        System.out.println("Duplicate elements: " + duplicates);
    }

    // 7. Count Character Occurrences in a String using HashMap
    public static void countCharOccurrences(String input) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        System.out.println("Character occurrences:");
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    // 8. Merge Two Arrays
    public static void mergeArrays(int[] arr1, int[] arr2) {
    	//System.arraycopy(sourceArray, sourceStartIndex, destinationArray, destinationStartIndex, numberOfElements);
    	
        int[] merged = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, merged, 0, arr1.length);
        System.arraycopy(arr2, 0, merged, arr1.length, arr2.length);
        System.out.println("Merged array: " + Arrays.toString(merged));
    }
    
    public static void mergeArraysNormal(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];

        // Copy elements from arr1
        for (int i = 0; i < arr1.length; i++) {
            merged[i] = arr1[i];
        }

        // Copy elements from arr2
        for (int i = 0; i < arr2.length; i++) {
            merged[arr1.length + i] = arr2[i];
        }

        // Print the merged array
        System.out.println("Merged array: " + Arrays.toString(merged));
    }
    
 // 9. Find the Second Largest Element in an Array
    public static void findSecondLargestBySorting(int[] array) {
        if (array.length < 2) {
            System.out.println("Array must contain at least two elements.");
            return;
        }

        Arrays.sort(array); // Sorts in ascending order
        int largest = array[array.length - 1];

        // Traverse backwards to find the second largest distinct element
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] != largest) {
                System.out.println("Second largest element: " + array[i]);
                return;
            }
        }

        System.out.println("No second largest element found.");
    }
    
    // 10. Remove Duplicates from a List
    public static void removeDuplicatesFromList(List<String> list) {
        Set<String> unique = new LinkedHashSet<>(list);
        System.out.println("List after removing duplicates: " + new ArrayList<>(unique));
    }


public static void removeDuplicatesFromListHashSet(List<String> list) {
        Set<String> uniqueSet = new HashSet<>(list); // Removes duplicates, but does NOT preserve order
        System.out.println("List after removing duplicates: " + uniqueSet);
    }


    public static void main(String[] args) {
        // Task 6
        int[] arrayWithDuplicates = {1, 2, 3, 2, 4, 5, 1};
        findDuplicates(arrayWithDuplicates);

        // Task 7
        countCharOccurrences("programming");

        // Task 8
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        mergeArrays(arr1, arr2);
        mergeArraysNormal(arr1, arr2);


        // Task 9
        int[] arrayForSecondLargest = {10, 20, 4, 45, 99, 99};
        findSecondLargestBySorting(arrayForSecondLargest);

        // Task 10
        List<String> stringListWithDuplicates = Arrays.asList("Apple", "Banana", "Apple", "Cherry", "Banana");
        removeDuplicatesFromList(stringListWithDuplicates);
        removeDuplicatesFromListHashSet(stringListWithDuplicates);
    }
}
