package pacecalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaceCalculatorTest {

    @Test
    public void testTacocatReverse(){
        assertEquals("tacocat",PaceCalculator.reverseString("tacocat"));
    }

    @Test
    public void testHelloReverse(){
        assertEquals("olleh",PaceCalculator.reverseString("hello"));
    }

    @Test
    public void testPalindromeTrue() {
        assertTrue(PaceCalculator.isPalindrome("tacocat"));
    }

    @Test
    public void testPalindromeFalse() {
        assertFalse(PaceCalculator.isPalindrome("hello"));
    }

}