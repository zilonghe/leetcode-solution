package 克隆图133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {

    private Map<Integer, Node> visited = new HashMap<>();

    public Node cloneGraph(Node node) {
        Node ret = new Node();
        ret.val = node.val;
        List<Node> neighbors = new ArrayList<>();
        ret.neighbors = neighbors;
        visited.put(ret.val, ret);

        for (Node nb : node.neighbors) {
            if (visited.containsKey(nb.val)) {
                neighbors.add(visited.get(nb.val));
            } else {
                neighbors.add(cloneGraph(nb));
            }
        }
        return ret;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
