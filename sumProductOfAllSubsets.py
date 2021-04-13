# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

#sum product of all subsets
def sumProductOfAllSubsets(arr):
    res = 0
    if not arr:
        return res

    for i in range(len(arr)):
        res += (res+1) * arr[i]
    
    return res

arr = [1,2,3]
print(sumProductOfAllSubsets(arr))
