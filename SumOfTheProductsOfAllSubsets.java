public class SumOfTheProductsOfAllSubsets {
    //Time Complexity: 0(n)
    //Space Complexity: 0(1)


    static int productOfSubsetSums(int arr[], int n)
    {
        int ans = 1;
        for (int i = 0; i < n; ++i )
            ans = ans * (arr[i] + 1);   //this answer can be computed based on the derivation subsets of [a,b] = (1+b) * (1+a) -1
        return ans-1;
    }

    public static void main (String[] args)
    {
        int arr[] = {1, 2, 3, 4};
        int n = arr.length;
        System.out.println(productOfSubsetSums(arr, n));
    }
}
