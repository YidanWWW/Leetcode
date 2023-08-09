import java.util.PriorityQueue;
import java.util.Arrays;

public class TopKSubsetSumsPriorityQueue {
    public static int[] findTopKSubsetSums(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Initialize the heap with the first element
        minHeap.add(0);

        for (int num : arr) {
            PriorityQueue<Integer> newHeap = new PriorityQueue<>(minHeap);
            for (int sum : minHeap) {
                newHeap.add(sum + num);
            }
            minHeap = newHeap;

            // Keep the size of the heap <= k
            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] topKSums = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            topKSums[i] = minHeap.poll();
        }

        return topKSums;
    }
        public static void main(String[] args) {
        int[] arr = {1,2,3,1000};
        int k = 4;
        int[] topKSums = findTopKSubsetSums(arr, k);
        System.out.println(Arrays.toString(topKSums));
    }
}