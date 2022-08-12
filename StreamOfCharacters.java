// time: O(Length of the string*Length of the substring) | space: O(Length of the string)


class StreamChecker {
    class Trie {
        Trie[] children;
        boolean isEnd;
        public Trie() {
            children = new Trie[26];
        }
    }
    Trie root;
    public void insertWords(String word) {
        Trie curr = root;
        for(int i=word.length()-1;i>=0;i--) {
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null) {
                curr.children[c-'a'] = new Trie();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }
    StringBuilder sb;
    public StreamChecker(String[] words) {
        root  = new Trie();
        sb = new StringBuilder();
        for(String word: words) {
            insertWords(word);
        }
    }

    public boolean query(char letter) {
        Trie curr = root;
        sb.append(letter);
        for(int i=sb.length()-1;i>=0;i--) {
            char c = sb.charAt(i);
            if(curr.children[c-'a'] == null || curr.isEnd) break;
            curr = curr.children[c-'a'];
        }
        if(curr.isEnd) return true;
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */