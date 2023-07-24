package org.example.algorithm;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinarySearchTree {

    public TreeNode search(TreeNode root, int target) {
        if (root == null || root.val == target) {
            return root;
        }

        if (target < root.val) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void main(String[] args) {
        // 构建二叉搜索树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        BinarySearchTree bst = new BinarySearchTree();
        int target = 4;
        TreeNode result = bst.search(root, target);

        if (result != null) {
            System.out.println("找到目标节点，值为：" + result.val);
        } else {
            System.out.println("未找到目标节点");
        }
    }
}
