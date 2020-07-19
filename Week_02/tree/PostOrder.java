package com.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * N叉树的后续遍历
 */
public class PostOrder {

    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            res.add(node.val);
            List<Node> children = node.children;
            if (children != null) {
                for (Node child : children) {
                    stack.push(child);
                }
            }
        }
        Collections.reverse(res);
        return res;
    }

    // 递归
//    private void helper(List res, Node root) {
//        if (root != null) {
//            List<Node> children = root.children;
//            if (children != null) {
//                for (int i = 0; i < children.size(); i++) {
//                    helper(res, children.get(i));
//                }
//            }
//            res.add(root.val);
//        }
//    }

    static class Node {
        int val;
        List<Node> children;

        Node() {}

        Node(int _val) {
            val = _val;
        }

        Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

}
