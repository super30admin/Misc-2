# TIME COMPLEXITY: O(log N) - N is length of the words array
# SPACE COMPLEXITY: O(1)

# Modified binary search - if mid is "", set mid to the nearest non empty string 
def sparseSearch(words, target):
    start = 0
    end = len(words) - 1
    while start <= end:
        mid = (start + end) // 2 
        low, high = 0, 0
        if words[mid] == "":
            low = mid - 1
            high = mid + 1
            while True:
                if low < start and high > end:
                    return -1
                elif low >= start and words[low] != "":
                    mid = low
                    break
                elif high <= end and words[high] != "":
                    mid = high
                    break
                else:
                    low -= 1
                    high += 1
        if words[mid] == target:
            return mid
        else:
            if words[mid] > target:
                end = mid - 1
            else:
                start = mid + 1
            

def main():
    words = ["for", "geeks", "", "", "", "", "ide",  
           "practice", "", "", "", "quiz"]                  
    target = ''
    print(sparseSearch(words , target))

main()