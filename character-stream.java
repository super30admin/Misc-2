// TC: O(n)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class TrieNode:
    def __init__(self):
        self.children = [None] * 26
        self.isWord = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        # Insert characters in reverse order
        for i in range(len(word) - 1, -1, -1):
            ch = word[i]
            idx = ord(ch) - ord('a')
            if node.children[idx] is None:
                node.children[idx] = TrieNode()
            node = node.children[idx]
        node.isWord = True


class StreamChecker:
    trie = None
    string = None

    def __init__(self, words):
        StreamChecker.trie = Trie()
        StreamChecker.string = ''
        for word in words:
            # Use class attribute trie to insert each word
            self.trie.insert(word)

    def query(self, letter: str) -> bool:
        StreamChecker.string += letter
        return self.find()

    def find(self) -> bool:
        node = StreamChecker.trie.root
        # Traverse the queried letters in reverse order
        for i in range(len(StreamChecker.string) - 1, -1, -1):
            ch = StreamChecker.string[i]
            if node.isWord:
                return True
            idx = ord(ch) - ord('a')
            if node.children[idx] is None:
                return False
            node = node.children[idx]
        return node.isWord
