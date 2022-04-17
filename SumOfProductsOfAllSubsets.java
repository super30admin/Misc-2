// Time Complexity : O(n)
// Space Complexity : O(1)

public class SumOfProductsOfAllSubsets {

    private static int SumOfProductsOfAllSubsets(int[] arr){
        if(arr == null || arr.length == 0) return 0;
        int result = 1;

        for(int num: arr){
            result *= (1 + num);
        }

        return result - 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        int result = SumOfProductsOfAllSubsets(arr);
        System.out.println("SumOfProductsOfAllSubsets : " + result);
    }

}
