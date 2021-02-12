"""
Time Complexity : O(nlogn)
Space Complexity : O(1)  
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

we can perform binary search on the array to find the target
"""


def binarySearch(arr, target):
    low = 0
    high = len(arr)-1

    while low <= high:
        mid = low+(high-low)//2
        left, right = 0, 0
        if arr[mid] == "":
            left = mid-1
            right = mid+1

            while True:
                if left < low and right > high:
                    return -1
                elif left >= low and arr[left] != "":
                    mid = left
                    break

                elif right <= high and arr[right] != "":
                    mid = right
                    break
                else:
                    left -= 1
                    right += 1

        if arr[mid] == target:
            return mid
        else:
            if arr[mid] > target:
                high = mid-1
            else:
                low = mid+1
    return -1


arr = ["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"]
target = "geeks"
print(binarySearch(arr, target))

arr = ["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"]
target = "ds"
print(binarySearch(arr, target))
