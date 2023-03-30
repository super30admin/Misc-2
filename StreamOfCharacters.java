public class StreamOfCharacters {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        private TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word){
        TrieNode curr = root;
        for(int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            if(curr.children[c-'a']==null){
                curr.children[c-'a'] = new TrieNode();
            }
            curr = curr.children[c-'a'];
        }
        curr.isEnd = true;
    }

    TrieNode root;
    StringBuilder sb;
    int max; // length of the longest word from list of words
    public StreamChecker(String[] words) {
        this.root = new TrieNode();
        this.sb = new StringBuilder();
        for(String word:words){
            insert(word);
            max = Math.max(max, word.length());
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        if(sb.length()>max){
            sb.deleteCharAt(0);
        }
        TrieNode curr = root;
        for(int i=sb.length()-1;i>=0;i--){
            char c = sb.charAt(i);
            if(curr.children[c-'a']==null) return false;
            curr = curr.children[c-'a'];
            if(curr.isEnd) return true;
        }
        return false;
    }
}

// TC - O(n)
// SC - O(n) n - length of longest word