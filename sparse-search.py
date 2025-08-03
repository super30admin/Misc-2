'''
Time Complexity: O(logn)
Space Complexity: O(1)

Approach: 
We start with binary search through the array; 
when we reach mid element where it's empty string "" we then do another search going outward in both the directions 
compare the element first reached with the target and set the binary search's bounds according to that 
'''

def sparseSearch(arr, target):
    N = len(arr)
    low = 0 
    high = N-1 
    res = -1

    while low < high:
        mid = (low+high)//2 

        if arr[mid]=="": 
            left, right = mid-1, mid+1 
            while True:
                if left < low and right>high:
                    return -1 
                if arr[left]!="":
                    mid = left 
                    break
                if arr[right]!="":
                    mid = right 
                    break 
                left-=1 
                right+=1 

            
        if arr[mid]==target:
                res = mid 
                break 
        if arr[mid]>target:
            high = mid-1 
        else:
            low = mid+1
    return res 


arr = ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""] 
target = "ball"
print("Expected output: 4")
print(sparseSearch(arr, target))

arr = ["at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""]
target = "at"
print("Expected output: 0")
print(sparseSearch(arr, target))




        
        
