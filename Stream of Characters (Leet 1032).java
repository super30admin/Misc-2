// Tries can also be used as suffix trees as well
// If string builder length is greater than some specific threshod (let's say 200), then if it crosses then we can move the elements and start doing the same process again

// Time: O(nm), where m is the average word length
// Space: O(nm), where m is the average word length


class StreamChecker {
    
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    StringBuilder sb;
    
    public void insert(String word){
        TrieNode curr = root;
        for(int i = word.length()-1; i >= 0; i--){
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for (String w: words){
            insert(w);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;
        for(int i = sb.length()-1; i >=0; i--){
            char c = sb.charAt(i);
            if (curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
            if (curr.isEnd == true) return true;
            
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
