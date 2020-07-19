package com.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 429. N叉树的层序遍历
 */
public class LevelOrder {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrder(Node root) {
        // 迭代解法
//        List<List<Integer>> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        ((LinkedList<Node>) queue).add(root);
//        while (!queue.isEmpty()) {
//            List<Integer> row = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node node = queue.poll();
//                row.add(node.val);
//                ((LinkedList<Node>) queue).addAll(node.children);
//            }
//            res.add(row);
//        }
//        return res;

        // 递归解法
        if (root != null) {
            traverseNode(root, 0);
        }
        return res;
    }

    private void traverseNode(Node root, int i) {
        if (res.size() <= i) {
            res.add(new ArrayList<>());
        }
        res.get(i).add(root.val);
        for (Node child : root.children) {
            traverseNode(child, i+1);
        }
    }

    static class Node {
        int val;
        List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
