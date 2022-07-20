public class Problem2 {

    // Trie solution
    // TC : O(kn + l)
    // SC : O (kn)
    // where n is total word , k = avg size of word and l = stream of characters
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    StringBuilder sb;

    public void StreamChecker(String[] words) {
        root = new TrieNode();
        for (String word : words) {
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
        sb = new StringBuilder();
    }

    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;

        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            if (curr.children[c - 'a'].isEnd) {
                return true;
            }
            curr = curr.children[c - 'a'];
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
