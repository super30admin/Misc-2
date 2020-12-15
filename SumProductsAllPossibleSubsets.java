// Time Complexity : O(n)
// Space Complexity : O(n) n: number of characters in the order
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Formula: [a,b,c] = (1+a) * (1+b) * (1+c) - 1  

static int productOfSubsetSums(int arr[], int n) { 
        int result = 1; 
        for (int i = 0; i < n; ++i ) 
            result = result * (arr[i] + 1); 
        return ans-1; 
    } 
