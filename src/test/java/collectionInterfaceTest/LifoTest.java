package collectionInterfaceTest;
import collectionInterface.LIFO;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LifoTest {
    LIFO lf;
    @Before
    public void Initialise(){
      lf = new LIFO(1);
    }
    @Test
    public void testSize(){
        assertEquals("when the array is empty size should always be zero",0, lf.size());
    }
    @Test
    public void testIsEmpty(){
        assertTrue("When no element is added, stack is empty", lf.isEmpty());
    }
    @Test
    public void testAdd(){
        lf.add(4.3);
        assertEquals("Size should increment as element is added",1, lf.size());
        lf.add(5.6);
        assertEquals("Size should increment as element is added",2,lf.size());
    }
    @Test
    public void testNegativeSize(){
        Assertions.assertThrows(NegativeArraySizeException.class, new Executable() {
            public void execute()  {
                lf = new LIFO(-2);
            }
        });
    }
    @Test
    public void testIsEmptyFalse(){
        lf.add(10);
        assertFalse("Element is added hence array is not empty",lf.isEmpty());
    }
    @Test
    public void testGet(){
        lf.add(10);
        lf.add(20);
        assertEquals("Always get the latest entry",20,lf.get());
    }
    @Test
    public void testSizeDecrement(){
        lf.add(4.5);
        lf.add(0.04);
        lf.get();
        assertEquals("Decrement size when element is removed",1,lf.size());
    }
    @Test
    public void testNewSizeAdd(){
        lf.add(4);
        lf.add(3);
        lf.add(2);
        lf.add(1);
        lf.add(20);
        lf.add(30);
        lf.add(40);
        lf.add("Shantanu");
        assertEquals("Since array is full","Shantanu",lf.get());
    }
    @Test
    public void testGetException(){
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, new Executable() {
            public void execute()  {

                lf.get();
            }
        });
    }
    @Test
    public void testGet2(){
        lf.add(10);
        lf.add(20);
        lf.get();
        lf.add(30);
        assertEquals(30,lf.get());
    }
    @Test
    public void testAddNew(){
        lf.add(2);
        lf.add(3);
        lf.get();
        lf.get();
        lf.add(1);
        lf.add(4);
        assertEquals("Since elements is popped, new space to add one more elements" ,4,lf.get());
    }
}
