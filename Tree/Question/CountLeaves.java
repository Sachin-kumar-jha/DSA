package Tree.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountLeaves {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static Map<Integer, List<Integer>> map;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        map = new HashMap<>();
        height(root);

        // Group values into a List<List<Integer>>
        List<List<Integer>> list = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            list.add(entry.getValue());
        }

        // Print all values using the stream logic you provided
        list.stream().forEach(x ->System.out.println(x));
        System.out.println(list);
        
       
    }

    private static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int LH = height(root.left);
        int RH = height(root.right);
        int H = 1 + Math.max(LH, RH);

        // Correct way to add a value to a list inside a map:
        // computeIfAbsent creates a new ArrayList if the key H isn't there, 
        // then .add(root.data) appends the data to that list.
        map.computeIfAbsent(H, k -> new ArrayList<>()).add(root.data);

        return H;
    }

    private static int countLeafNodes(Node root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }
}
