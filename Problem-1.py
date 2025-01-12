#Approach
# Since we are reaching for the suffix instead of creating the prefix trie create suffix trie and seach from backwards for each letter



#Complexities
#Time: O(W*L)(trie) +  O(Q*L)search in trie
#Space: O(W*L)



from typing import List


class Trie:
    def __init__(self):
        self.dictionary = [None] * 26
        self.startswith = False


class StreamChecker:
    def __init__(self, words: List[str]):
        self.root = Trie()
        self.streamCharacters = ""
        self.createTrie(words)

    def createTrie(self, words):
        for word in words:
            temp = self.root
            for char in word[::-1]:
                if temp.dictionary[ord(char) - ord("a")] == None:
                    node = Trie()
                    temp.dictionary[ord(char) - ord("a")] = node
                temp = temp.dictionary[ord(char) - ord("a")]
            temp.startswith = True

    def searchTrie(self, word):

        temp = self.root
        for char in word[::-1]:
            if temp.dictionary[ord(char) - ord("a")] == None:
                return False
            else:
                temp = temp.dictionary[ord(char) - ord("a")]
                if temp.startswith:
                    return True
        return False

    def query(self, letter: str) -> bool:
        self.streamCharacters += letter
        return self.searchTrie(self.streamCharacters)

# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)