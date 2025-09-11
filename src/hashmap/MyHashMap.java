package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyHashMap <K, V> {
    private int hash;
    private int index;
    private Node<K, V>[] table;
    private int size;
    public static final int DEFAULT_CAPACITY = 10;

    public MyHashMap() {
        table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    public int size(){
        return size;
    }
    public void put(K key, V value) {
//        if (key.equals(key)) {
//            System.out.println("That key present");
//        }
        if (key == null) {
            System.out.println("Enter key");
        } else {
            hash = key.hashCode();
            index = Math.abs(hash % table.length);
        }
        Node<K, V> currentNode = table[index];
        if (currentNode == null) {
            table[index] = new Node<>(null, value, key, hash);
            size++;
            return;
        }
            Node<K, V> prev = null;
            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    return;
                }
                prev = currentNode;
                currentNode = currentNode.getNextNode();
            }
        prev.setNextNode(new Node<>(null, value, key, hash));
        size++;

        //Map one = new HashMap();

    }
    public V get(K key){
        V v = null;
        hash = key.hashCode();
        index = Math.abs(hash % table.length);
        Node<K,V> current = table[index];
           while( current != null) {
               if (key.equals(current.getKey())) {
                   v = current.getValue();
               }
               current = current.getNextNode();
           }
        return v;
    }
    public void clear(){

        table = (Node<K, V>[]) new Node[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i=0;i<table.length; i++){
            Node<K, V> curr = table[i];
            while (curr != null){
                sb.append(curr.getKey()).append("=").append(curr.getValue()).append("|");
                curr = curr.getNextNode();
            }
        }
        if (sb.length()>1){
            sb.setLength(sb.length()-1);
        }
        sb.append("}");
        return sb.toString();
//        return "MyHashMap{" +
//                "table=" + Arrays.toString(table) +
//                '}';
    }
    public void remove(K key){
        hash = key.hashCode();
        index = Math.abs(hash % table.length);
        Node<K,V> current = table[index];
        while( current != null) {
            if (key.equals(current.getKey())) {
                current.setValue(null);
                current.setKey(null);
            }
            current = current.getNextNode();
        }
    }

    public static void main(String[] args) {
        //Map<String, Integer> ms = new HashMap<>();
        MyHashMap<String, Integer> mm = new MyHashMap<>();
        mm.put("rrr", 8);
        mm.put("www", 5);
        mm.put("ddd", 7);
        mm.put("qqq", 12);
        mm.put("rrr", 17);
        mm.put("qwr", 11);
        mm.put("qwt", 13);
        mm.put("qwy", 16);
        mm.put("qwu", 18);
        mm.put("qwi", 19);
        mm.put("qwo", 11);
        mm.put("qwp", 3);
        mm.put("qwa", 1);
        mm.put("qws", 2);
        mm.put("qwp", 21);
        System.out.println(mm);
        System.out.println(mm.get("qwy"));
        System.out.println(mm.get("qws"));
        System.out.println(mm.size());
//        mm.clear();
//        System.out.println(mm);
        System.out.println(mm.get("ttt")+ "////");
        System.out.println(mm.get("qwt") + "||||||");
        //System.out.println(mm);
        mm.remove("qwo");
        System.out.println(mm);
        mm.clear();
        System.out.println(mm);

    }
}
