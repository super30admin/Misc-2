class StreamChecker {

    //Time Complexity: 0(l) where l is the length of the stream. There is another TC of 0(kn) where k is the avg length of each word and n is the total words but I will ignore this as it is called in a constructor
    //Space Complexity: 0(kn)

    class TrieNode{
        TrieNode [] children;   //Children containaining all 26 chars
        boolean isTrue; //isTrue states the end of the word
        public TrieNode(){
            children = new TrieNode[26];    //constructor call initiates declaration of a trienode for 26 children
        }
    }

    TrieNode root;  //root to navigate through the trie
    StringBuilder sb;   //sb to take input of stream of characters and check if there exist a word or not

    private void insert(String word){   //Insert method takes 1 word at a time and created a trienode
        TrieNode curr = root;   //current is poiniting to root at present

        for(int i = word.length() - 1; i >= 0; i--){    //I start from last letter in the word as I am building trie for a reversed word as it helps the search function to carry out search easily
            char c = word.charAt(i);    //taking one character at a time starting from last
            if(curr.children[c - 'a'] == null){ //if the index is null
                curr.children[c - 'a'] = new TrieNode();    //initializing a new trienode at that place
            }
            curr = curr.children[c - 'a'];  //moving my curr pointer to the children
        }
        curr.isTrue = true; //at the end of the word, marking it as true stating 1 word is formed
    }


    public StreamChecker(String[] words) {  //constructor that calls and builds the trienode and initializes string builder

        root = new TrieNode();
        sb = new StringBuilder();

        for(String word : words){
            insert(word);
        }
    }

    public boolean query(char letter) { //returns true or false if the word exists

        TrieNode curr = root;   //current points to root
        sb.append(letter);  //putting the incoming letter to my string builder

        for(int i = sb.length() - 1; i >= 0; i--){  //starting from the last character in the word formed from stream of characters given as input
            char c = sb.charAt(i);  //taking 1 character at a time
            if(curr.children[c - 'a'] == null){ //if there is no trienode present for that character in my tire, I simply return false as no word can exist if the character does not
                return false;
            }
            if(curr.children[c-'a'].isTrue == true){    //if I reach a point where isTrue is true, means I have reached the end of the word and a word is formed
                return true;
            }
            curr = curr.children[c - 'a'];  //or move the pointer to the child in the trie
        }
        return false;   //if i come out of the loop and do not returning anything, means no word is found and I return false
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */