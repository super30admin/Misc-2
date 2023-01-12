class StreamChecker {

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    StringBuilder sb;

    // Time Complexity: O(m) where m is the length of single word
    // Space Complexity: O(n * l) where n is the number of words and l is the average length of each word
    private void insert(String word) {
        TrieNode curr = root;
        for (int i=word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public StreamChecker(String[] words) {
        sb = new StringBuilder();
        root = new TrieNode();
        // create a trie
        for (String word : words) {
            insert(word);
        }

    }

    // Time Complexity: O(m) where m is the length of sb
    // Space Complexity: O(n * l) where n is the number of words and l is the average length of each word
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;

        for (int i=sb.length() - 1; i>=0; i--) {
            char ch = sb.charAt(i);
            if(curr.children[ch - 'a'] == null) {
                return false;
            }
            if (curr.children[ch - 'a'].isEnd) {
                return true;
            }
            curr = curr.children[ch-'a'];
        }
        return curr.isEnd;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */