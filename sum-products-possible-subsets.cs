/*
Given an array of n non-negative integers. The task is to find the sum of the product of elements of all the possible subsets. It may be assumed that the numbers in subsets are small and computing product doesn’t cause arithmetic overflow.

Example : 

Input : arr[] = {1, 2, 3}
Output : 23
Possible Subset are: 1, 2, 3, {1, 2}, {1, 3}, 
                     {2, 3}, {1, 2, 3}
Products of elements in above subsets :
1, 2, 3, 2, 3, 6, 6
Sum of all products = 1 + 2 + 3 + 2 + 3 + 6 + 6 
                    = 23
*/

class HelloWorld {
    static void Main() {
        int[] arr = [1, 2, 3, 4];
        Console.WriteLine(Product(arr));
    }
    
    static int Product(int[] arr){
        double product = 1;
        for(int i = 0; i< arr.Length; i++){
            product *= (1+ arr[i]);
        }
        return (int)product - 1;
    }
}
