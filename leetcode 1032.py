"""
Time Complexity: O(N * L)+ O(K)
Space Complexity: O(N * L) + O(K)
"""
class StreamChecker:

    class TrieNode:
        def __init__(self):
            self.children = [None] * 26
            self.isStartsWith = False

    def __init__(self, words: List[str]):
        self.root = self.TrieNode()
        self.sb = []
        self.maxLength = 0

        for word in words:
            self.maxLength = max(self.maxLength, len(word))
            self.insert(word)

    def insert(self, word):  # mat
        curr = self.root
        for i in range(len(word)-1, -1, -1):
            c = word[i]
            if curr.children[ord(c) - ord('a')] is None:
                curr.children[ord(c) - ord('a')] = self.TrieNode()
            curr = curr.children[ord(c) - ord('a')]
        curr.isStartsWith = True

    def query(self, letter: str) -> bool:
        self.sb.append(letter)
        if len(self.sb) > self.maxLength:
            self.sb.pop(0)

        curr = self.root
        for i in range(len(self.sb) - 1, -1, -1):
            c = self.sb[i]
            if curr.children[ord(c) - ord('a')] is None:
                return False
            if curr.children[ord(c) - ord('a')].isStartsWith:
                return True
            curr = curr.children[ord(c) - ord('a')]
        return False