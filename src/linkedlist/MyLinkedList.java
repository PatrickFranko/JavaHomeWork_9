package linkedlist;

import java.util.LinkedList;

public class MyLinkedList <T>{
    private Node<T> firstNode;
    private  Node<T> lastNode;
    private int size;

    public void add(T value){
        if(firstNode == null){
            firstNode = new Node<>(firstNode, lastNode, value);
        }else if(lastNode == null){
            lastNode = new Node<>(firstNode, null, value);
            firstNode.setNextNode(lastNode);
        }else {
            Node<T> newLastNode = new Node<>(lastNode, null, value);
            lastNode.setNextNode(newLastNode);
            lastNode = newLastNode;
        }
        size++;
    }
    public int size(){
        return size;
    }
    public void remove(int index){

        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("wrong index");
        }

        Node<T> currentN;
        //index більше половини
        if(size() / 2 < index){
             currentN = lastNode;
             for (int i = size() - 1; i > index; i--){
                 currentN = currentN.getPrevNode();
             }
        }else {
            currentN = firstNode;
            for (int i = 0; i < index; i++) {
                currentN = currentN.getNextNode();
            }
        }
            Node<T> prev = currentN.getPrevNode();
            Node<T> next = currentN.getNextNode();
            if (prev != null) {

                prev.setNextNode(next);
            } else {
                firstNode = next;
            }
            if (next != null) {
                next.setPrevNode(prev);
            } else {
                lastNode = prev;
            }
        size--;
    }
    public T get(int index) {
        Node<T> currentNode;
        if (index > size() && index < 0) {
            throw new IndexOutOfBoundsException("wrong index");
        }

        if (size() / 2 < index) {
            currentNode = lastNode;
            for (int i = 0; i < size() - 1 - index; i++) {
                currentNode = currentNode.getPrevNode();
            }
            return currentNode.getValue();
        }
            currentNode = firstNode;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNextNode();
            }

        return currentNode.getValue();
    }
        //return /*currentNode.getValue()*/null;
    //}
    public void clear(){
        Node<T> currNode = firstNode;
        while (currNode != null){
            currNode.setNextNode(null);
            currNode.setPrevNode(null);
            currNode = currNode.getNextNode();

        }
        firstNode = null;
        lastNode = null;
        size = 0;
    }
    public static void main(String[] args){
        MyLinkedList<String> ml = new MyLinkedList<>();
        ml.add("Patrick1");
        ml.add("Patrick2");
        ml.add("Patrick3");
        ml.add("Patrick4");
        ml.add("Patrick5");
        ml.add("Patrick6");
        ml.add("Patrick7");
        ml.add("Patrick8");
        System.out.println(ml.get(3));
        System.out.println(ml.get(2));
        //ml.remove(3);
        System.out.println(ml.get(2));
        //System.out.println(ml.get(3)+"//////");
        System.out.println(ml.size()+"2222222222");
        ml.remove(2);
        System.out.println(ml.size()+"3333333");

        System.out.println(ml.get(2)+"//////+3333333");
        //System.out.println("-----");
        //ml.get(1);
        //System.out.println("000000");

    }
}
