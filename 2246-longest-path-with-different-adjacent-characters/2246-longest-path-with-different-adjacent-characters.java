class Solution {
    int ans = 1;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 1; i < n; i++) adj.get(parent[i]).add(i);
        longestPathDfs(0, adj, s);
        return ans;
    }
    private int longestPathDfs(int currentNode, List<List<Integer>> adjacentNodes, String stringInput) {
        int currentMax = 0;
        int secondMax = 0;
        for (int nextNode : adjacentNodes.get(currentNode)) {
            int result = longestPathDfs(nextNode, adjacentNodes, stringInput);
            if (stringInput.charAt(currentNode) == stringInput.charAt(nextNode)) continue;
            if (result > currentMax) {
                secondMax = currentMax;
                currentMax = result;
            } else if (result > secondMax) {
                secondMax = result;
            }
        }
        ans = Math.max(ans, 1 + currentMax + secondMax);
        return 1 + currentMax;
    }
}