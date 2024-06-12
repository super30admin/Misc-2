
def search_sparse_array(arr, x):
    for i in range(len(arr)):
        if arr[i] == x:
            return i
        elif arr[i] == "":
            continue
        elif arr[i] > x:
            return -1
    return -1


arr = ["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"]
x = "geeks"
print(search_sparse_array(arr, x))  # Output: 1

arr = ["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"]
x = "ds"
print(search_sparse_array(arr, x))  # Output: -1




'''

def find_string(arr, x):
    if not arr:
        return -1
    
    left, right = 0, len(arr) - 1
    
    while left <= right:
        mid = (left + right) // 2
        
        # If mid is empty, find the closest non-empty string
        if arr[mid] == "":
            mid_left, mid_right = mid - 1, mid + 1
            while True:
                if mid_left < left and mid_right > right:
                    return -1
                elif mid_left >= left and arr[mid_left] != "":
                    mid = mid_left
                    break
                elif mid_right <= right and arr[mid_right] != "":
                    mid = mid_right
                    break
                mid_left -= 1
                mid_right += 1
        
        # Perform standard binary search comparisons
        if arr[mid] == x:
            return mid
        elif arr[mid] < x:
            left = mid + 1
        else:
            right = mid - 1
    
    return -1

# Test cases
arr1 = ["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"]
x1 = "geeks"
print(find_string(arr1, x1))  # Output: 1

arr2 = ["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"]
x2 = "ds"
print(find_string(arr2, x2))  # Output: -1

x3 = "quiz"
print(find_string(arr1, x3))

'''
