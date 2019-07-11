package collectionInterfaceTest;

import collectionInterface.LIFO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LifoTest {

    @Test
    public void testSize(){
        LIFO lf = new LIFO(10);
        assertEquals("when the array is empty size should always be zero",0, lf.size());
    }
    @Test
    public void testIsEmpty(){
        LIFO lf = new LIFO(10);
        assertTrue("When no element is added, stack is empty", lf.isEmpty());
    }
    @Test
    public void testAdd(){
        LIFO lf = new LIFO(10);
        lf.add(10);
        assertEquals("Size should increment as element is added",1, lf.size());
        lf.add(20);
        assertEquals("Size should increment as element is added",2,lf.size());
    }
    @Test
    public void testIsEmptyFalse(){
        LIFO lf = new LIFO(10);
        lf.add(10);
        assertFalse("Element is added hence array is not empty",lf.isEmpty());
    }
    @Test
    public void testGet(){
        LIFO lf = new LIFO(10);
        lf.add(10);
        lf.add(20);
        assertEquals("Always get the latest entry",20,lf.get());
    }
    @Test
    public void testSizeDecrement(){
        LIFO lf = new LIFO(10);
        lf.add(10);
        lf.get();
        assertEquals("Decrement size when element is removed",0,lf.size());
    }
    @Test
    public void testAddException(){
        final LIFO lf = new LIFO(4);
        lf.add(10);
        lf.add(10);
        lf.add(10);
        lf.add(10);
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, new Executable() {
            public void execute()  {
                lf.add(10);
            }
        });
    }
    @Test
    public void testGetException(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, new Executable() {
            public void execute()  {
                LIFO lf = new LIFO(10);
                lf.get();
            }
        });
    }
    @Test
    public void testGet2(){
        LIFO lf = new LIFO(10);
        lf.add(10);
        lf.add(20);
        lf.get();
        lf.add(30);
        assertEquals(30,lf.get());
    }
    @Test
    public void testAddNew(){
        LIFO lf = new LIFO(2);
        lf.add(2);
        lf.add(3);
        lf.get();
        lf.get();
        lf.add(1);
        lf.add(4);
        assertEquals("Since elements is popped, new space to add one more elements" ,4,lf.get());
    }
}
