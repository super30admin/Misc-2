'''
Given an array of n non-negative integers. The task is to find the sum of the product of elements of all the possible subsets. It may be assumed that the numbers in subsets are small and computing product doesn't cause arithmetic overflow.

Example :
Input : arr[] = {1, 2, 3}
Output : 23
Explanation:
Possible Subset are: 1, 2, 3, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}
Products of elements in above subsets : 1, 2, 3, 2, 3, 6, 6
Sum of all products = 1 + 2 + 3 + 2 + 3 + 6 + 6 = 23

Solution:
1. For n element set = {e1, e2, ..., en}
sum of products of all subsets = (1+ e1) * (1 + e2) * … * (1 + en) - 1
https://youtu.be/4Ul2DCALeOs?t=4254
Time: O(N), Space: O(1)
'''
def sumsOfProductOfSubset(nums):
    if not nums:
        return 0
    N = len(nums)
    if N == 1:
        return nums[0]
    sum = 1
    for i in range(N):
        sum = sum * (nums[i] + 1)
    return sum-1

def run_sumsOfProductOfSubset():
    tests = [([1,2,3], 23),
             ([4,5,6], 209),
             ([1,2,4,5], 179),
             ([1], 1),
             ([], 0),
    ]
    for test in tests:
        nums, ans = test[0], test[1]
        print(f"\nnums = {nums}")
        sum = sumsOfProductOfSubset(nums)
        print(f"sum of all subsets = {sum}")
        success = (ans == sum)
        print(f"Pass: {success}")
        if not success:
            print("Failed")
            return

run_sumsOfProductOfSubset()