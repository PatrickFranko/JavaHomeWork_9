package queue;

import java.util.Arrays;

public class MyQueue <T>{
    private Object[] value = new Object[10];
    private int size = 0;
    private  int peek = 0;
    public void add(T obj){
        rebalance();
        value[size] = obj;
        size++;

    }
    private void rebalance(){
        if(value.length == size){
            value = Arrays.copyOf(value, value.length + 5);
        }
    }
    public int size(){
        return size;
    }
    public void clear(){
        for (int i=0;i<size; i++) {
            value[i] = null;
        }
    }
    public T peek(){
        return (T) value[0];
    }
    public T poll(){
        T t = (T) value[0];
        value[0] = null;
        int j=1;
        for (int i=0; i<size; i++) {
            value[i] = value[j];
            j++;
        }
        size--;
        return t;
    }

    public static void main(String[] args) {
        MyQueue <String> qu = new MyQueue<>();
        qu.add("pus1");
        qu.add("pus2");
        qu.add("pus");
        qu.add("pus");
        qu.add("pus");
        qu.add("pus");
        qu.add("pus");
        qu.add("pus");
        qu.add("pus");
        qu.add("pus");
        qu.add("pus11");
        qu.add("pus12");
        System.out.println(qu.size());
        System.out.println(qu.peek());
        System.out.println(qu.poll());
        System.out.println(qu.peek());
        qu.clear();
        System.out.println(qu.peek());
    }
}
