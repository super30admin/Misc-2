/*
Character Stream
approach: we can see that we have to search for words starting with a prefix which can be easily solved using tries and also, for
each query we're checking for a common character, for example
query is a, n, d, y - then we're checking if there are words starts with y, dy, ndy, andy
so each time previous characters are repeated, to reduce these we can use suffix tree which is storing words in reverse in Trie
time: O(len(q))
space: O(1)
 */
public class Problem2 {
    class Trie{
        boolean isEnd;
        Trie[] children;

        public Trie() {
            this.children = new Trie[26];
        }
    }
    Trie root;
    StringBuilder queryPrefix;
    int max;

    public Problem2(String[] words) {
        this.root = new Trie();
        this.max = 0;
        this.queryPrefix = new StringBuilder();

        for (String word: words) {
            max = Math.max(max, word.length());
            insert(word);
        }
    }

    private void insert(String word) {
        Trie curr = root;

        for (int i=word.length()-1;i>=0;i--) {
            char c = word.charAt(i);
            if (curr.children[c-'a']==null) {
                curr.children[c-'a'] = new Trie();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    public boolean query(char letter) {
        queryPrefix.append(letter);
        if (queryPrefix.length()>max) {
            queryPrefix.deleteCharAt(0);
        }
        Trie curr = root;
        for (int i=queryPrefix.length()-1;i>=0;i--) {
            char c = queryPrefix.charAt(i);
            if (curr.children[c-'a']==null) return false;
            curr = curr.children[c-'a'];
            if (curr.isEnd) return true;
        }
        return false;
    }
}
