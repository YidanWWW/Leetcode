package sf;
/*
 * Given an array of positive integers, 
 * find maximum possible value K such that 
 * the array has at-least K elements that are greater than or equal to K. 
 * The array is unsorted and may contain duplicate values.
 */

import java.util.*;


public class MaxValueK
{
static int findMaximumNum(int[] arr)
{
    //2,3,4,5,7,7,7,8,10
	int n = arr.length;
	int[] freq = new int[n];
	Arrays.sort(arr);
	//2,3,4,7,8
	for(int i=0; i<n; i++) {
	    if(i>0 && arr[i]==arr[i-1]) {
	        freq[i] = freq[i-1];
	    }else {
	        freq[i] = (n-i);
	    }
	}
	int res = -1;
	for(int i=0; i<n; i++) {
	    if(freq[i] >= arr[i]) res = arr[i];
	}
	return res;
}

// Driver code
public static void main (String[] args)
{
int arr[] = {4, 7, 2, 3, 8};
int n = arr.length;
System.out.println(findMaximumNum(arr));
}
}


