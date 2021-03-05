// Time, Space - O(N), O(1)
static int productOfSubsetSums(int arr[], int n)
    {
        int ans = 1;
        for (int i = 0; i < n; ++i )
            ans = ans * (arr[i] + 1);
        return ans-1;
    }
