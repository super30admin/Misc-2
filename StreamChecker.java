// Time Complexity : O(k) k is the max length of the word in dictionary / length of the query
// Space Complexity : O(nl) n is the number of words and l is the average length of the each word
// Did this code successfully run on Leetcode : Yes

public class StreamChecker {
    StringBuilder sb;
    TrieNode root;
    int max;
    class TrieNode{
        TrieNode[] children;
        boolean isStart;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(String word: words){
            insert(word);
        }
    }

    private void insert(String word){ // O(nl)
        TrieNode curr = root;
        for(int i=word.length()-1; i>=0; i--){
            max = Math.max(max,word.length());
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isStart = true;
    }

    public boolean query(char letter) {  // O(k) k is the length of the query
        if(sb.length() == max){
            sb.deleteCharAt(0);
        }
        sb.append(letter);
        TrieNode curr = root;
        for(int i = sb.length()-1; i>=0; i--){
            char c = sb.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
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