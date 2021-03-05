// Time - O(N) to build trie, O(K) for search and O(N) for space
/**
 * @param {string[]} words
 */

class TrieNode{
    
    constructor(){
        this.children = new Array(26);
        this.isEnd = false;
    }
}

let root;
let result = '';

var buildTrie = function(word) {
    let curr = root;
    for(let i=word.length-1;i>=0;i--) {
        let c = word[i];
        if(!curr.children[c.charCodeAt(0) - 'a'.charCodeAt(0)]){
            curr.children[c.charCodeAt(0) - 'a'.charCodeAt(0)] = new TrieNode();
        }
        curr = curr.children[c.charCodeAt(0) - 'a'.charCodeAt(0)];
    }
    curr.isEnd = true;
}

var StreamChecker = function(words) {
    root = new TrieNode();
    result = ''
    for(let word of words) {
        buildTrie(word);
    }
};

/** 
 * @param {character} letter
 * @return {boolean}
 */
StreamChecker.prototype.query = function(letter) {
    result+=letter;
    let trieNode = root;
    for(let i=result.length-1;i>=0;i--) {
        let c = result[i];
        if(!trieNode.children[c.charCodeAt(0) - 'a'.charCodeAt(0)]){
            return false;
        }
        trieNode = trieNode.children[c.charCodeAt(0) - 'a'.charCodeAt(0)];
        
        if(trieNode.isEnd) {
            return true;
        }
    }
    return false;
};

/** 
 * Your StreamChecker object will be instantiated and called as such:
 * var obj = new StreamChecker(words)
 * var param_1 = obj.query(letter)
 */
