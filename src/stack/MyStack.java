package stack;

import java.util.Arrays;

public class MyStack <T>{
    private Object[] values = new Object[10];
   private int size = 0;
   public void push(T obj){
       rebalance();
       values[size] = obj;
       size++;
   }
   private void rebalance(){
       if(values.length == size){
           values = Arrays.copyOf(values, values.length + 5);
       }
   }
   public void remove(int index){
       values[index] = null;
   }
   public void clear(){
       for (int i=0; i<size; i++){
           values[i] = null;
       }
   }
   public int size(){
       return size;
   }
   public T peek(){
       return (T) values[size-1];
   }
   public T pop(){
       T t = (T) values[size-1];
       values[size-1] = null;
       size--;
       return t;
   }

    public static void main(String[] args) {
        MyStack<String> ms = new MyStack<>();
        ms.push("obj1");
        ms.push("obj2");
        ms.push("obj");
        ms.push("obj");
        ms.push("obj");
        ms.push("obj");
        ms.push("obj");
        ms.push("obj");
        ms.push("obj");
        ms.push("obj");
        ms.push("obj");
        ms.push("obj12");
        ms.push("obj13");
        System.out.println(ms.size());
        System.out.println(ms.peek());
        ms.remove(11);
        System.out.println(ms.peek());
    }
}
