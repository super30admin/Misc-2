// Time Complexity : O(nk)
// Space Complexity : O(nk)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class StreamChecker {
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    StringBuilder sb;
    
    private void insert(String word) {
        TrieNode current = root;
        
        for(int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            
            if(current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode();
            }
            
            current = current.children[ch - 'a'];
        }
        
        current.isWord = true;
    }
    
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        
        for(String word : words) {
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        
        TrieNode current = root;
        
        sb.append(letter);
        
        for(int i = Math.min(200, sb.length() - 1); i >= 0; i--) {
            char ch = sb.charAt(i);
            
            if(current.children[ch - 'a'] == null) {
                return false;
            }
            
            if(current.children[ch - 'a'].isWord == true) {
                return true;
            }
            
            current = current.children[ch - 'a'];
        }
        
        return false;
    }
}