// Time complexity: O(m) where m is the length of the input stream
// Space complexity: O(nl) where n is the number of words and l is the average length of each word

/*
Create the trie backwards for each word
This way, we can check the words only once and not have to iterate over every wors

Ex: abc, def
If we add the words as is into the trie, when a letter a comes, we go check the trie and realise a is not a word - return false
ab => again iterate over the trie and return false 
abc => return true 
We are also iterating over the input string n times to generate all these suffix 
abc => c, bc, abc and this is a n^2 operation 

If we store all the words in reverse order and also iterate over the input in reverse, we will not have to generate all the suffix

if the input stream at this point is abcd and cd was the word, 
we start with d => and relise we do have something with d in trie -> so go on 

if the new letter is e, the input stream is now abcde and nothing starts with e in the trie -> simply return false
*/

class TrieNode {
public:
    bool isEnd;
    vector<TrieNode*> children;
    TrieNode() {
        isEnd = false;
        children = vector<TrieNode*>(26, NULL);
    }
};

class StreamChecker {
public:
    string input;
    TrieNode* root;

    // constructor 
    // create the trie
    StreamChecker(vector<string>& words) {
        root = new TrieNode(); 
        for(string word: words) {
            insertToTrie(word);
        }
    }
    
    bool query(char letter) {
        // keep a track of the input string
        input += letter;
        TrieNode* curr = root;
        for(int i = input.length()-1; i>= 0; i--) {
            char c = input[i];
            // if the new character is not in the trie, we can be sure that no word ends with that character - simply return false
            if(curr->children[c-'a'] == NULL)
                return false;
            // else move to the new letter that we saw 
            curr = curr->children[c-'a'];

            // if that has the end marker, return true
            if(curr->isEnd == true)
                return true; 
        }
        // if we are at the end - simply return the curr
        return curr->isEnd;
    }

private:
    // create the trie backwards 
    void insertToTrie(string word) {
        TrieNode* curr = root;
        for(int i = word.length()-1; i >= 0; i--) {
            char c = word[i];
            if(curr->children[c - 'a'] == NULL) {
                curr->children[c-'a'] = new TrieNode ();
            }
            curr = curr->children[c-'a'];
        }
        // Add an isEnd flag for every node
        curr->isEnd = true;
    }
};

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker* obj = new StreamChecker(words);
 * bool param_1 = obj->query(letter);
 */