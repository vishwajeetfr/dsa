/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

// Solution 1 using BFS (less optmized)

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        int k = node.val;
        boolean[] visited = new boolean[101];
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, Node> nodeMap = new HashMap<>();
        q.add(node);
        while(!q.isEmpty()){
            Node n = q.poll();
            nodeMap.put(n.val, new Node(n.val));
            System.out.println(n.val);
            visited[n.val] = true;
            List<Integer> nbrList = new ArrayList<>();
            for(Node nbr : n.neighbors){
                nbrList.add(nbr.val);
                if(!visited[nbr.val]){
                  q.add(nbr);
                }
            }
            adjList.put(n.val, nbrList);
            
        }
        for(int key : adjList.keySet()){
            Node cur = nodeMap.get(key);
            List<Node> nbrs = new ArrayList<>();
            for(int i : adjList.get(key)){
                nbrs.add(nodeMap.get(i));
            }
            cur.neighbors = nbrs;
        }
        return  nodeMap.get(k);
    }
}

// Solution 2 using DFS (more optimal)


class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        return getClonedGraph(node, new HashMap<Node,Node>());
    }
    Node getClonedGraph(Node node, HashMap<Node,Node> nodeMap){
        if(nodeMap.containsKey(node)) return nodeMap.get(node);
        Node clonedNode = new Node(node.val);
        nodeMap.put(node, clonedNode);
        List<Node> nodeList = new ArrayList<>();
        for(Node nbr : node.neighbors){
            clonedNode.neighbors.add(getClonedGraph(nbr, nodeMap));
        }
        return clonedNode;
    }
}
