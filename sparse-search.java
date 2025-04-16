// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Solution {
    public static int search(String[] arr, String x) {
        if (arr == null || x == null || x.isEmpty()) {
            return -1;
        }
        return searchHelper(arr, x, 0, arr.length - 1);
    }

    private static int searchHelper(String[] arr, String x, int low, int high) {
        if (low > high) {
            return -1;
        }
        
        int mid = (low + high) / 2;
        
        // If mid is an empty string, find the closest non-empty string.
        if (arr[mid].isEmpty()) {
            int left = mid - 1;
            int right = mid + 1;
            while (true) {
                if (left < low && right > high) {
                    return -1;
                }
                if (right <= high && !arr[right].isEmpty()) {
                    mid = right;
                    break;
                }
                if (left >= low && !arr[left].isEmpty()) {
                    mid = left;
                    break;
                }
                right++;
                left--;
            }
        }
        
        // Compare the found non-empty string with x.
        if (arr[mid].equals(x)) {
            return mid;
        } else if (arr[mid].compareTo(x) < 0) {
            return searchHelper(arr, x, mid + 1, high);
        } else {
            return searchHelper(arr, x, low, mid - 1);
        }
    }
    
    public static void main(String[] args) {
        String[] arr = {"for", "geeks", "", "", "", "", "ide",
                        "practice", "", "", "", "quiz"};
        
        // Example 1:
        String x1 = "geeks";
        int index1 = search(arr, x1);
        System.out.println("Index of \"" + x1 + "\": " + index1);  // Expected output: 1
        
        // Example 2:
        String x2 = "ds";
        int index2 = search(arr, x2);
        System.out.println("Index of \"" + x2 + "\": " + index2);  // Expected output: -1
    }
}
