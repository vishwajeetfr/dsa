class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> nodeMap = new HashMap<>();
        Map<String, Double> weightMap = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            List<String> srcLs = nodeMap.getOrDefault(src, new ArrayList<String>());
            List<String> destLs = nodeMap.getOrDefault(dest, new ArrayList<String>());
            srcLs.add(dest);
            destLs.add(src);
            nodeMap.put(dest, destLs);
            nodeMap.put(src, srcLs);
            weightMap.put(src+"-"+dest, values[i]);
            weightMap.put(dest+"-"+src, 1/values[i]);
        }
        double[] sol = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {

    String src = queries.get(i).get(0);
    String dest = queries.get(i).get(1);

    if(!nodeMap.containsKey(src) || !nodeMap.containsKey(dest)){
        sol[i] = -1.0;
        continue;
    }

    if(src.equals(dest)){
        sol[i] = 1.0;
        continue;
    }

    Queue<String> nodeQ = new LinkedList<>();
    Queue<Double> wtQ = new LinkedList<>();

    nodeQ.offer(src);
    wtQ.offer(1.0);

    Set<String> visited = new HashSet<>();
    visited.add(src);

    double result = -1.0;

    while(!nodeQ.isEmpty()) {
        String cur = nodeQ.poll();
        double currVal = wtQ.poll();

        if(cur.equals(dest)) {
            result = currVal;
            break;
        }

        for(String nbr : nodeMap.get(cur)) {
            if(!visited.contains(nbr)) {
                visited.add(nbr);
                nodeQ.offer(nbr);
                wtQ.offer(currVal * weightMap.get(cur + "-" + nbr));
            }
        }
    }

    sol[i] = result;
}
        return sol;
    }
}
