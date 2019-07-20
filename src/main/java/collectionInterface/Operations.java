package collectionInterface;

public abstract class Operations {
    int size;
    int top;
    int back;
    int maxCapacity;
    Object a[];
   public boolean isEmpty(){
         return size ==0;
    }
     private boolean isFull(){
         return size == maxCapacity;
    }
    public int size(){
        return size;
    }
    void resize(){
        if(isFull()){
            int s = 2*maxCapacity;
            maxCapacity = s;
            Object[] newA = new Object[s];
            System.arraycopy(a, 0, newA, 0, a.length);
            a = newA;
        }
    }

}
