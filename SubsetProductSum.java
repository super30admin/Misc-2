// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
public class Subset
{

    static int productOfSubsetSums(int arr[], int n)
    {
        int ans = 1;
        for (int i = 0; i < n; ++i )
            ans = ans * (arr[i] + 1);
        return ans-1;
    }
}
