package xyz.codingmentor.gerericnarytree.andris.tree;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author brianelete
 * @param <T>
 */
public class Tree<T> {

    private Node<T> root;

    public Tree() {
        super();
    }

    public Node<T> getRoot() {
        return this.root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public int getNumberOfNodes() {
        int numberOfNodes = 0;

        if (root != null) {
            numberOfNodes = helperGetNumberOfNodes(root) + 1;
        }

        return numberOfNodes;
    }

    private int helperGetNumberOfNodes(Node<T> node) {
        int numberOfNodes = node.getNumberOfChildren();

        for (Node<T> child : node.getChildren()) {
            numberOfNodes += helperGetNumberOfNodes(child);
        }

        return numberOfNodes;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public List<Node<T>> build(Order traversalOrder) {
        List<Node<T>> returnList = null;

        if (root != null) {
            returnList = build(root, traversalOrder);
        }

        return returnList;
    }

    public List<Node<T>> build(Node<T> node, Order traversalOrder) {
        List<Node<T>> traversalResult = new ArrayList<>();

        if (traversalOrder == Order.PRE_ORDER) {
            buildPreOrder(node, traversalResult);
        } else if (traversalOrder == Order.POST_ORDER) {
            buildPostOrder(node, traversalResult);
        }

        return traversalResult;
    }

    private void buildPreOrder(Node<T> node, List<Node<T>> traversalResult) {
        traversalResult.add(node);

        for (Node<T> child : node.getChildren()) {
            buildPreOrder(child, traversalResult);
        }
    }

    private void buildPostOrder(Node<T> node, List<Node<T>> traversalResult) {
        for (Node<T> child : node.getChildren()) {
            buildPostOrder(child, traversalResult);
        }

        traversalResult.add(node);
    }

    @Override
    public String toString() {
        String stringRepresentation = "";

        if (root != null) {
            stringRepresentation = build(Order.PRE_ORDER).toString();
        }
        return stringRepresentation;
    }
}
