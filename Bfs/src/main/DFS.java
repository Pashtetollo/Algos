package main;

import java.io.IOException;
import java.util.*;

public class DFS {
    public static ArrayList<Integer> loopDetectorBFS(String path) throws IOException {
        ArrayList<ArrayList<Integer>> inputArr = FileLineReader.readFile(path);
        inputArr.remove(0);
        Set<Integer> idOfNodes = new HashSet<>();
        for (ArrayList<Integer> elem : inputArr) {
            idOfNodes.add(elem.get(0));
        }
        NodeRepository nodeRepository = new NodeRepository();
        Integer node1Id;
        Integer node2Id;
        Node node;
        for (ArrayList<Integer> integers : inputArr) {
            node1Id = integers.get(0);
            node2Id = integers.get(1);
            if ((node = nodeRepository.getNode(node1Id)) != null) {
                node.addConnection(node2Id);
            } else {
                node = new Node(node1Id);
                node.addConnection(node2Id);
                nodeRepository.addNode(node);
            }
            if (nodeRepository.getNode(node2Id) == null) {
                node = new Node(node2Id);
                nodeRepository.addNode(node);
            }
        }
        for (Integer nodeId : idOfNodes) {
            ArrayList<Integer> travelPath = new ArrayList<>();
            if ((travelPath = deepSearch(new NodeRepository(nodeRepository), nodeId, nodeId, travelPath)) != null) {
                return travelPath;
            }
        }
        return null;
    }

    /**
     * recursive impl of dfs, causes Stackoverflow under big amount of input
     */

    public static ArrayList<Integer> deepSearch(NodeRepository nodeRepository, Integer nodeId,
                                                Integer originalNode, ArrayList<Integer> travelPath) {
        Node node = nodeRepository.getNode(nodeId);
        if ((node.innerState == 1)) {
            if (Objects.equals(originalNode, nodeId)) {
                travelPath.add(nodeId);
                return travelPath;
            } else {
                return null;
            }
        }
        node.innerState = 1;
        for (int connectedNodeId : node.connectedNodes) {

            if (deepSearch(nodeRepository, connectedNodeId, originalNode, travelPath) != null) {
                travelPath.add(nodeId);
                return travelPath;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        ArrayList<Integer> travelpathRecursed = loopDetectorBFS("src/input.in");
        StringBuilder output = new StringBuilder();
        if (travelpathRecursed == null) {
            output.append("No loops detected in entered graph!");
        } else {
            output.append("Loop detected! It's path is:\n");
            for (int i = travelpathRecursed.size() - 1; i >= 0; i--) {
                output.append(travelpathRecursed.get(i)).append(" -> ");
                if (i % 10 == 0) {
                    output.append("\n");
                }
            }
            output.delete(output.length() - 4, output.length());
        }
        System.out.println(output);
    }

}

class NodeRepository {
    private final HashMap<Integer, Node> nodeRepository;

    NodeRepository(NodeRepository clonedClass) {
        this.nodeRepository = new HashMap<>();
        clonedClass.getNodeRepository().forEach((key, value) -> this.nodeRepository.put(key, new Node(value)));
    }

    NodeRepository() {
        this.nodeRepository = new HashMap<>();
    }

    public HashMap<Integer, Node> getNodeRepository() {
        return this.nodeRepository;
    }

    public Node getNode(Integer id) {
        return nodeRepository.get(id);
    }

    public void addNode(Node node) {
        nodeRepository.putIfAbsent(node.id, node);
    }
}

class Node {
    Integer id;
    int innerState; // will be used as color for state of node (passed through/ new)
    ArrayList<Integer> connectedNodes;

    Node(Node copyNode) {
        this.innerState = copyNode.innerState;
        this.id = copyNode.id;
        this.connectedNodes = copyNode.connectedNodes;
    }

    Node(Integer id) {
        this.innerState = 0;
        this.id = id;
        this.connectedNodes = new ArrayList<>();
    }

    public void addConnection(Integer id) {
        connectedNodes.add(id);
    }
}
