// TC-O(logN) SC-O(1)
public class SparshSearch {
    // Sparse search function
    public static int sparseSearch(String[] arr, String target) {
        if (arr == null || target == null || target.isEmpty()) {
            return -1;
        }

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right)/ 2;

            // Move mid to the closest non-empty string
            if (arr[mid].isEmpty()) {
                int midLeft = mid - 1;
                int midRight = mid + 1;
                while (true) {
                    if (midLeft < left && midRight > right) {
                        return -1;
                    } else if (midRight <= right && !arr[midRight].isEmpty()) {
                        mid = midRight;
                        break;
                    } else if (midLeft >= left && !arr[midLeft].isEmpty()) {
                        mid = midLeft;
                        break;
                    }
                    midLeft--;
                    midRight++;
                }
            }

            // Normal binary search logic
            if (arr[mid].equals(target)) {
                return mid;
            } else if (arr[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Not found
    }

    // Main method
    public static void main(String[] args) {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", "", "geeks", "", "geeks", "", ""};
        String target = "geeks";

        int index = sparseSearch(words, target);

        if (index != -1) {
            System.out.println("Found '" + target + "' at index: " + index);
        } else {
            System.out.println("'" + target + "' not found.");
        }
    }
}
