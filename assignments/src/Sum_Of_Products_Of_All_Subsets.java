// Approach: Fastest - Formula: for [a,b,c] -> (a+1)(b+1)(c+1) - 1
// Without formula: Backtracking -> exponential time
// Time: O(n)
// Space: O(1)

public class Sum_Of_Products_Of_All_Subsets {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3};

        System.out.println(calculate(arr));
    }

    private static int calculate(int[] arr) {
        int sum = 1;

        if (arr.length == 0) return 0;

        for (int i = 0; i<arr.length; i++) {
            sum *= arr[i]+1;
        }

        return sum - 1;
    }
}
