package amazon;
/**
 * Count of subarrays starting or ending at an index i such that arr[i] is maximum in subarray
 * Input: arr[] = {3, 4, 1, 6, 2}
 * Output: 1 3 1 5 1
 */
// Java program for the above approach
import java.util.*;

public class GFG {

	// Function to find previous greater
	// element
	private static int[] getPGE(int[] arr)
	{
		// Stores the previous greater
		// element for each index
		int[] pge = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		// Traverse the array
		for (int i = 0; i < arr.length; i++) {

			// Iterate until stack is empty
			// and top element is less than
			// the current element arr[i]
			while (!stack.isEmpty()
				&& arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}

			// Update the previous greater
			// element for arr[i]
			pge[i] = stack.isEmpty() ? -1 : stack.peek();

			// Push the current index to
			// the stacl
			stack.push(i);
		}

		// Return the PGE[] array
		return pge;
	}

	// Function to find the Next Greater Element
	private static int[] getNGE(int[] arr)
	{
		// Stores the next greater element
		// for each index
		int[] nge = new int[arr.length];
		Stack<Integer> stack = new Stack<>();

		// Traverse the array from the back
		for (int i = arr.length - 1; i >= 0; i--) {

			// Iterate until stack is empty
			// and top element is less than
			// the current element arr[i]
			while (!stack.isEmpty()
				&& arr[stack.peek()] <= arr[i]) {
				stack.pop();
			}

			// Update the next greater
			// element for arr[i]
			nge[i] = stack.isEmpty() ? arr.length
									: stack.peek();

			// Push the current index
			stack.push(i);
		}

		// Return the NGE[] array
		return nge;
	}

	// Function to find the count of
	// subarrays starting or ending at
	// index i having arr[i] as maximum
	private static void countSubarrays(int[] arr)
	{

		// Function call to find the
		// previous greater element
		// for each array elements
		int[] pge = getPGE(arr);

		// Function call to find the
		// previous greater element
		// for each elements
		int[] nge = getNGE(arr);

		// Traverse the array arr[]
		for (int i = 0; i < arr.length; i++) {

			// Print count of subarrays
			// satisfying the conditions
			System.out.print(
				nge[i] - pge[i] - 1 + " ");
		}
	}

	// Driver Code
	public static void main(String[] args)
	{
		int[] arr = new int[] { 3, 4, 1, 6, 2 };
		countSubarrays(arr);
	}
}
