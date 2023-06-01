/*
Sum of the products of all possible Subsets
approach:
An Efficient approach is to generalize the whole problem into some pattern. Suppose we have two numbers a and b. We can write all possible subset products as:-
   = a + b + ab
   = a(1+b) + b + 1 - 1
   = a(1+b) + (1+b) - 1
   = (a + 1) * (b + 1) - 1
   = (1+a) * (1 + b) - 1
Now take three numbers a, b, c:-
   = a + b + c + ab + bc + ca + abc
   = a + ac + b + bc + ab + abc + c + 1 - 1
   = a(1+c) + b(1+c) + ab(1+c) + c + 1 - 1
   = (a + b + ab + 1)(1+c) - 1
   = (1+a) * (1+b) * (1+c) - 1
time: O(n)
space: O(1)
 */
public class Problem3 {
    static int productOfSubsetSums(int arr[], int n) {
        int ans = 1;
        for (int i = 0; i < n; ++i)
            ans = ans * (arr[i] + 1);
        return ans - 1;
    }
}
