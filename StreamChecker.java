public class StreamChecker {
    /**
     * Use trie as suffix trie.
     * store all the words in reverse order. Mark last(first char) as end of trie
     * when new character comes in check the first char if its present return true
     * or false.
     Insert
     Time - o(l) lenth of incoming word

     Find
     Time - o(k) k is max length of any of the String

     Query
     * Time complexity -o(k) k Total number of calls made ot query
     * Space complexity - o(nk) n number of words, k is lenght of words
     */
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;
    StringBuilder sb;

    private void insert(String word) {
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    boolean find(String word) {
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
            if (curr.isEnd == true) {
                return true;
            }
        }
        return false;
    }
    public StreamChecker(String[] words) {
        if (words == null || words.length == 0) {
            return;
        }
        root = new TrieNode();
        sb = new StringBuilder();
        // insert all words into the trie.
        for (String word : words) {
            insert(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return find(sb.toString());
    }

}
