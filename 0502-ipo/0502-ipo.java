class Solution {
    private class Project implements Comparable<Project> {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        public int compareTo(Project other) {
            return this.capital - other.capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new Project(capital[i], profits[i]));
        }    

        Collections.sort(projects);

        PriorityQueue<Integer> profitsHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        int index = 0;

        while (k > 0) {
            while (index < n && projects.get(index).capital <= w) {
                profitsHeap.offer(projects.get(index).profit);
                index++;
            }

            if (profitsHeap.isEmpty()) {
                break;
            }

            w += profitsHeap.poll();
            k--;
        }

        return w;
    }
}