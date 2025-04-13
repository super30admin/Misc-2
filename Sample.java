class Sample{
    /***************PROBLEM-1********************/

    /***************PROBLEM-2********************/
    class StreamChecker {
        TrieNode root;
        StringBuilder sb;
        class TrieNode{
            TrieNode[] children;
            boolean isEnd;
            public TrieNode(){
                children=new TrieNode[26];
                isEnd=false;
            }
        }
        private void insert(String word){
            TrieNode curr=root;
            for(int i=word.length()-1;i>=0;i--){
                char c=word.charAt(i);
                if(curr.children[c-'a']==null){
                    curr.children[c-'a']=new TrieNode();
                }
                curr=curr.children[c-'a'];
            }
            curr.isEnd=true;
        }

        private boolean find(String word){
            TrieNode curr=root;
            for(int i=word.length()-1;i>=0;i--){
                char c=word.charAt(i);
                if(curr.children[c-'a']==null){
                    return false;
                }
                curr=curr.children[c-'a'];
                if(curr.isEnd){
                    return true;
                }
            }
            return false;
        }

        public StreamChecker(String[] words) {
            if(words==null || words.length==0){
                return ;
            }
            root=new TrieNode();
            sb=new StringBuilder();
            for(String word:words){
                insert(word);
            }
        }
        //TC:0(N*l)
        //sc:0(n*l)
        public boolean query(char letter) {
            sb.append(letter);
            return find(sb.toString());
        }
    }

/***************PROBLEM-3********************/


}