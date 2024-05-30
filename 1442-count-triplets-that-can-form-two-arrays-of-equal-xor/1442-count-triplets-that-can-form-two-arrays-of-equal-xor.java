class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        int size = arr.length;

        for (int i = 0; i < size; i++) {
            int xor = 0;

            for (int j = i; j < size; j++) {
                xor ^= arr[j];

                if (xor == 0) {
                    count += (j - i);
                }
            }
        }

        return count;
    }
}