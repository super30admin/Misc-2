//Use Trie DS to store the strings in a reverse manner. (Suffix tree)
//Did it run successfully on Leetcode?:Yes
class StreamChecker {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;
    //TC: O(M) -> length pf max word
    //SC: O(M) -> length pf max word
    public void insertInTrie(String word){
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--){  //insert the reverse of the word -> start inserting letters from end of the word
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    //TC: O(M*N) -> M:length of max word, N:No.of words in the dictionary
    //SC: O(M*N) -> M:length of max word, N:No.of words in the dictionary
    public StreamChecker(String[] words) {
        root = new TrieNode();
        for (String word: words){
            insertInTrie(word);
        }
    }
    StringBuilder sb = new StringBuilder();
    //TC: O(M) -> length pf max word
    //SC: O(M) -> length pf max word
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;
        for (int i = sb.length() -1 ; i >= 0; i--){ //Iterate the stringbuilder from the end
            char c = sb.charAt(i);
            if (curr.children[c-'a'] == null)
                return false;
            curr = curr.children[c-'a'];
            if (curr.isEnd){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
