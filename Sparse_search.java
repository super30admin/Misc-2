class Solution{
    public static int binarySearch(String arr[], int low, int high, String x){
        while(low < high){
            int mid = low + (high - low) /2;
            if(arr[mid] == " "){
                int left = mid -1;
                int right = mid + 1;
                while(true) {
                    if(left < low && right > high) return -1;
                    else if(left >= low && arr[left] != " "){
                        mid = left;
                        break;
                    }
                    else if(right <= right && arr[right] != "") {
                        mid = right;
                        break;
                    }
                    left--;
                    right++;
                }
            }
            if(arr[mid] == x) return mid;
            else if(x.compareTo(arr[mid] < 0) high = mid -1;
            else low = mid + 1;
    }
     return -1;
}

                    
//TC: O(log(n))
//SC: O(1)
