class StreamChecker {
    
    class TrieNode{
            boolean isEnd;
            TrieNode [] children;
            public TrieNode(){
                children = new TrieNode[26];
            }
                
    }
    
    private void insert(String word){
        TrieNode curr = root;
        for(int i = word.length()-1; i >= 0; i--){
            char c = word.charAt(i);
            if(curr.children[c -'a'] == null){
                curr.children[c-'a'] = new TrieNode();
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
        for(String word: words){
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;
        
        for(int i = sb.length() -1;i>=0; i--){
            char c = sb.charAt(i);
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
            if(curr.isEnd) return true;
        }
        return false;
    }
}



//TC: O(n*k)
//SC: O(1)
