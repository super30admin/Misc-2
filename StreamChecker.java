// Time Complexity : O(n) no of characters
// Space Complexity : O(d) trie size 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

// Your code here along with comments explaining your approach
class StreamChecker {

    private TrieNode root;
    private StringBuilder query;
    public StreamChecker(String[] words) {
        
        root = new TrieNode();
        query = new StringBuilder("");
        
        for(String word : words) {
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        query.append(letter);
        return isValidQuery();
    }
    
    public void insert(String word) {
        
        TrieNode temp = root;
        for(int i = word.length()-1;i>=0;i--) {
         
            if(!temp.child.containsKey(word.charAt(i))) {
                temp.child.put(word.charAt(i), new TrieNode());
            }
            temp = temp.child.get(word.charAt(i));
        }
        temp.isWord = true;
    }
    
    public boolean isValidQuery() {
        
        TrieNode temp = root;
        for(int i = query.length()-1;i>=0;i--) {
         
            if(!temp.child.containsKey(query.charAt(i))) {
                return false;
            }
            temp = temp.child.get(query.charAt(i));
            if(temp.isWord) return true;
        }
        return temp.isWord;
        
    }
    
}

class TrieNode {
    
    public Map<Character,TrieNode> child;
    public boolean isWord = false;
    
    public TrieNode() {
        child = new HashMap();
    }
    
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
