class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Map<Node, Node> map = new HashMap<>(); // original -> clone
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            
            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    // Clone and map the neighbor if not cloned yet
                    map.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }
                // Add the cloned neighbor to the current cloned node
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        
        return clone;
    }
}