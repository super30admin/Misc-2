//Time - O(n)
//Space - O(n*k)
class StreamChecker {
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }


    public void insert(String word){
            TrieNode curr = root;
            for(int j=word.length()-1; j>=0; j--){
                char c = word.charAt(j);
                if(curr.children[c -'a'] == null){
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

    TrieNode root;
    StringBuilder sb;

    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }
    }
    
    public boolean query(char letter) {
        TrieNode curr = root;
        sb.append(letter);
        for(int i =sb.length()-1; i>=0; i--){
            char c = sb.charAt(i);
            if( curr.children[c-'a'] == null) return false;
            curr = curr.children[c-'a'];
            if(curr.isEnd) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */