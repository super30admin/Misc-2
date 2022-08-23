//Time complexity: O(n)
// Space complexity; O(1) for query method
class StreamChecker {
    TrieNode root;
    StringBuilder sb;
    class TrieNode{
        TrieNode[] arr;
        Boolean isEnd;
        public TrieNode(){
            arr=new TrieNode[26];
            isEnd=false;
        }
    }
    public void insertToTrie(String word)
    {
        TrieNode curr=root;
        for(int i=word.length()-1;i>=0;i--)
        {
            Character c=word.charAt(i);
            if(curr.arr[c-'a']==null)
            {
                curr.arr[c-'a']=new TrieNode();
            }
            curr=curr.arr[c-'a'];
        }
        curr.isEnd=true;
    }
    

    public StreamChecker(String[] words) {
        root=new TrieNode();
        sb=new StringBuilder();
        for(int i=0;i<words.length;i++)
        {
            insertToTrie(words[i]);
        }
        
        
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr=root;
        for(int i=sb.length()-1;i>=0;i--)
        {
            Character c=sb.charAt(i);
            if(curr.arr[c-'a']==null) return false;
            curr=curr.arr[c-'a'];
            if(curr.isEnd==true) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */