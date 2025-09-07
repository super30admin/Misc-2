def sparse_search(arr, x):
    low,high=0,len(arr)-1
    while low<=high:
        mid = low+(high-low)//2
        if arr[mid] == "":
            left,right = mid-1,mid+1
            while True:
                if left<low and right >high:
                    return -1
                elif left>=low and arr[left]!="":
                    mid = left
                    break
                elif right<=high and arr[right]!="":
                    mid = right
                    break
                left-=1
                right+=1
        if arr[mid] == x:
            return mid
        elif arr[mid] > x:
            high = mid-1
        else:
            low = mid+1
    return -1


arr = ["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"]
print(sparse_search(arr, "geeks"))   # Output: 1
print(sparse_search(arr, "ds"))      # Output: -1
print(sparse_search(arr, "ide"))  