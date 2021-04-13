/*
we will make use of Trie here. But we will build siffix tree instead of prefix
TC : O(m * n), to build the trie and to insert, wehre m is word length and n is number of words
TC : O(m), to query, where m is max word length

*/

class SuffixTrie{
    SuffixTrie [] children;
    boolean isEnd;
    SuffixTrie(){
        this.children = new SuffixTrie[26]; //assuming 26 characters
        this.isEnd = false;
    }
    
    
}
class StreamChecker {

   
    private void insertIntoTree(String word){
        SuffixTrie curr = root;
        for(int i = word.length()-1; i >= 0;i--){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new SuffixTrie();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }
    
    
     SuffixTrie root;
    StringBuilder sb;
    
    public StreamChecker(String[] words) {
        this.root = new SuffixTrie();
        sb = new StringBuilder();
        
        for(String word : words){
            insertIntoTree(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        SuffixTrie curr = root;
        for(int i = sb.length()-1; i >= 0;i--){
            char ch = sb.charAt(i);
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            curr = curr.children[ch-'a'];
            if(curr.isEnd)return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */