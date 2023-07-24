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

public class BinaryTree {

    // 前序遍历查找 跟左右
    public TreeNode search(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        if (root.val == target) {
            return root;
        }

        TreeNode leftResult = search(root.left, target);
        if (leftResult != null) {
            return leftResult;
        }

        return search(root.right, target);
    }

    public static void main(String[] args) {
        // 构建一个非搜索树的二叉树
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        BinaryTree binaryTree = new BinaryTree();
        int target = 4;
        TreeNode result = binaryTree.search(root, target);

        if (result != null) {
            System.out.println("找到目标节点，值为：" + result.val);
        } else {
            System.out.println("未找到目标节点");
        }
    }
}
