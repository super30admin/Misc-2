'''
Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.

Examples:
Input : arr[] = {"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"} x = "geeks" Output : 1

Input : arr[] = {"for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"}, x = "ds"
Output : -1

Solution:
1. Brute Force
Linear search
https://youtu.be/4n_RNFyv9RQ?t=156
Time: O(N), Space: O(1), N = no. of strings in the input array

2. Binary Search with Two-pointer
Perform standard binary search to search the target word. The only change to the standard binary search is that we check if the value at mid is an empty string "". If it is, we find the closest non-empty string to the left or right of mid using the two-pointer approach. Once we have found the index of the closest non-empty string, we treat as the new mid and continue with the standard binary search.

https://youtu.be/4n_RNFyv9RQ?t=220

Time: O(N), Space: O(1), N = no. of strings in the input array
O(N) occurs when the array is very sparse. Example: ['a', "", "", "", ..., "b"]
(arr[i] = "", i!=0, N-1)
'''

def sparse_search(arr, target):
    def find_closest_nonempty(arr, mid, left_limit, right_limit):
        left, right = mid-1, mid+1
        ans = -1
        while True:
            if left < left_limit and right > right_limit:
                return -1
            if left >= low and arr[left]:
                ans = left
                break
            if right <= right_limit and arr[right]:
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
            mid = find_closest_nonempty(arr, mid, low, high)
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
             (["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"], "quiz", 11),
             (["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"], "for", 0),
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