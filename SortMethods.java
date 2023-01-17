import java.util.List;

/**
 *	SortMethods - Sorts an array of Integers in ascending order.
 *
 *	@author 
 *	@since	
 */
public class SortMethods {
	
	/**
	 *	Bubble Sort algorithm - in ascending order
	 *	@param arr		array of Integer objects to sort
	 */
	public void bubbleSort(List<City> arr) {
			for (int outer = arr.size() - 1; outer > 0; outer--) {
				for (int inner = 0; inner < outer; inner++) {
					if (arr.get(inner).compareTo(arr.get(inner + 1)) > 0)
						swap(arr, inner, inner + 1);
				}
			}
	}
	
	/**
	 *	Swaps two Integer objects in array arr
	 *	@param arr		array of Integer objects
	 *	@param x		index of first object to swap
	 *	@param y		index of second object to swap
	 */
	private void swap(List<City> arr, int x, int y) {
		City temp = arr.get(x);
		arr.set(x, arr.get(y));
		arr.set(y, temp);
	}
	
	/**
	 *	Selection Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public List<City> selectionSort(List<City> array) {
		List<City> arr = array;
		for (int outer = 0; outer < arr.size() - 1; outer++) {
			int min = outer;
			for (int inner = outer + 1; inner < arr.size(); inner++) {
				if (arr.get(inner).compareTo(arr.get(min)) > 0) 
					min = inner;
			}
			swap(arr, outer, min);
		}
		return arr;
	}
	
	/**
	 *	Insertion Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public List<City> insertionSort(List<City> array) {
		List<City> arr = array;
		for (int outer = 0; outer < arr.size() - 1; outer++) {
			for (int inner = outer + 1; inner > 0; inner--) {
				if (arr.get(inner).compareByName(arr.get(inner - 1)) < 0) {
					swap(arr, inner, inner - 1);
				}
				else {
					inner = 0;
				}
			}
		}
		return arr;
	}
	
	/**
	 *	Merge Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void mergeSort(Integer [] arr) {}
	
	/*****************************************************************/
	/************************* For Testing ***************************/
	/*****************************************************************/
	
	/**
	 *	Print an array of Integers to the screen
	 *	@param arr		the array of Integers
	 */
	public void printArray(Integer[] arr) {
		if (arr.length == 0) System.out.print("(");
		else System.out.printf("( %4d", arr[0]);
		for (int a = 1; a < arr.length; a++) {
			if (a % 10 == 0) System.out.printf(",\n  %4d", arr[a]);
			else System.out.printf(", %4d", arr[a]);
		}
		System.out.println(" )");
	}

	public static void main(String[] args) {
		SortMethods se = new SortMethods();
		//se.run();
	}
	
// 	public void run() {
// 		Integer[] arr = new Integer[10];
// 		// Fill arr with random numbers
// 		for (int a = 0; a < 10; a++)
// 			arr[a] = (int)(Math.random() * 100) + 1;
// 		System.out.println("\nBubble Sort");
// 		System.out.println("Array before sort:");
// 		printArray(arr);
// 		System.out.println();
// 		bubbleSort(arr);
// 		System.out.println("Array after sort:");
// 		printArray(arr);
// 		System.out.println();
		
// 		for (int a = 0; a < 10; a++)
// 			arr[a] = (int)(Math.random() * 100) + 1;
// 		System.out.println("\nSelection Sort");
// 		System.out.println("Array before sort:");
// 		printArray(arr);
// 		System.out.println();
// 		selectionSort(arr);
// 		System.out.println("Array after sort:");
// 		printArray(arr);
// 		System.out.println();

		
// 		for (int a = 0; a < 10; a++)
// 			arr[a] = (int)(Math.random() * 100) + 1;
// 		System.out.println("\nInsertion Sort");
// 		System.out.println("Array before sort:");
// 		printArray(arr);
// 		System.out.println();
// 		insertionSort(arr);
// 		System.out.println("Array after sort:");
// 		printArray(arr);
// 		System.out.println();

// /*		
// 		for (int a = 0; a < 10; a++)
// 			arr[a] = (int)(Math.random() * 100) + 1;
// 		System.out.println("\nMerge Sort");
// 		System.out.println("Array before sort:");
// 		printArray(arr);
// 		System.out.println();
// 		mergeSort(arr);
// 		System.out.println("Array after sort:");
// 		printArray(arr);
// 		System.out.println();
// */
// 	}
}