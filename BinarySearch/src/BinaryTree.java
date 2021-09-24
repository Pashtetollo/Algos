class Node {
    int value;
    Node left;
    Node right;
};

class BinaryTree {
    Node root;


    void insert(int val, Node leaf) {

        if (val <= leaf.value) {
            if (leaf.left != null) {
                insert(val, leaf.left);
            } else {
                leaf.left = new Node();
                leaf.left.value = val;
                leaf.left.left = null;
                leaf.left.right = null;
            }
        } else {
            if (leaf.right != null) {
                insert(val, leaf.right);
            } else {
                leaf.right = new Node();
                leaf.right.value = val;
                leaf.right.right = null;
                leaf.right.left = null;
            }
        }

    }

    void insert(int val) {
        if (this.root != null) {
            insert(val, this.root);
        } else {
            this.root = new Node();
            this.root.value = val;
            this.root.left = null;
            this.root.right = null;
        }
    }

    void printInOrder() {
        printInOrder(this.root);
    }

    void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println(node.value);
            printInOrder(node.right);
        }
    }

    public static void main (String[] args){
        BinaryTree testTree = new BinaryTree();
        testTree.insert(3);
        testTree.insert(10);
        testTree.insert(4);
        testTree.insert(6);
        testTree.printInOrder();
    }
}