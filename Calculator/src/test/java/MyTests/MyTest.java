
package MyTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import ru.caf82.homework.calculator.MyCalculator;

/**
 *
 * @author Алена
 */
public class MyTest {
    private MyCalculator myCalc;
    
    public MyTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        myCalc = new MyCalculator();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void checkAdd() {
        assertTrue(myCalc.add(4, 5)==9);
        assertTrue(myCalc.add(122, 100)==222);
        assertTrue(myCalc.add(23, 23)==46);
    }
    
    @Test
    public void checkSub() {
        assertTrue(myCalc.sub(100, 14)==86);
        assertTrue(myCalc.sub(10, 3)==7);
        assertTrue(myCalc.sub(200, 32)==168);
    }
    
    @Test
    public void checkMult() {
        assertTrue(myCalc.mult(3, 4)==12);
        assertTrue(myCalc.mult(10, 10)==100);
        assertTrue(myCalc.mult(0, 4)==0);
    }
    
    @Test
    public void checkDiv() {
        assertTrue(myCalc.div(20, 4)==5);
        assertTrue(myCalc.div(1, 1)==1);
    }
    
    @Test(expected = ArithmeticException.class)
    public void checkZeroDiv() {
        myCalc.div(13, 0);
    }
}
