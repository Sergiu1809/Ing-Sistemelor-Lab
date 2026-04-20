package lab6.advanced;
import org.junit.jupiter.api.*;

public class DoubleCalculatorTest {
    private DoubleCalculator calculator;

    @BeforeEach
    public void setup(){
        calculator = new DoubleCalculator();
        calculator.state = 10.0;
    }

    @AfterEach
    void tearDown(){
        calculator = null;
    }

    @Test
    void testAddPositive() {
        double expected = 15.5;
        double result = calculator.add(5.5).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testAddNegative() {
        double expected = 7.0;
        double result = calculator.add(-3.0).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSubtractPositive() {
        double expected = 6.5;
        double result = calculator.subtract(3.5).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSubtractNegative() {
        double expected = 13.0;
        double result = calculator.subtract(-3.0).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testMultiplyPositive() {
        double expected = 25.0;
        double result = calculator.multiply(2.5).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testMultiplyNegative() {
        double expected = -20.0;
        double result = calculator.multiply(-2.0).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testMultiplyBy0() {
        double expected = 0.0;
        double result = calculator.multiply(0.0).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testDividePositive() {
        double expected = 2.0;
        double result = calculator.divide(5.0).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testDivideNegative() {
        double expected = -5.0;
        double result = calculator.divide(-2.0).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testDivideBy0() {
        double result = calculator.divide(0.0).result();
        Assertions.assertTrue(Double.isInfinite(result));
    }

    @Test
    void testClear() {
        calculator.clear();
        Assertions.assertNull(calculator.result());
    }

    @Test
    void testInit() {
        calculator.add(5.0);
        calculator.init();
        Assertions.assertEquals(0.0, calculator.result());
    }
}

