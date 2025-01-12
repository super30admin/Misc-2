#Approach
# tocalulate the product od sum of sunsets there is mathematical deriuvation(1+a)(1+b) -1
# By using that we can solve


#Complexities:
#Time: O(N)
#Space: O(1)




# Given an array of n non-negative integers. The task is to find the sum of the product of elements of all the possible subsets. It may be assumed that the numbers in subsets are small and computing product doesn’t cause arithmetic overflow.#
# Example :
#
# Input : arr[] = {1, 2, 3}
#
# Output : 23
#
# Possible Subset are: 1, 2, 3, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}
#
# Products of elements in above subsets : 1, 2, 3, 2, 3, 6, 6
#
# Sum of all products = 1 + 2 + 3 + 2 + 3 + 6 + 6 = 23




class Solution:

    def productSumSubSets(self,nums):
        res =1
        for num in nums:
            res *=(1+num)
        return res-1

s = Solution()
print(s.productSumSubSets([1,2,3]))