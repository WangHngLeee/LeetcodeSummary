package AmazonNG;
import java.util.*;

class EmployeeNode {
    int val;
    List<Node> subEmployeeNode;
}
// After reading the description of this question, I think this one can be simplified to the question of N-ary tree. So I came up with the recursion solution,
// which is the typical method in the tree problem.


//Time complexity : O(N)
// where N is the number of nodes in the tree. This is because we visit each and every node only once, as we do in like a postorder traversal.


//Space complexity : O(N),
// because we will create N states for each of the nodes in the tree. Also, in cases where we have a skewed tree,
// we will implicitly maintain a recursion stack of size N, hence space complexity from this will also be O(N).

public class SubTreeWithMaxAverage {
    // Initialize two global variables, one is the final target EmployeeNode, and another one is the max value of average.
    double max = Integer.MIN_VALUE;
    EmployeeNode res = null;

    public EmployeeNode getBusiestNode(EmployeeNode president) {
        if (root == null) return null; // corner case, we have to return null if the input president is null
        help(president); // then we will call the help function recursively.
        return res; // finally we need to return the target EmployeeNode which has the max average subEmployeeNode
    }

    private double[] help(EmployeeNode root) {
        if (root == null) return new double[] {0, 0}; // corner case, we need to return [0,0] as new array

        // define two important variables during the recursion. cursum is used to record the sum of node's val that we have seen.
        double curSum = root.val;
        // count means the number of node that we have seen, it should be initialized to 1 because we start from the input node and it has already been visited.
        double count = 1;

        // then we will recursively call the help function in current node's subEmployeeNode.
        // and we will update the curSum and count after visiting all the children node.
        for (Node child : root.subEmployeeNode) {
            double[] cur = helper(child);
            curSum += cur[0];
            count += cur[1];
        }

        // caculate the average time of each president node.
        double avg = curSum / count;

        // because the question clearly point out that each qualified EmployeeNode should have at least 1 child, so the count should be bigger than 1.
        if (count > 1 && avg > max) {  //注意题目要求，自己本身不算则是>1
            max = avg;
            res = root;
        }
        return new double[] {curSum, count}; // return the curSum and count in current level to the upper recursion level.
    }
}