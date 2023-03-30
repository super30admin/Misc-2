public class SparseSearch {
    public static int sparseSearch(String[] arr, String target){
        int n = arr.length;
        if(arr==null || n<0) return 0;
        int low = 0;
        int high = n-1;
        while(low<=high){
            int mid = low+ (high-low)/2;

            if(arr[mid]== ""){
                int left = mid-1;
                int right = mid+1;

                while(left>=0 && right<=n-1){
                    if(arr[left]!=""){
                        mid = left;
                        break;
                    }else if(arr[right]!=null){
                        mid = right;
                        break;
                    }else{
                        left--;
                        right++;
                    }
                }
            }

            if(arr[mid]==target) return mid;
            else if(arr[mid].compareTo(target)<0) low = mid+1;
            else high = mid-1;

        }
        return -1;
    }
}

// TC - O(k*logn)
// SC - O(1)