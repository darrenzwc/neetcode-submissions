/*
Definition for a Node.
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
class Solution {
    public Node cloneGraph(Node node) {
        // An empty graph has nothing to copy.
        if (node == null) {
            return null;
        }
        Map<Node, Node> copies = new HashMap<>();
        Node deepCopy = new Node(node.val, new ArrayList<>());

        copies.put(node, deepCopy);
        populate(deepCopy, node, copies);

        return deepCopy;
    }

    private void populate(Node copy, Node node, Map<Node, Node> copies) {
        for (Node n : node.neighbors) {
            if (!copies.containsKey(n)) {
                Node newNode = new Node(n.val, new ArrayList<>());
                copies.put(n, newNode);
                populate(newNode, n, copies);
            }
            copy.neighbors.add(copies.get(n));
        }
    }
}