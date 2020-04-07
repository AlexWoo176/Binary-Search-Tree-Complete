package codegym;

public class MainTest {
    public static void main(String[] args) {
        BinarySearchTree bin = new BinarySearchTree();
        bin.insertNode(3);
        bin.insertNode(8);
        bin.insertNode(1);
        bin.insertNode(4);
        bin.insertNode(6);
        bin.insertNode(2);
        bin.insertNode(10);
        bin.insertNode(9);
        bin.insertNode(20);
        bin.insertNode(25);
        bin.insertNode(15);
        bin.insertNode(16);
        System.out.println("--------------------");
        System.out.println("In Order Traversal: ");
        bin.displayInorder(bin.root);
        System.out.println("Check Whether Node With Value 4 exists: " + bin.findNode(4));
        bin.delete(2);
        System.out.println("Delete Node with no children (2): ");
        bin.displayInorder(bin.root);

    }
}
