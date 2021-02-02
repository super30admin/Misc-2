# TIME COMPLEXITY: Build Trie - O(m*n) - words * avg length of each word, O(n) for query where n is the length of the longest word
# SPACE COMPLEXITY: O(m*n) for Trie, O(n) to keep the deque of characters

# Define a Trie datastructure
from collections import deque, defaultdict

class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.endOfWord = False


class Trie:
    def __init__(self):
        self.root = TrieNode()

    def _insertWord(self, word):
        curr = self.root
        for ch in word:
            curr = curr.children[ch]
        curr.endOfWord = True

    def getRoot(self):
        return self.root


class StreamChecker(object):
    def __init__(self, words):
        """
        :type words: List[str]
        """
        # Ititialize a trie
        self.t = Trie()

        # Cur keeps track of the stream so far
        self.cur = deque([])

        # Build a Trie from the reverse of the words
        for word in set(words):
            self.t._insertWord(word[::-1])

    def query(self, letter):
        """
        :type letter: str
        :rtype: bool
        """
        # When a new letter comes in append it to the beginning of a deque
        self.cur.appendleft(letter)

        # The first character of the queue is always the last character we want to look back from to match characters in the stream
        # We walk down the trie, if at any character, endOfWord is True, return True
        # EG: words - [a, aa, aaab, ab, abaa]
        # query -> a - cur = a -> return True
        # query -> a - cur = aa -> return True
        # query -> a - cur = aaa -> return False
        # query -> b - cur = baaa -> return True
        # query -> a - cur = abaaa -> return False
        # query -> b - cur = babaa -> return True -> ba is a word in the Trie
        curr = self.t.getRoot()
        for ch in self.cur:
            if curr.endOfWord:
                return True
            # Invalid character, break (TLE without this condition)
            if ch not in curr.children:
                break
            curr = curr.children[ch]
        return curr.endOfWord


# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)
