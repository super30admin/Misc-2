// Time Complexity : O(n*l)
// Space Complexity : O(l)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class StreamChecker {
    class TrieNode{
        TrieNode[] children;
        boolean isStart;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    public void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(int i = word.length()-1; i >=0 ; i--){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null)
                curr.children[c-'a'] = new TrieNode();
            curr = curr.children[c-'a'];
        }
        curr.isStart = true;
    }
    StringBuilder stream;
    TrieNode root;
    public StreamChecker(String[] words) {
        this.stream = new StringBuilder();
        this.root = new TrieNode();
        for(String word : words){
            insert(root,word);
        }
    }
    
    public boolean query(char letter) {
        stream.append(letter);
        TrieNode curr = root;
        for(int i = stream.length()-1; i >= 0; i--){
            char c = stream.charAt(i);
            if(curr.children[c-'a']==null)
                return false;
            curr = curr.children[c-'a'];
            if(curr.isStart)
                return true;
        }
        return false;
    }
}