# TC: O(logn)
# SC: O(logn)
def sparseSearch(arr , key , low , high):
     
    left = 0; right = 0
 
    while low <= high:
 
            mid = low + (high - low) // 2
 
            if arr[mid] == '':
                left = mid - 1
                right = mid + 1
 
                while True:
 
                    # Check for out of bounds
                    if left < low and right > high:
                        return -1
 
                    elif left >= low and arr[left] != '':
                        # Search left
                        mid = left
                        break
 
                    elif right <= high and arr[right] != '':
                        # Search right
                        mid = right
                        break
 
                    left -= 1
                    right += 1
 
            if arr[mid] == key:
                print('Found string {} at index {}'.format
                     (arr[mid] , mid))
                return mid
 
            # Classical Binary search
            # search left
            elif arr[mid] > key:
                high = mid - 1
 
            # search right
            elif arr[mid] < key:
                low = mid + 1
 
    return -1
 
if __name__ == '__main__':
 
    arr = ["for", "geeks", "", "", "", "", "ide",
           "practice", "", "", "", "quiz"]                
    key = 'geeks'
 
    low = 0
    high = len(arr) - 1
 
    sparseSearch(arr , key , low , high)