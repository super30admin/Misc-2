// Time, Space - O(lgN), O(1)
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] arr = {"geeks", "","","for","","",
                                                    "geeks","",""};
        System.out.println(sparseSearch(arr,"for"));
    }
    
    private static int sparseSearch(String[] arr, String s) {
        int low =0 , high = arr.length-1;
        while(low<high) {
            int mid = low + (high - low)/2;
            if(arr[mid]==""){
                int left = mid - 1;
                int right = mid + 1;
                while(true) {
                    if(left<low&&right>high) {
                        return -1;
                    }
                    else if(left>=low&&arr[left]!="") {
                        mid= left;
                        break;
                    }
                    else if(right<=high && arr[right]!="") {
                        mid=right;
                        break;
                    }
                    left--;
                    right++;
                }
            }
            if(s.compareTo(arr[mid]) == 0) {
                return mid;
            }
            else if(s.compareTo(arr[mid]) < 0) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
                                    
        return -1;
    }
}
