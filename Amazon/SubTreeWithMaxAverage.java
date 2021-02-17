package AmazonNG;
import java.util.*;





class Node {
    int val;
    List<Node> children;
}

public class SubTreeWithMaxAverage {
    /**
     * Definition for a N-ary node.
     * public class MAryTreeNode {
     *     int val;
     *     List<TreeNode> children;
     * }
     */
    Node maxNode = null;
    double max = Integer.MIN_VALUE;

    public Node subtreeMaxAvg(Node root) {
        if (root == null) return null;
        helper(root);
        return maxNode;
    }

    private double[] helper(Node root) {
        if (root == null) return new double[] {0, 0};
        double curTotal = root.val;
        double count = 1;
        for (Node child : root.children) {
            double[] cur = helper(child);
            curTotal += cur[0];
            count += cur[1];
        }
        double avg = curTotal / count;
        if (count >= 1 && avg > max) {  //注意题目要求，自己本身算则>=1，如果自己本身不算则是>1
            max = avg;
            maxNode = root;
        }
        return new double[] {curTotal, count};
    }
}