def sparseSearch(arr, word, low, high):
    
    while low<=high:
        mid  = low + (high-low)//2
        
        if arr[mid] == "":
            left = mid-1
            right = mid+1
            while(True):
                if left<low and right>high:
                    return -1;
                elif left>=low and arr[left] != "":
                    mid = low
                    break;
                elif right<=high and arr[right] != "":
                    mid = right
                    break;
                left -= 1
                right += 1
        if arr[mid] == word:
            return mid
        if arr[mid]<word:
            low = mid+1
        else:
            high = mid-1
    
    return -1
