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

        if(node == null){
            return null;
        }
        if(node.neighbors.isEmpty()){
            return new Node();
        }
        HashMap<Node, Node> m = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        for(Node n: node.neighbors){
            q.add(n);
        }
        // create a new node for each coresponding node
        m.put(node , new Node(node.val, new ArrayList<>()));
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0; i<size; i++){
                Node cur = q.poll();
                if(!m.containsKey(cur)){
                    m.put(cur, new Node(cur.val, new ArrayList<>()));
                }

                for(Node c: cur.neighbors){
                    if(!m.containsKey(c)){
                        q.add(c);
                    }
                }
            }
        }

        // traverse each node and update its corresponding values.
        for(Map.Entry<Node, Node> val : m.entrySet()){
            List<Node> neg = val.getKey().neighbors;
            for(Node n: neg){
                Node cur = val.getValue();
                cur.neighbors.add(m.get(n));
            }
        }

        return m.get(node);
    }
}