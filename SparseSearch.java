// Time Complexity : O(log n) optimal case, O(n) worst case
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Use binary search technique. Follow below link for more details
// https://www.geeksforgeeks.org/sparse-search/
public class Main {
    public static void main(String[] args) {
        String arr[] = {"for", "geeks", "", "", "", "", "ide",
                    "practice", "", "", "", "quiz"};
        String x = "quiz";
        int n = x.length();
        int index = search(arr, x);
        if (index != -1)
            System.out.println(x+ " found at index "+index);
        else
            System.out.println(x+" not found");

    }
    public static int search(String[] arr, String x){
        int l = 0;
        int h = arr.length-1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(arr[mid].equals("")){
                int i = mid - 1;
                int j = mid + 1;
                while(i >= l || j <= h){
                    if(i >= l && !arr[i].equals("")){
                        mid = i;
                        break;
                    }
                    if(j <= h && !arr[j].equals("")){
                        mid = j;
                        break;
                    }
                    i--;
                    j++;  
                }  
                if(i < l && j > h)
                    return -1;
            }
            int cmp = arr[mid].compareTo(x);
            if(cmp == 0)
                return mid;
            if(cmp < 0){
                l = mid+1;
            }
            else{
                h = mid-1;
            }
        }
        return -1;
    }
}