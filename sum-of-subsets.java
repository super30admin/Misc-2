// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        int[] arr = new int[]{1, 2, 3};
        int setval = 1;

        for (int i = 0; i < arr.length; i++) {
            setval *= (1 + arr[i]);
        }

        System.out.println(setval - 1);
    }
}
