// "static void main" must be defined in a public class.
public class Main {

    //Time Complexity: 0(nlogk ) where n is the no. of words in my array and k is the average length
    //Space Complexity: 0(1)

    public static int BS(String [] arr, String value){
        int low = 0;    //I am doing a binary search to find the value
        int high = arr.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;   //getting mid
            if(arr[mid].equals("")){    //if mid equals to empty string, then I start branching out and moving my left towards left and right towards right from mid till I find a word
                int left = mid - 1;
                int right = mid + 1;
                while(true){    //till my condition is true
                    if(left < low && right > high){ //if either one is out of bounds, means there are no words
                        return -1;  //so I return -1
                    }
                    if(left >= low && arr[left] != ""){//if left is in bounds, and if it is not null, then I have found a non empty string and do binary search on that
                        mid = left; //so I assign my mid to left and i break
                        break;
                    }
                    if(right <= high && arr[right] != ""){  //do same for right
                        mid = right;
                        break;
                    }
                    left--; //otherwise I keep on moving my left pointer left of mid and right, right of mid
                    right++;
                }
            }
            if(arr[mid].equals(value)){ //once I come out, 3 things can happen, Either the word is the target I am looking for
                return mid; //then I return the current index where value is found
            }
            else if(value.compareTo(arr[mid]) < 0){ //or I compare the string with target, I get -1, 0 and 1 while comparing. If the current string is lexicographically bigger, Then i need to move my search to left so I move my high
                high = mid - 1;
            }
            else{   //else I move towards right
                low = mid + 1;
            }
        }
        return -1;  //If i still haven't returned anything, means the word is not present and I return -1
    }

    public static void main(String[] args) {
        String [] arr = {"for", "", "", "", "", "", "", "", "geeks", "", "", "", "iron", "", "", "", "zooms"};
        String value = "for";
        System.out.println(BS(arr, value));
    }
}