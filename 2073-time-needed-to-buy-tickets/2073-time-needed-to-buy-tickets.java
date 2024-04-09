class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ticketsKWants = tickets[k];
        int counter = 0;
        for (int i = 0; i < tickets.length; i++) {
            int current = tickets[i];
            if (i <= k) {
                counter += Math.min(ticketsKWants, current);
            } else {
                counter += Math.min(ticketsKWants - 1, current);
            }
        }
        return counter;
    }
}