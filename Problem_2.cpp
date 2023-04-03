Sum of the products of all possible Subsets

Time Complexity: O(n) 
Auxiliary Space: O(1)

// C++ program to find sum of product of
// all subsets.
#include <bits/stdc++.h>
using namespace std;
 
// Returns sum of products of all subsets
// of arr[0..n-1]
int productOfSubsetSums(int arr[], int n)
{
    int ans = 1;
    for (int i = 0; i < n; ++i )
        ans = ans * (arr[i] + 1);
    return ans-1;
}
 
// Driver code
int main()
{
    int arr[] = {1, 2, 3, 4};
    int n = sizeof(arr)/sizeof arr[0];
    cout << productOfSubsetSums(arr, n);
    return 0;
}
