import java.util.Arrays;
public class MyArrayList<T>{
    private Object[] values = new Object[10];
    private int size = 0;
    public void add(T obj){
        rebalance();
        values[size] = obj;
        size++;
    }
    private void rebalance(){
        if(values.length == size){
            values = Arrays.copyOf(values, values.length + 5);
        }
    }
    public T get(int index){
        if(index > values.length){
            System.out.println("You choose out of bound index");
        }
        return (T) values[index];
    }
    public void clear(){
        Object[] values = new Object[10];
    }
    public void remove(int index){
        if(index > values.length){
            System.out.println("You try remove out of bound index");
        }
        values[index] = null;
    }
    public void sizes(){
        System.out.println(values.length-1);
    }
    public static void main(String[]args){
        MyArrayList<String> myList = new MyArrayList<>();
        myList.add("dfas");
        myList.add("dfas");
        myList.add("dfas");
        myList.add("dfas");
        myList.add("dfas");
        myList.add("dfas");
        myList.add("dfas");
        myList.add("dfas");
        myList.add("dfas");
        myList.add("dfas");
        myList.add("dfas");
        myList.add("dfas11");
        myList.add("dfas12");
        myList.add("dfas13");
        myList.remove(7);

        System.out.println(myList.get(12));
        System.out.println(myList.get(7));
        myList.sizes();

    }
}