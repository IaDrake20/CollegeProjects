// Class to do MergeSort and QuickSort on int arrays
// and test them
import java.util.Scanner;

public class MergeQuickSorts  {
	
	// Create a main to test MergeSort and QuickSort for 
	// three cases - Sorted Aray, Reverse Sorted Array, Random Array
	// Each array should be size 50
	// For the sorted array use the entries 1, 2, 3......50
	// For the reverse sorted array use the entries 50, 49, 48.....1
	// For the random array use ints between 1 and 50 inclusive, duplicates allowed
	
	// For each of the 6 sorts print the array before and after the sort
	// and show clearly which sort is being done
	
	public static void main(String[] args) {
		
		int[] testArraySorted = new int[50];
		int[] testReversedArraySorted = new int[50];
		int[] testRandomArray = new int[50];

		for(int i = 0; i < testArraySorted.length; i++){
			testArraySorted[i] = 1+i;
		}

		for(int i = 0; i < testReversedArraySorted.length; i++){
			testReversedArraySorted[i] = 50-i;
		}

		//System.out.println("----------------------------------------------------------");

		for(int i = 0; i < testRandomArray.length; i++){
			testRandomArray[i] = (int)(Math.random() * 51);
		}

		System.out.println("testArraySorted (non-reversed) in original form.");
		printArray(testArraySorted);

		System.out.println("Merge Sorting the sorted array.");
		mergeSort(testArraySorted);

		System.out.println("The result is...");
		printArray(testArraySorted);

		//System.out.println("Quick Sorting the sorted array.");
		//quickSort(testArraySorted);
		//System.out.println("The result is...");
		//printArray(testArraySorted);

		System.out.println("testReversedArraySorted in original form.");
		printArray(testReversedArraySorted);

		System.out.println("Merge Sorting the reverse sorted array.");
		mergeSort(testReversedArraySorted);

		System.out.println("The result is...");
		printArray(testReversedArraySorted);

		//System.out.println("Quick Sorting the reverse sorted array.");
		//quickSort(testReversedArraySorted);
		//System.out.println("The result is...");
		//printArray(testReversedArraySorted);

		System.out.println("testRandomArray in original form.");
		printArray(testRandomArray);

		System.out.println("Merge Sorting the random array.");
		mergeSort(testRandomArray);

		System.out.println("The result is...");
		printArray(testRandomArray);

		//System.out.println("Quick Sorting the random array.");
		//quickSort(testRandomArray);
		//System.out.println("The result is...");
		//printArray(testRandomArray);

		//Scanner foo = new Scanner(System.in);
		//foo.nextLine();

	}
	
	// Initial call to do a MergeSort 
	// Method is correct
	public static void mergeSort(int[] arr) {
		mergeSort(arr, 0, arr.length - 1);
	} 

	// This method will instantiate the tempArray which is used during the Merge
	// Method is correct
	public static void mergeSort(int[] arr, int first, int last) {
		int[] tempArray = new int[last - first + 1];
		mergeSort(arr, tempArray, first, last);
	}
	
	// Recursive method that does the MergeSort
	// MergeSort the part of arr which is between first and last
	// Correct error(s) in the method
	public static void mergeSort(int[] arr, int[] tempArray, int first, int last)  {
		if (first < last) { //first <= last
			int mid = (first + last)/2;

			mergeSort(arr, tempArray, first, mid);
			mergeSort(arr, tempArray, mid + 1, last);
			merge(arr, tempArray, first, mid, last);
		}
	}
	
	
	// Method to merge two consecutive parts of arr into one
	// Use tempArray to temporarily store the entries as the merge
	// occurs. Then the entries are copied back to arr
	// First subarray goes from first to mid
	// Second subarray goes from mid + 1 to last
	// After the method is completed the subarray from first to last is sorted
	// Correct error(s) in the method and fill gaps
	public static void merge(int[] arr, int[] tempArray, int first, int mid, int last) {
		int firstArrayBegin = first;
		int secondArrayBegin = mid+1;
		int tempArrayIndex = first;  // index that iterates through tempArray
		
		// Do the merge until one of the subarrays is exhausted 
		while (firstArrayBegin <= mid && secondArrayBegin <= last)  { //both <=

			if (arr[firstArrayBegin] <= arr[secondArrayBegin]) {

				tempArray[tempArrayIndex] = arr[firstArrayBegin];
				++firstArrayBegin;
			}
			else  {

				tempArray[tempArrayIndex] = arr[secondArrayBegin];
				++secondArrayBegin;

			}
			++tempArrayIndex;
		}
		
		// Empty the rest of first subarray (if it has any entries left)
		while (firstArrayBegin <= mid) {

			tempArray[tempArrayIndex] = arr[firstArrayBegin];
			++firstArrayBegin;
			++tempArrayIndex;

		}
		
		// Empty the rest of second subarray (if it has any entries left)
		while (secondArrayBegin <= last){

			tempArray[tempArrayIndex] = arr[secondArrayBegin];
			++secondArrayBegin;
			++tempArrayIndex;

		}
		
		// Copy the contents of the tempArray back to arr
		for (int index = first; index <= last; index++) 
			arr[index] = tempArray[index];
	}
	
	// Initial call to do a QuickSort
	// Method is correct
	public static void quickSort(int[] arr)
	{
		quickSort(arr, 0, arr.length - 1);
	}

	// QuickSort the part of arr which is between first and last
	// Correct error(s) in the method
	public static void quickSort(int[] arr, int first, int last) {
		if (last > first) {
			int pivotPosition = partition(arr, first, last);
			quickSort(arr, first, pivotPosition-1);
			quickSort(arr, pivotPosition+1, last);
		}
	}
		
	// Method to partition the subarray from first to last
	// using the median of three method
	// First sort the first, middle and last entries
	// Then swap the middle and last entries
	// and use the last entry as the pivot
	// Correct error(s) in the method and fill gaps
	public static int partition(int[] arr, int first, int last) {
		int mid = (first + last)/2;
		sort(arr, first, mid, last);
		swap(arr, mid, last);

		int pivot = arr[last]-1;
		int i = last -2;		// will move right looking for items that belong on the right
		int j = first +1;   // will move left looking for items that belong on the left
		
		while (i <= j) {
			while ((i <= j) && (arr[i] <= pivot)) {
				
				
				
			}
			while ((i <= j) && (arr[j] >= pivot)) {
				
				
				
			} 
			
			if (i < j) {
				
				
				
			}
		}
		swap(arr, j, last);
		return j;	
	}	
		
	// Write swap method to swap two entries in arr
	public static void swap(int[] arr, int index1, int index2) {
		int temp = index2;
		arr[index2] = index1;
		arr[index1] = temp;
		//return arr;	
	}
	
	// Write the sort method used in median of three partition
	public static void sort(int[] arr, int first, int mid, int last) {

		if(Math.max(first, mid) == first){
			int temp = first;
			first = mid;
			mid = temp;
		} else {
			//int temp = mid;
			//mid = first;
			//first = temp;
		}

		if(Math.max(mid, last) == last){
			int temp = mid;
			mid = last;
			last = temp;
		} else {
			int temp = last;
			last = mid;
			mid = temp;
		}

		if(Math.max(first, last) == first){
			int temp = first;
			first = last;
			last = temp;
		}





	}
	
	// Write a print method that prints the entries in the array on the same line
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++){
			System.out.print(i+" ");
		}
		System.out.println("\n");
	}
		
}
		
		
		