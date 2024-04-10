class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        LinkedList<Integer> list = new LinkedList<>();
        Arrays.sort(deck);
        int n = deck.length;
        int[] res = new int[n];

        for(int i=0; i<n; i++){
            list.offer(i);
        }

        for(int i=0; i<n; i++){
            res[list.poll()] = deck[i];
            list.offer(list.poll());
        }
        return res;
    }
}
