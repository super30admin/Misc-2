"""
Time Complexity : O(n) 
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

The bruteforce could be to make all the subsets possible using backtracking , then multiply all of them and then add them. This
would be exponential again. To simplify this, this problem boild down to just a formulae.
Lets say we have [a,b,c]
All subsets- [a],[b],[c],[a,b][b,c],[a,c][a,b,c]
Our output should be a+b+c+ab+bc+ac+abc+1-1(we just add and subtract 1 for reaching the formula)
This boils down to (1+a) (1+b) (1+c) -1. So we just solve this and return. 
"""


def subsetProductSum(arr):
    result = 1
    for a in arr:
        result *= (a+1)
        print(result)
    return result - 1


arr = [1, 2, 3]
print(subsetProductSum(arr))
