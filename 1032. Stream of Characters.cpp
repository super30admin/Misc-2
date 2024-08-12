#define fr(n) for(int i=0;i<n;i++)
#define null NULL

class StreamChecker {
public:
    
    
    struct node{
        node* child[26];
        int leaf;

        node(){
            fr(26)  child[i]= null;
            leaf= 0;
        }
    
    };

    
    struct Trie{
    
        node* root;

        Trie() {
            root= new node();        
        }

        /** Inserts a word into the trie. */
        void insert(node *r, string word, int i) {
            if(i<0){
                r->leaf= 1;
                return;
            }


            int id= word[i] -'a';

            if(r->child[id]==null)  r->child[id]= new node();

            insert(r->child[id],word,i-1);        
        }

        /** Returns if the word is in the trie. */
        bool search(node *r, char *word, int i) {
            if(r==null)  return false;

            if(r->leaf)  return true;
            if(i<0)  return false;

            int id= word[i] -'a';

            return search(r->child[id],word,i-1);        
        }


    }T;
    
    char *stream;
    int len;
    
    StreamChecker(vector<string>& words) {
        len= 0;
        stream=(char*) malloc(sizeof(char)*40005);
        
        T.root= new node();
        
        for(string s: words) {            
            T.insert(T.root,s,s.length()-1);
        }
        
        
    }
    
    
    bool query(char letter) {
        stream[len]= letter;
       
        bool ans= T.search(T.root,stream,len);
        len++;
        return ans;
        
    }
};

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker* obj = new StreamChecker(words);
 * bool param_1 = obj->query(letter);
 */
