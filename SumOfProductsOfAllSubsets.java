// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use formula to calculate - (1+a)*(1+b)*(1+c)* ...(1*x) - 1
// This link for more details - https://www.geeksforgeeks.org/sum-products-possible-subsets/
class Subset{
    public static void main(String args[]){
        int[] arr = {1,2,3};
        System.out.println(sumOfProduct(arr));
    }
    public static int sumOfProduct(int[] arr){
        int ans = 1;
        for(int x: arr){
            ans *= (x+1);
        }
        return ans-1;
    }
}