// Time Complexity : The time complexity is O(n) where n is the length of the input stream
// Space Complexity : Te space complexity is O(n) where n is the length of the input stream
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class StreamChecker {

    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    TrieNode root;

    public void insert(String word){

        TrieNode cur = root;

        for(int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);

            if(cur.children[c-'a'] == null){
                cur.children[c-'a'] = new TrieNode();
            }

            cur = cur.children[c-'a'];
        }

        cur.isEnd = true;
    }
    public StreamChecker(String[] words) {
        root = new TrieNode();

        //store all thr words in a trie in reverse order since we are searching for the words in reverse order
        for(String word:words){
            insert(word);
        }
    }

    StringBuilder sb = new StringBuilder();

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode cur = root;

        //check if the current input is present in the dictionary
        for(int i=sb.length()-1;i>=0;i--){
            char c = sb.charAt(i);

            if(cur.children[c-'a'] == null) return false;
            cur = cur.children[c-'a'];
            if(cur.isEnd) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */