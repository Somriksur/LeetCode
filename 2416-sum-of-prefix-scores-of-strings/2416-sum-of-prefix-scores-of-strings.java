class Solution {
    public int[] sumPrefixScores(String[] words) {
        if (words.length == 1) {
            return new int[] { words[0].length() };
        }
        
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(word);
        }
        int[] ans = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i] = trie.getPrefixCount(words[i]);
        }
        return ans;
    }
}

class Trie {
    TrieNode root;
    
    Trie() {
        root = new TrieNode();
    }
    
    void addWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current.children[index].prefixCount++;
            current = current.children[index];
        }
    }
    
    int getPrefixCount(String word) {
        int sum = 0;
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return sum;
            }
            current = current.children[index];
            sum += current.prefixCount;
        }
        return sum;
    }
}

class TrieNode {
    final static int R = 26;
    
    int prefixCount;
    TrieNode[] children;
    
    TrieNode() {
        prefixCount = 0;
        children = new TrieNode[R];
    }
}