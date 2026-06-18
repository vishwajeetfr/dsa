class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        List<List<Integer>> adjList = new LinkedList<>();
        for(int i=0; i<n; i++){
             adjList.add(new LinkedList<>());
             dist[i] = Integer.MAX_VALUE;
        }
        Map<String, Integer> routes = new HashMap<>();
        for(int[] f : flights){
            routes.put(f[0]+"-"+f[1], f[2]);
            adjList.get(f[0]).add(f[1]);
        }

        int j=0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0});
        boolean reached = false;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            dist[cur[0]] = Math.min(dist[cur[0]], cur[1]);
            if(dst==cur[0]) reached = true;
            for(int nbr : adjList.get(cur[0])){
                int newDist = cur[1]+routes.get(cur[0]+"-"+nbr);
                if(k>=cur[2] && newDist<dist[nbr]) q.add(new int[]{nbr, newDist, cur[2]+1});
            }
        }

        if(!reached) return -1;

        return dist[dst];
    }
}
