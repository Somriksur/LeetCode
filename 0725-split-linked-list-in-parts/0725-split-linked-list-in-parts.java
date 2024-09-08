class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        current = head;
        int ps = count / k; // ps=partsize
        int ep = count % k; // ep=extrapart
        for (int i = 0; i < k; i++) {
            if (current == null)
                ans[i] = null;
            else {
                ans[i] = current;
                int cps = ps + (ep > 0 ? 1 : 0); //cps=current part size
                ep--;
                for (int j = 1; j < cps; j++) {
                    if (current != null) {
                        current = current.next;
                    }
                }
                if (current != null) {
                    ListNode np = current.next; // next part
                    current.next = null;
                    current = np;
                }

            }
        }
        return ans;
    }
}