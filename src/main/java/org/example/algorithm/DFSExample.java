package org.example.algorithm;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//}

public class DFSExample {

    public void depthFirstSearch(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.val + " ");

        depthFirstSearch(root.left);
        depthFirstSearch(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        DFSExample dfsExample = new DFSExample();
        dfsExample.depthFirstSearch(root);
    }
}
