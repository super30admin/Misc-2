/*
sparse-search

Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.

Examples:

Input : arr[] = {"for", "geeks", "", "", "", "", "ide", 

                      "practice", "", "", "", "quiz"}

          x = "geeks"

Output : 1


Input : arr[] = {"for", "geeks", "", "", "", "", "ide", 

                      "practice", "", "", "", "quiz"}, 

          x = "ds"

Output : -1
*/


// Approach 1: Linear search 
// Time complexity: O (n)
// Space complexity: O(1)

// Approach 2: Modified Binary Search 
// Time complexity: O(n) worst case is still O(n) cause we have the while loop expanding and might iterate over the entire string if all strings are empty
// Space complexity: O(1)

int sparseSearch(vector<string> arr, string x) {
    if(arr.size() == 0)
        return -1;
    
    int low = 0;
    int high = arr.size()-1;
    int mid;
    int left, right;
    
    while(low <= high) {
        mid = (high-low)/2 + low; // to avoid integer overflow
        int left = mid - 1;
        int right = mid + 1;
        // iterate around the mid till you find a non-empty string
        // If we have moved out of the bound low and high, that means the word does not exist
        if(arr[mid] == "") {
            while(true) {
                if(left < low && right > high)
                    return -1;
                if(left >= low && arr[left] != "") {
                    mid = left;
                    break;
                }
                if(right <= high && arr[right] != ""){
                    mid = right;
                    break;
                }
                left++;
                right--;
            }
        }
        if(arr[mid] == x)
            return mid;
        if(arr[mid] < x)
            low = mid + 1;
        else
            high = mid - 1;
    }
    return -1;
}

int main() {
    vector<string> arr = {"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"};
    string x = "geeks";
    cout<<"geeks: "<<sparseSearch(arr, x)<<endl;
    x = "practice";
    cout<<"practice: "<<sparseSearch(arr, x)<<endl;
    x = "quiz";
    cout<<"quiz: "<<sparseSearch(arr, x)<<endl;
    x = "Sahana";
    cout<<"Sahana: "<<sparseSearch(arr, x)<<endl;
    return 0;
}