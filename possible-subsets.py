'''
Approach: Exhaustive Solution with 0-1 Recrusion using DFS 

Time Complexity: O(n.2^n) n because of the deep copy and 2^n because of the two recursive calls being made 
Space Complexity: O(n) ( recurisve stack ) + O(n.2^n) which is the output array 
'''


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        uniqueSubsets = []
        N = len(nums)

        def dfs(index, arr):
            if index >= N:
                uniqueSubsets.append(arr)
                return
            
            arr_copy = deepcopy(arr)
            arr_copy.append(nums[index])
            dfs(index+1, arr_copy)
            dfs(index+1, arr)
    

        dfs(0, [])

        return uniqueSubsets



