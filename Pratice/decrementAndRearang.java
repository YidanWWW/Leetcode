class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        //1,1,2,2,2
        //-1 or rearrange
        int res = 0;
        if(arr[0]!=1) arr[0] = 1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i]-arr[i-1]>1) {
                arr[i] = arr[i-1]+1;
            }
        }

        return arr[arr.length-1];
    }
}