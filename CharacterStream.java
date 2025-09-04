// TC: O(n)
// SC: O(n)
class StreamChecker {
    class TrieNode {
        TrieNode[] children;
        boolean isComplete;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isComplete = false;
        }
    }

    TrieNode root;
    StringBuilder stream;
    int maxlen = 0;

    public StreamChecker(String[] words) { // O(n) building trie
        root = new TrieNode();
        stream = new StringBuilder();

        for (String word : words) {
            insert(word);
            maxlen = Math.max(maxlen, word.length());
        }
    }

    public boolean query(char letter) { // O(maxlen) for search

        stream.append(letter);

        if (stream.length() > maxlen) {
            stream.deleteCharAt(0);
        }

        return search(stream);
    }

    private void insert(String word) {
        // suffix tree
        TrieNode curr = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);

            if (curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new TrieNode();
            }

            curr = curr.children[ch - 'a'];
        }

        curr.isComplete = true;
    }

    private boolean search(StringBuilder word) {

        TrieNode curr = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);

            if (curr.children[ch - 'a'] == null) {
                return false;
            }

            curr = curr.children[ch - 'a'];

            if (curr.isComplete == true) {
                return true;
            }
        }

        return curr.isComplete;

    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */