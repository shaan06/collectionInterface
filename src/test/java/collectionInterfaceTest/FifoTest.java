package collectionInterfaceTest;

import collectionInterface.FIFO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FifoTest {
    private FIFO ff;
    @Before
    public void Initialise(){
        ff = new FIFO(1);
    }
    @Test
    public void testSize(){
        assertEquals("Initially Size Should be zero", 0, ff.size());
    }
    @Test
    public void testIsEmpty(){
        assertTrue("True when array is empty", ff.isEmpty());
    }
    @Test
    public void testAdd(){
        ff.add(10);
        assertEquals("Whenever new element is added imcrement size by 1",1, ff.size());
        ff.add(20);
        assertEquals("Whenever new element is added imcrement size by 1",2,ff.size());
    }
    @Test
    public void testIsEmptyFalse(){
        ff.add(10);
        assertFalse("Since array is not empty return false ",ff.isEmpty());
    }
    @Test
    public void testNegativeSize(){
        Assertions.assertThrows(NegativeArraySizeException.class, new Executable() {
            public void execute()  {
                ff = new FIFO(-2);
            }
        });
    }
    @Test
    public void testSize2(){
        ff.add("test");
        ff.get();
        assertEquals("Delete the first/old element and returns it, and decrement the size",0,ff.size());
    }
    @Test
    public void testGet(){
        ff.add("Test");
        ff.add(19);
        ff.add(1);
        ff.add(20);
        assertEquals("Get the first/old entry in the array","Test",ff.get());
    }
    @Test
    public void testGet2() {
        ff.add(20);
        ff.add(10);
        ff.get();
        ff.add(30);
        assertEquals("Always get the first/old entry ",10,ff.get());
    }
    @Test
    public void testNewSizeAdd(){
        ff.add(10);
        ff.add(20);
        ff.add(30);
        ff.add(40);
        ff.add(50);
        assertEquals(10,ff.get());
    }
    @Test
    public void testExceptionGet(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, new Executable() {
            public void execute()  {
                ff.get();
            }
        });
    }
    @Test
    public void testAddNew(){
        ff.add(1);
        ff.add(2);
        ff.get();
        ff.get();
        ff.add(3);
        ff.add(4);
        assertEquals("Since elements is popped, new space to add one more elements",3,ff.get());
    }
}
