class Solution:
    def sparseSearch(self, arr, key):
        """
            https://www.geeksforgeeks.org/sparse-search/
            Time Complexity - O(n)
            'n' is the length of arr
            Space Complexity - O(1)
        """
        low, high = 0, len(arr) - 1
        while low <= high:
            mid = (low + high) // 2
            if arr[mid] == '':
                left = mid - 1
                right = mid - 1
                while True:
                    # both left and right are moving at same speed
                    # so 'and' works
                    if left < low and right > high:
                        return -1
                    elif left >= low and arr[left] != '':
                        mid = left
                        break
                    elif right <= high and arr[right] != '':
                        mid = right
                        break
                    left -= 1
                    right -= 1
            if arr[mid] == key:
                return arr[mid]
            elif arr[mid] < key:
                low = mid + 1
            else:
                high = mid - 1
        return -1


if __name__ == '__main__':
    print(Solution().sparseSearch(["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"], 'geeks'))
    print(Solution().sparseSearch(["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"], 'ds'))
