package com.example.demo.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BinaryTreeIterator {

    Node root;

    // 前序非递归
    void iterativePreorder() {

        // Create an empty stack and push root to it
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(root);

		/* Pop all items one by one. Do following for every popped item
		a) print it
		b) push its right child
		c) push its left child
		Note that right child is pushed first so that left is processed first */
        while (nodeStack.empty() == false) {

            // Pop the top item from stack and print it
            Node mynode = nodeStack.peek();
            System.out.print(mynode.data + " ");
            nodeStack.pop();

            // Push right and left children of the popped node to stack
            if (mynode.right != null) {
                nodeStack.push(mynode.right);
            }
            if (mynode.left != null) {
                nodeStack.push(mynode.left);
            }
        }
    }

    //中序非递归
    public void iterativeMidOrder() {
        Stack<Node> s = new Stack<>();
        Node p = root;
        while (p != null || !s.isEmpty()) {
            while (p != null) {
                s.push(p);
                p = p.left;
            }
            if (!s.empty()) {
                p = s.peek();
                System.out.print(p.data+" ");
                s.pop();
                p = p.right;
            }
        }
    }

    //后序非递归 最难
    public List<Integer> iterativePostOrder() {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Node p = root;
        Stack<Node> sta = new Stack<>();
        sta.push(p);
        sta.push(p);
        while (!sta.empty()) {
            p = sta.peek();
            sta.pop();
            if (!sta.isEmpty() && p == sta.peek()) {
                if (p.right != null) {
                    sta.push(p.right);
                    sta.push(p.right);
                }
                if (p.left != null) {
                    sta.push(p.left);
                    sta.push(p.left);
                }
            }else {
                res.add(p.data);
            }
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeIterator tree = new BinaryTreeIterator();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);

        System.out.println("前序");
        tree.iterativePreorder();
        System.out.println("\n中序");
        tree.iterativeMidOrder();
        System.out.println("\n后序");
        tree.iterativePostOrder();

    }

}

