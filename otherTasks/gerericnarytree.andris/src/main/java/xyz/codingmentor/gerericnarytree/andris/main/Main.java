package xyz.codingmentor.gerericnarytree.andris.main;

import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.codingmentor.gerericnarytree.andris.tree.*;

/**
 *
 * @author brianelete
 */
public class Main {

    private static final Logger LOGGER = Logger.getAnonymousLogger();

    private Main() {
        //empty
    }

    public static void main(String[] args) {
        Tree<String> tree = new Tree<>();

        Node<String> rootA = new Node<>("A");
        Node<String> childB = new Node<>("B");
        Node<String> childC = new Node<>("C");
        Node<String> childD = new Node<>("D");

        childC.addChild(childD);
        rootA.addChild(childB);
        rootA.addChild(childC);

        tree.setRoot(rootA);
        LOGGER.log(Level.INFO, tree.toString());
    }
}
