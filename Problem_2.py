'''
1032 Steam of Characters
https://leetcode.com/problems/stream-of-characters/description/

Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string of a given array of strings words.

For example, if words = ["abc", "xyz"] and the stream added the four characters (one by one) 'a', 'x', 'y', and 'z', your algorithm should detect that the suffix "xyz" of the characters "axyz" matches "xyz" from words.

Implement the StreamChecker class:
StreamChecker(String[] words) Initializes the object with the strings array words.
boolean query(char letter) Accepts a new character from the stream and returns true if any non-empty suffix from the stream forms a word that is in words.

Solution:
1. Suffix Trie
We put all the words in reverse order in the Trie so that we build a Suffix Trie.

For example, if the list of words = ['cd', 'f', 'kl'], then the Suffix Trie is:
suffix_trie_root
        +-d-c.
        +-f.
        +-l-k.

As the new letters from the stream arrive, it becomes easier to check if the string of buffered letters is present in the Suffix Trie or not than a Prefix Trie.

Then, every time we get a new letter, we append it and keep the size limited to the longest word stored in the Suffix Trie. We walk backward through our stream and try to match it in the Trie; if we hit a valid word end, we return true.

Example:
At time t=1, stream = ['a']
t = 2, stream = ['a', 'b]
t = 3, stream = ['a', 'b', 'c']
t = 4, stream = ['a', 'b', 'c', 'd']

The corresponding suffixes are:
t = 1, suffix = a
t = 2, suffix = ba
t = 3, suffix = cba
t = 4, suffix = dcba

We send each of these suffixes as a query to the Suffix Trie and check if the query is present in the Suffix Trie or not. More specifically, we are asking: if the query starts with a word present in the Suffix Trie? In other words, is a prefix of the query present in the Suffix Trie?

Since, the Suffix Trie contains "dc", at t = 4, a prefix of the query (dcba) is found in the Trie ("dc").

Let N = no. of words in the trie, C = avg length of each word, K = max length of query (= max length of word in the Trie)

https://youtu.be/IVUWg82k5WU?t=2277
https://youtu.be/IVUWg82k5WU?t=2435 (why prefix trie is expensive?)
Time: O(NC + K), Space: O(NC + K)
'''
from typing import List
from collections import defaultdict, deque

class TrieNode:
    def __init__(self):
        self.children = defaultdict(str)
        self.isEOS  = False

    def pprint(self):
        print(" +", end='')
        self._pprint()

    def _pprint(self, indent_str=""):
        needs_indent = False

        if self.isEOS:
            print(".")  # Terminate with '.'
            needs_indent = True

        for ix, (letter, curr) in enumerate(sorted(self.children.items())):
            last_child = ix == len(self.children)-1

            if needs_indent:
                print(indent_str + " +", end='')
            print('-' + letter, end='')

            child_indent = indent_str + ("  " if last_child else " |")
            curr._pprint(child_indent)
            needs_indent = True

class SuffixTrie:
    def __init__(self):
        ''' T: O(1), S: O(1) '''
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        ''' T: O(C), S: O(C), C = num chars in word '''
        if not self.root:
            return None
        curr = self.root
        # Build the suffix trie by scanning from last char to 1st char in word
        for c in word[::-1]:
            if c not in curr.children:
                curr.children[c] = TrieNode()
            curr = curr.children[c]
        curr.isEOS = True

    def find(self, word:str) -> bool:
        ''' T: O(C), S: O(C), C = num chars in word '''
        if not self.root:
            return None
        curr = self.root
        for c in word:
            if c not in curr.children:
                return False
            curr = curr.children[c]
            if curr.isEOS:
                return True
        return curr.isEOS

class StreamChecker:
    def __init__(self, words: List[str]):
        self.trie = SuffixTrie()
        self.max_length = 0 # longest suffix stored in trie
        for word in words: # O(N)
            self.trie.insert(word) # O(C), C = avg len of word
            self.max_length = max(self.max_length, len(word))
        self.trie.root.pprint()
        self.buffer = deque()

    def query(self, letter: str) -> bool:
        self.buffer.append(letter)
        # check if the suffix is longer than the longest suffix in trie
        # if yes, pop the oldest character from the q
        if len(self.buffer) > self.max_length:
            self.buffer.popleft()

        # check if this suffix exists in the trie
        # suffix = newest char to oldest char in queue
        # hence, reverse the elements of the queue
        suffix = list(self.buffer)[::-1]
        if self.trie.find(suffix): # O(K), K = max length of query
            return True
        return False

def run_StreamChecker():
    tests = [ (["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"],
                [ [["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"] ],
                [None, False, False, False, True, False, True, False, False, False, False, False, True]),
    ]
    for test in tests:
        operations, inputs, ans = test[0], test[1], test[2]
        outputs = []
        for operation, input in zip(operations, inputs):
            if operation == "StreamChecker":
                sc = StreamChecker(input[0])
                output = None
            elif operation == "query":
                output = sc.query(input[0])
            print(f"{operation}({input}): {output}")
            outputs.append(output)

        print(f"\nOperations = {operations}")
        print(f"inputs = {inputs}")
        print(f"outputs = {outputs}")
        success = (ans==outputs)
        print(f"Pass: {success}")
        if not success:
            print("Failed")
            return

run_StreamChecker()
