class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int boats = 0;
        int small = 0;
        int big = people.length - 1;
        Arrays.sort(people);
        while (small < big)
        {
            if (people[small] + people[big] > limit)
                big--;
            else {
                small++;
                big--;
            }
            boats++;
        }
        if (big == small) boats++;
        return boats;
    }
}