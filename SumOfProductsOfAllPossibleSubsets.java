// Time Complexity = O(n)
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Here if the input is {a,b,c} we get the answer with a + b + c + ab + bc + ac
// There trick here to solve this question in O(n) time instead of recursion/0-1 knapsack approach is to
// add and subtract 1 from the formula.
// Therefore, a + b + c + ab + bc + ac + 1 - 1
// 1 + a + b + c + ab + bc + ac + abc - 1
// 1 + a + b + ab + c + ac + bc + abc - 1
// (1 + a) + b (1 + a) + c (1 + a) + bc (1 + a) - 1
// (1 + a) (1 + b + c + bc) - 1
// (1 + a) ((1 + b) + c (1 + b)) - 1
// (1 + a) (1 + b) (1 + c) - 1
import java.io.*;
import java.util.*;

class Solution {
    private static int sumOfProductsOfSubset(int[] arr) {
        if (arr == null || arr.length == 0) return 0;
        int result = 1;
        for (int i=0; i<arr.length; i++) {
            result *= (arr[i]+1);
        }
        result -= 1;
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(sumOfProductsOfSubset(arr));
    }
}