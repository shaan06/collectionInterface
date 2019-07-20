package collectionInterface;

public abstract class Operations {
   public int size;
   public int maxCapacity =0;
   public Object a[];
    public boolean isEmpty(){
         return size ==0;
    }
  public  boolean isFull(){
         return size == maxCapacity;
    }
    public int size(){
        return size;
    }
    public void resize(){
        if(isFull()){
            int s = 2*maxCapacity;
            maxCapacity = s;
            Object[] newA = new Object[s];
            for(int i =0;i<a.length;i++) {
                newA[i] = a[i];
            }
            a = newA;
        }
        return;
    }

}
