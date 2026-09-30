//problem1
class Solution {

    // Linear Search in an array with blanks
    static int linearSearch(String arr[], int n, String x) {

        for(int i = 0; i < n; i++) {

            if(arr[i].equals("")) continue;

            if(arr[i].equals(x)) return i;
        }

        return -1;
    }

    private static int sparseSearch(String arr[], String x, int n){
        return linearSearch(arr, n, x);
    }

    public static void main(String args[]) {

        String arr[] = {"for", "geeks", "", "", "", "", "ide",
                        "practice", "", "", "", "quiz"};

        String x = "geeks";
        int n = arr.length;

        int index = sparseSearch(arr, x, n);

        if(index != -1)
            System.out.println(x + " found at index " + index);
        else
            System.out.println(x + " not found");
    }
}
//problem2
class StreamChecker {
    TrieNode root;
    StringBuilder sb;
    int maxlen=0;
    class TrieNode{
        TrieNode[] children;
        boolean isstart;
        public TrieNode(){
            this.children=new TrieNode[26];
        }
    }
    public void insert(String word){
        TrieNode curr=root;
        for(int i=word.length()-1;i>=0;i--){
            char ch=word.charAt(i);
            if(curr.children[ch-'a']==null){
                curr.children[ch-'a']=new TrieNode();
            }
            curr=curr.children[ch-'a'];
        }
        curr.isstart=true;
    }
    public StreamChecker(String[] words) {
        this.root=new TrieNode();
        this.sb=new StringBuilder();
        for(String word:words){
            maxlen=Math.max(maxlen,word.length());
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        if(sb.length()>maxlen){
            sb.deleteCharAt(0);
        }
        TrieNode curr=root;
        for(int i=sb.length()-1;i>=0;i--){
            char ch=sb.charAt(i);
            if(curr.children[ch-'a']==null) return false;
            if(curr.children[ch-'a'].isstart) return true;
            curr=curr.children[ch-'a'];
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
//problem3
// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        
        int[] arr = new int[]{1,2,3};
        System.out.println(sumOfProductofSubSets(arr));  //23
       
    }
    
    private static int sumOfProductofSubSets(int[] arr){
        
        int n = arr.length;
        int result = 1;
        
        for(int i=0; i<n; i++){
            result *= 1 + arr[i];
        }
        
        return result-1;
    }
}
