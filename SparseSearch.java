// Time Complexity : O(log n) Binary Search where n is the number of elements of the array in avg case, in Worst case :O (n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : In worst case it is O(n)
/* Your code here along with comments explaining your approach: Do a binary search, if you land up on a blank character, introduce two pointers
to the left and right of mid and continue the pointers till you get a string to compare with target. If you dont get the string till end it means
the string does not exist. Recursively perform binary search till you get the target.
*/
class SparseSearch 
{ 
// Binary Search in an array with blanks  
static int binarySearch(String arr[], int low, int high, String x) { 
        if(high < low ) return -1;
        int mid  = low + (high - low)/2;                                                                                            
        if(arr[mid].equals("")){                                                                        // Equals blank character
            int i = mid -1;
            int j = mid + 1;
            while(i >= low && j <= high && arr[i].equals(" ") && arr[j].equals(" ")){                           // Till you find the string
                i--;
                j++;
            }
            if(i < low || j > high) return -1;                                                              // Out of bounds
            else
            if(!arr[i].equals("")) mid = i;                                                                 // Update mid
            else 
            if(!arr[j].equals("")) mid = j;
        }
        if(arr[mid].equals(x)) return mid;                                                              // Target found
        else
        if(x.compareTo(arr[mid]) < 0){
            return binarySearch(arr, low, mid - 1, x);                                                  // Lexicographically sorted check
            } else {
            return binarySearch(arr, mid + 1, high, x);
            }
} 
static int sparseSearch(String arr[], String x, int n) { 
return binarySearch(arr, 0, n - 1, x); 
} 
public static void main(String args[]) { 
String arr[] = {"for", "geeks", "", "", "", "", "ide",  
                    "practice", "", "", "", "quiz"}; 
String x = "geeks"; 
int n = x.length(); 
int index = sparseSearch(arr, x, n); 
if (index != -1) 
    System.out.println(x+ " found at index "+index); 
else
    System.out.println(x+" not found"); 
} 
} 