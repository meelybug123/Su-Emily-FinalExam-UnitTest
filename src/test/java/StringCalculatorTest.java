import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private StringCalculator sc;

    @BeforeEach
    public void setUp() {
        sc = new StringCalculator();
    }

    @AfterEach
    public void tearDown() {
        sc = null;
    }

    @Test
    public void addTest1() {
        Exception e = assertThrows(RuntimeException.class, () -> { sc.add("1,2,3"); });
        assertEquals(e.getMessage(), "Up to 2 numbers separated by comma (,) are allowed");
    }

    @Test
    public void addTest2() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> { sc.add("1,-2"); });
        assertEquals(e.getMessage(), "Negatives not allowed");
    }

    @Test
    public void addTest3() {
        assertEquals(sc.add("1,2"), 3);
    }

    @Test
    public void addTest4() {
        assertEquals(sc.add("1,1001"), 1);
    }
}
