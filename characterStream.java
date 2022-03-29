// Time Complexity = O(nk), to create the trie
// Space Complexity = O(nk)+O(l), where n=no. of words, k=avg length of each word, l=no. of input alphabets
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// We store the words in a trie in the reverse order since we want to do a suffix match
// In the query method everytime we get a new character, we append it to the stringbuilder and traverse the sb from the end to the start to check if its characters are present in the trie, as soon as we hit one of the following 2 conditions we return:
// when the child is null -> return false
// when we get isEnd -> return true
// finally if the above 2 cases are not hit, we return false, since the sb till now hasnt been a part of the words list

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

    private void buildTrie(String word) {
        TrieNode curr = root;
    }

    public StreamChecker(String[] words) {
        if (words == null || words.length == 0) return;
        root = new TrieNode();
        sb = new StringBuilder();

        // we will fill the trie with the words in a reverse order, since we want to check for suffix
        for (int i=0; i<words.length; i++) {
            String word = words[i];
            TrieNode curr = root;

            for (int j=word.length()-1; j>=0; j--) {
                if (curr.children[word.charAt(j) - 'a'] == null) {
                    curr.children[word.charAt(j) - 'a'] = new TrieNode();
                }
                curr = curr.children[word.charAt(j) - 'a'];
            }
            curr.isEnd = true;
        }
    }

    public boolean query(char letter) {
        TrieNode curr = root;

        sb.append(letter);
        for (int i=sb.length()-1; i>=0; i--) {
            char c = sb.charAt(i);
            if (curr.children[c-'a'] == null) {
                return false;
            }
            curr = curr.children[c - 'a'];
            if (curr.isEnd == true) {
                return true;
            }
        }
        return false;
    }
}