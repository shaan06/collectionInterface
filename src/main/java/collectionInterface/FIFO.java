package collectionInterface;

public class FIFO<E> extends Operations {
    private int back, top;
    public FIFO(int c){
        if(c > 0) {
            this.maxCapacity = c;
            a = new Object[maxCapacity];
        }
        else{
            throw new NegativeArraySizeException();
        }
        back = -1;
    }
    // Add the number to the rear of the array.
    public void add(Object x){
        //  Whenever array is full new array is created with twice the original array size and reference is copied to old array
            resize();
            back = (back + 1) % maxCapacity;
            a[back] = x;
            size++;
    }
    // Gets the number from the top of the array.
    public Object get(){
      if(isEmpty())
        {
            System.out.println("Array Underflow");
            throw new ArrayIndexOutOfBoundsException();
        }
        E e  = (E) a[top];
        top = (top+1)%maxCapacity;
        size--;
        return e;

    }
}
