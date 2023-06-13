//Time -> O(nl)
//Space -> O(1)

class StreamChecker {
    TrieNode root;
    StringBuilder sb;
    int max;

    class TrieNode {
        TrieNode[] children;
        boolean isStart;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

    public StreamChecker(String[] words) {
        this.sb = new StringBuilder();
        root = new TrieNode();
        this.max = 0;
        
        for (String word : words) {
            insert(root, word);
            max = Math.max(max, word.length());
        }
    }

    public void insert(TrieNode root, String word) {
        TrieNode curr = root;
        int l = word.length();
        for (int i = l - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isStart = true;
    }

    public boolean query(char letter) {
        sb.append(letter);
        int l = sb.length();
        int k = Math.min(max, l);
        TrieNode curr = root;
        for (int i = l - 1; i >= l - k; i--) {
            char c = sb.charAt(i);
            if (curr.children[c - 'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
            if (curr.isStart) {
                return true;
            }
        }
        return false;
    }
}
