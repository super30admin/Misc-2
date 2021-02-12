class TrieNode:
    def __init__(self):
        self.children = {}
        self.isEnd = False


class StreamChecker:

    def insert(self, word):
        curr = self.root
        l = len(word)
        for i in range(l-1, -1, -1):
            char = word[i]
            if char not in curr.children:
                curr.children[char] = TrieNode()
            curr = curr.children[char]
        curr.isEnd = True

    def __init__(self, words: List[str]):
        self.root = TrieNode()
        for word in words:
            self.insert(word)
        self.string = []

    def query(self, letter: str) -> bool:
        self.string.append(letter)
        curr = self.root
        # if letter not in curr.children:
        #     return False
        l = len(self.string)
        for i in range(l-1, -1, -1):
            char = self.string[i]
            if char not in curr.children:
                return False
            curr = curr.children[char]
            if curr.isEnd:
                return True

        return False


# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)
