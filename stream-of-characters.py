class StreamChecker:
    class Trie:
        def __init__(self):
            self.root = StreamChecker.TrieNode()

        def add(self, string):
            index = 0
            head = self.root
            while index < len(string):
                if string[index] not in head.children:
                    head.children[string[index]] = StreamChecker.TrieNode()
                head = head.children[string[index]]
                index += 1
            head.isEnd = True

    class TrieNode:
        def __init__(self):
            self.isEnd = False
            self.children = {}

    def __init__(self, words: List[str]):
        reverse_words = []
        self.string = ""
        for word in words:
            reverse_words.append(word[::-1])

        self.trie = StreamChecker.Trie()

        for reversed_word in reverse_words:
            self.trie.add(reversed_word)

    def query(self, letter: str) -> bool:
        self.string += letter
        #print("String is ", self.string)
        node = self.trie.root
        index = len(self.string) - 1
        while index >= 0:
            character = self.string[index]
            if character not in node.children:
                return False
            node = node.children[self.string[index]]
            if node.isEnd:
                return True
            index -= 1
        return False


# Your StreamChecker object will be instantiated and called as such:
# obj = StreamChecker(words)
# param_1 = obj.query(letter)
