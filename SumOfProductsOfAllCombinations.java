// Time: O(N^N) | Space: O(N)

// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
class SumOfProductsOfSubsets {
    int sum;
    public int createSubSets(int[] arr) {
        helper(arr, 0, new ArrayList<>());
        return sum;
    }
    private void helper(int[] arr, int pivot, List<Integer> path) {
        if(path.size() > 0) {
            int product = 1;
            for(int ele: path) {
                product *= ele;
            }
            sum += product;
        }
        for(int i=pivot;i<arr.length;i++) {
            path.add(arr[i]);
            helper(arr, i+1, path);
            path.remove(path.size() -1);
        }
    }
    public static void main(String[] args) {
        SumOfProductsOfSubsets s = new SumOfProductsOfSubsets();
        System.out.println(s.createSubSets(new int[]{1,2,3}));
    }
}