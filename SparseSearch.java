// Time Complexity: O(N) since worst case, if there are only two words at beggining and end and all
// others are sparse characters, then its going to incrmeent and decrment right and left
// Amortized Time Complexity: O(logN)
// Space Complexity: O(1)

// "static void main" must be defined in a public class.
public class Main {

    private static int binarySearch(String[] words, String x) {
        int low = 0;
        int high = words.length - 1;

        while (low<= high) {
            int mid = low + (high-low)/2;
            if (words[mid] == "") {
                int left = mid - 1;
                int right = mid + 1;
                if (left <low && right>high) {
                    return -1;
                }
                while (left >= low && right <=high) {
                    if (left>=low && words[left] != "") {
                        mid = left;
                        break;
                    }
                    if (right  <= high && words[right] != "") {
                        mid = right;
                        break;
                    }
                    left--;
                    right++;
                }

            }

            if(x.compareTo(words[mid]) == 0) {
                return mid;
            } else if (x.compareTo(words[mid])  < 0) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"for", "", "", "", "geeks", "", "", "xyz", "", "", "zebra"};
        System.out.println(binarySearch(words, "adc"));
    }
}