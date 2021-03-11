from collections import defaultdict
class TrieNode:
    def __init__(self):
        self.dict = defaultdict(TrieNode)
        self.isEnd = False


class StreamChecker:

    def __init__(self, words: List[str]):
        self.trie = TrieNode()
        self.prefix = ''
        
        #building a trie from the words
        for word in words:
            curr_node = self.trie
            word = word[::-1]
            
            for char in word:
                curr_node = curr_node.dict[char]
            
            curr_node.isEnd = True

    def query(self, letter: str) -> bool:
        self.prefix += letter
        
        curr_node = self.trie
        for char in reversed(self.prefix):
            
            if char not in curr_node.dict:
                break
            
            curr_node = curr_node.dict[char]
            
            if curr_node.isEnd is True:
                return True
        
        return False