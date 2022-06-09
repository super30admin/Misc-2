// Time Complexity : O(N * M) for constructor  
// O(M) for query where n is the no. of words and m is the word length
// Space Complexity : O(N * M)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create trie and put all the words in reverse order in it
// Now for query keep adding characters in stringbuilder  
// Each time we will call the trie search with the appended word
// The search finds if the suffix ending with this exist of not and return boolean
class StreamChecker {
    Trie tr;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        tr = new Trie();
        sb  = new StringBuilder();
        for(String word: words)
            tr.insert(word);   
    } 
    public boolean query(char letter) {
        sb.append(letter);
        return tr.search(sb.toString());
    }
}
class Trie{
    class TrieNode{
        boolean isWord;
        Map<Character, TrieNode> children;
        TrieNode(){
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }
    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
        TrieNode node = root;
        for(int i = word.length() - 1; i >= 0; i--){
            char c = word.charAt(i);
            if(!node.children.containsKey(c))
                node.children.put(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isWord = true;
    }
    public boolean search(String word){
        TrieNode node = root;
        for(int i = word.length() - 1; i >= 0; i--){
            char c = word.charAt(i);
            node = node.children.get(c);
            if(node == null){
                return false;
            }
            if(node.isWord)
                return true;
        }
        return node.isWord;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */