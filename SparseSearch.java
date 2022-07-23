import java.util.Objects;

public class SparseSearch {
    // TC : O(n)
    // SC : O(1)
    public int search(String[] arr, String val) {
        if(arr == null || arr.length == 0) return -1;

        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid].equals("")){
                int left = mid - 1;
                int right = mid + 1;

                while(true) {
                    if(left < low && right > high) {
                        return -1;
                    }
                    if(left >= low && !Objects.equals(arr[left], "")){
                        mid = left;
                        break;
                    }
                    if(right <= high && !Objects.equals(arr[right], "")){
                        mid = right;
                        break;
                    }
                    left--;
                    right++;
                }
            }
            if(val.equals(arr[mid])){
                return mid;
            }
            else if(val.compareTo(arr[mid]) < 0){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
