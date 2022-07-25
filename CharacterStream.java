//TC : O(nk) where n is number of words and k is the avg length
//SC : O(nk)
class StreamChecker {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode root;
    StringBuilder sb;

    private void insert(String word) {
        TrieNode current = root;

        for(int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);

            if(current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode();
            }

            current = current.children[ch - 'a'];
        }

        current.isWord = true;
    }

    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();

        for(String word : words) {
            insert(word);
        }
    }

    public boolean query(char letter) {

        TrieNode current = root;

        sb.append(letter);

        for(int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);

            if(current.children[ch - 'a'] == null) {
                return false;
            }

            if(current.children[ch - 'a'].isWord == true) {
                return true;
            }

            current = current.children[ch - 'a'];
        }

        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */