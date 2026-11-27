/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class TreeNode {
    private final Employee employee;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() { return employee; }

    public TreeNode getLeft() { return left; }
    public void setLeft(TreeNode left) { this.left = left; }

    public TreeNode getRight() { return right; }
    public void setRight(TreeNode right) { this.right = right; }
}