// "static void main" must be defined in a public class.
// Given an array of n non-negative integers. The task is to find the sum of the product of elements of all the possible subsets. It may be assumed that the numbers in subsets are small and computing product doesn’t cause arithmetic overflow.

// Example :

// Input : arr[] = {1, 2, 3}

// Output : 23

// Possible Subset are: 1, 2, 3, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}

// Products of elements in above subsets : 1, 2, 3, 2, 3, 6, 6

// Sum of all products = 1 + 2 + 3 + 2 + 3 + 6 + 6 = 23



//TC:O(N)
//SC:O(1)
//Did it run successfully on Leetcode?:Yes
public class Main {
    public static void main(String[] args) {
       int[] arr = new int[]{1, 2, 3};
       System.out.println(getSumOfProductsOfAllSubsets(arr));
    }
    public static int getSumOfProductsOfAllSubsets(int[] arr){
        int product = 1;
        // If arr = [a,b,c], use the formula [(1+a)(1+b)(1+c)] - 1 
        // for sum of products of all possible subsets
        for (int n : arr){
            product = product * (1+n);
        }
        return product-1;
    }
}
