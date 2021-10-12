# Miscellaneous-2

## Problem1: Sparse Search

Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.

Examples:

Input : arr[] = {"for", "geeks", "", "", "", "", "ide",
"practice", "", "", "", "quiz"}
x = "geeks"
Output : 1

Input : arr[] = {"for", "geeks", "", "", "", "", "ide",
"practice", "", "", "", "quiz"},
x = "ds"

Output : -1

// Yet to be discussed in Class

## Problem2: Character stream (https://leetcode.com/problems/stream-of-characters/)

// Time - Complexity = O(N) length of word
// Space complexity = Space of Trie + length of longest word

class StreamChecker {

    class TrieNode {
        TrieNode[] children;
        boolean isStart;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private void insert(String word) {
        TrieNode current = root;
        for(int i = word.length()-1; i >= 0; i--) {
            char c = word.charAt(i);
            if(current.children[c-'a'] == null) {
                current.children[c-'a'] = new TrieNode();
            }
            current =  current.children[c-'a'];
        }
        current.isStart = true;
    }

    TrieNode root;
    StringBuilder sb;
    int maxLength;
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for(String word : words) {
            insert(word);
            maxLength = Math.max(maxLength, word.length());
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        if(sb.length() > maxLength) {
            sb.delete(0,sb.length() - maxLength);
        }
        TrieNode current = root;
        for(int i = sb.length()-1; i >= 0; i--) {
            char c = sb.charAt(i);
            if(current.children[c-'a'] == null) {
                return false;
            }
            current = current.children[c-'a'];
            if(current.isStart) {
                return true;
            }
        }
        return false;
    }

}

/\*\*

- Your StreamChecker object will be instantiated and called as such:
- StreamChecker obj = new StreamChecker(words);
- boolean param_1 = obj.query(letter);
  \*/

## Problem 2: Sum of the products of all possible Subsets

Given an array of n non-negative integers. The task is to find the sum of the product of elements of all the possible subsets. It may be assumed that the numbers in subsets are small and computing product doesn’t cause arithmetic overflow.

Example :

Input : arr[] = {1, 2, 3}

Output : 23

Possible Subset are: 1, 2, 3, {1, 2}, {1, 3},
{2, 3}, {1, 2, 3}

Products of elements in above subsets :
1, 2, 3, 2, 3, 6, 6

Sum of all products = 1 + 2 + 3 + 2 + 3 + 6 + 6
= 23

// Time Complexity : O(N)
// Space Complexity : O(1)

// "static void main" must be defined in a public class.
public class Main {
public static void main(String[] args) {
int[] arr = new int[] {1,2,3};

        System.out.println(sumOfproductOfSubsets(arr));
    }

    private static int sumOfproductOfSubsets(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        for(int i = 0 ; i < nums.length; i++) {
            result *= (1 + nums[i]);
        }
        return result - 1;
    }

}
