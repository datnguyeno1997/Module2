package translate_fizz_buzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTranslateTest {
    @Test
    void translate() {
        int number = 277;
        String expected = "277";
        String actual = FizzBuzzTranslate.translate(number);
        assertEquals(expected,actual);
    }
}
