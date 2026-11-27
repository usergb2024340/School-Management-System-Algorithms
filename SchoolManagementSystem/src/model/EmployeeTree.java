/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EmployeeTree {

    private TreeNode root;
    private int size = 0;

    // Level-order insertion: fill left first, then right,
    // then move on to the next node in level order.
    public void insert(Employee employee) {
        TreeNode newNode = new TreeNode(employee);
        size++;

        if (root == null) {
            root = newNode;
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                return;
            }
            queue.add(current.getLeft());

            if (current.getRight() == null) {
                current.setRight(newNode);
                return;
            }
            queue.add(current.getRight());
        }
    }

    // Level-order traversal: returns the employees grouped by level
    public List<List<Employee>> levelOrder() {
        List<List<Employee>> levels = new ArrayList<>();
        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int nodesInThisLevel = queue.size();
            List<Employee> level = new ArrayList<>();

            for (int i = 0; i < nodesInThisLevel; i++) {
                TreeNode node = queue.poll();
                level.add(node.getEmployee());
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
            levels.add(level);
        }
        return levels;
    }

    // Height = number of levels (a tree with only a root has height 1)
    public int height() {
        return height(root);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public int size() {
        return size;
    }
}