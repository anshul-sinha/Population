import java.util.ArrayList;
import java.util.List;

/**
 *	SortMethods - Sorts an array of City in ascending order.
 *
 *	@author Anshul Sinha
 *	@since	December 20, 2022
 */
public class SortMethods {
	
	/**
	 *	Bubble Sort algorithm - in ascending order
	 *	@param arr		array of City objects to sort
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
	 *	@param arr		array of City objects to sort
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
	 *	@param arr		array of City objects to sort
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
	 *	@param arr		array of City objects to sort
	 */
	public void mergeSort(List<City> arr) 
	{
		if (arr.size() >= 2) {
			int mid = arr.size() / 2;
			List<City> leftArr = new ArrayList<City>();

			List<City> rightArr = new ArrayList<City>();
			for (int i = 0; i < mid; i++) leftArr.add(arr.get(i));
			for (int i = mid; i < arr.size(); i++)
				rightArr.add(arr.get(i));
			mergeSort(leftArr);
			mergeSort(rightArr);
			int left = 0;
			int right = 0;
			int main = 0;
			while (left < leftArr.size() && right < rightArr.size()) {
				if (leftArr.get(left).compareTo(rightArr.get(right)) > 0) {
					arr.set(main, leftArr.get(left));
					left++;
					main++;
				}
				else {
					arr.set(main, rightArr.get(right));
					right++;
					main++;
				}
			}
			while (left < leftArr.size()) {
				arr.set(main, leftArr.get(left));
				left++;
				main++;
			}
			while (right < rightArr.size()) {
				arr.set(main, rightArr.get(right));
				right++;
				main++;
			}

		}
	}
	/**
	 * Uses merge sort to sort a list of cities
	 * @param arr	the list to sort
	 */
	public void mergeSortByName(List<City> arr) 
	{
		if (arr.size() >= 2) {
			int mid = arr.size() / 2;
			List<City> leftArr = new ArrayList<City>();

			List<City> rightArr = new ArrayList<City>();
			for (int i = 0; i < mid; i++) leftArr.add(arr.get(i));
			for (int i = mid; i < arr.size(); i++)
				rightArr.add(arr.get(i));
			mergeSortByName(leftArr);
			mergeSortByName(rightArr);
			int left = 0;
			int right = 0;
			int main = 0;
			while (left < leftArr.size() && right < rightArr.size()) {
				if (leftArr.get(left).compareByName(rightArr.get(right)) < 0) {
					arr.set(main, leftArr.get(left));
					left++;
					main++;
				}
				else {
					arr.set(main, rightArr.get(right));
					right++;
					main++;
				}
			}
			while (left < leftArr.size()) {
				arr.set(main, leftArr.get(left));
				left++;
				main++;
			}
			while (right < rightArr.size()) {
				arr.set(main, rightArr.get(right));
				right++;
				main++;
			}

		}
	}
	
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
		// se.run();
	}
	
	// public void run() {
	// 	// Integer[] arr = new Integer[10];
	// 	// Fill arr with random numbers
	// 	// for (int a = 0; a < 10; a++)
	// 	// 	arr[a] = (int)(Math.random() * 100) + 1;
	// 	// System.out.println("\nBubble Sort");
	// 	// System.out.println("Array before sort:");
	// 	// printArray(arr);
	// 	// System.out.println();
	// 	// bubbleSort(arr);
	// 	// System.out.println("Array after sort:");
	// 	// printArray(arr);
	// 	// System.out.println();
		
	// 	// for (int a = 0; a < 10; a++)
	// 	// 	arr[a] = (int)(Math.random() * 100) + 1;
	// 	// System.out.println("\nSelection Sort");
	// 	// System.out.println("Array before sort:");
	// 	// printArray(arr);
	// 	// System.out.println();
	// 	// selectionSort(arr);
	// 	// System.out.println("Array after sort:");
	// 	// printArray(arr);
	// 	// System.out.println();

		
	// 	// for (int a = 0; a < 10; a++)
	// 	// 	arr[a] = (int)(Math.random() * 100) + 1;
	// 	// System.out.println("\nInsertion Sort");
	// 	// System.out.println("Array before sort:");
	// 	// printArray(arr);
	// 	// System.out.println();
	// 	// insertionSort(arr);
	// 	// System.out.println("Array after sort:");
	// 	// printArray(arr);
	// 	// System.out.println();

	
	// 	Integer[] arr = {54, 26, 93, 17, 77, 31, 44, 55, 20};
	// 	System.out.println("\nMerge Sort");
	// 	System.out.println("Array before sort:");
	// 	printArray(arr);
	// 	System.out.println();
	// 	mergeSort(arr);
	// 	System.out.println("Array after sort:");
	// 	printArray(arr);
	// 	System.out.println();

	// }
}