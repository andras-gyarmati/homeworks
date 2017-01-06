package xyz.codingmentor.gerericnarytree.andris.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author brianelete
 * @param <T>
 */
public final class Node<T> {

    private T data;
    private List<Node<T>> children;
    private Node<T> parent;

    public Node() {
        super();
        children = new ArrayList<>();
    }

    public Node(T data) {
        this();
        setData(data);
    }

    public Node<T> getParent() {
        return this.parent;
    }

    public List<Node<T>> getChildren() {
        return this.children;
    }

    public int getNumberOfChildren() {
        return getChildren().size();
    }

    public boolean hasChildren() {
        return getNumberOfChildren() > 0;
    }

    public void setChildren(List<Node<T>> children) {
        for (Node<T> child : children) {
            child.parent = this;
        }

        this.children = children;
    }

    public void addChild(Node<T> child) {
        child.parent = this;
        children.add(child);
    }

    public void addChildAt(int index, Node<T> child) {
        child.parent = this;
        children.add(index, child);
    }

    public void removeChildren() {
        this.children = new ArrayList<>();
    }

    public void removeChildAt(int index) {
        children.remove(index);
    }

    public Node<T> getChildAt(int index) {
        return children.get(index);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return getData().toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.data);
        hash = 89 * hash + Objects.hashCode(this.children);
        hash = 89 * hash + Objects.hashCode(this.parent);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Node<?> other = (Node<?>) obj;
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.children, other.children)) {
            return false;
        }
        if (!Objects.equals(this.parent, other.parent)) {
            return false;
        }
        return true;
    }
}
