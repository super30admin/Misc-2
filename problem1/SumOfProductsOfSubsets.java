// Time Complexity : O(n), n -> Number of elements in the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class SumOfProductsOfSubsets {

	public int sumOfProducts(int[] nums) {
		if(nums == null || nums.length == 0) {
			return 0;
		}
		
		int ans = 1;
		
		for(int num: nums) {
			ans *= (1 + num); 
		}
		
		return ans - 1;
	}
	
	public static void main(String[] args) {
		SumOfProductsOfSubsets obj = new SumOfProductsOfSubsets();
		int[] nums = {1,2,3};
		
		System.out.println("Sum of products of subsets = " + obj.sumOfProducts(nums));
	}

}
