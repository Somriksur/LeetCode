class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int fullBottles = numBottles;
        while (numBottles >= numExchange) {
            int newFullBottles = (numBottles) / numExchange;
            fullBottles += newFullBottles;
            int emptyBottles = numBottles % numExchange;
            numBottles = newFullBottles + emptyBottles;
        }
        return fullBottles;
    }
}