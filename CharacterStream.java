// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Using Trie (storing the string in reverse order)
class StreamChecker {
    
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        
        public TrieNode(){
            children = new TrieNode[26]; 
        }
    }
        
    TrieNode root;
        
    private void insert(String word){
        TrieNode curr = root;
        for(int i=word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true; 
    }
            
    
    StringBuilder sb;
    public StreamChecker(String[] words) {
        sb = new StringBuilder();
        root = new TrieNode();
        for(String word : words){
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;
        for(int i= sb.length()-1; i>=0; i--){
            char c = sb.charAt(i);
            if(curr.children[c-'a'] == null)
                return false;
            curr = curr.children[c-'a'];
            if(curr.isEnd)
                return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
