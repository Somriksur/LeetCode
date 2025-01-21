class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder(s).reverse();
        String[] words = sb.toString().split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(new StringBuilder(word).reverse()).append(" ");
            }
        }
        return result.toString().trim();
    }
}