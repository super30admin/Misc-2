//Time Complexity: O(N * L) for tries + O(K) for each query where N is the number of words in the dictionary and L is the length of each word and K is the length of the stream.
//Space Complexity: O(N * L) + O(K)

//Build a reversed trie of all words and track the stream in a StringBuilder capped at maxLength.
//On each query, append the letter; if buffer exceeds maxLength, drop the oldest char.
//Walk the trie from the buffer’s end toward start; if a path ends at isStartsWith==true return true; if a child is missing return false.


class StreamChecker {

    TrieNode root;
    StringBuilder sb;
    int maxLength;

    class TrieNode {
        TrieNode[] children;
        boolean isStartsWith;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word) { // mat
        TrieNode curr = root;

        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }

        curr.isStartsWith = true;
    }

    public StreamChecker(String[] words) {
        this.root = new TrieNode();
        this.sb = new StringBuilder();

        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
            insert(word);
        }
    }

    public boolean query(char letter) { // abat

        sb.append(letter);

        if (sb.length() > maxLength) {
            sb.deleteCharAt(0); // O(k)
        }

        TrieNode curr = root;

        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);

            if (curr.children[c - 'a'] == null) {
                return false;
            }
            if (curr.children[c - 'a'].isStartsWith) return true;
            curr = curr.children[c - 'a'];
        }

        return false;
    }
}
