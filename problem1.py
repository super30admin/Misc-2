# problem 1 

class Solution:

    def binarySearch(self, arr, low, high, x):
        while low <= high:
            mid = low + (high - low) // 2
            if arr[mid] == "":
                left = mid - 1
                right = mid + 1

                while True:
                    if left < low and right > high:
                        return -1

                    elif left >= low and arr[left] != "":
                        mid = left
                        break

                    elif right <= high and arr[right] != "":
                        mid = right
                        break

                    left -= 1
                    right += 1

            if arr[mid] == x:
                return mid
            elif x < arr[mid]:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def sparseSearch(self, arr, x, n):
        return self.binarySearch(arr, 0, n - 1, x)


arr = ["for", "geeks", "", "", "", "", "ide", "practice", "", "", "", "quiz"]
x = "geeks"
n = len(arr)

sol = Solution()
index = sol.sparseSearch(arr, x, n)

if index != -1:
    print(f"{x} found at index {index}")
else:
    print(f"{x} not found")
