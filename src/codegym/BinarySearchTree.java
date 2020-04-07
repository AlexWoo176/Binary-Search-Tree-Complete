package codegym;

public class BinarySearchTree {
    public static TreeNode root;

    public BinarySearchTree() {
        this.root = null;
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

    public TreeNode deleteNode(TreeNode root, int value) {
        if (root == null) return root;
        if (root.getData() > value) {
            root.setLeft(deleteNode(root.getLeft(), value));
        } else if (root.getData() < value) {
            root.setRight(deleteNode(root.getRight(), value));
        } else {
            // Node with no leaf nodes
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            } else if (root.getLeft() == null) {
                // Node with one Node (No left Node)
                return root.getRight();
            } else if (root.getRight() == null) {
                // Node with one Node (No right Node)
                return root.getLeft();
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                int minValue = minValue(root.getRight());
                root.setData(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
            }
        }
        return root;
    }

    public int minValue(TreeNode node) {
        if (node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getData();
    }

    public void delete(int value) {
        deleteNode(this.root, value);
    }

    public void displayInorder(TreeNode root) {
        if (root !=null){
            displayInorder(root.getLeft());
            System.out.println(" " + root.getData());
            displayInorder(root.getRight());
        }
    }
}
