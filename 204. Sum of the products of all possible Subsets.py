class Solution:
    def productOfSubsetsSums(self, arr, n):
        ans = 1

        for i in range(n):
            ans = ans * (arr[i] + 1)
        print(ans - 1)
        return ans - 1


arr = [1, 2, 3]
n = len(arr)

obj = Solution()
obj.productOfSubsetsSums(arr, n)

# Time Complexity: O(n)
# Auxiliary Space: O(1)
