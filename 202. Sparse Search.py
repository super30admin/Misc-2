class Solution:
    def sparseSearch(self, arr, key, low, high):
        left = 0
        right = 0

        while low <= high:
            mid = low + (high - low) // 2
            # if string is empty we'll use two pointers and keep moving left and right pointers in outside directions

            if arr[mid] == "":
                left = mid - 1
                right = mid + 1
                while True:
                    # boundary case
                    # if both left and right are either outside the range of low and high or out of bounds
                    # we return -1
                    if left < low and right > high:
                        return -1
                    # checking there is non-empty string on left side
                    elif left >= low and arr[left] != "":
                        mid = left
                        break
                    elif right <= high and arr[right] != "":
                        mid = right
                        break

                    left -= 1
                    right += 1
            if arr[mid] == key:
                print("Found string {} at index {}.".format(arr[mid], mid))
                return mid

            if arr[mid] > key:
                high = mid - 1
            elif arr[mid] < key:
                low = mid + 1

        return -1


arr = ["for", "geeks", "", "", "", "", "ide",
       "practice", "", "", "", "quiz"]
key = 'practice'

low = 0
high = len(arr) - 1
if __name__ == "__main__":
    obj = Solution()
    obj.sparseSearch(arr, key, low, high)

# Binary Search, Two Pointers
# Time Complexity: O(logn)
# Space Complexity: O(logn)
# Did this code successfully run on GeeksForGeeks : Yes
# Any problem you faced while coding this : No
