from typing import List

# class StreamChecker:

#     def __init__(self, words: List[str]):
#         self.wordsSet = set()
#         self.sb = []
#         self.maxLength = 0

#         for word in words:
#             self.wordsSet.add(word)
#             self.maxLength = max(self.maxLength, len(word))

#     def query(self, letter: str) -> bool:
#         self.sb.append(letter)

#         if len(self.sb) > self.maxLength:
#             self.sb.pop(0)

#         for i in range(len(self.sb)):
#             suffix = ''.join(self.sb[i:])
#             if suffix in self.wordsSet:
#                 return True

#         return False


class StreamChecker:

    class TrieNode:
        def __init__(self):
            self.children = [None]*26
            self.startswith = False

    def __init__(self, words: List[str]):
        self.sb = []
        self.maxlen = 0
        self.root = self.TrieNode()
        for word in words:
            self.maxlen = max(self.maxlen, len(word))
            self.insert(word)

    def insert(self,word):
        curr = self.root
        for i in range(len(word)-1,-1,-1):
            c = word[i]
            if not curr.children[ord(c)-ord('a')]:
                curr.children[ord(c)-ord('a')] = self.TrieNode()
            curr = curr.children[ord(c)-ord('a')]
        curr.startswith = True
        
    def query(self, letter: str) -> bool:
        self.sb.append(letter)
        if len(self.sb) > self.maxlen: self.sb.pop(0)
        curr = self.root
        for i in range(len(self.sb)-1,-1,-1):
            c = self.sb[i]
            if not curr.children[ord(c)-ord('a')]:return False
            if curr.children[ord(c)-ord('a')].startswith: return True
            curr = curr.children[ord(c)-ord('a')]
        return False
        


# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)