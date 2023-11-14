// Approach: Binary search with while loop to skip the empty strings
// Time: O(nlogn)
// Space: O(1)

public class Sparse_Search {

    public static void main(String[] args) {

        String[] words = new String[] {
          "ant", "", "", "", "bat", "",
          "car", "", "", "coat", "", "",
          "", "", "fox", "", "yolk", "zebra"
        };

        for (int i = 0; i<words.length; i++) {
            boolean empty = words[i].isEmpty();
            int rec = search(words, words[i]);

            if (i == rec || (rec == -1 && empty)) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL, Expected: " + i + ", Returned: " + rec);
            }
        }
    }

    private static int search(String[] words, String target) {

        int low = 0, high = words.length-1;

        while (low <= high) {
            int mid = low + (high - low)/2;

            if (words[mid].isEmpty()) {         // empty string
                int i = mid-1, j = mid+1;

                while (i >= low || j <= high) {

                    if (i >= low && !words[i].isEmpty()) {
                        mid = i;
                        break;
                    }
                    if (j <= high && !words[j].isEmpty()) {
                        mid = j;
                        break;
                    }

                    if (i < low && j > high) {
                        break;
                    }
                }
            }

            int cmp = target.compareTo(words[mid]);

            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                high = mid - 1;         // move to left
            } else {
                low = mid + 1;          // move to right
            }
        }

        return -1;
    }
}

