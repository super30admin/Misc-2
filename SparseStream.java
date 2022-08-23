//Time complexity: O(nl)
// Space complexity; O(nl)
public class SparseStream {
    TrieNode root;
    public class TrieNode{
        TrieNode[] arr;
        Boolean isEnd;
        public TrieNode(){
            arr=new TrieNode[26];
            isEnd=false;
        }
    }
    public void insertToTrie(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(curr.arr[c-'a']==null)
            {
                curr.arr[c-'a']=new TrieNode();
            }
            curr=curr.arr[c-'a'];
        }
        curr.isEnd=true;
    }
    public int checkWord(String[] arr, String word){
        root=new TrieNode();
        TrieNode curr=root;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i].equals("")) continue;
            insertToTrie(arr[i]);
        }
        for(int i=0;i<word.length();i++)
        {
            char c=word.charAt(i);
            if(curr.arr[c-'a']==null) return -1;
            curr=curr.arr[c-'a'];
        }
        if(curr.isEnd) return 1;
        else return -1;
    }
    
}
