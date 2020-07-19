package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的前序遍历
 */
public class PreOrder {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node =  stack.pop();
            res.add(node.val);
            List<Node> children = node.children;
            if (children != null) {
                Collections.reverse(children);
                for (Node child : children) {
                    stack.push(child);
                }
            }
        }
        return res;
    }

    // 递归
//    private void helper(List res, Node root) {
//        if (root != null) {
//            res.add(root.val);
//            List<Node> children = root.children;
//            if (children != null) {
//                for (int i = 0; i < children.size(); i++) {
//                    helper(res, children.get(i));
//                }
//            }
//        }
//    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

}
