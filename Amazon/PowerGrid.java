package AmazonNG;
import java.util.*;

class Connection {
    public char from;
    public char to;
    public int cost;

    public Connection(char from, char to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class PowerGrid {

    public static List<Connection> minCostConnectAllNodes(int n, List<Connection> connections) {
        HashMap<Character, List<Connection>> map = buiildMap(n, connections);
        return bfsHelper(n, connections.get(0), map);
    }

    private static List<Connection> bfsHelper(int n, Connection startConn, HashMap<Character, List<Connection>> map) {
        HashSet<Character> visited = new HashSet<>();
        List<Connection> result = new ArrayList<>();

        // sort queue based on cost
        Queue<Connection> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(startConn);
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                Connection currentConn = pq.poll();
                // stop when processed
                if(currentConn != null) {
                    if (visited.contains(currentConn.from)) continue;
                    result.add(currentConn);
                    visited.add(currentConn.from); // only place set visited

                    List<Connection> nextconns = map.get(currentConn.to);
                    pq.addAll(nextconns);
                }
            }
        }

        return result;
    }

    private static HashMap<Character, List<Connection>> buiildMap(int n, List<Connection> connections) {
        HashMap<Character, List<Connection>> map = new HashMap<>();

        for (char c = 'A'; c <= 'E'; c++)
            map.put(c, new ArrayList<>());

        int len1 = connections.size();
        for (Connection conn : connections) {
            map.get(conn.from).add(conn);
            map.get(conn.to).add(conn);
        }
        return map;
    }














    public static void main(String[] args) {
        List<Connection> connections = new ArrayList<>();
        connections.add(new Connection('A', 'B', 1));
        connections.add(new Connection('B', 'C', 4));
        connections.add(new Connection('B', 'D', 6));
        connections.add(new Connection('D', 'E', 5));
        connections.add(new Connection('C', 'E', 1));
        int n = 5;
        List<Connection> result = minCostConnectAllNodes(n, connections);
        for (Connection c : result)
            System.out.println(c.from + ", " + c.to + ", " + c.cost);
    }
}


