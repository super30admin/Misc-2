"""
Time Complexity: O(n)
Space Complexity: O(1)
"""
def sumOfProductofSubSets(arr):
    n = len(arr)
    result = 1

    for i in range(n):
        result *= 1 + arr[i]

    return result - 1