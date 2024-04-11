class Solution {
    public String removeKdigits(String num, int k) {

        if (k >= num.length()) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && result.length() > 0 && result.charAt(result.length() - 1) > num.charAt(i)) {
                result.deleteCharAt(result.length() - 1);
                k--;
            }

            if (k == 0) {
                result.append(num.substring(i));
                break;
            } else {
                result.append(num.charAt(i));
            }
        }

        while (k > 0) {
            result.deleteCharAt(result.length() - 1);
            k--;
        }

        String resultStr = result.toString().replaceFirst("^0+", "");

        return resultStr.isEmpty() ? "0" : resultStr;
    }
}