//Time complexity: O(n)
// Space complexity; O(1)
public class SumOfSubsets {
    public int subsetSum(int[] arr){
        int product=1;
        for(int i=0;i<arr.length;i++)
        {
            product*=(1+arr[i]);
        }
        return product-1;
    }
    
}
