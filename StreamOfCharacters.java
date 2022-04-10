// Time Complexity : O(k) k - no.of characters in query
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class StreamOfCharacters {

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(int i = word.length() - 1; i >=0; i--){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    TrieNode root;
    StringBuilder sb;
    public void StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(String word: words){
            insert(word);
        }
    }


    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;
        for(int i = sb.length() - 1; i >=0 ; i--){
            char c = sb.charAt(i);
            if(curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
            //check if word is found in Trie
            if(curr.isEnd) return true;
        }
        return false;
    }
}
