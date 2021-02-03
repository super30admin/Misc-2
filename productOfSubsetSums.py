#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes

def productOfSubsetSums(arr):
    res = 1
    for i in range(0,len(arr)):
        res = res * (arr[i] + 1)
    return ans-1


arr = [1, 2, 3, 4]
productOfSubsetSums(arr)
