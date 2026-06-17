class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        for(int i=0; i<parent.length; i++) parent[i] = i;

        for(int[] edge : edges) if(union(edge[0], edge[1])) return edge;

        return new int[2];
    }

    int getParent(int i){
        if(parent[i]==i) return i;
        return parent[i] = getParent(parent[i]);
    }

    boolean union(int a, int b){
        int parentA = getParent(a);
        int parentB = getParent(b);

        if(parentA!=parentB){
            parent[parentA] = parentB;
            return false;
        }

        return true;
    }
}
