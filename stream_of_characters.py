class TrieNode:
    def __init__(self) -> None:
        self.children = [None]*26
        self.is_end = False

class StreamChecker:
    ## T.C = O(n)
    ## S.C = O(N) + O(nl)
    
    def __init__(self, words: List[str]):
        self.words = words
        self.root = TrieNode()
        self.build_trie(self.words)
        self.stream = ''
    
    def build_trie(self, words):
        for word in words:
            curr = self.root
            for i in range(len(word)-1, -1, -1):
                idx = ord(word[i]) - ord('a')
                if curr.children[idx] == None:
                    curr.children[idx] = TrieNode()
                curr = curr.children[idx]
            curr.is_end = True


    def query(self, letter: str) -> bool:
        self.stream = letter + self.stream
        curr = self.root

        for i in range(min(len(self.stream), 201)):
            if curr.is_end == True:
                return curr.is_end
            idx = ord(self.stream[i]) - ord('a')
            if curr.children[idx] == None:
                return False
            curr = curr.children[idx]
        
        return curr.is_end



# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)