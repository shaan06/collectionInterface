package collectionInterface;
public class LIFO<E> extends Operations {
    private int top;
    //Constructor
    public LIFO(int c){
        if(c > 0) {
            this.maxCapacity = c;
            a = new Object[maxCapacity];
        }
        else{
            throw new NegativeArraySizeException();
        }
        top = -1;
    }
    // add to the top of the array
    public void add(Object x) {
        resize();
        //  Whenever array is full new array is created with twice the size of original array and reference is copied to old array
        a[++top] = x;
        size++;
    }
    // removes the top of the array and returns it.
    public Object get() {
        if (isEmpty()) {
            System.out.println("array Underflow");
            throw new ArrayIndexOutOfBoundsException("It is Empty");
        } else {
            E e = (E) a[top--];
            size--;
            return e;
        }
    }

}