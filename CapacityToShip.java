/*
variation of binary search problem where in we have to find the range of binary search

TC:  n * (log(K)), [K is difference between max-min or range of capcity ] 
*/
class Solution {
    public int shipWithinDays(int[] weights, int D) {
        
        
        if(weights.length == 0 || weights == null){
            return 0;
        }
        
        int low = 0;
        int high = 0;
        for(int i = 0; i < weights.length;i++){
            low = Math.max(weights[i], low);
            high += weights[i];
        }
        
        
        //binary search on the capacity
        while(low <= high){ //
            int mid = low + (high-low)/2;
            int currDays = 1;
            int currSum = 0;
            for(int i = 0; i < weights.length;i++){
                if(currSum + weights[i] > mid){
                    currSum = 0; //reset the sum once it crosses the capacity at mid
                    currDays++;
                }
                currSum += weights[i];
            }
            if(currDays > D){
                low = mid+1; //we increase the capacity 
            }else{
                high = mid-1;
            }
        }
        return low;
    }
}