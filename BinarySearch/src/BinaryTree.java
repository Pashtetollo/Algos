import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node {
    int value;
    Node left;
    Node right;
    Node parent;
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
//
//    void delete(int val) {
//        delete(val, this.root);
//    }
//
//    void delete(int val, Node node) {
//        if (node.value == val) {
//            Node temp =deleteNode(node);
//            node = temp;
//        }
//            if (node.left != null)
//                delete(val, node.left);
//            if (node.right != null)
//                delete(val, node.right);
//        }
//    }
//
//    Node deleteNode(Node node) {
//        if (node.left == null && node.right == null) {
//            return null;
//        }
//        if (node.left == null) {
//            Node temp = node.right;
//            node = null;
//            return temp;
//        } else if (node.right == null) {
//            Node temp = node.left;
//            node = null;
//            return temp;
//        }
//        Node temp = minValueNode(node.right);
//
//        node.value = temp.value;
//        node.right = null;
//        return node;
//    }
//
//    Node minValueNode(Node node) {
//        Node current = node;
//
//        while (current.left != null)
//            current = current.left;
//
//        return current;
//    }

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
        testTree.insert(10);
        testTree.insert(15);
        testTree.insert(3);
        testTree.insert(8);
        testTree.insert(2);
        testTree.insert(12);
        testTree.insert(11);
        testTree.insert(14);
        testTree.printInOrder();
        BTreePrinter.printNode(testTree.root);
    }


}

class BTreePrinter {

    public static void printNode(Node root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Node> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(Node node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}