package lab6.advanced;

import org.junit.jupiter.api.*;

public class NewIntCalculatorTest {
    private NewIntCalculator calculator;

    @BeforeEach
    void setup() {
        calculator = new NewIntCalculator();
        calculator.state = 10;
    }

    @AfterEach
    void tearDown(){
        calculator = null;
    }

    @Test
    void testAddPositive(){
        int expected = 15;
        int result = calculator.add(5).result();
        Assertions.assertEquals(expected,result);
    }

    @Test
    void testAddNegative() {
        int expected = 7;
        int result = calculator.add(-3).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSubtractPositive() {
        int expected = 6;
        int result = calculator.subtract(4).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testSubtractNegative() {
        int expected = 13;
        int result = calculator.subtract(-3).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testMultiplyPositive() {
        int expected = 30;
        int result = calculator.multiply(3).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testMultiplyNegative() {
        int expected = -20;
        int result = calculator.multiply(-2).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testMultiplyBy0() {
        int expected = 0;
        int result = calculator.multiply(0).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testDividePositive() {
        int expected = 2;
        int result = calculator.divide(5).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testDivideNegative() {
        int expected = -5;
        int result = calculator.divide(-2).result();
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testDivideBy0() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(0).result();
        });
    }

    @Test
    void testClear() {
        calculator.clear();
        Assertions.assertNull(calculator.result());
    }

    @Test
    void testInit() {
        calculator.add(5);
        calculator.init();
        Assertions.assertEquals(0, calculator.result());
    }

}
