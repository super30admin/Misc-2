/*
sum-of-product-of-all-possible-subsets

Given an array of n non-negative integers. The task is to find the sum of the product of elements of all the possible subsets. It may be assumed that the numbers in subsets are small and computing product doesn’t cause arithmetic overflow.

Example :

Input : arr[] = {1, 2, 3}

Output : 23
*/

// Approach 1: Expand search space
// Time complexity: Exponential
// Space complexity: O(1)

// Approach 2: Mathematical result
// Time complexity: O (n)
// Space complexity: O(1)

/*
arr = {a,b}
Subsets are a, b, ab
result 	= a + b + ab
		= a + b + ab + 1 - 1
		= a + 1 + b (1 + a) - 1
		= (a + 1) + b (1 + a) - 1
		= (a + 1)(1 + b) - 1

arr = {a,b,c} 
result = (1+a)(1+b)(1+c) - 1
*/

int getSumOfPeroductOfSubsets(vector<int> arr) {
    int result = 1;
    for(int a: arr) {
        result *= a+1; 
    }
    result = result - 1;
    return result;
}

int main() {
    vector<int> arr = {1,2,3};
    int result = getSumOfPeroductOfSubsets(arr);
    cout<<"Result: "<<result<<endl;
    return 0;
}