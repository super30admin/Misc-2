class StreamChecker {
    
  /**
  It is already given that words[i] can be a max length of 200, so this is constant time complexity.
  
  Time Complexity: O(n)
  
  Space Complexity : O(n)
      
  Were you able to solve this on leetcode? Yes
  
  */ 
  class TrieNode {
      TrieNode[] children;
      boolean isEnd;
      
      TrieNode(){
          children = new TrieNode[26];
          isEnd = false;
      }
  }
  
  void insert(String word) {
      TrieNode curr = root;
      
      // insert word in the reverse order.
      for(int i = word.length() - 1; i >= 0; i--){
          char c = word.charAt(i);
          
          if(curr.children[c - 'a'] == null){
              curr.children[c - 'a'] = new TrieNode();
          }
          
          curr = curr.children[c - 'a'];
      }
      
      curr.isEnd = true;
  }
  
  boolean suffixSearch(StringBuilder sb) {
      TrieNode curr = root;
      
      for(int i = sb.length() - 1; i >= 0; i--){
          char c = sb.charAt(i);
          
          if(curr.children[c - 'a'] == null){
              return false;
          }

          curr = curr.children[c - 'a'];
          
          if(curr.isEnd) { return true; }
      }
      
      return false;
  }
  
  TrieNode root;
  StringBuilder sb;
  public StreamChecker(String[] words) {
      root = new TrieNode();
      for(String word : words){
          insert(word);
      }
      sb = new StringBuilder();
      
  }
  
  public boolean query(char letter) {
      if(sb.length() == 200){
          sb = sb.deleteCharAt(0);
      }
      
      sb.append(letter);
      return suffixSearch(sb);
  }
}
