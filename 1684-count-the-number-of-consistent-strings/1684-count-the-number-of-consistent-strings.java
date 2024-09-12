// class Solution {
//     public int countConsistentStrings(String ad, String[] arr) {
//         char[] arr1 = ad.toCharArray();
//         HashSet<Character> s = new HashSet<>();
//         for(char i:arr1){
//             s.add(i);
//         }
//         int size = s.size();
//         int count = 0;
//         boolean is_true = true;
//         for(int i=0;i<arr.length;i++){
//             for(int j=0;j<arr[i].length();j++){
//                 s.add(arr[i].charAt(j));
//                 int k = s.size();
//                 if(k>size){
//                     s.remove(arr[i].charAt(j));
//                     is_true = false;
//                     break;
//                 }
//             }
//             if(is_true)count++;
//             else is_true = true;
//         }
//         return count;
//     }
// }
class Solution {
    public int countConsistentStrings(String ad, String[] arr) {
        HashSet<Character> ch = new HashSet<>();
        for (char c : ad.toCharArray()) {
            ch.add(c);
        }
        
        int count = 0;
        
        for (String str : arr) {
            boolean is_true = true;
            for (char c : str.toCharArray()) {
                if (!ch.contains(c)) {
                    is_true = false;
                    break;
                }
            }
            if (is_true) {
                count++;
            }
        }
        
        return count;
    }
}