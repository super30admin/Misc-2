class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.isEnd = False

class StreamChecker:

    def __init__(self, words: List[str]):
        # build trie for each word in reverse order
        self.prefix = ''
        self.trie = TrieNode()
        for word in words:
            curnode = self.trie
            word = word[::-1]
            for char in word:
                curnode = curnode.children[char]
            curnode.isEnd = True
        

    def query(self, letter: str) -> bool:
        self.prefix += letter
        curnode = self.trie
        for char in reversed(self.prefix):
            if char not in curnode.children:
                break
            curnode = curnode.children[char]
            if curnode.isEnd:
                return True
        return False
        


# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)