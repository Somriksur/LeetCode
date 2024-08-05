class Solution {
  public String kthDistinct(String[] arr, int k) {
    var map = new HashMap<String, Integer>();

    for (var s : arr)
      map.put(s, map.getOrDefault(s, 0) + 1);
    
    for (var s : arr) {
      if (map.get(s) == 1) k--;

      if (k == 0) return s;
    }
    return "";
  }
}