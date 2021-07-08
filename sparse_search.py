"""
// Time Complexity : Average case O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
The main twist here is to consider the modified form of bsearch when we come across blank character,
- check for first non blank character in the left and the right -> update the mid accordingly
- follow the normal bsearch comparing string with arr[mid]
"""


def sparse_search(arr,search_word):
    def bsearch(arr,low,high,search_word):
        while low <  high:
            mid = (low + high) // 2
            if arr[mid] == '':
            #check for the nearest possible word which is non blank while checking on the left and the right 
                left = mid - 1
                right = mid + 1
                while True:
                        if left < low and right > high: #word not found
                            return -1

                        if left>=low and arr[left]:
                            mid = left
                            break
                        if right<= high and arr[right]:
                            mid = right
                            break
                        
                        left -=1
                        right+=1
            
            if arr[mid] in search_word:
                return mid
            elif arr[mid] > search_word:
                high = mid - 1
            else:
                low = mid + 1
        
        return -1
    
    return bsearch(arr,0,len(arr)-1,search_word)



if __name__ == '__main__':
    print(sparse_search(["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"],"geeks"))
    print(sparse_search(["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"],"ds"))
    print(sparse_search(["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"],"practice"))