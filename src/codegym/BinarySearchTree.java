package codegym;

public class BinarySearchTree {
    public static TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public boolean findNode(int value) {
        TreeNode current = root;
        while (current !=null) {
            if (current.getData() == value) {
                return true;
            } else if (current.getData() > value) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    public void insertNode(int value) {
        TreeNode treeNode = new TreeNode(value);
        if (root == null) {
            root = treeNode;
            return;
        }
        TreeNode current = root;
        TreeNode parent = null;
        while (true) {
            parent = current;
            if (current.getData() > value) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(new TreeNode(value));
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(new TreeNode(value));
                    return;
                }
            }
        }
    }

    public void displayInorder(TreeNode root) {
        if (root !=null){
            displayInorder(root.getLeft());
            System.out.println(" " + root.getData());
            displayInorder(root.getRight());
        }
    }
}
