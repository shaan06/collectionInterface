package collectionInterface;

public class FIFO {

    private int maxCapacity;
    private int top,back,size;
    private int a[];

    public FIFO(int c){
        this.maxCapacity = c;
        this.back = -1;
        a = new int[maxCapacity];
    }

    public boolean isFull(){
        return size == maxCapacity;
    }

    // Checks whether array is empty or not
    public  boolean isEmpty()
    {
        return size==0;
    }

    // Add the number to the rear of the array.
    public void add(int x){

        if(isFull()){
            //  Whenever array is full new arraty is created with twice the original array size and reference is copied to old array
           int s = 2*maxCapacity;
           maxCapacity = s;
           int[] newA = new int[s];
           for(int i =0;i<a.length;i++)
                newA[i] = a[i];
           a = newA;
           back = (back+1)%s;
           a[back] = x;
           size++;
        }
        else {
            back = (back + 1) % maxCapacity;
            a[back] = x;
            size++;
        }
    }

    // Gets the number from the top of the array.
    public int get(){

      if(isEmpty()){
            System.out.println("Array Underflow");
            throw new ArrayIndexOutOfBoundsException();
        }
        int item = a[top];
        top = (top+1)%maxCapacity;
        size--;
        return item;

    }
    public int size()
    {
        return size;
    }
}
