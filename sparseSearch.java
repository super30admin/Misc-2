// Time Complexity = O(n), since in the worst case left and right will traverse all the way
// Space Complexity = O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
import java.io.*;

class SparseSearch {
    public static int sparse(String[] arr, String x) {
        if (arr == null || arr.length == 0) return -1;
        int n = arr.length;
        int low = 0, high=n-1;

        while (low<=high) {
            int mid = low+(high-low)/2;
            if (arr[mid] == "") {
                int left = mid-1;
                int right = mid+1;

                while (true) {

                    if (left<low && right>high) return -1;

                    if (left>=low && arr[left] != "") {
                        if (arr[left].equals(x)) {
                            return left;
                        }
                        else {
                            if (arr[left].compareTo(x) < 0) {
                                low = left+1;
                            }
                            else {
                                high = left-1;
                            }
                            break;
                        }
                    }
                    left--;

                    if (right <= high && arr[right] != "") {
                        if (arr[right].equals(x)) {
                            return right;
                        }
                        else {
                            if (arr[right].compareTo(x) < 0) {
                                low = right+1;
                            }
                            else {
                                high = right-1;
                            }
                            break;
                        }
                    }
                    right++;
                }
            }
            else {
                if (arr[mid].equals(x)) {
                    return mid;
                }
                else {
                    if (arr[mid].compareTo(x) < 0) {
                        low = mid+1;
                    }
                    else {
                        high = mid-1;
                    }
                    break;
                }
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        String[] arr = {"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"};
        String x = "geeks";
        System.out.println(sparse(arr, x));
    }
}