public class ProductOfAllSubsets {

  /**
   * Time Complexity : O(n)
   * 
   * Space Complexity: O(1)
   * 
   * Were you able to solve this? yes
   */
  int productOfSubsetSums(int arr[], int n) {
    int ans = 1;
    for (int i = 0; i < n; ++i )
        ans = ans * (arr[i] + 1);
    return ans-1;
  }
}
