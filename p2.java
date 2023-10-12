// Time Complexity : for query O(k) where k is the max length of word in words
// Space Complexity :O(n*l) where n is the number of words and l is the average length
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class StreamChecker {
//Using inverted trie to check the suffix
    public class Trie{
        Trie[] children;
        boolean isStart;
        public Trie(){
            this.children = new Trie[26];
        }
    }

    public void insert(String word){
        Trie curr = root;
        for(int i=word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            if(curr.children[c - 'a'] == null){
                curr.children[c-'a'] = new Trie();
            }
            curr = curr.children[c-'a'];
        }
        curr.isStart = true;
    }

    Trie root;
    StringBuilder sb;
    int max = 0;
    public StreamChecker(String[] words) {
        this.root = new Trie();
        sb = new StringBuilder();
        for(String word: words){
            insert(word);
            max = Math.max(max, word.length());
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        if(sb.length() > max){
            sb.deleteCharAt(0);
        }
        Trie curr = root;
        for(int i=sb.length()-1; i>=0; i--){
            char c = sb.charAt(i);
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
            if(curr.isStart) return true;
        }
        return false;

    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */