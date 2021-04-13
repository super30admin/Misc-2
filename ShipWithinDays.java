// Time Complexity : The time complexity is O(nlog(high-low)) where n is the input array
// Space Complexity : Te space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int shipWithinDays(int[] weights, int D) {

        int low = 0;
        int high = 0;

        //find the range of days possible with the given weights
        for(int weight:weights){
            low = Math.max(low,weight);
            high += weight;
        }

        //binary search between the limit of days to find the optimal one
        while(low <= high){

            int mid = (high-low)/2 + low;
            int curD = 1;
            int curSum = 0;

            for(int weight:weights){
                if(curSum+weight > mid){
                    curSum = 0;
                    curD++;
                }
                curSum += weight;
            }

            if(curD > D){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return low;
    }
}