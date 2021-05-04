// Time Complexity : O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class SparseSearch {
  int search(String[] arr, String str) {
     if(arr == null || arr.length == 0 || str == null || ) {
      return -1;
     }
     return searchBinary(arr, str, 0, arr.length);
  }


  int searchBinary(String[] arr, String target, int start, int end) {
     while(start > end) {
     
       int mid = (start + end)/2; 
       if(arr[mid].isEmpty()) {
         int left = mid -1;
       int right = mid +1;

       while(true) {
         if( left < start && right > end){
             return -1;
         }else if( right <= end && !arr[right].isEmpty()){
            mid = right;
          break;
         }else if( left >= start && !arr[left].isEmpty()){
            mid = left;
          break;
         }
         left++;
         right--;
       }
    }	 

      if( arr[mid].equals(target)) {
          return mid;
      }else if(arr[mid].compareTo(str) < 0) {
          start = mid+1;
      }  else {
          end = mid -1;
      }
     }
     return -1;
   }
}
