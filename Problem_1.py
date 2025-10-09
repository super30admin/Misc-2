'''
Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.

Examples:
Input : arr[] = {"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"} x = "geeks" Output : 1

Input : arr[] = {"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"}, x = "ds"
Output : -1

Solution:
1. Binary Search with Two-pointer
Perform standard binary search to search the target word. The only change to the standard binary search is that we check if the value at mid is an empty string "". If it is, we find the closest non-empty string to the left or right of mid using the two-pointer approach. Once we have found the index of the closest non-empty string, we treat as the new mid and continue with the standard binary search.

Time: O(M log K), Space: O(1), K = no. of non-empty strings in the input array, M = no. of empty string in the input array.
'''

def sparse_search(arr, target):
    def find_closest_nonempty(arr, mid):
        N = len(arr)
        left, right = mid-1, mid+1
        ans = -1
        while left>=0 and right<=N-1:
            if arr[left]:
                ans = left
                break
            elif arr[right]:
                ans = right
                break
            left -= 1
            right += 1
        return ans

    N = len(arr)
    low = 0
    high = N-1
    while low <= high:
        mid = low + (high - low)//2 # same as int((s+e)/2) but prevents overflow

        if arr[mid] == "":
            mid = find_closest_nonempty(arr, mid)
            if mid == -1: return -1

        if arr[mid] == target:
            return mid
        elif arr[mid] < target:
            low = mid + 1
        else:
            high = mid - 1
    return -1

def run_sparse_search():
    tests = [(["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"], "geeks", 1),
             (["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"], "practice", 7),
             (["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"], "ds", -1),
    ]
    for test in tests:
        arr, target, ans = test[0] , test[1], test[2]
        print(f"\narray = {arr}")
        print(f"target = {target}")
        index = sparse_search(arr, target)
        print(f"Word '{target}' found at index = {index}")
        success = (ans == index)
        print(f"Pass: {success}")
        if not success:
            print(f"Failed")
            return

run_sparse_search()