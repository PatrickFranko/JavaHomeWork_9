package hashmap;

import java.util.Objects;

public class Node <K, V>{
    private Node<K, V> nextNode;
    private V value;
    private K key;
    private int hash;

    public Node(Node<K, V> nextNode, V value, K key, int hash) {
        this.nextNode = nextNode;
        this.value = value;
        this.key = key;
        this.hash = hash;
    }

    public Node<K, V> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return Objects.equals(key, node.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }

    @Override
    public String toString() {
        return "\nNode{" +
                "value=" + value +
                ", key=" + key +
                '}'+"\n";
    }
}
