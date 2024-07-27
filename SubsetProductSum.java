public class SubsetProductSum {
    public static void main(String[] args) {
        // Tc: O(n) Sc: O(1)
        int[] arr = { 1, 2, 3 };
        System.out.println(sumOfProductOfSubsets(arr));
    }

    public static int sumOfProductOfSubsets(int[] arr) {
        int ans = 1;
        for (int i = 0; i < arr.length; ++i)
            ans = ans * (arr[i] + 1);
        return ans - 1;
    }
}

/*
 * import java.util.ArrayList;
 * 
 * public class SubsetProductSum {
 * public static void main(String[] args) {
 * // Tc: O(n*2^N) Sc: O(2^n)
 * int[] arr = { 2, 2, 1 };
 * System.out.println(sumOfProductOfSubsets(arr)); // Output: 23
 * }
 * 
 * public static int sumOfProductOfSubsets(int[] arr) {
 * int sum = 0;
 * ArrayList<ArrayList<Integer>> subsets = generateSubsets(arr);
 * for (ArrayList<Integer> subset : subsets) {
 * if (!subset.isEmpty()) {
 * int product = 1;
 * for (int num : subset) {
 * product *= num;
 * }
 * sum += product;
 * }
 * }
 * return sum;
 * }
 * 
 * public static ArrayList<ArrayList<Integer>> generateSubsets(int[] arr) {
 * ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
 * int n = arr.length;
 * for (int i = 0; i < (1 << n); i++) {
 * ArrayList<Integer> subset = new ArrayList<>();
 * for (int j = 0; j < n; j++) {
 * if ((i & (1 << j)) > 0) {
 * subset.add(arr[j]);
 * }
 * }
 * subsets.add(subset);
 * }
 * return subsets;
 * }
 * }
 * 
 */
