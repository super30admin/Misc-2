class Solution:
    #Solution 1
    def sumOfProduct(self, arr):
        #Approach: Maths
        #Sum of products of all subsets of n1, n2, ..., nk:
        #(1 - n1) * (1 - n2) * ... * (1 - nk) - 1
        #Time Complexity: O(n)
        #Space Complexity: O(1)
        
        result = 1
        for num in arr:
            result *= (num + 1)
            
        return result - 1
    
    #Solution 2
    """
    def sumOfProduct(self, arr):
        #Approach: Recursion // DFS
        #Time Complexity: O(2^n)
        #Space Complexity: O(n)
        
        self.result = 0
        self.helper(arr, 0, 1)
        return self.result - 1  # removing extra 1 from the empty subset
    
    def helper(self, arr, idx, product):
        #base
        if idx == len(arr):
            self.result += product
            return
        
        #logic
        #not use
        self.helper(arr, idx + 1, product)
        
        #use
        self.helper(arr, idx + 1, product * arr[idx])
    """
        
#Driver code
arr = [3, 5, 8, -12, -16]
sol = Solution()
print(sol.sumOfProduct(arr))