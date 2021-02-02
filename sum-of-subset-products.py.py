# TIME COMPLEXITY: O(n)
# SPACE COMPLEXITY: O(1)
# Use formula [a,b,c]
#    = a + b + c + ab + bc + ca + abc
#    = a + ac + b + bc + ab + abc + c + 1 - 1
#    = a(1+c) + b(1+c) + ab(1+c) + c + 1 - 1
#    = (a + b + ab + 1)(1+c) - 1
#    = (1+a) * (1+b) * (1+c) - 1
def sumOfSubsetProducts(arr):
    ans = 1
    for i in range(len(arr)):
        ans = ans * (arr[i] + 1)
    return ans-1

# Recursive Approach
# TIME COMPLEXITY: O(2^n)
# SPACE COMPLEXITY: O(n) - slate
def sumOfSubsetProducts_recursive(arr):
    prod = [0]

    def _helper(index, slate):
        if index == len(arr):
            slate_prod = 1
            for x in slate:
                slate_prod *= x
            prod[0] += slate_prod
            return
        # Include
        slate.append(arr[index])
        _helper(index + 1, slate)
        slate.pop()
        # Exclude
        _helper(index+1, slate)
    _helper(0, [])
    return prod[0] - 1


def main():
    arr = [1, 2, 3, 4]
    print(sumOfSubsetProducts_recursive(arr))


main()
