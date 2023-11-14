// LC 1032. Stream of Characters
// Approach: Create Trie modification (Suffix tree). Add words to the Trie,
// starting backwards, meaning last letter first as the root.
// Store stream as a StringBuilder and go backwards in the sb if a matching letter is found in the stream (sb) as the curr TrieNode.

class Character_Stream {

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;
        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = word.length()-1; i>=0; i--) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    TrieNode root;
    StringBuilder sb;
    int max;

    // Time, Space: O(nm), n = no. of input words, m = word length
    public Character_Stream(String[] words) {
        this.root = new TrieNode();
        this.sb = new StringBuilder();
        for (String word : words) {
            max = Math.max(max, word.length());
            insert(word);
        }
    }

    // Time, Space: O(m), m = max word length
    public boolean query(char letter) {
        if (sb.length() > max) {
            sb.deleteCharAt(0);
        }
        sb.append(letter);
        int currLenSb = sb.length();
        TrieNode curr = root;

        for (int i = currLenSb - 1; i>=0 && i>=currLenSb - max; i--) {
            char c = sb.charAt(i);
            if (curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
            if (curr.isEnd) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */