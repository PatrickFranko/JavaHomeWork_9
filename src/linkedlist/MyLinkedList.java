package linkedlist;

import java.util.LinkedList;

public class MyLinkedList <T>{
    private Node<T> firstNode;
    private  Node<T> lastNode;

    public void add(T value){
        if(firstNode == null){
            firstNode = new Node<>(null, null, value);
        }else if(lastNode == null){
            lastNode = new Node<>(firstNode, null, value);
            firstNode.setNextNode(lastNode);
        }else {
            Node<T> newLastNode = new Node<>(lastNode, null, value);
            lastNode.setNextNode(newLastNode);
            lastNode = newLastNode;

        }

    }
    public int size(){
        Node<T> currN = firstNode;
        int index = 0;
        while (currN != null){
            index++;
            currN=currN.getNextNode();
        }
        return index;
    }
    public void remove(int index){
        Node<T> currentN = firstNode;

        if(index < 0 && index >size()){
            System.out.println("Wrong index to remove");
        }else {
            for (int i = 0; i < index; i++) {
                currentN = currentN.getNextNode();
            }
            Node<T> prev = currentN.getPrevNode();
            Node<T> next = currentN.getNextNode();
            if (prev != null) {
                prev.setNextNode(next);
                //System.out.println(currentN.getValue() + "|||||");
            } else if (next != null) {
                next.setPrevNode(prev);
                System.out.println("||||");
            } else if (prev == null) {
                //System.out.println("88888");
                firstNode = next;
            } else if (next == null) {
                //System.out.println("99999");
                lastNode = prev;
            }
        }

    }
    public T get(int index){
        Node<T> currentNode = firstNode;
        for(int i = 0; i<index; i++){
            currentNode = currentNode.getNextNode();
        }
        return currentNode.getValue();
    }
    public void clear(){
        Node<T> currNode = firstNode;
        while (currNode != null){
            currNode.setNextNode(null);
            currNode.setPrevNode(null);
            currNode = currNode.getNextNode();

        }
        firstNode = null;
        lastNode = null;
    }
    public static void main(String[] args){
        MyLinkedList<String> ml = new MyLinkedList<>();
        ml.add("Patrick1");
        ml.add("Patrick2");
        ml.add("Patrick3");
        ml.add("Patrick4");
        System.out.println(ml.get(3));
        System.out.println(ml.get(2));
        ml.remove(3);
        System.out.println(ml.get(2));
        //System.out.println(ml.get(3)+"//////");
        ml.size();
        ml.clear();

        //ml.get(0);
        //System.out.println("-----");
        //ml.get(1);
        //System.out.println("000000");

    }
}
