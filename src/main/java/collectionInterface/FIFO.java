package collectionInterface;
public class FIFO<E> extends Operations {

    // Constructor
    public FIFO(int c){
        if(c > 0) {
            maxCapacity = c;
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
            a[back = (back + 1) % maxCapacity] = x;
            size++;
    }
    // Gets the number from the top of the array.
    public Object get(){
        E e  = (E) a[top];
        top = (top+1)%maxCapacity;
        size--;
        return e;
    }
}
