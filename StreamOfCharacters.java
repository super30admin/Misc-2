//TC-O(N * L) SC-O(N*L)
public class StreamOfCharacters {
    public class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    TrieNode root;
    StringBuilder sb;

    private void insert(String word){
        TrieNode curr = root;
        for(int i = word.length()-1; i>=0 ; i--){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    private boolean find(String word){
        TrieNode curr = root;
        for(int i = word.length()-1; i>=0; i--){
            char c = word.charAt(i);
            if(curr.children[c-'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
            if(curr.isEnd){
                return true;
            }
        }
        return false;
    }

    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(String word: words){
            insert(word);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        return find(sb.toString());
    }
}
