class Solution:
    def sparseSearch(self, arr: List[str], x: str) -> int:
        # TC : O(log n)
        # SC : O(1)
        left, right = 0, len(arr) - 1  # Initialize binary search bounds

        while left <= right:
            mid = (left + right) // 2  # Compute middle index

            # If mid is an empty string, find the closest non-empty string
            if arr[mid] == "":
                left_idx, right_idx = mid - 1, mid + 1

                # Search towards both left and right for the closest non-empty string
                while True:
                    if left_idx < left and right_idx > right:  # If both sides are out of bounds
                        return -1
                    elif right_idx <= right and arr[right_idx] != "":
                        mid = right_idx  # Update mid to closest non-empty string
                        break
                    elif left_idx >= left and arr[left_idx] != "":
                        mid = left_idx  # Update mid to closest non-empty string
                        break
                    right_idx += 1
                    left_idx -= 1

            # Perform standard binary search comparison
            if arr[mid] == x:
                return mid  # Found target, return index
            elif arr[mid] < x:
                left = mid + 1  # Search in the right half
            else:
                right = mid - 1  # Search in the left half

        return -1  # Target not found