# def sumOfProductofSubSets(nums):
#     def helper(nums,pivot,path):
#         total =0
#         if path:
#             product = 1
#             for num in path:
#                 product*=num
#             total+=product
#         for i in range(pivot, len(nums)):
# #             action
#             path.append(nums[i])
#       #recurse
#             total+= helper(nums, i+1, path)
#             path.pop()
#         return total

def sumOfProductofSubSets(nums):
    res = 1
    for n in nums:
        res*=1+n
    return res-1

arr = [1, 2, 3]
print(sumOfProductofSubSets(arr))