package collectionInterface;

public class LIFO {
    private int maxCapacity;
    private int top;
    private int size = 0;
    private int a[];


    public boolean isEmpty()
    {
        return (size == 0);
    }

    //Constructor
    public LIFO(int c){
        top = -1;
       this.maxCapacity = c;
       a = new int[maxCapacity];
    }

    public boolean isFull(){
        return size == maxCapacity;
    }

    // add to the top of the array
    public void add(int x) {
        if (isFull()) {
            System.out.println("array Overflow");
            throw new ArrayIndexOutOfBoundsException();
        } else {
            a[++top] = x;
            size++;
        }
    }

    // returns the size of the array thats filled.
    public int size(){ return size; }

    // removes the top of the array and returns it.
    public int get() {

        if (isEmpty()) {
            System.out.println("array Underflow");
            throw new ArrayIndexOutOfBoundsException();
        } else {
            int x = a[top--];
            size--;
            return x;
        }
    }
}