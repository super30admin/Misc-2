public class SparseSearch {
    // "static void main" must be defined in a public class.
    public class Main {
        public static int binarySearch(String[] str, String x){
            int low = 0;
            int high = str.length-1;
            while(low<=high){
                int mid = low+(high-low)/2; // to prevent integer overflow
                int left =mid-1;
                int right = mid+1;
                while(true){
                    if(left<low && right >high){
                        return -1;
                    }
                    if(left>=low && str[left]!=""){
                        mid = left;
                        break;
                    }
                    if(right<=high && str[right]!=""){
                        mid =right;
                        break;
                    }
                    left--;
                    right++;

                }
                if(x.compareTo(str[mid]) == 0){
                    return mid;
                }else if(x.compareTo(str[mid]) < 0){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            return -1;
        }
        public static void main(String[] args) {
            String[] strs = {"for", "", "","","","","","","geeks","","","","","","","","","", "Zebra","","","","",};
            String x = "Zebra";
            System.out.println(binarySearch(strs,x));
        }
    }
}
