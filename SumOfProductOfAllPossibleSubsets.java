public class SumOfProductOfAllPossibleSubsets {
    public static int subsetSum(int[] arr){
        int n = arr.length;
        if(arr==null || n<0) return 0;
        int result = arr[0];
        for(int i=1;i<n;i++){
            result += arr[i] * (result+1);
        }
        return result;
    }
}

// TC - O(n)
// SC - O(1)
