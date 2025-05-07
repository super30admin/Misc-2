public class StreamChecker {
    //TC => O(nk) => length of longest word
    //SC => O(nk)
    public class TrieNode{
        public TrieNode[] Children;
        public bool IsEnd;
        // public char Char1;
        public TrieNode(){
            Children = new TrieNode[26];
            IsEnd = false;
        }
     }
     TrieNode root;
     StringBuilder sb;

    public void Insert(string word){
        TrieNode current = root;
        for(int i = word.Length - 1; i >= 0; i--){
            char c = word[i];
            if(current.Children[c - 'a'] == null){
                current.Children[c-'a'] = new TrieNode();
            }
            // current.Char1 = c;
            // if(i == 0){
            //     break;
            // }
            current = current.Children[c-'a'];
        }
        current.IsEnd = true;
    }

    public bool Find(string sufix){
        TrieNode current = root;
        for(int i = sufix.Length - 1; i >= 0; i--){
            char c = sufix[i];
            if(current.Children[c - 'a'] == null){
                return false;
            }
            current = current.Children[c-'a'];
            if(current.IsEnd){
                return true;
            }
            
        }
        return false;
    }
    public StreamChecker(string[] words) {
        if(words == null || words.Length == 0){
            return;
        }

        root = new TrieNode();
        sb = new StringBuilder();
        foreach(var w in words){
            Insert(w);
        }
    }
    
    public bool Query(char letter) {
        sb.Append(letter);
        // Console.WriteLine(sb.ToString());
        return Find(sb.ToString());
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * bool param_1 = obj.Query(letter);
 */
