public class Subset {
    // Returns sum of products of all subsets
    // of arr[0..n-1]
    static int productOfSubsetSums(int arr[], int n) {
        int ans = 1;
        for (int i = 0; i < n; ++i)
            ans = ans * (arr[i] + 1);
        return ans - 1;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int n = arr.length;
        System.out.println(productOfSubsetSums(arr, n));
    }
}
