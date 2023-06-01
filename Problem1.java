/*
Sparse Search
approach: we can see that the words are sorted and in ascending order, we can do a binary search
time: O(n) in worst case as there are empty words
space: O(1)
 */
public class Problem1 {
    private int search(String[] arr, String str) {
        if(arr == null || arr.length == 0 || str == null) {
            return -1;
        }
        return searchBinary(arr, str, 0, arr.length);
    }


    private int searchBinary(String[] arr, String str, int start, int end) {
        if(start > end)
            return -1;

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

        if( arr[mid].equals(str)) {
            return mid;
        }else if(arr[mid].compareTo(str) < 0) {
            searchBinary(arr, str, mid+1, end);
        }  else {
            searchBinary(arr, str, start, mid -1);
        }
        return start;
    }
}
