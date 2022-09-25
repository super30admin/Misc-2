# TC : O(n)
# SC : O(1)
"""
Approach : Mathematically [a,b,c] SOP is 
   = a + b + c + ab + bc + ca + abc 
   = a + ac + b + bc + ab + abc + c + 1 - 1
   = a(1+c) + b(1+c) + ab(1+c) + c + 1 - 1
   = (a + b + ab + 1)(1+c) - 1 
   = (1+a) * (1+b) * (1+c) - 1  
"""
def productOfSubsetSums(arr, n):
    ans = 1;
    for i in range(0,n):
        ans = ans * (arr[i] + 1)
    return ans-1
 
# Driver code
arr = [1, 2, 3, 4]
n = len(arr)
 
print (productOfSubsetSums(arr, n))