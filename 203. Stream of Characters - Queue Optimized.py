from collections import deque


class TrieNode:
    def __init__(self):
        self.children = [None for i in range(26)]
        self.isEnd = False


class StreamChecker:
    def insert(self, word):

        curr = self.root
        for i in range(len(word) - 1, -1, -1):
            c = word[i]
            if not curr.children[ord(c) - ord("a")]:
                curr.children[ord(c) - ord("a")] = TrieNode()
            curr = curr.children[ord(c) - ord("a")]
        curr.isEnd = True

    def __init__(self, words: List[str]):
        self.root = TrieNode()
        self.sb = deque()

        for word in words:
            self.insert(word)

    def query(self, letter: str) -> bool:
        self.sb.append(letter)
        if len(self.sb) > 2000:
            self.sb.popleft()

        curr = self.root

        for i in range(len(self.sb) - 1, -1, -1):
            c = self.sb[i]
            if not curr.children[ord(c) - ord("a")]:
                return False
            curr = curr.children[ord(c) - ord("a")]
            if curr.isEnd:
                return True
        return False

# Trie(Prefix Tree), Queue
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
